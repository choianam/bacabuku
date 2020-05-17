package com.example.bacabuku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UmumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umum);

        TextView title = (TextView) findViewById(R.id.activityTitleUmum);
        title.setText("UMUM");
    }
}
