package com.greenteam.captainsquarters;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

class Cannon {

    //positioning
    Rectangle boundingBox;

    //physical attributes
    float movementSpeed; //world units per second

    //graphics
    TextureRegion textureRegion;

    public Cannon(TextureRegion textureRegion, float movementSpeed, float height, float width, float yPosition, float xPosition) {
        this.textureRegion = textureRegion;
        this.movementSpeed = movementSpeed;
        this.boundingBox = new Rectangle(xPosition, yPosition, width, height);
//        this.height = height;
//        this.width = width;
//        this.yPosition = yPosition;
//        this.xPosition = xPosition;
    }

    public void draw(Batch batch){
        batch.draw(textureRegion, boundingBox.x - boundingBox.width/2, boundingBox.y, boundingBox.width, boundingBox.height);
    }

//    public Rectangle getBoundingBox(){
//        return boundingBox;
//    }




}
