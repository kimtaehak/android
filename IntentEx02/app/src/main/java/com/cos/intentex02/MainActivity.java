package com.cos.intentex02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final User user = new User();
        user.setId(1);
        user.setUsername("name");
        user.setPassword("pppp");

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("phone", "01022223333");

                //bundle,직렬화 해서 보낸다.
                Bundle bundle = new Bundle();
                bundle.putSerializable("user", user );
                intent.putExtras(bundle);


                startActivity(intent);

            }
        });
    }
}
