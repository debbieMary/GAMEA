package elalto.gamea.map.canchas.view;

import elalto.gamea.R;
import elalto.gamea.map.canchas.entities.CanchaInfo;
import elalto.gamea.map.canchas.model.CanchasInteractorImpl;
import elalto.gamea.map.canchas.presenter.CanchaCobroPresenter;
import elalto.gamea.map.canchas.presenter.CanchasInfoPresenter;
import elalto.gamea.map.canchas.presenter.CanchasInfoPresenterImpl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class CanchaInformacionActivity extends AppCompatActivity implements CanchasInfoView {

    CanchasInfoPresenter canchasInfoPresenter;
    Bundle bundle;
    String nombre_cancha;
    String id_cancha;
    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    String tag= "[INFORMACION_CANCHA]";
    TextView lbl_nombre_cancha;
    ProgressDialog progressDialog;
    Button horarios_disponibles;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancha_informacion);
        bundle= getIntent().getExtras();
        nombre_cancha= bundle.getString("nombre");
        id_cancha= bundle.getString("id_cancha");
        Log.e(tag,nombre_cancha+" "+id_cancha);
        horarios_disponibles= (Button) this.findViewById(R.id.btn_ver_horarios_disponibles);
        horarios_disponibles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verHorariosDisponibles();
            }
        });
        lbl_nombre_cancha= (TextView) this.findViewById(R.id.lbl_nombre_cancha);
        lbl_nombre_cancha.setText(nombre_cancha);
        canchasInfoPresenter = new CanchasInfoPresenterImpl(this, new CanchasInteractorImpl());
        canchasInfoPresenter.getCanchasInfo(id_cancha);
        mCustomPagerAdapter = new CustomPagerAdapter(this);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);

        lbl_tipo_escenario= (TextView) this.findViewById(R.id.lbl_tipo_escenario);
        lbl_muro_perimetral= (TextView) this.findViewById(R.id.lbl_muro_perimetral);
        lbl_techo= (TextView) this.findViewById(R.id.lbl_techo);
        lbl_se_encuentra= (TextView) this.findViewById(R.id.lbl_se_encuentra);
        lbl_administrado_por= (TextView) this.findViewById(R.id.lbl_administrado_por);
        lbl_graderias= (TextView) this.findViewById(R.id.lbl_graderias);
        lbl_banhio= (TextView) this.findViewById(R.id.lbl_banhio);
        lbl_camerinos= (TextView) this.findViewById(R.id.lbl_camerinos);
        lbl_horarios_acceso_libre= (TextView) this.findViewById(R.id.lbl_horarios_acceso_libre);
        lbl_realizado_por= (TextView) this.findViewById(R.id.lbl_realizado_por);
        lbl_estado= (TextView) this.findViewById(R.id.lbl_estado);
        lbl_distrito= (TextView) this.findViewById(R.id.lbl_distrito);
        lbl_direccion= (TextView) this.findViewById(R.id.lbl_direccion);
        lbl_telefono= (TextView) this.findViewById(R.id.lbl_telefono);
    }

    public void verHorariosDisponibles(){
        Intent i= new  Intent(this, ReservarCanchaActivity.class);
        i.putExtra("id_cancha",  id_cancha);
        startActivity(i);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void populateInfo(List<CanchaInfo> canchaInfoObject) {
        lbl_tipo_escenario.setText(canchaInfoObject.get(0).getTipo_escenario_deportivo());
        lbl_muro_perimetral.setText(canchaInfoObject.get(0).getTiene_perimetral());
        lbl_techo.setText(canchaInfoObject.get(0).getTiene_tinglado_techo());
        lbl_se_encuentra.setText(canchaInfoObject.get(0).getSe_encuentra());
        lbl_administrado_por.setText(canchaInfoObject.get(0).getAdministrado_por());
        lbl_graderias.setText(canchaInfoObject.get(0).getGraderias());
        lbl_banhio.setText(canchaInfoObject.get(0).getBanos());
        lbl_camerinos.setText(canchaInfoObject.get(0).getCamerinos());
        lbl_horarios_acceso_libre.setText(canchaInfoObject.get(0).getAcceso_libre());
        lbl_realizado_por.setText(canchaInfoObject.get(0).getQuien_realizo());
        lbl_estado.setText(canchaInfoObject.get(0).getEstado());
        lbl_distrito.setText(canchaInfoObject.get(0).getDistrito());
        lbl_direccion.setText(canchaInfoObject.get(0).getDireccion());
        lbl_telefono.setText(canchaInfoObject.get(0).getTelefono());
    }

    @Override
    public void showErrorMessage(String message) {

    }
}
