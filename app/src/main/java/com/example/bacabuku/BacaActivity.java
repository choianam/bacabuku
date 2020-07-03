package com.example.bacabuku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class BacaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca);

        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);

        pdfView.fromAsset("biologi kelas X.pdf").load();
    }

}
