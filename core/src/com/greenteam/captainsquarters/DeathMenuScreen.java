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
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Locale;

public class DeathMenuScreen implements Screen {
    PirateInvaders game;
    int score;

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
    //HUD-font
    BitmapFont font;
    float hudVerticalMargin, hudLeftX, hudRightX, hudCentreX, hudRow1Y, hudRow2Y, hudSectionWidth;

    //textures
    Texture playAgainButtonActive;
    Texture playAgainButtonInactive;
    Texture scoreTexture;
    Texture scoreValue;
    Texture homeButtonActive;
    Texture homeButtonInactive;

    //objects
    private StartText playText;
    private ScoreText scoreText;
    private HomeText homeText;

    DeathMenuScreen(PirateInvaders game, int score){
        this.game = game;
        this.score = score;

        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        background = new Texture("background_img.png");

        playAgainButtonActive = new Texture("play-again-txt-hover.png");
        playAgainButtonInactive = new Texture("play-again-txt.png");
        scoreTexture = new Texture("score-txt.png");
        //score value stuff
        homeButtonActive = new Texture("back_btn.png");
        homeButtonInactive = new Texture("back_btn.png");


        playText = new StartText(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, START_BTN_WIDTH, START_BTN_HEIGHT, playAgainButtonInactive, playAgainButtonActive);
        scoreText = new ScoreText(WORLD_WIDTH / 2, WORLD_HEIGHT / 2 - (START_BTN_HEIGHT*2), START_BTN_WIDTH, START_BTN_HEIGHT, scoreTexture, scoreTexture);
        homeText = new HomeText(WORLD_WIDTH / 2, WORLD_HEIGHT / 2 - (START_BTN_HEIGHT*2)*2, START_BTN_WIDTH, START_BTN_HEIGHT, homeButtonInactive, homeButtonActive);


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
        hudRow1Y = WORLD_HEIGHT - hudVerticalMargin;
        hudRow2Y = hudRow1Y - hudVerticalMargin - font.getCapHeight();
        hudSectionWidth = WORLD_WIDTH / 3;
    }

    public void render(float delta) {
        batch.begin();
        batch.draw(background, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);
//        batch.draw(startButtonInactive, 20, 10, 30, 10);
        float x = 100;

//        float x1 = startText.boundingBox.x  + startText.boundingBox.width*2;
//        float y1 = startText.boundingBox.y + startText.boundingBox.height*2;
//        float x2 = x1 + startText.boundingBox.width;
//        float y2 = y1 + startText.boundingBox.height;
//
//        //track touch location
        Vector2 touchPoint = new Vector2(Gdx.input.getX(), Gdx.input.getY());
//        //convert to world positioning
        touchPoint = viewport.unproject(touchPoint);
//
        if(playText.boundingBox.contains(touchPoint)){
//            batch.draw(startButtonActive, (float) WORLD_WIDTH / 3, (float) WORLD_HEIGHT / 2, 30, 10);
            playText.draw(batch, true);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new GameScreen(game));
//                Screen GameScreen = new GameScreen();
//                game.setScreen(GameScreen);
            }
        }
        else{
            playText.draw(batch, false);
        }

//        scoreText.draw(batch, false);

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

        updateAndRenderHUD();


        batch.end();
    }

    private void updateAndRenderHUD(){
        //Top row rendering
        font.draw(batch, "Score", hudCentreX, WORLD_HEIGHT / 2 - (START_BTN_HEIGHT), hudSectionWidth, Align.center, false);
        //Second row rendering - values
        font.draw(batch, String.format(Locale.getDefault(), "%d", score), hudCentreX, WORLD_HEIGHT / 2 - (START_BTN_HEIGHT*2), hudSectionWidth, Align.center, false);
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
