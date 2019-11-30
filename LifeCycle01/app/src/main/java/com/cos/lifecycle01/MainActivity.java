package com.cos.lifecycle01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainLog";
    private int saveNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
        // 데이터 저장하기!!
        // 1. 전역 변수저장 변경하기
        saveNum = 100;

        // 2. 내부 저장소 (파일)
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);  //다른 액티비티랑 앱에서 접근 불가능
        SharedPreferences.Editor editor = pref.edit(); //해쉬 테이블
        editor.putString("saveStr", "코스");
        editor.commit();  //화일에 기록
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 데이터 읽기!!
        // 1. 전역변수
        Log.d(TAG, "onResume: saveNum : "+saveNum);

        // 2. 내부 저장소 (파일)
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        String saveStr = pref.getString("saveStr", "");
        Log.d(TAG, "onResume: saveStr : "+saveStr);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");

    }
}