package com.greenteam.captainsquarters;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.LinkedList;
import java.util.ListIterator;

public class GameScreen implements Screen {

    //screen
    private Camera camera;
    private Viewport viewport;

    //graphics
    private SpriteBatch batch;
    private TextureAtlas textureAtlas;
//    private Texture background;
    private TextureRegion[] backgrounds;

    private TextureRegion playerShipTextureRegion, playerShieldTextureRegion, enemyShipTextureRegion, enemyShieldTextureRegion, playerCannonTextureRegion, enemyCannonTextureRegion;


    //game timing
//    private int backgroundOffset; //background move
    private float[] backgroundOffsets = {0, 0, 0, 0};
    private float backgroundMaxScrollingSpeed;

    //parameters for world
    private final int WORLD_WIDTH = 72;
    private final int WORLD_HEIGHT = 128;

    //game objects
    private Ship playerShip;
    private Ship enemyShip;
    private LinkedList<Cannon> playerCannonList;
    private LinkedList<Cannon> enemyCannonList;

    GameScreen() {

        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        //setting texture atlas
        textureAtlas = new TextureAtlas("imagesthree.atlas");

        //setting up background

//        background = textureAtlas.findRegion("Water-Top");
//        backgroundOffset = 0;
        backgrounds = new TextureRegion[4];
//        backgrounds[0] = textureAtlas.findRegion("Starscape00");
        backgrounds[0] = textureAtlas.findRegion("ocean9");
        backgrounds[1] = textureAtlas.findRegion("Starscape01");
        backgrounds[2] = textureAtlas.findRegion("Starscape02");
        backgrounds[3] = textureAtlas.findRegion("Starscape03");

        backgroundMaxScrollingSpeed = (float)WORLD_HEIGHT / 4;

        //initialise texture regions
        playerShipTextureRegion = textureAtlas.findRegion("shipteam");
        enemyShipTextureRegion = textureAtlas.findRegion("shipenemy");
        playerShieldTextureRegion = textureAtlas.findRegion("shield2");
        enemyShieldTextureRegion = textureAtlas.findRegion("shield1");
        playerCannonTextureRegion = textureAtlas.findRegion("cannonBall");
        enemyCannonTextureRegion = textureAtlas.findRegion("cannonBall");

        //setting up game objects
        playerShip = new PlayerShip(WORLD_WIDTH/2, WORLD_HEIGHT/4,
                10, 10,
                2, 3,
                0.4f, 4,
                45, 0.5f,
                playerShipTextureRegion, playerShieldTextureRegion, playerCannonTextureRegion);
        enemyShip = new EnemyShip(WORLD_WIDTH/2, WORLD_HEIGHT*3/4,
                10, 10,
                2, 1,
                0.4f, 4,
                50, 0.8f,
                enemyShipTextureRegion, enemyShieldTextureRegion, enemyCannonTextureRegion);

        playerCannonList = new LinkedList<>();
        enemyCannonList = new LinkedList<>();

        batch = new SpriteBatch(); //collect individual changes to graphics and display

    }



    @Override
    public void render(float deltaTime) {
        batch.begin();

        playerShip.update(deltaTime);
        enemyShip.update(deltaTime);

        //Vertical scrolling background
        renderBackground(deltaTime);

        //enemy ships
        enemyShip.draw(batch);

        //player ship
        playerShip.draw(batch);

        //cannons
        //making cannon balls
        //player
        if(playerShip.canFireCannon()){
            Cannon[] cannons = playerShip.fireCannons();
            for (Cannon cannon: cannons){
                playerCannonList.add(cannon);
            }
        }
        //enemy
        if(enemyShip.canFireCannon()){
            Cannon[] cannons = enemyShip.fireCannons();
            for (Cannon cannon: cannons){
                enemyCannonList.add(cannon);
            }
        }
        //draw cannon balls
        //deleting old cannon balls
        ListIterator<Cannon> iterator = playerCannonList.listIterator();
        while(iterator.hasNext()){ //moves through list one at a time
            Cannon cannon = iterator.next();
            cannon.draw(batch); //draws
            cannon.yPosition += cannon.movementSpeed*deltaTime; //speed * time = distance --moves it
            if(cannon.yPosition > WORLD_HEIGHT){
                iterator.remove(); //removes last item retrieved from iterator
            }
        }
        iterator = enemyCannonList.listIterator();
        while(iterator.hasNext()){ //moves through list one at a time
            Cannon cannon = iterator.next();
            cannon.draw(batch); //draws
            cannon.yPosition -= cannon.movementSpeed*deltaTime; //going down the screen
            if(cannon.yPosition + cannon.height < 0){
                iterator.remove(); //removes last item retrieved from iterator
            }
        }

        //explosions

        //Horizontal scrolling
//        backgroundOffset ++;
//        if (backgroundOffset % WORLD_WIDTH == 0){
//            backgroundOffset = 0;
//        }

//        batch.draw(background, -backgroundOffset, 0,WORLD_WIDTH, WORLD_HEIGHT);
//        //adds background at the top for repeating effect
//        batch.draw(background, -backgroundOffset+WORLD_WIDTH,0 ,WORLD_WIDTH, WORLD_HEIGHT);


        batch.end(); //finish and display

    }

    private void renderBackground(float deltaTime) {

        //how far down to push the furthest away layer

        backgroundOffsets[0] += deltaTime * backgroundMaxScrollingSpeed / 8;
        backgroundOffsets[1] += deltaTime * backgroundMaxScrollingSpeed / 4;
        backgroundOffsets[2] += deltaTime * backgroundMaxScrollingSpeed / 2;
        backgroundOffsets[3] += deltaTime * backgroundMaxScrollingSpeed;

        for (int layer = 0; layer < backgroundOffsets.length; layer ++){
            if (backgroundOffsets[layer] > WORLD_HEIGHT){
                backgroundOffsets[layer] = 0;
            }
            batch.draw(backgrounds[layer],
                    0,
                    -backgroundOffsets[layer],
                    WORLD_WIDTH, WORLD_HEIGHT);
            batch.draw(backgrounds[layer],
                    0,
                    -backgroundOffsets[layer]+WORLD_HEIGHT,
                    WORLD_WIDTH, WORLD_HEIGHT);

//            batch.draw(backgrounds[layer],
//                    -backgroundOffsets[layer],
//                    0,
//                    WORLD_WIDTH, WORLD_HEIGHT);
//            batch.draw(backgrounds[layer],
//                    -backgroundOffsets[layer]+WORLD_WIDTH,
//                    0,
//                    WORLD_WIDTH, WORLD_HEIGHT);

        }


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
