package com.greenteam.captainsquarters;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

class Cannon {

    //positioning
    float xPosition, yPosition; //bottom center of cannon
    float width, height;

    //physical attributes
    float movementSpeed; //world units per second

    //graphics
    TextureRegion textureRegion;

    public Cannon(TextureRegion textureRegion, float movementSpeed, float height, float width, float yPosition, float xPosition) {
        this.textureRegion = textureRegion;
        this.movementSpeed = movementSpeed;
        this.height = height;
        this.width = width;
        this.yPosition = yPosition;
        this.xPosition = xPosition;
    }

    public void draw(Batch batch){
        batch.draw(textureRegion, xPosition - width/2, yPosition, width, height);
    }

    public Rectangle getBoundingBox(){
        return new Rectangle(xPosition, yPosition, width, height);
    }




}
