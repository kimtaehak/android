package com.cos.intentex03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    private TextView textViewNumbers;
    private Button buttonAdd, buttonSubtract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Intent intent = getIntent();
        final int number1 = intent.getIntExtra("number1", 0);
        final int number2 = intent.getIntExtra("number2", 0);


        TextView textViewNumbers = findViewById(R.id.text_view_numbers);
        buttonAdd= findViewById(R.id.button_add);
        buttonSubtract= findViewById(R.id.button_subtract);

        textViewNumbers.setText("Numbers: " + number1 + ", " + number2);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result = number1 + number2;
                Intent intent = new Intent();    //호출한 곳으로 가기 위해서 새로 경로 지정 하지 않는다.
                intent.putExtra("result", result);

                setResult(RESULT_OK,intent);

                finish();  //Intent정보를 가져감.



            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result = number1 - number2;
                Intent intent = new Intent();    //호출한 곳으로 가기 위해서 새로 경로 지정 하지 않는다.
                intent.putExtra("result", result);

                setResult(RESULT_OK,intent);

                finish();  //Intent정보를 가져감.

            }
        });

    }
}
