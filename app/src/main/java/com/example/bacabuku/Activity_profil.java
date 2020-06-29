package com.example.bacabuku;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bacabuku.Model.ModelProfil;
import java.text.CollationElementIterator;

import java.util.HashMap;
import java.util.List;

public class Activity_profil extends AppCompatActivity {

    List<ModelProfil> mItems;
    ProgressDialog pd;
    SessionManager sessionManager;
    //String username, nama, id_user, id_akses;

    private TextView ID, Username, id_akses;
    //SessionManager sessionManager;

    //private String muser_idr, mUsername, mPassword, mid_akses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        initControl();

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();
        HashMap<String, String> user = sessionManager.getUserDetail();
        String muser_id = user.get(sessionManager.USER_ID);
        String mUsername = user.get(sessionManager.USERNAME);
        String mid_akses = user.get(sessionManager.ID_AKSES);

        ID.setText(muser_id);
        Username.setText(mUsername);
        id_akses.setText(mid_akses);
    }

    private void initControl() {
        ID = (TextView) findViewById(R.id.ID);
        Username = (TextView) findViewById(R.id.Username);
        id_akses = (TextView) findViewById(R.id.id_akses);


    }

}
