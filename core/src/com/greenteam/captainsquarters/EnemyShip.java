package com.greenteam.captainsquarters;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

class EnemyShip extends Ship {

    Vector2 directionVector;
    float timeSinceLastDirectionChange = 0;
    float directionChangeFrequency = 0.75f;

    public EnemyShip(float xCentre, float yCentre,
                      float width, float height,
                      float movementSpeed, int shield,
                      float cannonWidth, float cannonHeight,
                      float cannonMovementSpeed, float timeBetweenFire,
                      TextureRegion shipTextureRegion, TextureRegion shieldTextureRegion,
                      TextureRegion cannonTextureRegion) {
        super(xCentre, yCentre, width, height, movementSpeed, shield, cannonWidth, cannonHeight, cannonMovementSpeed, timeBetweenFire, shipTextureRegion, shieldTextureRegion, cannonTextureRegion);

        directionVector = new Vector2(0,-1);
    }

    public Vector2 getDirectionVector() {
        return directionVector;
    }

    private void randomizedDirectionVector(){
        double bearing = PirateInvaders.random.nextDouble()*6.283185; //0-2 *PI
        directionVector.x = (float)Math.sin(bearing);
        directionVector.y = (float)Math.cos(bearing);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        timeSinceLastDirectionChange += deltaTime;
        if(timeSinceLastDirectionChange > directionChangeFrequency){
            randomizedDirectionVector();
            timeSinceLastDirectionChange -= directionChangeFrequency;
        }
    }

    @Override
    public Cannon[] fireCannons() {
        Cannon[] Cannon = new Cannon[1];
        Cannon[0] = new Cannon(cannonTextureRegion, cannonMovementSpeed, cannonHeight, cannonWidth, boundingBox.y+boundingBox.height*0.0f, boundingBox.x+boundingBox.width*0.5f);
//        Cannon[1] = new Cannon(cannonTextureRegion, cannonMovementSpeed, cannonHeight, cannonWidth, yPosition+height, xPosition+width*0.5f);

        timeSincePreviousFire = 0;

        return Cannon;
    }
    @Override
    public void draw(Batch batch){
        batch.draw(shipTextureRegion, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        //drawn second so its displayed above
        if (shield > 0){
            batch.draw(shieldTextureRegion, boundingBox.x, boundingBox.y-0.8f, boundingBox.width, boundingBox.height);
        }
    }
}
