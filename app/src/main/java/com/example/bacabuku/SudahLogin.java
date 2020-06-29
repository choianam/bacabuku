package com.example.bacabuku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SudahLogin extends AppCompatActivity implements View.OnClickListener {
    //    sessionmanager dipakai pada activity ini untuk process logout
    SessionManager sessionManager;

    private Button Home,  Profil, Category, Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sudahlogin);

//        menyambungkan sessionmanager pada context class ini
//        dengan instance constructor
        sessionManager = new SessionManager(this);

        Home=(Button) findViewById(R.id.Home);
        Home.setOnClickListener(this);

        Profil=(Button) findViewById(R.id.Profil);
        Profil.setOnClickListener(this);

        Category=(Button) findViewById(R.id.Category);
        Category.setOnClickListener(this);

        Logout = findViewById(R.id.btnLogout);
        Logout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Home:
                Intent rekomendasi =new Intent(SudahLogin.this, menu.class);
                startActivity(rekomendasi);
                break;
            case R.id.Profil:
                Intent pesan =new Intent(SudahLogin.this, Activity_profil.class);
                startActivity(pesan);
                break;
            case R.id.Category:
                Intent add= new Intent(SudahLogin.this, CategoryActivity.class);
                startActivity(add);
                break;
            case R.id.btnLogout:
                sessionManager.logout();
                break;
        }
    }
}