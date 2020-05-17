package com.example.bacabuku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class IpsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ips);

        TextView title = (TextView) findViewById(R.id.activityTitleIps);
        title.setText("IPS");
    }
}
