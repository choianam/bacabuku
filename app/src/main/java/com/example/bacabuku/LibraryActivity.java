package com.example.bacabuku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.bacabuku.Api.Url;
import com.example.bacabuku.Model.ModelHome;
import com.example.bacabuku.Model.ModelLibrary;
import com.example.bacabuku.adapter.AdapterHome;
import com.example.bacabuku.adapter.AdapterLibrary;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {

    View view;
    private RequestQueue queue;


    RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    List<ModelLibrary> mItems;
    Button btnBaca;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        queue = Volley.newRequestQueue(LibraryActivity.this);

        mRecyclerview = (RecyclerView)findViewById(R.id.lvl);
        btnBaca = (Button)findViewById(R.id.toBarang1);
        pd = new ProgressDialog(LibraryActivity.this);
        mItems = new ArrayList<>();

        loadJson();

        mManager = new LinearLayoutManager(LibraryActivity.this,LinearLayoutManager.VERTICAL,false);
        mRecyclerview.setLayoutManager(mManager);
        mAdapter = new AdapterLibrary(LibraryActivity.this,mItems);
        mRecyclerview.setAdapter(mAdapter);


        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent a = new Intent(LibraryActivity.this,menu.class);
                        startActivity(a);
                        break;
                    case R.id.nav_category:
                        Intent b = new Intent(LibraryActivity.this,CategoryActivity.class);
                        startActivity(b);
                        break;
                    case R.id.nav_library:
                        break;
                }
                return false;
            }
        });

    }

    private void loadJson()
    {
        pd.setMessage("Mengambil Data");
        pd.setCancelable(false);
        pd.show();

        JsonArrayRequest reqData = new JsonArrayRequest(Request.Method.POST, Url.API_LIBRARY,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        pd.cancel();
                        Log.d("volley","response : " + response.toString());
                        for(int i = 0 ; i < response.length(); i++)
                        {
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelLibrary md = new ModelLibrary();
                                md.setJudul_buku1(data.getString("judul_buku"));
                                md.setKategori_buku1(data.getString("kategori_buku"));
                                md.setPengarang_buku1(data.getString("pengarang_buku"));
                                md.setPenerbit_buku1(data.getString("penerbit_buku"));
                                mItems.add(md);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Log.d("volley", "error : " + error.getMessage());
                    }
                });

        queue.add(reqData);
    }
}
