package com.example.bacabuku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bacabuku.Model.ModelHome;
import com.example.bacabuku.adapter.AdapterHome;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class menu extends AppCompatActivity {

    private String URLstring = "http://mabook.mif-project.com/BukuApi/Api";
    private static ProgressDialog mProgressDialog;
    private ListView listView;
    ArrayList<ModelHome> dataModelkArrayList;
    private AdapterHome adapterHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listView = findViewById(R.id.lv);
        retrieveJSON();

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
switch (item.getItemId()) {
    case R.id.nav_home:
        break;
    case R.id.nav_category:
        Intent a = new Intent(menu.this,CategoryActivity.class);
        startActivity(a);
        break;
    case R.id.nav_library:
        Intent b = new Intent(menu.this,LibraryActivity.class);
        startActivity(b);
        break;
}
                return false;
            }
        });


    }

    private void retrieveJSON() {
        showSimpleProgressDialog(this, "Loading...","Fetching Json", false);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLstring, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("volley", ">>" + response);
                try {
                    JSONObject obj = new JSONObject(response);
                    if (obj.optString("status").equals("true")) {
                        dataModelkArrayList = new ArrayList<>();
                        JSONArray dataArray = obj.getJSONArray("data");

                        for (int i=0; i<dataArray.length(); i++) {
                            ModelHome md = new ModelHome();
                            JSONObject dataobj = dataArray.getJSONObject(i);

                            md.setJudul_buku(dataobj.getString("judul_buku"));
                            md.setKategori_buku(dataobj.getString("kategory_buku"));
                            md.setPengarang_buku(dataobj.getString("pengarang_buku"));
                            md.setPenerbit_buku(dataobj.getString("penerbit_buku"));
                            md.setNama_file(dataobj.getString("nama_file"));

                            dataModelkArrayList.add(md);
                        }
                        setupListView();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void setupListView(){
        removeSimpleProgressDialog();
        adapterHome = new AdapterHome(this, dataModelkArrayList);
        listView.setAdapter(adapterHome);
    }
    public static void removeSimpleProgressDialog(){
        try {
            if (mProgressDialog != null){
                if (mProgressDialog.isShowing()){
                    mProgressDialog.dismiss();
                    mProgressDialog = null;
                }
            }
        }catch (IllegalArgumentException ie){
            ie.printStackTrace();
        }catch (RuntimeException re){
            re.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void showSimpleProgressDialog(Context context, String title, String msg, boolean isCancelable){
        try {
            if (mProgressDialog == null){
                mProgressDialog = ProgressDialog.show(context, title, msg);
                mProgressDialog.setCancelable(isCancelable);
            }
            if (!mProgressDialog.isShowing()){
                mProgressDialog.show();
            }
        }catch (IllegalArgumentException ie){
            ie.printStackTrace();
        }catch (RuntimeException re){
            re.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.searchmenu, menu);



        final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
