package com.example.matka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matka.development.YouTubeActivity;
import com.example.matka.maps.MapsActivity;
import com.example.matka.settings.SettingsActivity;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigatinView);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        onCLickMainActivity();
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){

            case R.id.nav_home:
                Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_history:
                Intent intent1=new Intent(MainActivity.this,HomeActivity.class);
                intent1.putExtra("HISTORY","HISTORY");
                startActivity(intent1);
                break;
            case R.id.nav_exhibits:
                Intent intent2=new Intent(MainActivity.this,HomeActivity.class);
                intent2.putExtra("EXHIBITS","EXHIBITS");
                startActivity(intent2);
                break;
            case R.id.nav_videos:
                Intent intent3=new Intent(MainActivity.this,HomeActivity.class);
                intent3.putExtra("VIDEO","VIDEO");
                startActivity(intent3);
                break;
            case R.id.nav_development:

                Intent youTubeIntent=new Intent(MainActivity.this, YouTubeActivity.class);
                startActivity(youTubeIntent);
//                DevelopmentDialogFragment fragment=new DevelopmentDialogFragment();
//                fragment.show(getSupportFragmentManager(),"dialog");
                break;
            case R.id.nav_contact:
                Intent intent4=new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent4);
                break;
            case R.id.nav_visit_us:
                Intent intent5=new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent5);
                break;


        }

        return false;
    }

    private void onCLickMainActivity(){

        TextView learnMore=findViewById(R.id.to_home_fragment);
        learnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        ImageView facebook=findViewById(R.id.facebook_open);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.facebook.com/MatkaExhibitionCenter");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        ImageView instagram=findViewById(R.id.instagram_open);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.instagram.com/matka.exhibition.center/");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);

        if(menu instanceof MenuBuilder) {
            MenuBuilder menuBuilder = (MenuBuilder) menu;
            menuBuilder.setOptionalIconsVisible(true);
        }

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       switch (item.getItemId()){
           case R.id.settings_:

               Intent intent=new Intent(MainActivity.this, SettingsActivity.class);
               startActivity(intent);
               break;

       }

        return super.onOptionsItemSelected(item);
    }

}
