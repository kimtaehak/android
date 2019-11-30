package com.cos.bottonnavigationviewex01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.DialogTitle;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //화면이 회전하거나 빠르게 변할때 view안의 데이터를 저장하려면 savedInstanceState를 사용
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        mainListener();
    }

    private void init() {
        bnv = findViewById(R.id.bottom_navigation);
    }

    private void mainListener() {
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationCustom());
    }

    class BottomNavigationCustom implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override

         public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.nav_search:
                    selectedFragment = new SearchFragment();
                    break;
                case R.id.nav_setting:
                    selectedFragment = new SettingFrament();
                    break;
                case R.id.nav_menu:
                    selectedFragment = new MenuFragment();
                    break;
            }


            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    }
}