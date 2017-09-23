package com.example.practice0706drawerlayout2;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.*;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.practice0706drawerlayout2.R.id.tablayout;
import static com.example.practice0706drawerlayout2.R.id.useLogo;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Fragment1 fragment1 = new Fragment1();
    private Fragment2 fragment2 = new Fragment2();
    private Fragment3 fragment3 = new Fragment3();
    private Fragment4 fragment4 = new Fragment4();
    private DrawerLayout mDrawerlayout;
    private MyPagerAdapter adapter;



    private ArrayList<String> titleList = new ArrayList<String>(){{
        add("新生导航");
        add("二手资讯");
        add("校园云打印");
        add("课外生活");
    }};

    private ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>(){{
        add(fragment1);
        add(fragment2);
        add(fragment3);
        add(fragment4);
    }};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerlayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();

        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);


        adapter = new MyPagerAdapter(getSupportFragmentManager(),titleList,fragmentArrayList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager,false);





          if (actionBar!=null){
              actionBar.setDisplayHomeAsUpEnabled(true);
              actionBar.setHomeAsUpIndicator(R.drawable.menu);
         }

         navigationView.setCheckedItem(R.id.nav_call);
         navigationView.setNavigationItemSelectedListener(new NavigationView.
                  OnNavigationItemSelectedListener(){
            @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                    mDrawerlayout.closeDrawers();
        //在这里写具体的菜单选项的实现功能


                   return true;
               }
          });
    }

         @Override
         public boolean onOptionsItemSelected(MenuItem item) {
          switch (item.getItemId()){
               case android.R.id.home:
                    mDrawerlayout.openDrawer(GravityCompat.START);
                    break;
               //


           default:
               }
           return true;
        }
    }
