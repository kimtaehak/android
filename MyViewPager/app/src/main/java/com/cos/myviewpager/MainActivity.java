package com.cos.myviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView menuIcon;
    private MyFragmentPagerAdapter adapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        toolbarSetting();
        viewPagerSetting();
        tabLayoutSetting();
    }

    private void init(){
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationview);
        menuIcon = findViewById(R.id.menu_Icon);
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),1);  //공식적으로 넣어줌
        mViewPager = findViewById(R.id.container);
        tabLayout = findViewById(R.id.tabs);
    }

    private void toolbarSetting(){
        //Toolbar를 기본 Appbar로 지정하기
        setSupportActionBar(toolbar);

        //menuIcon에 이벤트 달기
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void tabLayoutSetting(){
        tabLayout.setupWithViewPager(mViewPager);  //Viewpager와 Tablayout연결
        tabLayout.getTabAt(0).setText(adapter.getFragmentTitle(0));
        tabLayout.getTabAt(1).setText(adapter.getFragmentTitle(1));
        tabLayout.getTabAt(2).setText(adapter.getFragmentTitle(2));
    }

    private void viewPagerSetting(){
        adapter.addFragment(new FragmentFirst(), "첫번째 프레그먼트");
        adapter.addFragment(new FragmentSecond(), "두번째 프레그먼트");
        adapter.addFragment(new FragmentThird(), "세번째 프레그먼트");
        mViewPager.setAdapter(adapter);  //Viewpager와 Fragment 연결
    }
}
