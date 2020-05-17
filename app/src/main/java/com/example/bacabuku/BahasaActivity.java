package com.example.bacabuku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BahasaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bahasa);

        TextView title = (TextView) findViewById(R.id.activityTitleBahasa);
        title.setText("BAHASA");
    }
}
