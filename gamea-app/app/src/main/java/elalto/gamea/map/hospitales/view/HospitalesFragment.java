package elalto.gamea.map.hospitales.view;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import elalto.gamea.R;
import elalto.gamea.denuncia.MapReportesActivity;
import elalto.gamea.map.hospitales.entities.HospitalPoint;
import elalto.gamea.map.hospitales.model.HospitalInteractorImpl;
import elalto.gamea.map.hospitales.presenter.HospitalPresenter;
import elalto.gamea.map.hospitales.presenter.HospitalPresenterImpl;
import elalto.network.entities.TokenManager;
import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class HospitalesFragment extends Fragment implements OnMapReadyCallback, PermissionsListener, HospitalView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private MapView mapView;
    private MapboxMap mapboxMap;
    public ProgressDialog progressDialog;
    TokenManager tokenManager;
    private HospitalPresenter presenter;
    List<MarkerOptions> markerOptionsList;
    private PermissionsManager permissionsManager;
    public HospitalesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Mapbox.getInstance(getContext(), getString(R.string.map_token));
        View view = inflater.inflate(R.layout.fragment_hospitales, container, false);
        ButterKnife.bind(this, view);
        presenter = new HospitalPresenterImpl(this, new HospitalInteractorImpl());
        progressDialog = new ProgressDialog(getActivity());
        toolbar.setTitle("Hospitales");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        tokenManager = TokenManager.getInstance(getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE));
        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        progressDialog.setMessage("Obteniendo informacion...");
        progressDialog.setCancelable(false);
        return view;
    }

    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        HospitalesFragment.this.mapboxMap = mapboxMap;
        mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
            @Override
            public void onStyleLoaded(@NonNull Style style) {
                enableLocationPlugin(style);
                presenter.getHospitales(tokenManager);
            }
        });
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
    public void populateMap(List<HospitalPoint> hospitalPoints) {
        IconFactory iconFactory = IconFactory.getInstance(getActivity());
        Icon icon = iconFactory.fromResource(R.drawable.hospital);
        markerOptionsList = new ArrayList<>();
        for (int i = 0; i < hospitalPoints.size(); i++){
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(new LatLng(hospitalPoints.get(i).getLat(),hospitalPoints.get(i).getLng()));
            markerOptions.icon(icon);

            if (TextUtils.isEmpty(hospitalPoints.get(i).getHospital())){
                markerOptions.title(hospitalPoints.get(i).getZona().toString());
            }else{
                markerOptions.title(hospitalPoints.get(i).getHospital().toString());
            }

            markerOptions.setSnippet(hospitalPoints.get(0).getTipo());
            markerOptionsList.add(markerOptions);
        }
        mapboxMap.addMarkers(markerOptionsList);
    }



    @Override
    public void showErrorMessage(String message) {
        Toasty.error(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings({"MissingPermission"})
    private void enableLocationPlugin(@NonNull Style loadedMapStyle) {
        if (PermissionsManager.areLocationPermissionsGranted(getActivity())) {
            LocationComponent locationComponent = mapboxMap.getLocationComponent();
            locationComponent.activateLocationComponent(getActivity(), loadedMapStyle);
            locationComponent.setLocationComponentEnabled(true);
            locationComponent.setCameraMode(CameraMode.TRACKING);
            locationComponent.setRenderMode(RenderMode.COMPASS);
            locationComponent.zoomWhileTracking(14);
        } else {
            permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(getActivity());
        }
    }

    @Override
    @SuppressWarnings({"MissingPermission"})
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }


    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {

    }

    @Override
    public void onPermissionResult(boolean granted) {
        if (granted && mapboxMap != null) {
            Style style = mapboxMap.getStyle();
            if (style != null) {
                enableLocationPlugin(style);
            }
        } else {
            Toast.makeText(getActivity(), "Debe aceptar los permisos de gps", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
