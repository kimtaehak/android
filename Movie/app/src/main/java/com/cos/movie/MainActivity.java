package com.cos.movie;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.Rating;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv = findViewById(R.id.gv);

        MyGridAdapter adapter = new MyGridAdapter();

        adapter.addItem(R.drawable.mov01);
        adapter.addItem(R.drawable.mov02);
        adapter.addItem(R.drawable.mov03);
        adapter.addItem(R.drawable.mov04);
        adapter.addItem(R.drawable.mov05);
        adapter.addItem(R.drawable.mov06);
        adapter.addItem(R.drawable.mov07);
        adapter.addItem(R.drawable.mov08);
        adapter.addItem(R.drawable.mov09);
        adapter.addItem(R.drawable.mov10);
        adapter.addItem(R.drawable.mov11);
        adapter.addItem(R.drawable.mov12);

        gv.setAdapter(adapter);

    }

    class MyGridAdapter extends BaseAdapter {


        List<Integer> items = new ArrayList<>();

        public void addItem(Integer item) {
            items.add(item);
        }

        //전체 사이즈 중요. 어댑터는 먼저 전체 사이즈 확인
        @Override
        public int getCount() {
            return items.size();
        }


        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //화면 크기를 계산해서 지금 보여야할 것들을 return. 동작2번 함.
        // 1. 첫번째는 안드로이드가 최초 실행 될때
//            2.스크롤 할때
        public View getView(int position, View convertView, ViewGroup parent) {
            // 그리드에 출력할 이미지
            LayoutInflater inflater1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater1.inflate(R.layout.image_item, parent, false);
            ImageView ivItem = v.findViewById(R.id.iv_item);
            ivItem.setImageResource(items.get(position));

            final int pos = position;
            ivItem.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // 팝업에 출력할 이미지
                    View dialogView = View.inflate(MainActivity.this, R.layout.dialog_item, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPopup = dialogView.findViewById(R.id.iv_popup);
                    ivPopup.setImageResource(items.get(pos));

                    //1. 추가
                    RatingBar ratingBar = dialogView.findViewById(R.id.ratingBar);
                    final TextView tvRating = dialogView.findViewById(R.id.rating);

                    ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                        @Override
                        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                            tvRating.setText(rating + "");
                        }
                    });

                    dlg.setTitle("큰 포스터");
                    dlg.setIcon(R.drawable.movie_icon);


                    // 2. 추가
                    // getSharedPreference는 해당 저장소 이름을 내가 설정한 이름으로 만든다.
                    //SharedPreferences cos = getSharedPreferences("cos", MODE_PRIVATE);
                    final SharedPreferences pref = getSharedPreferences("pref", MainActivity.MODE_PRIVATE);
                    float ratingGet = pref.getFloat("rating" + pos, 0);
                    ratingBar.setRating(ratingGet);
                    tvRating.setText(ratingGet + "");
                    dlg.setView(dialogView);


                    // 3. 추가
                    dlg.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SharedPreferences.Editor ed = pref.edit();
                            float ratingSave = Float.parseFloat(tvRating.getText().toString());
                            Log.d(TAG, "setNegativeButton: " + ratingSave);
                            ed.putFloat("rating" + pos, ratingSave);
                            ed.commit();
                        }
                    });

                    dlg.show();
                }
            });

            return ivItem;
        } // getView() 종료

    }
}