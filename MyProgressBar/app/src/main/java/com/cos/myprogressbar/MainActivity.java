package com.cos.myprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Mainlog";
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar =findViewById(R.id.progressBar);
        download();

        Log.d(TAG, "onCreate :종료");


    }

    private void download(){
        //쓰레드가 동작할 메쓰드을 만들어 준다. 쓰레드는 Runnable 타임이어야 한다.
        //Runnable은 인터페이스이기 때문에 new 할수 없다.
        //인터페이스를 new하면서
//        new Thread( 동작할 메쓰드 ).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    Log.d(TAG,"download : 다운로드시작");
                    Thread.sleep(5000);
                    Log.d(TAG,"download : 다운로드종료");

                    progressBar.setVisibility(View.INVISIBLE);

                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();





    }
}
