package com.example.lonecaptain_adampages;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class shipView extends AppCompatActivity {


    Button area1;
    Button area2;
    Button area3;
    Button area4;

    Dialog dialog1;
    Dialog dialog2;
    Dialog dialog3;
    Dialog dialog4;

    ImageView close_dialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ship_view);

        area1 = findViewById(R.id.btn1);
        area2 = findViewById(R.id.btn2);
        area3 = findViewById(R.id.btn3);
        area4 = findViewById(R.id.btn4);

        dialog1 = new Dialog(shipView.this);
        dialog1.setContentView(R.layout.pop_up_box1);
        dialog1.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog1.getWindow().setBackgroundDrawable(getDrawable(R.drawable.pop_up_box1_bg));
        dialog1.setCancelable(false);

        close_dialogue = dialog1.findViewById(R.id.pop_up_close_btn);

        close_dialogue.setOnClickListener(new View.OnClickListener() {
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


    }
}