package com.greenteam.captainsquarters;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieTask;

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

    ConstraintLayout btnContainer;

    ArrayList<ArrayList<View>> views;

    Animation fade;

    ImageView backBtn;

    LottieAnimationView shipAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ship_view);

        pageTitle = (TextView)findViewById(R.id.Ship_View_Title);

        shipImg = findViewById(R.id.shipImg);
//        shipImg.setImageAssetDelegate(new ImageAssetDelegate() {
//            @Nullable
//            @Override
//            public Bitmap fetchBitmap(LottieImageAsset asset) {
//               if(asset.getId().equals())
//            }
//        });

//        shipImg.addAnimatorListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                LottieComposition composition = shipImg.getComposition();
//                if (composition != null) {
//                    for (String key : composition.getImages().keySet()) {
//                        Log.d("LottieImageAssets", "Image asset: " + key);
//                    }
//                }
//            }
//        });


//        LottieAnimationView shipImg = findViewById(R.id.shipImg);
//        shipImg.setAnimation(R.raw.ship_anim);
//        shipImg.setRepeatCount(LottieDrawable.INFINITE);
//
//        LottieTask<LottieComposition> compositionTask = LottieCompositionFactory.fromRawRes(this, R.raw.ship_anim);
//        compositionTask.addListener(new LottieListener<LottieComposition>() {
//            @Override
//            public void onResult(LottieComposition composition) {
//                shipImg.setComposition(composition);
//                shipImg.playAnimation();
//            }
//        });
//        compositionTask.addFailureListener(new LottieListener<Throwable>() {
//            @Override
//            public void onResult(Throwable result) {
//                Log.e("Lottie", "Unable to parse composition", result);
//            }
//        });

        page_hint = (TextView)findViewById(R.id.page_hint);

        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.back_btn,null);
        backBtn = v.findViewById(R.id.back_btn);
        btnContainer = (ConstraintLayout)findViewById(R.id.btnContainer);
        btnContainer.addView(v);

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


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Home_Page.class);
                startActivity(intent);
            }
        });


    Integer time = 100;

    for(ArrayList<View> array:views){
        for(View view: array){

            Animation fade = AnimationUtils.loadAnimation(this,R.anim.ship_view_fade);
            fade.setDuration(time);
            view.startAnimation(fade);
            time+=100;

        }

    }
}

}