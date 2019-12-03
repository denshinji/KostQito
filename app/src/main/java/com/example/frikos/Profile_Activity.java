package com.example.frikos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.navigation.NavigationView;

public class Profile_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button saved;
    private DrawerLayout mdrawer;
    private NavigationView navigationView;
    private MenuItem daftar, akun, about;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        saved = findViewById(R.id.btnsaved);
        saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "082284220439";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
            }
        });

        daftar = findViewById(R.id.listkost1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        akun = findViewById(R.id.akun);
        mdrawer = findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, mdrawer, R.string.open,R.string.close);
        mdrawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /* BottomNavigationView bottomNavigationView = findViewById(R.id.button_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.relative_id,
                new Home_Activity()).commit(); */

    }
    @Override
    public void onBackPressed() {
        if (mdrawer.isDrawerOpen(GravityCompat.START)) {
            mdrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.listkost1) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.about1) {
            mdrawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.akun) {
            Intent intent = new Intent(this,AccountActivity.class);
            startActivity(intent);
        }

        mdrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    }

