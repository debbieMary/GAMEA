package elalto.gamea.map.canchas.view;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
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
import elalto.gamea.map.canchas.entities.Cancha;
import elalto.gamea.map.canchas.entities.CanchaCobro;
import elalto.gamea.map.canchas.model.CanchaCobroInteractor;
import elalto.gamea.map.canchas.model.CanchasInteractorImpl;
import elalto.gamea.map.canchas.presenter.CanchaCobroPresenter;
import elalto.gamea.map.canchas.presenter.CanchaCobroPresenterImpl;
import elalto.gamea.map.canchas.presenter.CanchasPresenter;
import elalto.gamea.map.canchas.presenter.CanchasPresenterImpl;
import elalto.network.entities.TokenManager;
import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class CanchasFragment extends Fragment implements OnMapReadyCallback, PermissionsListener, CanchasView, CanchaCobroView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private MapView mapView;
    private MapboxMap mapboxMap;
    public ProgressDialog progressDialog;
    TokenManager tokenManager;
    List<MarkerOptions> markerOptionsList;
    List<MarkerOptions> markerOptionsListCobros;
    private CanchasPresenter presenter;
    private CanchaCobroPresenter presenterCobro;
    private PermissionsManager permissionsManager;

    public CanchasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Mapbox.getInstance(getContext(), getString(R.string.map_token));
        View view = inflater.inflate(R.layout.fragment_canchas, container, false);
        ButterKnife.bind(this, view);
        presenter = new CanchasPresenterImpl(this, new CanchasInteractorImpl());
        presenterCobro = new CanchaCobroPresenterImpl(this, new CanchasInteractorImpl());

        progressDialog = new ProgressDialog(getActivity());
        toolbar.setTitle("Canchas deportivas");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        tokenManager = TokenManager.getInstance(getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE));
        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        progressDialog.setMessage("Obteniendo informacion...");
        progressDialog.setCancelable(false);
        //progressDialog.show();
        return view;
    }

    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        CanchasFragment.this.mapboxMap = mapboxMap;
        mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
            @Override
            public void onStyleLoaded(@NonNull Style style) {
                enableLocationPlugin(style);
                presenter.getCanchas(tokenManager);
            }
        });
    }

    @SuppressWarnings({"MissingPermission"})
    private void enableLocationPlugin(@NonNull Style loadedMapStyle) {
        if (PermissionsManager.areLocationPermissionsGranted(getActivity())) {
            LocationComponent locationComponent = mapboxMap.getLocationComponent();
            locationComponent.activateLocationComponent(getActivity(), loadedMapStyle);
            locationComponent.setLocationComponentEnabled(true);
            locationComponent.setCameraMode(CameraMode.TRACKING);
            locationComponent.setRenderMode(RenderMode.COMPASS);
            locationComponent.zoomWhileTracking(15);
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
    public void populateMap(List<Cancha> canchaList) {
        IconFactory iconFactory = IconFactory.getInstance(getActivity());
        Icon icon = iconFactory.fromResource(R.drawable.cancha);
        markerOptionsList = new ArrayList<>();
        for (int i = 0; i < canchaList.size(); i++) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(new LatLng(canchaList.get(i).getLat(), canchaList.get(i).getLng()));
            markerOptions.icon(icon);
            markerOptions.snippet(String.valueOf(canchaList.get(i).getId_cancha()));
            markerOptions.title(canchaList.get(i).getNombre_cancha().toString());
            markerOptionsList.add(markerOptions);
        }
        mapboxMap.addMarkers(markerOptionsList);
        mapboxMap.setOnMarkerClickListener(new MapboxMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                marker.getInfoWindow();
                if(!marker.getTitle().contains("Punto: ")){
                    Intent i = new Intent(getContext(), CanchaInformacionActivity.class);
                    i.putExtra("nombre", marker.getTitle());
                    i.putExtra("id_cancha", marker.getSnippet());
                    startActivity(i);
                }
                return false;
            }
        });
        presenterCobro.getCobros(tokenManager);
    }


    @Override
    public void showErrorMessage(String message) {
        Toasty.error(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressCC() {
        progressDialog.show();
    }

    @Override
    public void hideProgressCC() {
        progressDialog.hide();
    }

    @Override
    public void populateMapCC(List<CanchaCobro> canchaCobroList) {
        IconFactory iconFactory = IconFactory.getInstance(getActivity());
        Icon icon = iconFactory.fromResource(R.drawable.hospital);
        markerOptionsListCobros = new ArrayList<>();
        for (int i = 0; i < canchaCobroList.size(); i++) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(new LatLng(canchaCobroList.get(i).getLatitud(), canchaCobroList.get(i).getLongitud()));
            markerOptions.icon(icon);
            markerOptions.setSnippet("Tel: " +canchaCobroList.get(i).getTelefono().toString());
            markerOptions.title("Punto: "+canchaCobroList.get(i).getNombre_cobro().toString());
            markerOptionsListCobros.add(markerOptions);
        }
        mapboxMap.addMarkers(markerOptionsListCobros);
    }

    @Override
    public void showErrorMessageCC(String message) {
        Toasty.error(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
