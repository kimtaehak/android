package com.cos.myfirstevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button btnCount;
    private Button btnMinus;
    private TextView tvCount;
    private int count = 0;

    // 최초실행은 onCreate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Inflater 부풀리다.즉 실행하다

        //레퍼런스 찾기
        init();

        settings();

        // 리스너 등록
        mainListener();

    }


    private void init() {
        btnCount = findViewById(R.id.btn_count);   //type을 알아서 변환 해준다. 디자인의 버튼을 객체화해서 변수로 지정
        btnMinus = findViewById(R.id.btn_minus);
        tvCount = findViewById(R.id.tv_count);
    }

    private void settings() {
        tvCount.setText(count + "");
    }

    private void mainListener() {
        //리스너 등록 완료
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override  //타킷만들기
            public void onClick(View v) {
                Log.d(TAG, "onClick: 버튼 호출됨");
                count++;
                tvCount.setText(count + "");

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                tvCount.setText(count +"");

            }
        });
    }

}
