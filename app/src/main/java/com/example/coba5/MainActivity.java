package com.example.coba5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView TxtRegister;
    Button btnLogin;
    EditText edtEmail, edtPassword;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        TxtRegister = findViewById(R.id.txt_register);
        btnLogin = findViewById(R.id.btn_login);
        TxtRegister.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, Register.class);
            startActivity(i);
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String strEmail = edtEmail.getText().toString();
            String strPassword = edtPassword.getText().toString();
            Boolean masuk =db.checkLogin(strEmail, strPassword);
            if (strEmail.isEmpty() || strPassword.isEmpty()) {
                Toast.makeText(MainActivity.this, "Fields must be filled", Toast.LENGTH_SHORT).show();
            }else if (masuk==true){
                Intent i2 = new Intent(MainActivity.this, MainForm.class);
                //sendDataIntentEmail
                i2.putExtra("PembuatInformasiWisata", strEmail);
                Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                startActivity(i2);
                finish();
            }
            }
        });
    }
}