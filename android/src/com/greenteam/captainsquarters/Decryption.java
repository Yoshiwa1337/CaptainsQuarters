package com.greenteam.captainsquarters;

import android.content.Intent;
import android.os.Bundle;


import android.widget.Button;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;


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
        btn2 = findViewById(R.id.imageView4);
        btn3 = findViewById(R.id.imageView5);
        btn4 = findViewById(R.id.imageView7);
        btn5 = findViewById(R.id.imageView23);
        btn6 = findViewById(R.id.imageView6);
        btn7 = findViewById(R.id.imageView20);
        btn8 = findViewById(R.id.imageView17);
        btn9 = findViewById(R.id.imageView16);
        btn10 = findViewById(R.id.imageView14);
        btn11 = findViewById(R.id.imageView8);
        btn12 = findViewById(R.id.imageView9);
        btn13 = findViewById(R.id.imageView26);
        btn14 = findViewById(R.id.imageView24);
        btn15 = findViewById(R.id.imageView19);
        btn16 = findViewById(R.id.imageView21);
        btn17 = findViewById(R.id.imageView10);
        btn18 = findViewById(R.id.imageView27);
        btn19 = findViewById(R.id.imageView28);
        btn20 = findViewById(R.id.imageView18);
        btn21 = findViewById(R.id.imageView30);
        btn22 = findViewById(R.id.imageView22);
        btn23 = findViewById(R.id.imageView11);
        btn24 = findViewById(R.id.imageView15);
        btn25 = findViewById(R.id.imageView31);
        btn26 = findViewById(R.id.imageView25);

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