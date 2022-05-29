package com.example.coba5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    DatabaseHelper db;
    EditText Remail, RePassword, RePhoneNumber;
    Button btRegister;
    RadioButton rbMale, rbFemale;
    RadioGroup rgGender;
    CheckBox chkAgreement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        Remail = findViewById(R.id.R_email_txt);
        RePassword = findViewById(R.id.R_password_txt);
        rgGender = findViewById(R.id.R_gender);
        rbFemale = findViewById(R.id.R_rbFemale);
        rbMale = findViewById(R.id.R_rbMale);
        chkAgreement = findViewById(R.id.R_cbTerms);
        btRegister = findViewById(R.id.btn_register1);

        btRegister.setOnClickListener(view -> {
            String gender;
            String email = Remail.getText().toString();
            String password = RePassword.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(Register.this, "Fields must be filled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Register.this, "Register sukses", Toast.LENGTH_SHORT).show();
                if (rbMale.isChecked()) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                Boolean daftar = db.insertedUser(email, password, gender);
                if (daftar == true) {
                    Toast.makeText(this, "Daftar berhasil", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}