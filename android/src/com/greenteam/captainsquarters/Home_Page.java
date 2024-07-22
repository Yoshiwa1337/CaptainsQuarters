package com.greenteam.captainsquarters;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Home_Page extends AppCompatActivity {

    TextView[] pages;
    Animation fade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        TextView btn3 = (TextView) findViewById(R.id.page3);

//        btn1.setOnHoverListener(new View.OnHoverListener() {
//            @Override
//            public boolean onHover(View v, MotionEvent event) {
//               btn1.setShadowLayer(50,0,0, Color.BLACK);
//               return true;
//            };
//        });
//
        pages = new TextView[]{
                (TextView) findViewById(R.id.page_heading),
                (TextView) findViewById(R.id.page1),
                (TextView) findViewById(R.id.page2),
                (TextView) findViewById(R.id.page3),
                (TextView) findViewById(R.id.page4),
                (TextView) findViewById(R.id.page5),
                (TextView) findViewById(R.id.page6),
                (TextView) findViewById(R.id.page7),
                (TextView) findViewById(R.id.page8),
                (TextView) findViewById(R.id.page9)
        };


        fade = AnimationUtils.loadAnimation(this,R.anim.home_page_fade);


        Integer time = 300;
        for (TextView page : pages) {
                   page.startAnimation(fade);
                   fade.setDuration(time);
                   time+= 100;
             }

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn3.setShadowLayer(50,0,0, Color.BLACK);
                Intent intent = new Intent(getApplicationContext(),Ship_View.class);
                startActivity(intent);

            }
        });

    }
}