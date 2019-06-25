package com.codigo.venadostest.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codigo.venadostest.adapters.PageAdapter;
import com.codigo.venadostest.R;
import com.codigo.venadostest.utilities.Utilities;


public class FragmentHome extends Fragment {


    View view;
    private AppBarLayout appBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        if(Utilities.rotation == 0){
            View parent = (View) container.getParent();

            if(appBar == null){
                appBar = (AppBarLayout) parent.findViewById(R.id.appBar);
                tabLayout = new TabLayout(getActivity());
                tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
                appBar.addView(tabLayout);


                viewPager = (ViewPager) view.findViewById(R.id.pager);
                inflateViewPager(viewPager);
                viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }
                });

                tabLayout.setupWithViewPager(viewPager);
            }

            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        }else{

            Utilities.rotation = 1;
        }

        return view;
    }

    private void inflateViewPager(ViewPager viewPager) {

        PageAdapter adapter = new PageAdapter(getFragmentManager());
        adapter.addFragment(new TabFragmentCopa(),"Copa MX");
        adapter.addFragment(new TabFragmentAscenso(),"Ascenso MX");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if(Utilities.rotation == 0){
            appBar.removeView(tabLayout);
        }

    }
}
