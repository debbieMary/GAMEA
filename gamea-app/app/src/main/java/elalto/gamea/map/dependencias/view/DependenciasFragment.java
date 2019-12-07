package elalto.gamea.map.dependencias.view;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import elalto.gamea.R;
import elalto.gamea.map.dependencias.adapter.DependenciasAdapter;
import elalto.gamea.map.dependencias.entities.Dependencias;
import elalto.gamea.map.dependencias.model.DependenciasInteractorImpl;
import elalto.gamea.map.dependencias.presenter.DependenciasPresenter;
import elalto.gamea.map.dependencias.presenter.DependenciasPresenterImpl;
import es.dmoral.toasty.Toasty;

public class DependenciasFragment extends Fragment implements DependenciasView, DependenciasAdapter.DependenciaAdapterListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private ProgressDialog progressDialog;
    private DependenciasPresenter presenter;
    RecyclerView rvDependencias;
    DependenciasAdapter dependenciasAdapter;
    SearchView searchView;

    public DependenciasFragment() {
    }

    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dependencias, container, false);
        ButterKnife.bind(this, view);
        presenter = new DependenciasPresenterImpl(this, new DependenciasInteractorImpl());
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Obteniendo informacion...");
        progressDialog.setCancelable(false);
        toolbar.setTitle("Dependencias GAMEA");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        rvDependencias = (RecyclerView) view.findViewById(R.id.rv_dependencias);
        rvDependencias.setHasFixedSize(true);
        rvDependencias.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        presenter.getDependencias();
        setHasOptionsMenu(true);
        return view;
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
    public void navigateToBack() {

    }

    @Override
    public void showErrorMessage(String message) {
        Toasty.error(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getDependencias(List<Dependencias> dependencias) {
        dependenciasAdapter = new DependenciasAdapter(dependencias, getContext(), this);
        rvDependencias.setAdapter(dependenciasAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_dependencia, menu);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dependenciasAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                dependenciasAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return;
    }

    @Override
    public void onDependenciaSelected(Dependencias dependencia) {
        Toasty.info(getContext(), dependencia.getSecretaria(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), MapDependenciaActivity.class);
        intent.putExtra("dependencia", dependencia);
        getActivity().startActivity(intent);
    }
}
