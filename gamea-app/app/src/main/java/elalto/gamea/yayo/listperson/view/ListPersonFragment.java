package elalto.gamea.yayo.listperson.view;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import elalto.gamea.R;
import elalto.gamea.yayo.listperson.adapters.DesaparecidosAdapter;
import elalto.gamea.yayo.listperson.entities.Desaparecido;
import elalto.gamea.yayo.listperson.model.ListPersonInteractorImpl;
import elalto.gamea.yayo.listperson.presenter.ListPersonPresenter;
import elalto.gamea.yayo.listperson.presenter.ListPersonPresenterImpl;
import elalto.network.entities.TokenManager;
import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListPersonFragment extends Fragment implements ListPersonView {
    public ProgressDialog progressDialog;
    TokenManager tokenManager;
    RecyclerView rvDesaparecidos;
    DesaparecidosAdapter desaparecidosAdapter;
    private ListPersonPresenter presenter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public ListPersonFragment() {
    }

    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_person, container, false);
        ButterKnife.bind(this, view);
        presenter = new ListPersonPresenterImpl(this, new ListPersonInteractorImpl());
        progressDialog = new ProgressDialog(getActivity());
        toolbar.setTitle("Adultos desaparecidos");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        tokenManager = TokenManager.getInstance(getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE));
        progressDialog.setMessage("Obteninedo informacion...");
        progressDialog.setCancelable(false);
        presenter.getDesaparecidos(tokenManager);
        rvDesaparecidos = (RecyclerView) view.findViewById(R.id.rv_desaparecidos);
        rvDesaparecidos.setHasFixedSize(true);
        rvDesaparecidos.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
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
    public void showError(String message) {
        progressDialog.dismiss();
        Toasty.error(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setAdapter(List<Desaparecido> desaparecidoList) {
        desaparecidosAdapter = new DesaparecidosAdapter(desaparecidoList, getContext());
        rvDesaparecidos.setAdapter(desaparecidosAdapter);
    }

    @Override
    public void back() {


    }
}
