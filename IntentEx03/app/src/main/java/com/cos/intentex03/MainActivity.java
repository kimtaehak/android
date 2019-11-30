package com.cos.intentex03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView mTextViewResult;
    private EditText mEditTextNumber1;
    private EditText mEditTextNumber2;
    private Button buttonOpenotheRActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.text_view_result);
        mEditTextNumber1 = findViewById(R.id.edit_text_number1);
        mEditTextNumber2 = findViewById(R.id.edit_text_number2);

        Button buttonOpenActivity = findViewById(R.id.button_open_activity2);

        buttonOpenActivity.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                int number1 = Integer.parseInt(mEditTextNumber1.getText().toString());
                int number2 = Integer.parseInt(mEditTextNumber2.getText().toString());

                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                intent.putExtra("number1", number1);
                intent.putExtra("number2", number2);
                startActivityForResult(intent, 50);   //50은 임의의 지정숫자





            }
        });

    }


    // finish 될때 자동호출 된다.

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // requestCode로 target을 확인한다.
        if (requestCode == 50) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra("result", 0);
                mTextViewResult.setText("" + result);
            }
            if (resultCode == RESULT_CANCELED) {
                mTextViewResult.setText("Nothing selected");
            }
        }
    }

}
