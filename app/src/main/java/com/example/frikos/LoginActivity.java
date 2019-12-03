package com.example.frikos;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password,name;
    private ImageButton btn_login;
    private ImageView registbt;
    private TextView link_regist,guest;
    private ProgressBar loading;
    SessionManager sessionManager;
    private static String URL_LOGIN = "https://denshin.000webhostapp.com/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);
        registbt=findViewById(R.id.intent_register);
        registbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        loading = findViewById(R.id.bar_login);
        email = findViewById(R.id.email_login);
        email.setTag(email.getKeyListener());
        email.setKeyListener(null);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email.setKeyListener((KeyListener) email.getTag());
            }
        });
        password = findViewById(R.id.password_login);
        btn_login = findViewById(R.id.r_btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = email.getText().toString().trim();
                String mPass = password.getText().toString().trim();

                if (!mEmail.isEmpty() || !mPass.isEmpty()) {
                    Login(mEmail, mPass);
                } else {
                    email.setError("Please insert email");
                    password.setError("Please insert password");
                }
            }
        });




    }

    private void Login(final String email, final String password) {
        loading.setVisibility(View.VISIBLE);
        btn_login.setVisibility(View.GONE);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if (success.equals("1")) {

                                for (int i = 0; i < jsonArray.length(); i++) {

                                    JSONObject object = jsonArray.getJSONObject(i);


                                    String name = object.getString("name").trim();
                                    String email = object.getString("email").trim();


                                    sessionManager.createSession(name, email);
                                    Toast.makeText(LoginActivity.this,"Welcome "+name,Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(LoginActivity.this, Dashboard.class);

                                    startActivity(intent);
                                    finish();

                                    loading.setVisibility(View.VISIBLE);
                                    btn_login.setVisibility(View.GONE);


                                }

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this, "Email atau Password " + "\n Salah"+toString(), Toast.LENGTH_SHORT).show();
                            loading.setVisibility(View.GONE);
                            btn_login.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "Email atau Password " + "\n Salah"+toString(), Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        btn_login.setVisibility(View.VISIBLE);
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


}