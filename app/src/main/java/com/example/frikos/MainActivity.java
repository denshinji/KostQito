package com.example.frikos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.frikos.R.layout.activity_main;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView rvKost;
    private ArrayList<Kost> list = new ArrayList<>();
    private DrawerLayout mdrawer;
    private NestedScrollView nested;
    private NavigationView navigationView;
    private MenuItem daftar, akun, about;
    private TextView namaed,emailed;
    private ActionBarDrawerToggle toggle;
    private Context context;
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();


        namaed = findViewById(R.id.name_header);
        emailed = findViewById(R.id.email_header);

        HashMap<String , String> user = sessionManager.getUserDetail();
        String mName = user.get(sessionManager.NAME);
        String mEmail = user.get(sessionManager.EMAIL);

        namaed.setText(mName);
        emailed.setText(mEmail);


        rvKost = findViewById(R.id.rv_kost);
        rvKost.setHasFixedSize(true);
        rvKost.setNestedScrollingEnabled(false);
        list.addAll(KostData.getListData());

        showRecyclerList();
        daftar = findViewById(R.id.listkost1);
        /* Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); */
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


    private void showRecyclerList() {
        rvKost.setLayoutManager(new LinearLayoutManager(this));
        ListKostAdapter listKostAdapter = new ListKostAdapter(list);
        rvKost.setAdapter(listKostAdapter);
        rvKost.setNestedScrollingEnabled(false);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.listkost1) {
            mdrawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.about1) {
            Intent intent = new Intent(this,Profile_Activity.class);
            startActivity(intent);
        } else if (id == R.id.akun) {
            Intent intent = new Intent(this,AccountActivity.class);
            startActivity(intent);
        }

        mdrawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

