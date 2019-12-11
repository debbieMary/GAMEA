package elalto.gamea.map.canchas.view.Adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import elalto.gamea.map.canchas.view.FragmentToday;
import elalto.gamea.map.canchas.view.FragmentTomorrow;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentToday tab1 = new FragmentToday();
                return tab1;
            case 1:
                FragmentTomorrow tab2 = new FragmentTomorrow();
                return tab2;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
