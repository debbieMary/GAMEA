package elalto.gamea.denuncia.reportar.view;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;
import com.mapbox.mapboxsdk.geometry.LatLng;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import elalto.gamea.R;
import elalto.gamea.denuncia.MapReportesActivity;
import elalto.gamea.denuncia.reportar.model.ReportarInteractorImpl;
import elalto.gamea.denuncia.reportar.presenter.ReportarPresenter;
import elalto.gamea.denuncia.reportar.presenter.ReportarPresenterImpl;
import elalto.gamea.yayo.map_yayo.MapYayoActivity;
import elalto.network.entities.TokenManager;
import es.dmoral.toasty.Toasty;
import id.zelory.compressor.Compressor;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportarFragment extends Fragment implements ReportarView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    public ProgressDialog progressDialog;
    TokenManager tokenManager;
    @BindView(R.id.sp_distrito)
    Spinner spDistrito;
    @BindView(R.id.sp_categoria)
    Spinner spCategoria;
    @BindView(R.id.til_zona)
    TextInputLayout tilZona;
    @BindView(R.id.til_detalles)
    TextInputLayout tilDetalles;
    @BindView(R.id.btn_reportar)
    Button btnReportar;
    @BindView(R.id.img_gallery)
    ImageView imgGallery;
    public LatLng latLng;
    public String imagePath;
    private ReportarPresenter presenter;
    private static final int REQUEST_PERMISSION = 101;
    private static final int SELECT_PICTURE = 1;
    private static final int TAKE_PHOTO = 2;
    private static final int GET_LAT_LNG = 200;
    private final String RUTA_IMAGEN = "app_gamea";
    String path;
    AlertDialog dialog;
    public ReportarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reportar, container, false);
        ButterKnife.bind(this, view);
        toolbar.setTitle("Reportar caso");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        presenter = new ReportarPresenterImpl(this, new ReportarInteractorImpl());
        tokenManager = TokenManager.getInstance(getActivity().getSharedPreferences("prefs", MODE_PRIVATE));
        ArrayAdapter<CharSequence> spDistritoAdapter = ArrayAdapter.createFromResource(getContext(),
              R.array.distritos, android.R.layout.simple_spinner_item);
        spDistritoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDistrito.setAdapter(spDistritoAdapter);

        ArrayAdapter<CharSequence> spCategoriaAdapter = ArrayAdapter.createFromResource(getContext(), R.array.categorias, android.R.layout.simple_spinner_dropdown_item);
        spCategoriaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategoria.setAdapter(spCategoriaAdapter);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Enviando informacion");
        progressDialog.setCancelable(false);
        solicitarPermisos();
        return view;
    }

    private void solicitarPermisos() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return;
        if ((getActivity().checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED) && (getActivity().checkSelfPermission(READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) && (getActivity().checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED))
            return;

        if ((shouldShowRequestPermissionRationale(CAMERA)) || (shouldShowRequestPermissionRationale(READ_EXTERNAL_STORAGE)) || (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE))) {
            cargarDialogoRecomendacion();
        } else {
            requestPermissions(new String[]{CAMERA, WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION);
        }
    }

    private void cargarDialogoRecomendacion() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Permisos Desactivados");
        dialogo.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");
        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                requestPermissions(new String[]{CAMERA, WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION);
            }
        });
        dialogo.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION) {
            if (grantResults.length == 3 && grantResults[0] != PackageManager.PERMISSION_GRANTED && grantResults[1] != PackageManager.PERMISSION_GRANTED && grantResults[2] != PackageManager.PERMISSION_GRANTED) {
                solicitarPermisosManual();
            }
        }
    }

    private void solicitarPermisosManual() {
        final CharSequence[] opciones = {"si", "no"};
        final AlertDialog.Builder alertOpciones = new AlertDialog.Builder(getActivity());
        alertOpciones.setTitle("¿Desa configurar los permisos de fomra manual?");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (opciones[which].equals("si")) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                } else {
                    dialog.dismiss();
                }
            }
        });
        alertOpciones.show();
    }


    @OnClick(R.id.btn_reportar)
    public void confirmarReportar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Esta seguro de enviar el caso");
        builder.setMessage("Por favor ingrese información fidedigna para poder dar atencio pronta gracias. :)")
              .setCancelable(false)
              .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      if (latLng == null) {
                          Toasty.error(getContext(), "Debe elejir una ubicacion en el mapa", Toast.LENGTH_SHORT).show();
                          return;
                      }
                      if (TextUtils.isEmpty(imagePath)) {
                          Toasty.error(getContext(), "Elija una imagen", Toast.LENGTH_SHORT).show();
                          return;
                      }
                      File file = new File(imagePath);
                      File compresFile = compresor(file);
                      if (compresFile == null) {
                          Toasty.error(getContext(), "Error al comprimir imagen intente nuevamente", Toast.LENGTH_SHORT).show();
                          return;
                      }
                      presenter.reportar(spDistrito.getSelectedItem().toString(), spCategoria.getSelectedItem().toString(), tilZona.getEditText().getText().toString(), tilDetalles.getEditText().getText().toString(), String.valueOf(latLng.getLatitude()), String.valueOf(latLng.getLongitude()), compresFile, tokenManager);
                  }
              })
              .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {

                  }
              });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @OnClick(R.id.img_gallery)
    public void getImage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = getLayoutInflater().inflate(R.layout.take_picture, null);
        builder.setView(view);
        dialog = builder.create();
        ImageView imgGaleria, imgCamera;
        imgGaleria = (ImageView) view.findViewById(R.id.img_galeria);
        imgGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                openGallery();
            }
        });
        imgCamera = (ImageView) view.findViewById(R.id.img_camera);
        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tomarFoto();
            }
        });
        dialog.setTitle("Tomar imagen");
        dialog.show();
    }

    public void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent, "Seleccione la aplicacion"), SELECT_PICTURE);
    }

    public void tomarFoto() {
        File fileImagen = new File(Environment.getExternalStorageDirectory(), RUTA_IMAGEN);
        boolean iscreada = fileImagen.exists();
        String nombreImg = "";
        if (iscreada == false) {
            iscreada = fileImagen.mkdir();
        }
        if (iscreada) {
            nombreImg = (System.currentTimeMillis() / 1000) + ".jpg";
        }
        path = Environment.getExternalStorageDirectory() + File.separator + RUTA_IMAGEN + File.separator + nombreImg;
        File imagen = new File(path);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
            String authorities = getActivity().getPackageName()+".provider";
            Uri imageUri = FileProvider.getUriForFile(getActivity(),authorities, imagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        }else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(imagen));
        }
        startActivityForResult(intent, TAKE_PHOTO);
    }

    @OnClick(R.id.img_map)
    public void navigateToMap() {
        Intent intent = new Intent(getActivity(), MapReportesActivity.class);
        if (latLng != null) {
            intent.putExtra("lat", String.valueOf(latLng.getLatitude()));
            intent.putExtra("lng", String.valueOf(latLng.getLongitude()));
        }
        startActivityForResult(intent, GET_LAT_LNG);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case SELECT_PICTURE:
                    Uri mipath = data.getData();
                    Glide.with(getContext()).load(mipath).into(imgGallery);
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getActivity().getContentResolver().query(mipath, filePathColumn, null, null, null);
                    assert cursor != null;
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    imagePath = cursor.getString(columnIndex);
                    cursor.close();
                    break;
                case TAKE_PHOTO:
                    MediaScannerConnection.scanFile(getContext(), new String[]{path}, null, new MediaScannerConnection.OnScanCompletedListener() {
                        @Override
                        public void onScanCompleted(String path, Uri uri) {
                            imagePath = path;
                        }
                    });
                    dialog.dismiss();
                    Glide.with(getContext()).load(path).into(imgGallery);
                    break;
                case GET_LAT_LNG:
                    latLng = new LatLng(Double.valueOf(data.getStringExtra("lat")), Double.valueOf(data.getStringExtra("lng")));
                    break;
                default:
            }
        }

    }

    private File compresor(File file) {
        try {
            File compressFile = new Compressor(getContext())
                  .setMaxWidth(640)
                  .setMaxHeight(480)
                  .setQuality(75)
                  .setCompressFormat(Bitmap.CompressFormat.JPEG)
                  .setDestinationDirectoryPath(Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES).getAbsolutePath())
                  .compressToFile(file);
            return compressFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showSuccessMessage(String message) {
        Toasty.success(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showErrorMessage(String message) {
        Toasty.error(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setErrorDistrito(String message) {
        Toasty.error(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setErrorZona(String message) {
        tilZona.setError(message);
    }

    @Override
    public void setErrorDetalle(String message) {
        tilDetalles.setError(message);
    }

    @Override
    public void setErrorLatLng(String message) {
        Toasty.error(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resetForm() {
        tilZona.getEditText().setText(null);
        tilDetalles.getEditText().setText(null);
        imagePath = null;
        imgGallery.setImageResource(R.drawable.gallery);
        latLng = null;
    }

    @Override
    public void resetErrors() {
        progressDialog.dismiss();
        tilDetalles.setError(null);
        tilZona.setError(null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
