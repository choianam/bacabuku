package com.example.bacabuku;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edtEmail,edtPass;
    TextInputLayout txtEmail,txtPass;
    TextView tv_Reg;
    Button btnLogin;
    private String a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = findViewById(R.id.editTextEmail);
        edtPass = findViewById(R.id.editTextPassword);
        txtEmail = findViewById(R.id.textInputLayoutEmail);
        txtPass = findViewById(R.id.textInputLayoutPassword);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameKey = edtEmail.getText().toString();
                String passwordKey = edtPass.getText().toString();

                if (usernameKey.equals("admin")&&passwordKey.equals("123")){
                    Toast.makeText(getApplicationContext(), "Login Sukses !",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, menu.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Username atau Password Salah!").setNegativeButton("Retry",null).create().show();
                }
            }
        });
    } }
