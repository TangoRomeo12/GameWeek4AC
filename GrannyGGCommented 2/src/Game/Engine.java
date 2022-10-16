package Game;


import Game.Screens.GameOver;
import Game.Screens.Level1;
import Game.Screens.StartGame;
import GameObjects.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Engine implements KeyboardHandler {

    private Life[] gugaLives;
    private CodeCadet codeCadet;
    private Obstacles obstacle;
    private Guga guga;
    private Map map;
    private ObjectFactory factory;
    private StartGame startGame;
    private Level1 level1;
    private GameOver restart;
    private int delay;
    private boolean gameOver = false;
    private boolean hasCollidedCadet = false;
    private boolean hasCollidedObstacle = false;
    private int pressedKey;
    private boolean gameHasStarted;



    public Engine(int delay) {
        this.delay = delay;
        this.map = new Map();
        this.factory = new ObjectFactory();
        this.guga = factory.spawnGuga(Map.Padding, map.getHeight());
        this.level1 = new Level1(map);
        this.startGame = new StartGame(map);
        this.restart = new GameOver(map);
        this.gugaLives = new Life[guga.getMaxLife()];

    }


    public void move() throws InterruptedException {

        obstacle.fall(map);
        obstacle.obstacleDraw();
        codeCadet.move();
        codeCadet.codeCadetDraw();


       while (codeCadet.getPosX() >= Map.Padding || obstacle.getPosY() >= map.getHeight()) {

            Thread.sleep(90);
            checkObstacleCollision();
            checkCadetCollision();
            guga.gravity(map);
            codeCadet.move();
            obstacle.fall(map);


       }

        if(hasCollidedCadet) {
            guga.setMaxLife(codeCadet.getDamageDone());
            System.out.println(guga.getMaxLife());
            gugaLives[guga.getMaxLife()].lifeDelete();

        }
        if(hasCollidedObstacle) {
            guga.setMaxLife(1);
            System.out.println(guga.getMaxLife());
            gugaLives[guga.getMaxLife()].lifeDelete();
        }
        if (guga.getMaxLife() == 0) {
            gameOver = true;
        }

        hasCollidedObstacle = false;
        hasCollidedCadet = false;
        codeCadet.cadetDelete();
        obstacle.obstacleDelete();

    }


    public void checkCadetCollision() {

        if (guga.getPosX() < codeCadet.getPosX() + codeCadet.getWidth()
                && guga.getPosX() + guga.getWidth() > codeCadet.getPosX()
                && guga.getPosY() < codeCadet.getPosY() + codeCadet.getHight()
                && guga.getHight() + guga.getPosY() > codeCadet.getPosY()) {
            hasCollidedCadet = true;
            codeCadet.cadetDelete();

        }

    }

    public void checkObstacleCollision(){
        if (guga.getPosX() < obstacle.getPosX() + obstacle.getWidth()
                && guga.getPosX() + guga.getWidth() > obstacle.getPosX()
                && guga.getPosY() < obstacle.getPosY() + obstacle.getHeight()
                && guga.getHight() + guga.getPosY() > obstacle.getPosY()) {
            hasCollidedObstacle = true;
            obstacle.obstacleDelete();

        }
    }


    public void startGame() throws InterruptedException {

        Text life = new Text(map.getWidth()- 40*5, 30, "HP: ");
        life.setColor(Color.BLACK);
        life.grow(30, 20);
        life.draw();

        gugaLives[0] = new Life(map.getWidth(), 20);
        gugaLives[0].lifeDraw();

        for (int i = 1; i < gugaLives.length; i++) {
            gugaLives[i] = new Life(gugaLives[i -1].getPosX() - 40, 20 );
            gugaLives[i].lifeDraw();
        }

        guga.keyboardInit();

        while (!gameOver) {

            obstacle = factory.spawnObstacles(map);
            codeCadet = factory.spawnCodeCadets(map.getWidth(), map.getHeight() - 60);

            Thread.sleep(200);
            guga.draw();
            guga.gravity(map);
            move();

        }
        guga.delete();
        restart.draw();
        Thread.sleep(2000);
        System.exit(0);

    }


    public void verifyStartGame() throws InterruptedException {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent startGameKey = new KeyboardEvent();
        startGameKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        startGameKey.setKey(KeyboardEvent.KEY_P);
        keyboard.addEventListener(startGameKey);

        KeyboardEvent restartGame = new KeyboardEvent();
        restartGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        restartGame.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(restartGame);


        while(!gameHasStarted){
            startGame.draw();
        }
        startGame.delete();
        level1.draw();
        startGame();

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(keyboardEvent.getKey() ==  KeyboardEvent.KEY_P){
                pressedKey = KeyboardEvent.KEY_P;
                gameHasStarted = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}








