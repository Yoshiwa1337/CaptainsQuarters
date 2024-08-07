package com.greenteam.captainsquarters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

class Explosion {

    private Animation<TextureRegion> explosionAnimation;
    private float explosionTimer;

    private Rectangle boundingBox;

    Explosion(TextureRegion[] texture, Rectangle boundingBox, float totalAnimationTime){
        this.boundingBox = boundingBox;

        //texture splitting
//        TextureRegion[][] textureRegion2D = TextureRegion.split(texture, texture.getWidth(), texture.getHeight());
//
//        //converting to 1D array

//        TextureRegion[] textureRegion1D = new TextureRegion[3];
//        int index = 0;
//        for(int i = 0; i < 4; i++){
//            for(int j = 0; j < 4; j++){
//
//            }
//        }

        explosionAnimation = new Animation<TextureRegion>(totalAnimationTime / 3, texture);
        explosionTimer = 0;

    }

    public void update(float deltaTime){
        explosionTimer += deltaTime;
    }

    public void draw(SpriteBatch batch){
        batch.draw(explosionAnimation.getKeyFrame(explosionTimer),
                boundingBox.x,
                boundingBox.y,
                boundingBox.width,
                boundingBox.height);
    }

    public boolean isFinished(){
        return explosionAnimation.isAnimationFinished(explosionTimer);
    }




}
