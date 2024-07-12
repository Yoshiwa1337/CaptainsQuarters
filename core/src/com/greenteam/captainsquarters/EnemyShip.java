package com.greenteam.captainsquarters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

class EnemyShip extends Ship {

    public EnemyShip(float xCentre, float yCentre,
                      float width, float height,
                      float movementSpeed, int shield,
                      float cannonWidth, float cannonHeight,
                      float cannonMovementSpeed, float timeBetweenFire,
                      TextureRegion shipTextureRegion, TextureRegion shieldTextureRegion,
                      TextureRegion cannonTextureRegion) {
        super(xCentre, yCentre, width, height, movementSpeed, shield, cannonWidth, cannonHeight, cannonMovementSpeed, timeBetweenFire, shipTextureRegion, shieldTextureRegion, cannonTextureRegion);
    }

    @Override
    public Cannon[] fireCannons() {
        Cannon[] Cannon = new Cannon[1];
        Cannon[0] = new Cannon(cannonTextureRegion, cannonMovementSpeed, cannonHeight, cannonWidth, yPosition+height*0.0f, xPosition+width*0.5f);
//        Cannon[1] = new Cannon(cannonTextureRegion, cannonMovementSpeed, cannonHeight, cannonWidth, yPosition+height, xPosition+width*0.5f);

        timeSincePreviousFire = 0;

        return Cannon;
    }
}
