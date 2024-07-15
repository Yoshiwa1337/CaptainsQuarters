package com.example.lonecaptain_adampages;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView btn1 = (TextView) findViewById(R.id.howToPlay);

//        btn1.setOnHoverListener(new View.OnHoverListener() {
//            @Override
//            public boolean onHover(View v, MotionEvent event) {
//               btn1.setShadowLayer(50,0,0, Color.BLACK);
//               return true;
//            };
//        });
//
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setShadowLayer(50,0,0, Color.BLACK);

            }
        });

    }
}