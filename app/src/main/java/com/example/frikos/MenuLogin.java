package com.example.frikos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuLogin extends AppCompatActivity {

    private ImageButton login,daftar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_login);

        login = findViewById(R.id.button_menu_login);
        daftar = findViewById(R.id.button_menu_regist);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuLogin.this,LoginActivity.class));
            }
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuLogin.this,RegisterActivity.class));
            }
        });
    }
}
