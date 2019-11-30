package com.cos.bottonnavigationviewex01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cos.bottonnavigationviewex01.R;

public class SettingFrament extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // true 로 설정해 줄 경우 ViewGroup의 자식 View로 자동으로 추가됩니다. 이때 root는 null 일 수 없습니다.
        View v = inflater.inflate(R.layout.frag_setting, container, false);
        return v;
    }
}