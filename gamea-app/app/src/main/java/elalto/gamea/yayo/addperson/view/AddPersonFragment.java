package elalto.gamea.yayo.addperson.view;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;
import com.mapbox.mapboxsdk.geometry.LatLng;


import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import elalto.gamea.R;
import elalto.gamea.yayo.addperson.model.AddPersonInteractorImpl;
import elalto.gamea.yayo.addperson.presenter.AddPersonPresenter;
import elalto.gamea.yayo.addperson.presenter.AddPersonPresenterImpl;
import elalto.gamea.yayo.map_yayo.MapYayoActivity;
import elalto.network.entities.TokenManager;
import es.dmoral.toasty.Toasty;
import id.zelory.compressor.Compressor;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddPersonFragment extends Fragment implements AddPersonView {
    public ProgressDialog progressDialog;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private static final int SELECT_PICTURE = 1;
    private static final int GET_LAT_LNG = 200;
    private static final int TAKE_PHOTO = 2;
    private final String RUTA_IMAGEN = "app_gamea";
    String path;
    AlertDialog dialog;

    @BindView(R.id.edt_date)
    EditText edtDate;
    @BindView(R.id.img_gallery)
    ImageView imgGallery;
    @BindView(R.id.img_map)
    ImageView imgMap;
    @BindView(R.id.til_ci)
    TextInputLayout tilCi;
    @BindView(R.id.til_nombres)
    TextInputLayout tilNombres;
    @BindView(R.id.til_apellidos)
    TextInputLayout tilApellidos;
    @BindView(R.id.til_edad)
    TextInputLayout tilEdad;
    @BindView(R.id.rbt_genero)
    RadioGroup rbtGenero;
    @BindView(R.id.til_celular)
    TextInputLayout tilCelular;
    @BindView(R.id.til_desaparecio)
    TextInputLayout tilDesaparecion;
    @BindView(R.id.til_detalles)
    TextInputLayout tilDetalles;
    @BindView(R.id.til_fec_desaparicion)
    TextInputLayout tilFecDesaparicion;
    @BindView(R.id.btn_buscar_dtm)
    Button btnPublicar;

    public LatLng latLng;
    public String imagePath;
    private AddPersonPresenter presenter;
    TokenManager tokenManager;

    public AddPersonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_person, container, false);
        ButterKnife.bind(this, view);
        toolbar.setTitle("Publicar adulto desaparecido?");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        presenter = new AddPersonPresenterImpl(this, new AddPersonInteractorImpl());
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Publicando adulto mayor desaparecido");
        progressDialog.setCancelable(false);
        tokenManager = TokenManager.getInstance(getActivity().getSharedPreferences("prefs", MODE_PRIVATE));
        return view;
    }

    @OnClick(R.id.edt_date)
    public void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(
              getActivity(),
              android.R.style.Theme_Holo_Light_Dialog_MinWidth,
              new DatePickerDialog.OnDateSetListener() {
                  @Override
                  public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                      edtDate.setText(year + "-" + month + "-" + dayOfMonth);
                  }
              },
              year, month, day);
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        datePickerDialog.getDatePicker().setSpinnersShown(true);
        datePickerDialog.getDatePicker().setCalendarViewShown(false);
        datePickerDialog.show();
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            String authorities = getActivity().getPackageName() + ".provider";
            Uri imageUri = FileProvider.getUriForFile(getActivity(), authorities, imagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        } else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
        }
        startActivityForResult(intent, TAKE_PHOTO);
    }

    @OnClick(R.id.img_map)
    public void navigateToMap() {
        Intent intent = new Intent(getActivity(), MapYayoActivity.class);
        if (latLng != null) {
            intent.putExtra("lat", String.valueOf(latLng.getLatitude()));
            intent.putExtra("lng", String.valueOf(latLng.getLongitude()));
        }
        startActivityForResult(intent, GET_LAT_LNG);
    }

    @OnClick(R.id.btn_buscar_dtm)
    public void confirmPublicar() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Esta Seguro de publicar.?");
        builder.setMessage("Por favor ingrese información real que nos ayudara a encontrar a la persona gracias.")
              .setCancelable(false)
              .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      resetError();
                      if (latLng == null) {
                          Toasty.error(getContext(), "Debe elejir una ubicacion en el mapa", Toast.LENGTH_SHORT).show();
                          return;
                      }
                      RadioButton genero = (RadioButton) getView().findViewById(rbtGenero.getCheckedRadioButtonId());
                      if (genero == null) {
                          Toasty.error(getContext(), "Elija el genero", Toast.LENGTH_SHORT).show();
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
                      presenter.publicar(tilCi.getEditText().getText().toString(), tilNombres.getEditText().getText().toString(), tilApellidos.getEditText().getText().toString(), tilEdad.getEditText().getText().toString(), genero.getText().toString(), tilCelular.getEditText().getText().toString(), tilDesaparecion.getEditText().getText().toString(), tilDetalles.getEditText().getText().toString(), String.valueOf(latLng.getLatitude()), String.valueOf(latLng.getLongitude()), tilFecDesaparicion.getEditText().getText().toString(), compresFile, tokenManager);
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


    @Override
    public void showErrorMessage(String message) {
        Toasty.error(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSuccessMessage(String message) {
        Toasty.success(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void resetFormulario() {
        tilCi.getEditText().setText(null);
        tilNombres.getEditText().setText(null);
        tilApellidos.getEditText().setText(null);
        tilEdad.getEditText().setText(null);
        tilCelular.getEditText().setText(null);
        tilDesaparecion.getEditText().setText(null);
        tilDetalles.getEditText().setText(null);
        tilFecDesaparicion.getEditText().setText(null);
        imagePath = null;
        imgGallery.setImageResource(R.drawable.gallery);
        latLng = null;

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
    public void setNombresError(String message) {
        tilNombres.setError(message);
        tilNombres.requestFocus();
    }

    @Override
    public void setApellidosError(String message) {
        tilApellidos.setError(message);
        tilApellidos.requestFocus();
    }

    @Override
    public void setEdadError(String message) {
        tilEdad.setError(message);
        tilEdad.requestFocus();
    }

    @Override
    public void setGeneroError(String message) { }

    @Override
    public void setCelularError(String message) {
        tilCelular.setError(message);
        tilCelular.requestFocus();
    }

    @Override
    public void setDesaparecioError(String message) {
        tilDesaparecion.setError(message);
        tilDesaparecion.requestFocus();
    }

    @Override
    public void setDetallesError(String message) {
        tilDetalles.setError(message);
        tilDetalles.requestFocus();
    }

    @Override
    public void setFechaDesaparicionError(String message) {
        tilFecDesaparicion.setError(message);
        tilDesaparecion.requestFocus();
    }

    public void resetError() {
        progressDialog.dismiss();
        tilNombres.setError(null);
        tilApellidos.setError(null);
        tilEdad.setError(null);
        tilCelular.setError(null);
        tilDesaparecion.setError(null);
        tilDetalles.setError(null);
        tilFecDesaparicion.setError(null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
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
}
