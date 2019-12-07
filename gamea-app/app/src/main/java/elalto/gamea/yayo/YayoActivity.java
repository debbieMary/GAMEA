package elalto.gamea.yayo;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import elalto.gamea.R;
import elalto.gamea.yayo.addperson.view.AddPersonFragment;
import elalto.gamea.yayo.listperson.view.ListPersonFragment;

public class YayoActivity extends AppCompatActivity {
    AddPersonFragment addPersonFragment;
    ListPersonFragment listPersonFragment;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.listPerson:
                    setFragment(listPersonFragment);
                    return true;
                case R.id.addPerson:
                    setFragment(addPersonFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yayo);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        addPersonFragment = new AddPersonFragment();
        listPersonFragment = new ListPersonFragment();
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.listPerson);
    }

    private void setFragment(Fragment fragment) {
        if (findViewById(R.id.container_yayo )!=null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container_yayo, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
