package com.cos.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    private Button[] btn = new Button[16];
    private EditText edit1;
    private String value="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        mainListener();

    }

    private void init(){
        btn[0] = findViewById(R.id.Num0);
        btn[1] = findViewById(R.id.Num1);
        btn[2] = findViewById(R.id.Num2);
        btn[3] = findViewById(R.id.Num3);
        btn[4] = findViewById(R.id.Num4);
        btn[5] = findViewById(R.id.Num5);
        btn[6] = findViewById(R.id.Num6);
        btn[7] = findViewById(R.id.Num7);
        btn[8] = findViewById(R.id.Num8);
        btn[9] = findViewById(R.id.Num9);
        btn[10] = findViewById(R.id.add);
        btn[11] = findViewById(R.id.Sub);
        btn[12] = findViewById(R.id.Mul);
        btn[13] = findViewById(R.id.Div);
        btn[14] = findViewById(R.id.Cls);
        btn[15] = findViewById(R.id.Cal);

        edit1 = findViewById(R.id.edit1);

    }

    private void mainListener(){

        //btn[0].setOnClickListener(this); 을 반복문으로 처리

        for(Button b : btn){
            b.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        Log.d(TAG,  "onClick: getId() :" +v.getId());

        switch (v.getId()){
            case R.id.Num0:
                value += btn[0].getText().toString();
                edit1.setText(value);
                break;
            case R.id.Num1:
                value += btn[1].getText().toString();
                edit1.setText(value);
                break;
            case R.id.Num2:
                value += btn[2].getText().toString();
                edit1.setText(value);
                break;
            case R.id.Num3:
                value += btn[3].getText().toString();
                edit1.setText(value);
                break;
            case R.id.Num4:
                value += btn[4].getText().toString();
                edit1.setText(value);
                break;
            case R.id.Num5:
                value += btn[5].getText().toString();
                edit1.setText(value);
                break;
            case R.id.Num6:
                value += btn[6].getText().toString();
                edit1.setText(value);
                break;
            case R.id.Num7:
                value += btn[7].getText().toString();
                edit1.setText(value);
                break;
            case R.id.Num8:
                value += btn[8].getText().toString();
                edit1.setText(value);
                break;
            case R.id.Num9:
                value += btn[9].getText().toString();
                edit1.setText(value);
                break;
            case R.id.Add:
                value += btn[10].getText().toString();
                edit1.setText(value);
                break;
            case R.id.Sub:
                value += btn[11].getText().toString();
                edit1.setText(value);
                break;
            case R.id.Mul:
                value += btn[12].getText().toString();
                edit1.setText(value);
                break;
            case R.id.Div:
                value += btn[13].getText().toString();
                edit1.setText(value);
                break;
            case R.id.Cls:
                edit1.setText("");
                value="";
                break;
            case R.id.Cal:

                String result = Eval.generate(value);
                edit1.setText(result);
                value="";
                break;
        }

    }
}
