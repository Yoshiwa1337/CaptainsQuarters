package com.greenteam.captainsquarters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

import org.w3c.dom.Text;

import java.util.Objects;

abstract class MenuText {

    //Positioning
    Rectangle boundingBox;


    //Textures
    Texture textActiveTexture, textInactiveTexture;

    public MenuText(float xCentre, float yCentre,
                    float btnWidth, float btnHeight,
                    Texture textInactive, Texture textActive){
        this.textActiveTexture = textActive;
        this.textInactiveTexture = textInactive;
        this.boundingBox = new Rectangle(xCentre - btnWidth/2, yCentre - btnHeight/2, btnWidth, btnHeight);
    }

//    public void draw(Batch batch){
//        batch.draw(textInactiveTexture, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
//    }
    public void draw(Batch batch, Boolean status){
        if(status){
            batch.draw(textActiveTexture, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        }
        else{
            batch.draw(textInactiveTexture, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        }
    }


}
