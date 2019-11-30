package com.cos.listtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  ListView lv1;
    private EditText etInput;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv1 = findViewById(R.id.lv_1);
        etInput = findViewById(R.id.et_input);
        btnAdd = findViewById(R.id.btn_add);



        final List<String> mid = new ArrayList<>();
        mid.add("히어로");
        mid.add("24시");
        mid.add("로스트");


                //데이타  , final을 붙이면 죽지 않는다.!!!
//        final List<String> mid = Arrays.asList("히어로즈", "24시", "로스트", "로스트룸", "스몰빌", "탐정몽크",
//                "빅뱅이론", "프렌즈", "덱스터", "글리", "가쉽걸", "테이큰", "슈퍼내추럴", "브이");

        //어댑터
        final ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mid);

        //합치기
        lv1.setAdapter(adapter);

        // 아이템을 클릭 했을때 실행 (lv1이 눌러졌을때 아이템이 보이는것이 .setOnItem  <- 대충 기억, new AdapterView을 누르면 문법 알아서 구성해줌
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //화면 표시 형태 Toast.
//                Toast.makeText(MainActivity.this, "클릭됨"+ position, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, mid.get(position), Toast.LENGTH_SHORT).show();

            }
        });


        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mid.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInput.getText()+"";
//                String input = etInput.getText().toString();
                mid.add(input);
                adapter.notifyDataSetChanged();
            }
        });

        etInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                && event, getAction() == keyEVENT
                if (keyCode == KeyEvent.KEYCODE_ENTER ) {
                    mid.add(etInput.getText().toString());
                    adapter.notifyDataSetChanged();
                    return true;
                }
                    return false;
            }
        });

    }



}


