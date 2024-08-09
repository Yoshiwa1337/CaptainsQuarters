package com.greenteam.captainsquarters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainMenuScreen implements Screen {
    private final PirateInvaders game;
    //screen
    private Camera camera;
    private Viewport viewport;

    //graphics
    SpriteBatch batch;
    Texture background;

    //world parameters
    private final int WORLD_WIDTH = 72;
    private final int WORLD_HEIGHT = 128;

    //HUD
    private static final int START_BTN_WIDTH = 30;
    private static final int START_BTN_HEIGHT = 10;

    //textures
    Texture startButtonActive;
    Texture startButtonInactive;
    Texture homeButtonActive;
    Texture homeButtonInactive;

    //objects
    private StartText startText;
    private HomeText homeText;

    MainMenuScreen(PirateInvaders game){
        this.game = game;

        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        background = new Texture("background_img.png");

        startButtonActive = new Texture("start-txt-hover.png");
        startButtonInactive = new Texture("start-txt.png");
        homeButtonActive = new Texture("back_btn.png");
        homeButtonInactive = new Texture("back_btn.png");

        startText = new StartText(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, START_BTN_WIDTH, START_BTN_HEIGHT, startButtonInactive, startButtonActive);
        homeText = new HomeText(WORLD_WIDTH / 2, WORLD_HEIGHT / 2 - (START_BTN_HEIGHT*2), START_BTN_WIDTH, START_BTN_HEIGHT, homeButtonInactive, homeButtonActive);


        batch = new SpriteBatch();
    }

    public void render(float delta) {
        batch.begin();
        batch.draw(background, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);

        //track touch location
        Vector2 touchPoint = new Vector2(Gdx.input.getX(), Gdx.input.getY());
        //convert to world positioning
        touchPoint = viewport.unproject(touchPoint);

        if(startText.boundingBox.contains(touchPoint)){
//            batch.draw(startButtonActive, (float) WORLD_WIDTH / 3, (float) WORLD_HEIGHT / 2, 30, 10);
            startText.draw(batch, true);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new GameScreen(game));
//                Screen GameScreen = new GameScreen();
//                game.setScreen(GameScreen);
            }
        }
        else{
            startText.draw(batch, false);
        }

        if(homeText.boundingBox.contains(touchPoint)){
//            batch.draw(exitButtonActive, (float) (WORLD_WIDTH - 30) / 2, 10, 30, 10);
            homeText.draw(batch, true);
            if(Gdx.input.isTouched()){
                Gdx.app.exit();
//                Screen GameScreen = new GameScreen();
//                game.setScreen(GameScreen);
            }
        }
        else{
//            batch.draw(homeButtonInactive, (float) (WORLD_WIDTH - 30) / 2, 10, 30, 10);
            homeText.draw(batch, false);
        }


        batch.end();
    }


    @Override
    public void show() {
    }


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
}
