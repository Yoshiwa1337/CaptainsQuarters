package com.greenteam.captainsquarters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
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
    private float timeBetweenEnemySpawns = 3f;
    private float enemySpawnTimer = 0;

    //parameters for world
    private final int WORLD_WIDTH = 72;
    private final int WORLD_HEIGHT = 128;
    private final float TOUCH_MOVEMENT_THRESHOLD = 0.5f;

    //game objects
    private PlayerShip playerShip;
    private LinkedList<EnemyShip> enemyShipList;
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
        enemyShieldTextureRegion.flip(false, true);
        playerCannonTextureRegion = textureAtlas.findRegion("cannonBall");
        enemyCannonTextureRegion = textureAtlas.findRegion("cannonBall");

        //setting up game objects
        playerShip = new PlayerShip(WORLD_WIDTH/2, WORLD_HEIGHT/4,
                10, 10,
                48, 3,
                0.4f, 4,
                45, 0.5f,
                playerShipTextureRegion, playerShieldTextureRegion, playerCannonTextureRegion);
        enemyShipList = new LinkedList<>();


        playerCannonList = new LinkedList<>();
        enemyCannonList = new LinkedList<>();

        batch = new SpriteBatch(); //collect individual changes to graphics and display

    }



    @Override
    public void render(float deltaTime) {
        batch.begin();

        //Vertical scrolling background
        renderBackground(deltaTime);

        detectInput(deltaTime);
        playerShip.update(deltaTime);

        spawnEnemyShips(deltaTime);

        ListIterator<EnemyShip> enemyShipListIterator = enemyShipList.listIterator();
        while(enemyShipListIterator.hasNext()){
            EnemyShip enemyShip = enemyShipListIterator.next();
            moveEnemy(enemyShip, deltaTime);
            enemyShip.update(deltaTime);
            //enemy ships
            enemyShip.draw(batch);
        }

        //player ship
        playerShip.draw(batch);

        //cannons
        renderCannons(deltaTime);

        //detect any collisions between the ships/cannons
        detectCollisions();

        //explosions
        renderExplosions(deltaTime);

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

    private void spawnEnemyShips(float deltaTime){
        enemySpawnTimer += deltaTime;
        if(enemySpawnTimer > timeBetweenEnemySpawns){
            enemyShipList.add(new EnemyShip(PirateInvaders.random.nextFloat()*(WORLD_WIDTH-10)+5,
                    WORLD_HEIGHT - 5,
                    10, 10,
                    47, 1,
                    0.4f, 4,
                    50, 0.8f,
                    enemyShipTextureRegion, enemyShieldTextureRegion, enemyCannonTextureRegion));
            enemySpawnTimer -= timeBetweenEnemySpawns;
        }

    }

    private void detectInput(float deltaTime){
        //keyboard input

        //figure out max distance ship can move
        //check each relevant key and move accordingly

        float leftLimit, rightLimit, upperLimit, lowerLimit;
        leftLimit = -playerShip.boundingBox.x;
        lowerLimit = -playerShip.boundingBox.y;
        rightLimit = WORLD_WIDTH - playerShip.boundingBox.x - playerShip.boundingBox.width;
        upperLimit = (float)WORLD_HEIGHT / 2 - playerShip.boundingBox.y - playerShip.boundingBox.height;

//        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && rightLimit > 0){
////            float xChange = playerShip.movementSpeed*deltaTime;
////            xChange = Math.min(xChange, rightLimit);
////            playerShip.translate(xChange, 0f);
//            playerShip.translate(Math.min(playerShip.movementSpeed*deltaTime, rightLimit), 0f);
//        }
//
//        if(Gdx.input.isKeyPressed(Input.Keys.UP) && upperLimit > 0){
//            playerShip.translate(0f, Math.min(playerShip.movementSpeed*deltaTime, upperLimit));
//        }
//
//        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && leftLimit < 0){
//            playerShip.translate(Math.max(-playerShip.movementSpeed*deltaTime, leftLimit), 0f);
//        }
//
//        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && lowerLimit < 0){
//            playerShip.translate(0f, Math.max(-playerShip.movementSpeed*deltaTime, leftLimit));
//        }
        //touch input (applies for mouse)
        if(Gdx.input.isTouched()){
            //get screen position of touched location
            float xTouchPixels = Gdx.input.getX();
            float yTouchPixels = Gdx.input.getY();

            //convert to world position
            Vector2 touchPoint = new Vector2(xTouchPixels, yTouchPixels);
            touchPoint = viewport.unproject(touchPoint);

            //calculate x/y difference
            Vector2 playerShipCentre = new Vector2(
                    playerShip.boundingBox.x + playerShip.boundingBox.width/2,
                    playerShip.boundingBox.y + playerShip.boundingBox.height/2);

            float touchDistance = touchPoint.dst(playerShipCentre);

            if(touchDistance > TOUCH_MOVEMENT_THRESHOLD){
                float xTouchDifference = touchPoint.x - playerShipCentre.x;
                float yTouchDifference = touchPoint.y - playerShipCentre.y;

                //scale to max speed of the ship
                float xMove = xTouchDifference / touchDistance * playerShip.movementSpeed * deltaTime;
                float yMove = yTouchDifference / touchDistance * playerShip.movementSpeed * deltaTime;

                if(xMove > 0) xMove = Math.min(xMove, rightLimit);
                else xMove = Math.max(xMove, leftLimit);

                if(yMove > 0) yMove = Math.min(yMove, upperLimit);
                else yMove = Math.max(yMove, lowerLimit);

                playerShip.translate(xMove, yMove);



            }




        }


    }

    private void moveEnemy(EnemyShip enemyShip, float deltaTime){
        //figure out max distance ship can move

        float leftLimit, rightLimit, upperLimit, lowerLimit;
        leftLimit = -enemyShip.boundingBox.x;
        lowerLimit = (float)WORLD_HEIGHT / 2 -enemyShip.boundingBox.y;
        rightLimit = WORLD_WIDTH - enemyShip.boundingBox.x - enemyShip.boundingBox.width;
        upperLimit = WORLD_HEIGHT - enemyShip.boundingBox.y - enemyShip.boundingBox.height;

        float xMove = enemyShip.getDirectionVector().x * enemyShip.movementSpeed * deltaTime;
        float yMove = enemyShip.getDirectionVector().y * enemyShip.movementSpeed * deltaTime;

        if(xMove > 0) xMove = Math.min(xMove, rightLimit);
        else xMove = Math.max(xMove, leftLimit);

        if(yMove > 0) yMove = Math.min(yMove, upperLimit);
        else yMove = Math.max(yMove, lowerLimit);

        enemyShip.translate(xMove, yMove);
    }

    private void detectCollisions(){
        //for each player cannon, check if it reaches an enemy ship
        ListIterator<Cannon> CannonListIterator = playerCannonList.listIterator();
        while(CannonListIterator.hasNext()){ //moves through list one at a time
            Cannon cannon = CannonListIterator.next();
            ListIterator<EnemyShip> enemyShipListIterator = enemyShipList.listIterator();
            while(enemyShipListIterator.hasNext()){
                EnemyShip enemyShip = enemyShipListIterator.next();

                if(enemyShip.intersects(cannon.boundingBox)){
                    //makes contact with enemy
                    enemyShip.hit(cannon);
                    CannonListIterator.remove();
                }
            }
        }

        //for each enemy cannon, check if it reaches an player ship
        CannonListIterator = enemyCannonList.listIterator();
        while(CannonListIterator.hasNext()){ //moves through list one at a time
            Cannon cannon = CannonListIterator.next();
            if(playerShip.intersects(cannon.boundingBox)){
                //makes contact with player
                playerShip.hit(cannon);
                CannonListIterator.remove();
            }
        }

    }

    private void renderExplosions(float deltaTime){

    }

    private void renderCannons(float deltaTime){
        //making cannon balls
        //player
        if(playerShip.canFireCannon()){
            Cannon[] cannons = playerShip.fireCannons();
            for (Cannon cannon: cannons){
                playerCannonList.add(cannon);
            }
        }
        //enemy
        ListIterator<EnemyShip> enemyShipListIterator = enemyShipList.listIterator();
        while(enemyShipListIterator.hasNext()){
            EnemyShip enemyShip = enemyShipListIterator.next();
            if(enemyShip.canFireCannon()){
                Cannon[] cannons = enemyShip.fireCannons();
                for (Cannon cannon: cannons){
                    enemyCannonList.add(cannon);
                }
            }
        }
        //draw cannon balls
        //deleting old cannon balls
        ListIterator<Cannon> iterator = playerCannonList.listIterator();
        while(iterator.hasNext()){ //moves through list one at a time
            Cannon cannon = iterator.next();
            cannon.draw(batch); //draws
            cannon.boundingBox.y += cannon.movementSpeed*deltaTime; //speed * time = distance --moves it
            if(cannon.boundingBox.y > WORLD_HEIGHT){
                iterator.remove(); //removes last item retrieved from iterator
            }
        }
        iterator = enemyCannonList.listIterator();
        while(iterator.hasNext()){ //moves through list one at a time
            Cannon cannon = iterator.next();
            cannon.draw(batch); //draws
            cannon.boundingBox.y -= cannon.movementSpeed*deltaTime; //going down the screen
            if(cannon.boundingBox.y + cannon.boundingBox.height < 0){
                iterator.remove(); //removes last item retrieved from iterator
            }
        }
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
//This is for testing purposes