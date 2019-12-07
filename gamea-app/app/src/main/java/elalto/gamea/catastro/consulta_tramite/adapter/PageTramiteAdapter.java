package elalto.gamea.catastro.consulta_tramite.adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import elalto.gamea.catastro.consulta_tramite.entities.Tramite;
import elalto.gamea.catastro.consulta_tramite.view.TabGeneral;
import elalto.gamea.catastro.consulta_tramite.view.TabHistorial;

public class PageTramiteAdapter extends FragmentStatePagerAdapter {
    int counttab;
    Tramite tramite;

    public PageTramiteAdapter(FragmentManager fm, int counttab, Tramite tramite) {
        super(fm);
        this.counttab = counttab;
        this.tramite = tramite;
    }

    @Override
    public Fragment getItem(int i) {
        Bundle args = new Bundle();
        switch (i) {
            case 0:
                TabGeneral tabGeneral = new TabGeneral();
                args.putSerializable("tramite", tramite);
                tabGeneral.setArguments(args);
                return tabGeneral;
            case 1:
                TabHistorial tabHistorial = new TabHistorial();
                args.putSerializable("tramite", tramite);
                tabHistorial.setArguments(args);
                return tabHistorial;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return counttab;
    }
}
