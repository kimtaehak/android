package com.cos.recyclerviewtest1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * ViewHolder란 view를 꼽아두는 객체이다. 주의할 점은 하나의 view만 관리하는 객체이다.
 */


//리사이클뷰에  필요한 RecyclerView.Adapter

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder>         {

    List<Person> list = new ArrayList<>();

    //규칙: 뷰홀더가 필요하고 리사이클뷰홀더를 상속하면 된다.
// 뷰홀더에 담길애들을 만들어준다.(중요)

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivProfile;
        private TextView tvName;
        private TextView tvPhone;

        public MyViewHolder(View personItemView) {
            super(personItemView);
            ivProfile = personItemView.findViewById(R.id.ivProfile);
            tvName = personItemView.findViewById(R.id.tvName);
            tvPhone = personItemView.findViewById(R.id.tvPhone);
        }


        public void setItem(Person person){
            Picasso.get().load("https://img.hankyung.com/photo/201909/03.20511778.1.jpg").into(ivProfile);
            tvName.setText(person.getName());
            tvPhone.setText(person.getPhone());
        }
    }


    public void addItem(Person person){
        list.add(person);
    }

    public void addItems(List<Person> list){
        this.list = list;
    }



    //GetView와 같다.
    //GetView와 같지만 안드로이드 시작에만 실행되고 스크롤시는 실행되지 않는다.
    //화면에 view가 5개만 들어간다면 5+1~2번 실행된다.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext()); //inflate객체생성
        //XML을 메모일에 뛰우는 것.
        View v = inflater.inflate(R.layout.person_item,parent, false);

        return new MyViewHolder(v);  //뷰홀더에 꼿아준다.
    }

    //재활용 되는 뷰가 호출하여 실행되는 메소드, 뷰 홀더를 전달하고 어댑터는 position의 데이터를 ui에 결합시킨다.

    //안드로이드 시작
    //스크롤 할때
    //무한호출
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        Person person = list.get(position);
        myViewHolder.setItem(person);
    }

    //전체 사이즈
    @Override
    public int getItemCount() {
        return list.size();
    }
}
