package com.cos.contexex01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainLog";
    public String hello = "hello";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ManActivity.this : " + MainActivity.this);
        Log.d(TAG, "onCreate: getApplicationContext() : " + getApplicationContext());

        final Context c1 = MainActivity.this;
        Log.d(TAG, "onCreate: c1.hello : " +((MainActivity) c1).hello);

        final Context c2 = getApplicationContext();

        Toast.makeText(c2, "토스트메세지", Toast.LENGTH_SHORT).show();

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context c3 = v.getContext();
                Log.d(TAG, "onClick: c3.hello : " +((MainActivity)c3).hello);

                AlertDialog.Builder builder = new AlertDialog.Builder(c3);

                builder.setTitle("인사말").setMessage("반갑습니다");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                Toast.makeText(c3, "안녕", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
