package com.greenteam.captainsquarters;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

class Ship {

    //characteristics
    float movementSpeed; //world units per second
    int shield;

    //dimensions and positioning
    float xPosition, yPosition; //lower-left corner default
    float width, height;

    //graphics
    TextureRegion shipTexture, shieldTexture;

    public Ship(float movementSpeed, int shield,
                float xCentre, float yCentre, //storing center on creation
                float width, float height,
                TextureRegion shipTexture, TextureRegion shieldTexture) {
        this.movementSpeed = movementSpeed;
        this.shield = shield;
        this.xPosition = xCentre - width/2; //storing lowerleft corner
        this.yPosition = yCentre - height/2; //storing lowerleft corner
        this.width = width;
        this.height = height;
        this.shipTexture = shipTexture;
        this.shieldTexture = shieldTexture;
    }

    public void draw(Batch batch){

    }
}
