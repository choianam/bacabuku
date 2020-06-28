package com.example.bacabuku;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    //Declaration EditTexts
    EditText edtEmail;
    EditText edtPass;

    //Declaration Button
    Button btn_login;

    //Declaration TextInputLayout
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;

    //Declaration SqliteHelper
    SqliteHelper sqliteHelper;

    //    progress dialog dan request queue volley
    ProgressDialog progressDialog;
    RequestQueue requestQueue;

    //    session manager untuk menyimpan sesi login
    SessionManager SessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqliteHelper = new SqliteHelper(this);
        initViews();

//        instance dari session manager, requestQueue volley dan progressdialog
        SessionManager = new SessionManager(this);
        requestQueue = Volley.newRequestQueue(this);
        progressDialog = new ProgressDialog(this);


//  cek apakah user sudah login
        if (SessionManager.isLogin()) {
            Intent afterLogin = new Intent(MainActivity.this, SudahLogin.class);
            startActivity(afterLogin);
            finish();
        }

        //set click event of login button
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Check user input is correct or not
                if (validate()) {
                    loginProcess();
                }
            }
        });
    }


    //this method is used to connect XML views to its Objects
    private void initViews() {
        edtEmail = (TextInputEditText) findViewById(R.id.editTextEmail);
        edtPass = (TextInputEditText) findViewById(R.id.editTextPassword);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        btn_login = (Button) findViewById(R.id.btn_login);

    }

    //This method is for handling fromHtml method deprecation
    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String Email = edtEmail.getText().toString();
        String Password = edtPass.getText().toString();

        //Handling validation for Email field
        if (Email.isEmpty()) {
            valid = false;
            textInputLayoutEmail.setError("Please enter valid email!");
        } else {
            valid = true;
            textInputLayoutEmail.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            textInputLayoutPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() > 0) {
                valid = true;
                textInputLayoutPassword.setError(null);
            } else {
                valid = false;
                textInputLayoutPassword.setError("Password is to short!");
            }
        }

        return valid;
    }

    //    fungsi untuk volley request login
    private void loginProcess() {
        progressDialog.show();

//        string request untuk request ke api login
        StringRequest loginRequest = new StringRequest(Request.Method.GET, konfigurasi.URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                try {
//                    mengambil array dan objek dari resoinse api login
                    JSONArray arrayHasil = new JSONArray(response);
                    JSONObject objekHasil = arrayHasil.getJSONObject(0);

//                    menyimpan response data ke variabel string
                    String user_id = objekHasil.getString("user_id");
                    String Username = objekHasil.getString("Username");
                    String id_akses = objekHasil.getString("id_akses");

//                    menyimpan session login
                    SessionManager.createSession(user_id, Username, id_akses);

//                    intent ke afterloginactivity
                    Intent afterLogin = new Intent(MainActivity.this, SudahLogin.class);
                    startActivity(afterLogin);
                    finish();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
//                parameter yang dikirim ke api dengan method post
                Map<String, String> params = new HashMap<>();
                params.put("Username", edtEmail.getText().toString().trim());
                params.put("Password", edtPass.getText().toString().trim());
                return params;
            }
        };

        requestQueue.add(loginRequest);
    }
}



