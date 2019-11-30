package com.cos.myviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentFirst extends Fragment {
/*  내가 실행 하는 것이 아님.fragment_first.xml을 메인에 미리 로딩하고 return하면 됨.
    root: attachToRoot가 true일경우 생성되는 View가 추가될 부모 뷰, attachToRoot가 false일 경우에는 LayoutParams값을 설정해주기 위한 상위 뷰, null로 설정할경우 android:layout_xxxxx값들이 무시됨.
    attachToRoot: true일 경우 생성되는 뷰를 root의 자식으로 만든다, false일 경우 root는 생성되는 View의 LayoutParam을 생성하는데만 사용된다.
*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //전개와 동시에 container에 붙이고 싶으면
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }
}

