package com.example.matka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.matka.exibits.ExhibitsFragment;
import com.example.matka.history.HistoryFragment;
import com.example.matka.home.HomeFragment;
import com.example.matka.video.VideosFragment;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar=findViewById(R.id.toolbar_homeAcv);
        toolbar.setTitle(getString(R.string.matka_EC));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);

        adapter.addFragment(new HomeFragment(), getString(R.string.for_tab));
        adapter.addFragment(new HistoryFragment(), getString(R.string.history_tab));
        adapter.addFragment(new ExhibitsFragment(), getString(R.string.exib_tab));
        adapter.addFragment(new VideosFragment(), getString(R.string.vid_tab));

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        String putExtras1 = "HISTORY";
        String putExtras2 = "EXHIBITS";
        String putExtras3 = "VIDEO";
        if (putExtras1.equals(getIntent().getStringExtra("HISTORY"))) {
            viewPager.setCurrentItem(1);
            tabLayout.setupWithViewPager(viewPager);

        } else if (putExtras2.equals(getIntent().getStringExtra("EXHIBITS"))) {
            viewPager.setCurrentItem(2);
            tabLayout.setupWithViewPager(viewPager);

        } else if (putExtras3.equals(getIntent().getStringExtra("VIDEO"))) {
            viewPager.setCurrentItem(3);
            tabLayout.setupWithViewPager(viewPager);
        }
    }
}
