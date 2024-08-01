package com.greenteam.captainsquarters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

class HomeText extends MenuText{
    public HomeText(float xCentre, float yCentre, float btnWidth, float btnHeight, Texture textInactive, Texture textActive) {
        super(xCentre, yCentre, btnWidth, btnHeight, textInactive, textActive);
    }

    @Override
    public void draw(Batch batch, Boolean status) {
        if(status){
            batch.draw(textActiveTexture, boundingBox.x, boundingBox.y - boundingBox.height*2, boundingBox.width, boundingBox.height);
        }
        else{
            batch.draw(textInactiveTexture, boundingBox.x, boundingBox.y - boundingBox.height*2, boundingBox.width, boundingBox.height);
        }
    }
}
