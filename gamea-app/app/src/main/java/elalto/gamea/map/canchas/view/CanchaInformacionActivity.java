package elalto.gamea.map.canchas.view;

import elalto.gamea.R;
import elalto.gamea.map.canchas.model.CanchasInteractorImpl;
import elalto.gamea.map.canchas.presenter.CanchasInfoPresenter;
import elalto.gamea.map.canchas.presenter.CanchasInfoPresenterImpl;
import elalto.gamea.map.canchas.presenter.UserCanchasPresenter;
import elalto.gamea.map.canchas.presenter.UserCanchasPresenterImpl;
import elalto.network.canchas.entities.CanchaInfo;
import elalto.network.canchas.entities.ListarUserBody;
import elalto.network.canchas.entities.UserCanchas;
import elalto.network.entities.UserManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CanchaInformacionActivity extends AppCompatActivity implements CanchasInfoView, UserCanchasView {

    CanchasInfoPresenter canchasInfoPresenter;
    UserCanchasPresenter userCanchasPresenter;
    Toolbar toolbar;
    Bundle bundle;
    String nombre_cancha;
    String id_cancha, distrito;
    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    String tag = "[INFORMACION_CANCHA]";
    TextView lbl_nombre_cancha;
    ProgressDialog progressDialog;
    TextView lbl_tipo_escenario;
    TextView lbl_muro_perimetral;
    TextView lbl_techo;
    TextView lbl_se_encuentra;
    TextView lbl_administrado_por;
    TextView lbl_graderias;
    TextView lbl_banhio;
    TextView lbl_camerinos;
    TextView lbl_horarios_acceso_libre;
    TextView lbl_realizado_por;
    TextView lbl_estado;
    TextView lbl_distrito;
    TextView lbl_direccion;
    TextView lbl_telefono;
    TextView lbl_precio_hora;
    Integer precio_hora;
    UserManager userManager = new UserManager();

    ArrayList<String> images = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancha_informacion);
        bundle = getIntent().getExtras();
        nombre_cancha = bundle.getString("nombre");
        id_cancha = bundle.getString("id_cancha");
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("INFORMACIÓN DE CANCHAS");
        Log.e(tag, nombre_cancha + " " + id_cancha);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Obteniendo informacion...");
        progressDialog.setCancelable(false);

        lbl_nombre_cancha = (TextView) this.findViewById(R.id.lbl_nombre_cancha);
        lbl_nombre_cancha.setText(nombre_cancha);
        canchasInfoPresenter = new CanchasInfoPresenterImpl(this, new CanchasInteractorImpl());
        canchasInfoPresenter.getCanchasInfo(id_cancha);
        userCanchasPresenter = new UserCanchasPresenterImpl(this, new CanchasInteractorImpl());
    }

    public void verHorariosDisponibles(View v) {
        Intent i = new Intent(this, HorariosDisponiblesActivity.class);
        i.putExtra("id_cancha", id_cancha);
        i.putExtra("distrito", distrito);
        i.putExtra("precio_hora", precio_hora);
        i.putExtra("nombre_cancha", nombre_cancha);
        startActivity(i);
    }


    public void verMisReservas(View v) {
        Intent i = new Intent(this, MisReservasActivity.class);
        startActivity(i);
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public void populateUser(List<UserCanchas> userCanchas) {
        userManager.saveIdUser(this, userCanchas.get(0).getIdUser());
        userManager.saveUserName(this, userCanchas.get(0).getNombres()+ " " + userCanchas.get(0).getApellidos());
    }

    @Override
    public void populateInfo(List<CanchaInfo> canchaInfoObject) {
        initLabelInformation();
        lbl_tipo_escenario.setText(canchaInfoObject.get(0).getTipoEscenarioDeportivo());
        lbl_muro_perimetral.setText(canchaInfoObject.get(0).getTienePerimetral());
        lbl_techo.setText(canchaInfoObject.get(0).getTieneTingladoTecho());
        lbl_se_encuentra.setText(canchaInfoObject.get(0).getSeEncuentra());
        lbl_administrado_por.setText(canchaInfoObject.get(0).getAdministradoPor());
        lbl_graderias.setText(canchaInfoObject.get(0).getGraderias());
        lbl_banhio.setText(canchaInfoObject.get(0).getBanos());
        lbl_camerinos.setText(canchaInfoObject.get(0).getCamerinos());
        lbl_horarios_acceso_libre.setText(canchaInfoObject.get(0).getAccesoLibre());
        lbl_realizado_por.setText(canchaInfoObject.get(0).getQuienRealizo() + "");
        lbl_estado.setText(canchaInfoObject.get(0).getEstado());
        distrito = canchaInfoObject.get(0).getDistrito();
        lbl_distrito.setText(distrito);
        lbl_direccion.setText(canchaInfoObject.get(0).getDireccion());
        lbl_telefono.setText(canchaInfoObject.get(0).getTelefono());
        canchaInfoObject.get(0).getPrecioHora();
        precio_hora = canchaInfoObject.get(0).getPrecioHora();
        lbl_precio_hora.setText("Bs. " + precio_hora);
        images.add(canchaInfoObject.get(0).getFoto1());
        images.add(canchaInfoObject.get(0).getFoto2());
        images.add(canchaInfoObject.get(0).getFoto3());
        setViewPagerImages();
        getUserInformation();
    }


    public void getUserInformation() {
        String userCi = userManager.getCi(this);
        if (!userCi.equals("")) {
            ListarUserBody listarUserBody = new ListarUserBody();
            listarUserBody.setCi(userCi);
            userCanchasPresenter.getUser(listarUserBody);
        } else {
            Toast.makeText(this, "No se pudo obtener datos de usuario", Toast.LENGTH_LONG).show();
        }
    }

    public void setViewPagerImages() {
        mCustomPagerAdapter = new CustomPagerAdapter(this, images);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);
    }

    public void initLabelInformation() {

        lbl_tipo_escenario = (TextView) this.findViewById(R.id.lbl_tipo_escenario);
        lbl_muro_perimetral = (TextView) this.findViewById(R.id.lbl_muro_perimetral);
        lbl_techo = (TextView) this.findViewById(R.id.lbl_techo);
        lbl_se_encuentra = (TextView) this.findViewById(R.id.lbl_se_encuentra);
        lbl_administrado_por = (TextView) this.findViewById(R.id.lbl_administrado_por);
        lbl_graderias = (TextView) this.findViewById(R.id.lbl_graderias);
        lbl_banhio = (TextView) this.findViewById(R.id.lbl_banhio);
        lbl_camerinos = (TextView) this.findViewById(R.id.lbl_camerinos);
        lbl_horarios_acceso_libre = (TextView) this.findViewById(R.id.lbl_horarios_acceso_libre);
        lbl_realizado_por = (TextView) this.findViewById(R.id.lbl_realizado_por);
        lbl_estado = (TextView) this.findViewById(R.id.lbl_estado);
        lbl_distrito = (TextView) this.findViewById(R.id.lbl_distrito);
        lbl_direccion = (TextView) this.findViewById(R.id.lbl_direccion);
        lbl_telefono = (TextView) this.findViewById(R.id.lbl_telefono);
        lbl_precio_hora = (TextView) this.findViewById(R.id.lbl_precio_hora);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
