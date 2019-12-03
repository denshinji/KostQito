package com.example.frikos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.HashMap;

public class MenuActivity extends Fragment {
    TextView txtUsername, txtEmail;
    SessionManager session;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.activity_menu, container, false);

        session = new SessionManager(getActivity());

        txtUsername = view.findViewById(R.id.nama_profile);
        txtEmail = view.findViewById(R.id.email_profile);
        HashMap<String, String> user = session.getUserDetail();
        String mName = user.get(session.NAME);
        String mEmail = user.get(session.EMAIL);


        txtUsername.setText(mName);
        txtEmail.setText(mEmail);
        return view;
    }

}
