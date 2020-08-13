package com.example.doorsteptailors;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    private TabLayout tablayout;
    private ViewPager viewpager;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //for navigation bar
        drawerLayout =findViewById(R.id.drawerID);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //for tab bar
        tablayout = findViewById(R.id.tabLayoutId);
        viewpager = findViewById(R.id.viewPagerId);

        viewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tablayout.setupWithViewPager(viewpager);
    }
    class MyPagerAdapter extends FragmentPagerAdapter{

        String[] text ={"BestRated","Favourites","Discounted"};

        public MyPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }
        @Override
        public Fragment getItem(int i) {
            if(i == 0)
            {
                return new BestRated();
            }
            if(i == 1)
            {
              return new Favourites();
            }
            if (i == 2)
            {
                return new Discounts();
            }
            return null;
        }

        @Override
        public int getCount() {
            return text.length;
        }
        public CharSequence getPageTitle(int position)
        {
            return text[position];
        }
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.right_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

}
