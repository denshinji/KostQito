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
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile_Login extends AppCompatActivity {

    private TextView namedd, email;
    private Button btnlogout;

    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__login);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();


        namedd = findViewById(R.id.text_name);
        email = findViewById(R.id.text_email);
        HashMap<String, String> user = sessionManager.getUserDetail();
        String mName = user.get(sessionManager.NAME);
        String mEmail = user.get(sessionManager.EMAIL);

        namedd.setText(mName);
        email.setText(mEmail);


    }
}
