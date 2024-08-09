package com.greenteam.captainsquarters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    dbhelper DBhelper;
    EditText lemail, pass;
    Button register, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DBhelper = new dbhelper(this);

        lemail = (EditText) findViewById(R.id.usertext);
        pass = (EditText) findViewById(R.id.passlogtext);
        register = (Button) findViewById(R.id.registerbtn);
        login = (Button) findViewById(R.id.loginbtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), signup.class);
                startActivity(i);
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = lemail.getText().toString().trim();
                String password = pass.getText().toString().trim();

                if (DBhelper.checkUser(email, password))
                {
                    Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Home_Page.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(login.this, "Login failed, please check values.", Toast.LENGTH_SHORT).show();
                }
            }
        });



        ImageView backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Home_Page.class);
                startActivity(intent);
            }
        });

    }
}