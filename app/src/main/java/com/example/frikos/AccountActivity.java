package com.example.frikos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class AccountActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private EditText named,emaild;
    private Button btnlogout;
    private CircleImageView profileImage;
    private DrawerLayout mdrawer;
    private NavigationView navigationView;
    private MenuItem daftar, akun, about;
    private ActionBarDrawerToggle toggle;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();


        named = findViewById(R.id.acc_name);
        emaild = findViewById(R.id.acc_email);
        HashMap<String , String> user = sessionManager.getUserDetail();
        String mName = user.get(sessionManager.NAME);
        String mEmail = user.get(sessionManager.EMAIL);

        named.setText(mName);
        emaild.setText(mEmail);

        btnlogout = findViewById(R.id.btn_logout);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               sessionManager.logout();
            }
        });   daftar = findViewById(R.id.listkost1);
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
            Intent intent = new Intent(this,Profile_Activity.class);
            startActivity(intent);
        } else if (id == R.id.akun) {
            mdrawer.closeDrawer(GravityCompat.START);

        }

        mdrawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
