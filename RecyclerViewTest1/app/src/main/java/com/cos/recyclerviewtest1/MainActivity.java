package com.cos.recyclerviewtest1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvSetting();
        rvDataSetting();
    }

    private void rvSetting(){
        recyclerView = findViewById(R.id.rv_1);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void rvDataSetting(){
        PersonAdapter adapter = new PersonAdapter();

        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));
        adapter.addItem(new Person(R.drawable.ic_launcher_background, "홍길동", "01022228888"));

        recyclerView.setAdapter(adapter);
    }
}