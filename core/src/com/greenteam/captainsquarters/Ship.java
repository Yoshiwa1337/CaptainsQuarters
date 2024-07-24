package com.greenteam.captainsquarters;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

abstract class Ship {

    //characteristics
    float movementSpeed; //world units per second
    int shield;

    //dimensions and positioning
//    float xPosition, yPosition; //lower-left corner default
//    float width, height;
    Rectangle boundingBox;

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
//        this.xPosition = ; //storing lowerleft corner
//        this.yPosition = ; //storing lowerleft corner
//        this.width = width;
//        this.height = height;
        this.boundingBox = new Rectangle(xCentre - width/2, yCentre - height/2, width, height);
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

    public boolean intersects(Rectangle otherRectangle){
        return boundingBox.overlaps(otherRectangle);
    }

    public void hit(Cannon cannon){
        if(shield > 0){
            shield --;
        }
    }

    public void translate(float xChange, float yChange){
        boundingBox.setPosition(boundingBox.x+xChange, boundingBox.y+yChange);
    }


    public void draw(Batch batch){
        batch.draw(shipTextureRegion, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        //drawn second so its displayed above
        if (shield > 0){
            batch.draw(shieldTextureRegion, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        }
    }
}
