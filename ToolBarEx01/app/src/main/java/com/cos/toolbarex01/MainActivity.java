package com.cos.toolbarex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView menuIcon;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
        toolbarSetting();
    }

    private void init(){
        toolbar = findViewById(R.id.toolbar);
        menuIcon = findViewById(R.id.nenu_id);
        drawerLayout = findViewById(R.id.drawer_layout);

    }

    private void toolbarSetting(){
        setSupportActionBar(toolbar);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                네비게이션뷰 스와이프

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });
    }

}
