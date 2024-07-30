package com.greenteam.captainsquarters;

import android.content.ComponentName;
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
import androidx.appcompat.app.AppCompatCallback;

import java.util.ArrayList;
import java.util.List;

public class Home_Page extends AppCompatActivity {

    TextView[] textViews;
    Animation fade;
    Class<?> [] pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        pages = new Class[]{null,null,Ship_View.class,Trivia_Page.class,null,null,null,null,login.class};


//        btn1.setOnHoverListener(new View.OnHoverListener() {
//            @Override
//            public boolean onHover(View v, MotionEvent event) {
//               btn1.setShadowLayer(50,0,0, Color.BLACK);
//               return true;
//            };
//        });
//
        textViews = new TextView[]{
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


//        fade = AnimationUtils.loadAnimation(this,R.anim.home_page_fade);


        Integer time = 100;

       int pageCount = 0;
        for (TextView textView : textViews) {
                   Animation fade = AnimationUtils.loadAnimation(this,R.anim.home_page_fade);
                   textView.startAnimation(fade);
                   fade.setDuration(time);
                   time+= 100;

                   if(textView.getId() != R.id.page_heading ){
                       int finalPageCount = pageCount;
                       textView.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               textView.setShadowLayer(50,0,0, Color.BLACK);
                               Intent intent = new Intent(getApplicationContext(),pages[finalPageCount]);
                               startActivity(intent);
                           }
                        });
                       pageCount++;
                       }


        }


//        textViews[3].setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textViews[3].setShadowLayer(50,0,0, Color.BLACK);
//                Intent intent = new Intent(getApplicationContext(),pages[0]);
//                startActivity(intent);
//
//            }
//        });

    }
}