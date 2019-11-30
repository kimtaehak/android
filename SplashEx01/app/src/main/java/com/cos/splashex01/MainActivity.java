package com.cos.splashex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private List<Integer> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        listView = findViewById(R.id.list_view);
        items = new ArrayList<>();

        //초기값 설정
        items.add(10);
        items.add(20);
        items.add(30);
        items.add(40);
        items.add(50);
        items.add(60);
        items.add(70);

        final ArrayAdapter<Integer> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        //리프레쉬 색상 변경
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_dark);

        //SwipeRefreshlayout에 리스너 달기
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                insertData();  //데이타 추가
                adapter.notifyDataSetChanged();   // 데이타 변경된 것 알려줌
                swipeRefreshLayout.setRefreshing(false);   // 뱅글뱅글 없애줌.
            }
        });
    }

    public void insertData() {
        Random r = new Random();
        //1~100까지 무작위
        int ranNum = r.nextInt(100) + 1;
        items.add(ranNum);
        Collections.sort(items);  //정렬  cf. 배열정렬 Array.sort 사용

    }

}
