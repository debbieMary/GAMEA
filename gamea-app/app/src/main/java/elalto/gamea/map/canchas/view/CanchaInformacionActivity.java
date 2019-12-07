package elalto.gamea.map.canchas.view;

import elalto.gamea.R;
import elalto.gamea.map.canchas.entities.CanchaInfo;
import elalto.gamea.map.canchas.model.CanchasInteractorImpl;
import elalto.gamea.map.canchas.presenter.CanchasInfoPresenter;
import elalto.gamea.map.canchas.presenter.CanchasInfoPresenterImpl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancha_informacion);
        bundle= getIntent().getExtras();
        nombre_cancha= bundle.getString("nombre");
        id_cancha= bundle.getString("id_cancha");
        Log.e(tag,nombre_cancha+" "+id_cancha);
        lbl_nombre_cancha= (TextView) this.findViewById(R.id.lbl_nombre_cancha);
        lbl_nombre_cancha.setText(nombre_cancha);
        canchasInfoPresenter = new CanchasInfoPresenterImpl(this, new CanchasInteractorImpl());
        canchasInfoPresenter.getCanchasInfo(id_cancha);
        mCustomPagerAdapter = new CustomPagerAdapter(this);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);
        /*progressDialog.setMessage("Obteniendo informacion...");
        progressDialog.setCancelable(false);*/
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void populateInfo(List<CanchaInfo> canchaList) {

    }

    @Override
    public void showErrorMessage(String message) {

    }
}
