package com.greenteam.captainsquarters;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Ship_View extends AppCompatActivity {

    ImageView shipImg;

    Button area1;
    Button area2;
    Button area3;
    Button area4;

    Dialog dialog1;
    Dialog dialog2;
    Dialog dialog3;
    Dialog dialog4;

    ImageView close_dialogue1;
    ImageView close_dialogue2;
    ImageView close_dialogue3;
    ImageView close_dialogue4;

    Animation[] fade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ship_view);

        shipImg = (ImageView) findViewById(R.id.shipImg);

        area1 = findViewById(R.id.btn1);
        area2 = findViewById(R.id.btn2);
        area3 = findViewById(R.id.btn3);
        area4 = findViewById(R.id.btn4);

        dialog1 = new Dialog(Ship_View.this);
        dialog1.setContentView(R.layout.pop_up_box1);
        dialog1.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog1.getWindow().setBackgroundDrawable(getDrawable(R.drawable.pop_up_box_bg));
        dialog1.setCancelable(false);

        dialog2 = new Dialog(Ship_View.this);
        dialog2.setContentView(R.layout.pop_up_box2);
        dialog2.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog2.getWindow().setBackgroundDrawable(getDrawable(R.drawable.pop_up_box_bg));
        dialog2.setCancelable(false);

        dialog3 = new Dialog(Ship_View.this);
        dialog3.setContentView(R.layout.pop_up_box3);
        dialog3.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog3.getWindow().setBackgroundDrawable(getDrawable(R.drawable.pop_up_box_bg));
        dialog3.setCancelable(false);

        dialog4 = new Dialog(Ship_View.this);
        dialog4.setContentView(R.layout.pop_up_box4);
        dialog4.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog4.getWindow().setBackgroundDrawable(getDrawable(R.drawable.pop_up_box_bg));
        dialog4.setCancelable(false);

        close_dialogue1 = dialog1.findViewById(R.id.pop_up_close_btn1);
        close_dialogue2 = dialog2.findViewById(R.id.pop_up_close_btn2);
        close_dialogue3 = dialog3.findViewById(R.id.pop_up_close_btn3);
        close_dialogue4 = dialog4.findViewById(R.id.pop_up_close_btn4);

        fade= new Animation[]
         {AnimationUtils.loadAnimation(this, R.anim.ship_fade1),
          AnimationUtils.loadAnimation(this, R.anim.ship_fade2),
          AnimationUtils.loadAnimation(this, R.anim.ship_fade4),
          AnimationUtils.loadAnimation(this, R.anim.ship_fade5),
          AnimationUtils.loadAnimation(this, R.anim.ship_fade3)
        };

        shipImg.startAnimation(fade[0]);
        area1.startAnimation(fade[1]);
        area2.startAnimation(fade[2]);
        area3.startAnimation(fade[3]);
        area4.startAnimation(fade[4]);


        close_dialogue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });

        area1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.show();

            }


        });


        close_dialogue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.dismiss();
            }
        });

        area2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.show();
            }
        });

        close_dialogue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog3.dismiss();
            }
        });

        area3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog3.show();
            }
        });

        close_dialogue4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog4.dismiss();
            }
        });

        area4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog4.show();
            }
        });


        LayoutInflater inflater = getLayoutInflater();
        View v =inflater.inflate(R.layout.back_btn,null);
        Button backBtn = v.findViewById(R.id.back_btn);
        ConstraintLayout shipLayout = (ConstraintLayout)findViewById(R.id.btnContainer);
        shipLayout.addView(v);



    }
}