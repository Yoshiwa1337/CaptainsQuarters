package com.greenteam.captainsquarters;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Ship_View extends AppCompatActivity {

    TextView pageTitle;

    ImageView shipImg;

    int[] areas =  {R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4};

    Button area;

    Create_Dialogue[] dialogs;

    int[] layoutIds = {R.layout.pop_up_box1,R.layout.pop_up_box2,R.layout.pop_up_box3,R.layout.pop_up_box4};

    int[] close_btn_ids  = {R.id.pop_up_close_btn1,R.id.pop_up_close_btn2,R.id.pop_up_close_btn3,R.id.pop_up_close_btn4};

    ImageView close_btn;

    TextView page_hint;

    ConstraintLayout shipLayout;

    ArrayList<ArrayList<View>> views;

    Animation fade;

    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ship_view);

        pageTitle = (TextView)findViewById(R.id.Ship_View_Title);

        shipImg = (ImageView) findViewById(R.id.shipImg);

        page_hint = (TextView)findViewById(R.id.page_hint);

        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.back_btn,null);
        backBtn = v.findViewById(R.id.back_btn);
        shipLayout = (ConstraintLayout)findViewById(R.id.btnContainer);
        shipLayout.addView(v);

        views = new ArrayList<ArrayList<View>>();
        views.add(new ArrayList<View>(Arrays.asList(pageTitle,shipImg)));
        views.add(new ArrayList<View>(Arrays.asList()));
        views.add(new ArrayList<View>(Arrays.asList(page_hint,backBtn)));

        dialogs = new Create_Dialogue[4];

        int i =0;
        while(i < 4){
            dialogs[i] = new Create_Dialogue(Ship_View.this);
            dialogs[i].setDialogueLayout(layoutIds[i]);

            area = findViewById(areas[i]);
            views.get(1).add(area);

            close_btn = dialogs[i].findViewById(close_btn_ids[i]);
            int dialog = i;

            close_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogs[dialog].dismiss();
                }
            });

            area.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {dialogs[dialog].show();}

            });

            i++;
        }
//
//        dialog1 = new Dialog(Ship_View.this);
//        dialog1.setContentView(R.layout.pop_up_box1);
//        dialog1.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog1.getWindow().setBackgroundDrawable(getDrawable(R.drawable.pop_up_box_bg));
//        dialog1.setCancelable(false);
//
//        dialog2 = new Dialog(Ship_View.this);
//        dialog2.setContentView(R.layout.pop_up_box2);
//        dialog2.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog2.getWindow().setBackgroundDrawable(getDrawable(R.drawable.pop_up_box_bg));
//        dialog2.setCancelable(false);
//
//        dialog3 = new Dialog(Ship_View.this);
//        dialog3.setContentView(R.layout.pop_up_box3);
//        dialog3.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog3.getWindow().setBackgroundDrawable(getDrawable(R.drawable.pop_up_box_bg));
//        dialog3.setCancelable(false);
//
//        dialog4 = new Dialog(Ship_View.this);
//        dialog4.setContentView(R.layout.pop_up_box4);
//        dialog4.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog4.getWindow().setBackgroundDrawable(getDrawable(R.drawable.pop_up_box_bg));
//        dialog4.setCancelable(false);
//
//        close_dialogue1 = dialog1.findViewById(R.id.pop_up_close_btn1);
//        close_dialogue2 = dialog2.findViewById(R.id.pop_up_close_btn2);
//        close_dialogue3 = dialog3.findViewById(R.id.pop_up_close_btn3);
//        close_dialogue4 = dialog4.findViewById(R.id.pop_up_close_btn4);
//
//        close_dialogue1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog1.dismiss();
//            }
//        });
//
//        area1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {dialog1.show();}
//
//        });
//
//        close_dialogue2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog2.dismiss();
//            }
//        });
//
//        area2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog2.show();
//            }
//        });
//
//        close_dialogue3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog3.dismiss();
//            }
//        });
//
//        area3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog3.show();
//            }
//        });
//
//        close_dialogue4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog4.dismiss();
//            }
//        });
//
//        area4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog4.show();
//            }
//        });



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Home_Page.class);
                startActivity(intent);
            }
        });

//        fade= new Animation[]
//                {AnimationUtils.loadAnimation(this, R.anim.ship_fade1),
//                        AnimationUtils.loadAnimation(this, R.anim.ship_fade2),
//                        AnimationUtils.loadAnimation(this, R.anim.ship_fade4),
//                        AnimationUtils.loadAnimation(this, R.anim.ship_fade5),
//                        AnimationUtils.loadAnimation(this, R.anim.ship_fade3),
//                        AnimationUtils.loadAnimation(this, R.anim.ship_fade6),
//                        AnimationUtils.loadAnimation(this, R.anim.ship_fade7),
//                        AnimationUtils.loadAnimation(this, R.anim.ship_fade8)
//                };
//
//        pageTitle.startAnimation(fade[0]);
//        shipImg.startAnimation(fade[1]);
//        area1.startAnimation(fade[2]);
//        area2.startAnimation(fade[3]);
//        area3.startAnimation(fade[4]);
//        area4.startAnimation(fade[5]);
//        page_hint.startAnimation(fade[6]);
//        shipLayout.startAnimation(fade[7]);



//   views = new View[]{pageTitle,shipImg,areas1,area4,area2,area3,backBtn};
//        views = new View[][]{{pageTitle,shipImg},{areas[0],area4,area2,area3},{backBtn}};


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
//                flattendedView = views.stream().flatMap(list->list.stream()).toList();
//            }
//        }

    Integer time = 300;

    for(ArrayList<View> array:views){
        for(View view: array){

            Animation fade = AnimationUtils.loadAnimation(this,R.anim.ship_view_fade);
            fade.setDuration(time);
            view.startAnimation(fade);
            time+=200;

        }

    }
}

}