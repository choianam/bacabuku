package com.example.bacabuku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CategoryActivity extends AppCompatActivity {

    private Button ipa, ips, bahasa, umum, lainnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ipa = (Button)findViewById(R.id.btn_move_ipa);

        ips = (Button)findViewById(R.id.btn_move_ips);

        bahasa = (Button)findViewById(R.id.btn_move_bahasa);

        umum = (Button)findViewById(R.id.btn_move_umum);

        lainnya = (Button)findViewById(R.id.btn_move_lainnya);


        ipa.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       switch (v.getId()){
                                           case R.id.btn_move_ipa:
                                               Intent moveIntent = new Intent(CategoryActivity.this, IpaActivity.class);
                                               startActivity(moveIntent);
                                               break;
                                       }
                                   }
                               });
        ips.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.btn_move_ips:
                        Intent moveIntent = new Intent(CategoryActivity.this, IpsActivity.class);
                        startActivity(moveIntent);
                        break;
                }
            }
        });
        bahasa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.btn_move_bahasa:
                        Intent moveIntent = new Intent(CategoryActivity.this, BahasaActivity.class);
                        startActivity(moveIntent);
                        break;
                }
            }
        });
        umum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.btn_move_umum:
                        Intent moveIntent = new Intent(CategoryActivity.this, UmumActivity.class);
                        startActivity(moveIntent);
                        break;
                }
            }
        });
        lainnya.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.btn_move_lainnya:
                        Intent moveIntent = new Intent(CategoryActivity.this, LainnyaActivity.class);
                        startActivity(moveIntent);
                        break;
                }
            }
        });

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent a = new Intent(CategoryActivity.this,menu.class);
                        startActivity(a);
                        break;
                    case R.id.nav_category:
                        break;
                    case R.id.nav_library:
                        Intent b = new Intent(CategoryActivity.this,LibraryActivity.class);
                        startActivity(b);
                        break;
                }
                return false;
            }
        });

    }



}
