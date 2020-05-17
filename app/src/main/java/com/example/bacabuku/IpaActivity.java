package com.example.bacabuku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class IpaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipa);

        TextView title = (TextView) findViewById(R.id.activityTitleIpa);
        title.setText("Home");
    }
}
