package com.greenteam.captainsquarters;

import static androidx.appcompat.content.res.AppCompatResources.getDrawable;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public class Create_Dialogue extends Dialog{


    public Create_Dialogue(@NonNull Context context){
    super(context);
    initDialogue(context);

    }

    public Create_Dialogue(@NonNull Context context,int themeid){
        super(context,themeid);
        initDialogue(context);
    }


    private void initDialogue(Context context){
      setContentView(R.layout.pop_up_box1);
      getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
      getWindow().setBackgroundDrawable(context.getDrawable(R.drawable.pop_up_box_bg));
      setCancelable(false);

    }

    public void setDialogueLayout(int layoutId){ setContentView(layoutId);}

//    public void stDialogueBackground(Drawable background){ getWindow().setBackgroundDrawable(background);}





}
