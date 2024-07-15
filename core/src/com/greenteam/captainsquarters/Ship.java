package com.greenteam.captainsquarters;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

abstract class Ship {

    //characteristics
    float movementSpeed; //world units per second
    int shield;

    //dimensions and positioning
    float xPosition, yPosition; //lower-left corner default
    float width, height;

    //cannon info
    float cannonWidth, cannonHeight;
    float cannonMovementSpeed;
    float timeBetweenFire;
    float timeSincePreviousFire = 0;

    //graphics
    TextureRegion shipTextureRegion, shieldTextureRegion, cannonTextureRegion;

    public Ship(float xCentre, float yCentre, //storing center on creation
                float width, float height,
                float movementSpeed, int shield,
                float cannonWidth, float cannonHeight, float cannonMovementSpeed,
                float timeBetweenFire,
                TextureRegion shipTextureRegion, TextureRegion shieldTextureRegion,
                TextureRegion cannonTextureRegion) {
        this.movementSpeed = movementSpeed;
        this.shield = shield;
        this.xPosition = xCentre - width/2; //storing lowerleft corner
        this.yPosition = yCentre - height/2; //storing lowerleft corner
        this.width = width;
        this.height = height;
        this.cannonWidth = cannonWidth;
        this.cannonHeight = cannonHeight;
        this.cannonMovementSpeed = cannonMovementSpeed;
        this.timeBetweenFire = timeBetweenFire;
        this.shipTextureRegion = shipTextureRegion;
        this.shieldTextureRegion = shieldTextureRegion;
        this.cannonTextureRegion = cannonTextureRegion;
    }

    //updates ship
    public void update(float deltaTime){
        timeSincePreviousFire += deltaTime;
    }

    public boolean canFireCannon(){
        return (timeSincePreviousFire - timeBetweenFire >= 0); //is the amount of time safe to fire
    }

    public abstract Cannon[] fireCannons();


    public void draw(Batch batch){
        batch.draw(shipTextureRegion, xPosition, yPosition, width, height);
        //drawn second so its displayed above
        if (shield > 0){
            batch.draw(shieldTextureRegion, xPosition, yPosition+0.5f, width, height);
        }
    }
}
