package com.greenteam.captainsquarters;

import android.content.Intent;
import android.os.Bundle;


import android.widget.Button;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Decryption extends AppCompatActivity {

    ConstraintLayout btnContainer;
    AppCompatImageButton btn1, btn2, btn3, btn4, btn5, btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24,btn25,btn26;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_decryption);

        btn1 = findViewById(R.id.imageView13);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "a", Toast.LENGTH_SHORT).show();
            }
        });
        btn2 = findViewById(R.id.imageView4);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "b", Toast.LENGTH_SHORT).show();
            }
        });
        btn3 = findViewById(R.id.imageView5);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "c", Toast.LENGTH_SHORT).show();
            }
        });
        btn4 = findViewById(R.id.imageView7);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "d", Toast.LENGTH_SHORT).show();
            }
        });
        btn5 = findViewById(R.id.imageView23);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "e", Toast.LENGTH_SHORT).show();
            }
        });
        btn6 = findViewById(R.id.imageView6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "f", Toast.LENGTH_SHORT).show();
            }
        });
        btn7 = findViewById(R.id.imageView20);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "g", Toast.LENGTH_SHORT).show();
            }
        });
        btn8 = findViewById(R.id.imageView17);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "h", Toast.LENGTH_SHORT).show();
            }
        });
        btn9 = findViewById(R.id.imageView16);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "i", Toast.LENGTH_SHORT).show();
            }
        });
        btn10 = findViewById(R.id.imageView14);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "j", Toast.LENGTH_SHORT).show();
            }
        });
        btn11 = findViewById(R.id.imageView8);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "k", Toast.LENGTH_SHORT).show();
            }
        });
        btn12 = findViewById(R.id.imageView9);
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "l", Toast.LENGTH_SHORT).show();
            }
        });
        btn13 = findViewById(R.id.imageView26);
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "m", Toast.LENGTH_SHORT).show();
            }
        });
        btn14 = findViewById(R.id.imageView24);
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "n", Toast.LENGTH_SHORT).show();
            }
        });
        btn15 = findViewById(R.id.imageView19);
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "o", Toast.LENGTH_SHORT).show();
            }
        });
        btn16 = findViewById(R.id.imageView21);
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "p", Toast.LENGTH_SHORT).show();
            }
        });
        btn17 = findViewById(R.id.imageView10);
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "q", Toast.LENGTH_SHORT).show();
            }
        });
        btn18 = findViewById(R.id.imageView27);
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "r", Toast.LENGTH_SHORT).show();
            }
        });
        btn19 = findViewById(R.id.imageView28);
        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "s", Toast.LENGTH_SHORT).show();
            }
        });
        btn20 = findViewById(R.id.imageView18);
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "t", Toast.LENGTH_SHORT).show();
            }
        });
        btn21 = findViewById(R.id.imageView30);
        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "u", Toast.LENGTH_SHORT).show();
            }
        });
        btn22 = findViewById(R.id.imageView22);
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "v", Toast.LENGTH_SHORT).show();
            }
        });
        btn23 = findViewById(R.id.imageView11);
        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "w", Toast.LENGTH_SHORT).show();
            }
        });
        btn24 = findViewById(R.id.imageView15);
        btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "x", Toast.LENGTH_SHORT).show();
            }
        });
        btn25 = findViewById(R.id.imageView31);
        btn25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "y", Toast.LENGTH_SHORT).show();
            }
        });
        btn26 = findViewById(R.id.imageView25);
        btn26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Decryption.this, "z", Toast.LENGTH_SHORT).show();
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