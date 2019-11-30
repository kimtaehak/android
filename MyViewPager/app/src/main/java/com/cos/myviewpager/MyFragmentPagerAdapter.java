package com.cos.myviewpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/*
    FragmentPagerAdapter 에서는 프래그먼트 개 수가 정해진 화면에 사용하면 좋다.
    프래그먼트 매니저에서 한 번 생성된 프래그먼트의 인스턴스를 제거하지 않고 연결된 View 만 제거합니다.

    FragmentStatePagerAdapter 에서는 프래그먼트 개 수가 변하는 화면에 사용하면 좋다.
    프래그먼트 매니저에서 한 번 생성된 프래그먼트의 인스턴스를 완전히 제거하여 메모리 누수 문제에
    적합하게 대응할 수 있습니다.
*/

public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    //Fragment는 FragmentManager를 꼭 생성자로 받아야 함.
    public MyFragmentPagerAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    //데이타 만들어 주는 것
    public void addFragment(Fragment fragment, String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public String getFragmentTitle(int position){
        return mFragmentTitleList.get(position);
    }

    //아래는 자동 생성코드
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}