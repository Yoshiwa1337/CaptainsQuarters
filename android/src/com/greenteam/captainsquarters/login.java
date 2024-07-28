package com.greenteam.captainsquarters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    EditText useremail, pass;
    Button register, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        useremail = (EditText) findViewById(R.id.usertext);
        pass = (EditText) findViewById(R.id.passlogtext);
        register = (Button) findViewById(R.id.registerbtn);
        login = (Button) findViewById(R.id.loginbtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(com.example.userregistration.login.this, signup.class);
                startActivity(i);
            }
        });
    }
}