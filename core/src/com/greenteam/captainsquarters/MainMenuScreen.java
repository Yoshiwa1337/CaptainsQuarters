package com.greenteam.captainsquarters;

import com.badlogic.gdx.Gdx;
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

import java.util.Locale;

import javax.swing.text.View;

public class MainMenuScreen implements Screen {
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
    BitmapFont font;
    float hudVerticalMargin, hudLeftX, hudRightX, hudCentreX, hudRow1Y, hudRow2Y, hudRow3Y, hudSectionWidth;

    MainMenuScreen(){

        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        background = new Texture("background_img.png");

        batch = new SpriteBatch();

        prepareHUD();

    }

    private void prepareHUD(){
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Pieces-of-Eight.otf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        fontParameter.size = 72;
        fontParameter.borderWidth = 5;
        fontParameter.borderColor = Color.BLACK;
        fontParameter.color = Color.WHITE;
        font = fontGenerator.generateFont(fontParameter);

        //Scale font to world
        font.getData().setScale(0.08f);

        //calculate hud margins, etc.
        hudVerticalMargin = font.getCapHeight() / 2;
        hudLeftX = hudVerticalMargin;
        hudRightX = WORLD_WIDTH * 2/3 - hudLeftX;
        hudCentreX = WORLD_WIDTH / 3;
        hudRow1Y = WORLD_HEIGHT * 2/3 - hudVerticalMargin;
        hudRow2Y = hudRow1Y - hudVerticalMargin - font.getCapHeight()*2;
        hudRow3Y = hudRow2Y - hudVerticalMargin - font.getCapHeight()*2;
        hudSectionWidth = WORLD_WIDTH / 3;
    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(background, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);

        updateAndRenderHUD();


        batch.end();
    }

    private void updateAndRenderHUD(){
        //first word column
        font.draw(batch, "Start Game", hudCentreX, hudRow1Y, hudSectionWidth, Align.center, false);
        //second word column
        font.draw(batch, "History", hudCentreX, hudRow2Y, hudSectionWidth, Align.center, false);
        //third word column
        font.draw(batch, "Home", hudCentreX, hudRow3Y, hudSectionWidth, Align.center, false);
        //Top row rendering
//        font.draw(batch, "Score", hudLeftX, hudRow1Y, hudSectionWidth, Align.left, false);
//        font.draw(batch, "Shield", hudCentreX, hudRow1Y, hudSectionWidth, Align.center, false);
//        font.draw(batch, "Lives", hudRightX, hudRow1Y, hudSectionWidth, Align.right, false);
//        //Second row rendering - values
//        font.draw(batch, String.format(Locale.getDefault(), "%06d", score), hudLeftX, hudRow2Y, hudSectionWidth, Align.left, false);
//        font.draw(batch, String.format(Locale.getDefault(), "%02d", playerShip.shield), hudCentreX, hudRow2Y, hudSectionWidth, Align.center, false);
//        font.draw(batch, String.format(Locale.getDefault(), "%02d", playerShip.lives), hudRightX, hudRow2Y, hudSectionWidth, Align.right, false);
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
