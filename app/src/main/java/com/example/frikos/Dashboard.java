package com.example.frikos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;

public class Dashboard extends AppCompatActivity {

    private ImageView list,fav,account,history,cart;
    private TextView name,email;
    private EditText edtAddress;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        edtAddress = (EditText) findViewById(R.id.search_edit);
        edtAddress.setTag(edtAddress.getKeyListener());
        edtAddress.setKeyListener(null);
        edtAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtAddress.setKeyListener((KeyListener) edtAddress.getTag());
            }
        });
        name = findViewById(R.id.get_name_dash);
        email = findViewById(R.id.em_dashboard);

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_but);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);


        HashMap<String , String> user = sessionManager.getUserDetail();
        String mName = user.get(sessionManager.NAME);
        String mEmail = user.get(sessionManager.EMAIL);



        name.setText(mName);
        email.setText(mEmail);


        list=findViewById(R.id.list_kost);


        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,MainActivity.class));
            }
        });

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment=null;
                    switch (menuItem.getItemId()){
                        case R.id.button_home:
                            selectedFragment = new Fragment();
                            break;
                        case R.id.button_menu:
                            selectedFragment = new MenuActivity();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_con,selectedFragment).commit();
                    return true;
                }
            };
}
