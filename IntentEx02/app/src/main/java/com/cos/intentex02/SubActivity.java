package com.cos.intentex02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();   // 전달된 자료를 가져온다.
        String phone  = intent.getStringExtra("phone");
        Toast.makeText(this,"phone: " +phone,Toast.LENGTH_SHORT).show();

        //택배박스 해체
        User user = (User)intent.getSerializableExtra("user");
        Toast.makeText(this,"id " +user.getId()+", username :"+user.getUsername()+", password : "+user.getPassword(),Toast.LENGTH_SHORT).show();

        Button button;
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });


    }
}
