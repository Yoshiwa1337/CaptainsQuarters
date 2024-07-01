package com.greenteam.captainsquarters;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    //screen
    private Camera camera;
    private Viewport viewport;

    //graphics
    private SpriteBatch batch;
    private Texture background;

    //game timing
    private int backgroundOffset; //background move

    //parameters for world
    private final int WORLD_WIDTH = 72;
    private final int WORLD_HEIGHT = 128;

    GameScreen() {

        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        background = new Texture("Water-Top.png");
        backgroundOffset = 0;

        batch = new SpriteBatch(); //collect individual changes to graphics and display

    }



    @Override
    public void render(float deltaTime) {
        batch.begin();

        //Vertical scrolling background
//        backgroundOffset ++;
//        if (backgroundOffset % WORLD_HEIGHT == 0){
//            backgroundOffset = 0;
//        }
//
//
//        batch.draw(background, 0, -backgroundOffset,WORLD_WIDTH, WORLD_HEIGHT);
//        //adds background at the top for repeating effect
//        batch.draw(background, 0, -backgroundOffset+WORLD_HEIGHT,WORLD_WIDTH, WORLD_HEIGHT);

        //Horizontal scrolling
        backgroundOffset ++;
        if (backgroundOffset % WORLD_WIDTH == 0){
            backgroundOffset = 0;
        }


        batch.draw(background, -backgroundOffset, 0,WORLD_WIDTH, WORLD_HEIGHT);
        //adds background at the top for repeating effect
        batch.draw(background, -backgroundOffset+WORLD_WIDTH,0 ,WORLD_WIDTH, WORLD_HEIGHT);


        batch.end(); //finish and display

    }

    //for when user changes screen size -ran on startup
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void show() {

    }
}
