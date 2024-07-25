package com.greenteam.captainsquarters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    EditText username, email, password, cpassword;
    Button signin, signup;
    dbhelper DBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText) findViewById(R.id.usertext);
        email = (EditText) findViewById(R.id.emailtext);
        password = (EditText) findViewById(R.id.passwordtext);
        cpassword = (EditText) findViewById(R.id.cpasswordtext);
        signin = (Button) findViewById(R.id.signinbtn);
        signup = (Button) findViewById(R.id.signupbtn);
        DBhelper = new dbhelper(this);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(signup.this, login.class);
                startActivity(i);

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String chusername = username.getText().toString();
                String chemail = email.getText().toString();
                String chpassword = password.getText().toString();
                String chcpassword = cpassword.getText().toString();

                if (chusername.isEmpty() && chemail.isEmpty() && chpassword.isEmpty() && chcpassword.isEmpty()) {
                    Toast.makeText(signup.this, "Please fill in all the fields.", Toast.LENGTH_LONG).show();
                } else if (chpassword.equals(chcpassword)) {

//                        Users user = new Users(0, chusername, chemail, chcpassword);
                    dbhelper dbhelper = new dbhelper(getApplicationContext());
                    dbhelper.addUser(chusername, chemail, chpassword);
                    Toast.makeText(signup.this, "User registered successfully.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(signup.this, "Passwords do not match.", Toast.LENGTH_LONG).show();
                }

            }


        });
    }
}