package com.greenteam.captainsquarters;

import static com.badlogic.gdx.Input.Keys.SPACE;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.peer.TextComponentPeer;
import java.util.Locale;

import javax.swing.text.View;

import jdk.tools.jmod.Main;

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
    private static final int START_BTN_WIDTH = 350;
    private static final int START_BTN_HEIGHT = 175;

    //textures
    Texture startButtonActive;
    Texture startButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;

    MainMenuScreen(PirateInvaders game){
        this.game = game;

        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        background = new Texture("background_img.png");

        startButtonActive = new Texture("start-txt-hover.png");
        startButtonInactive = new Texture("start-txt.png");
        exitButtonActive = new Texture("exit-txt-hover.png");
        exitButtonInactive = new Texture("exit-txt.png");


        batch = new SpriteBatch();
    }

    public void render(float delta) {
        batch.begin();
        batch.draw(background, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);
//        batch.draw(startButtonInactive, 20, 10, 30, 10);
        float x = 100;


        if(Gdx.input.getX() > 100 && Gdx.input.getX() < viewport.getScreenWidth() - 100 && Gdx.input.getY() < 475 && Gdx.input.getY() > 475 - 30){
            batch.draw(startButtonActive, (float) (WORLD_WIDTH - 30) / 2, 30, 30, 10);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new GameScreen(game));
//                Screen GameScreen = new GameScreen();
//                game.setScreen(GameScreen);
            }
        }
        else{
            batch.draw(startButtonInactive, (float) (WORLD_WIDTH - 30) / 2, 30, 30, 10);
        }

        if(Gdx.input.getX() > 130 && Gdx.input.getX() < viewport.getScreenWidth() - 130 && Gdx.input.getY() < 575 && Gdx.input.getY() > 575 - 30){
            batch.draw(exitButtonActive, (float) (WORLD_WIDTH - 30) / 2, 10, 30, 10);
            if(Gdx.input.isTouched()){
                Gdx.app.exit();
//                Screen GameScreen = new GameScreen();
//                game.setScreen(GameScreen);
            }
        }
        else{
            batch.draw(exitButtonInactive, (float) (WORLD_WIDTH - 30) / 2, 10, 30, 10);
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
