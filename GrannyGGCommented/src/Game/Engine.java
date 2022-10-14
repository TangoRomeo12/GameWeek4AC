package Game;


import Game.Screens.GameOver;
import Game.Screens.Level1;
import Game.Screens.StartGame;
import GameObjects.CodeCadet;
import GameObjects.Guga;
import GameObjects.ObjectFactory;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Engine implements KeyboardHandler {

    private CodeCadet[] cadet;
    private ObjectFactory factory;

    private Picture gameOverScreen;

    private StartGame startGame;
    private Level1 level1;
    private Map map;
    private Guga guga;
    private GameOver restart;
    private int delay;
    private boolean gameOver = false;
    private boolean hasColided = false;
    private int pressedKey;
    private boolean gameHasStarted;



    public Engine(int delay) throws InterruptedException {
        this.delay = delay;
        this.map = new Map();
        this.factory = new ObjectFactory();
        this.guga = factory.spawnGuga(Map.Padding, map.getHeight());
        this.cadet = new CodeCadet[50];
        this.level1 = new Level1(map);
        this.startGame = new StartGame(map);
        this.restart = new GameOver(map);

    }

    //e agora não me toca
    public void makeObjectsMove() throws InterruptedException {
        for (int i = 0; i < cadet.length; i++) {
            cadet[i].move();
            cadet[i].codeCadetDraw();
            while (cadet[i].getPosX() >= Map.Padding) {
                Thread.sleep(90);
                checkCollision(i);
                guga.gravity(map);
                cadet[i].move();
            }
            if(hasColided) {
                guga.setLife(cadet[i].getDamageDone());
                System.out.println(guga.getLife());
                if (guga.getLife() == 0) {
                    gameOver = true;
                    break;
                }
            }
            hasColided = false;
            cadet[i].cadetDelete();
        }
    }
    
    public void checkCollision(int i) throws InterruptedException {
        if (guga.getPosX() < cadet[i].getPosX() + cadet[i].getWidth()
                && guga.getPosX() + guga.getWidth() > cadet[i].getPosX()
                && guga.getPosY() < cadet[i].getPosY() + cadet[i].getHight()
                && guga.getHight() + guga.getPosY() > cadet[i].getPosY()) {
            hasColided = true;
            cadet[i].cadetDelete();
        }
    }


    public void startGame() throws InterruptedException {

        for (int i = 0; i < cadet.length; i++) {
            cadet[i] = factory.spawnCodeCadets(map.getWidth(), map.getHeight() - 60);
        }
        guga.keyboardInit();
        System.out.println(gameOver);
        while (!gameOver) {
            Thread.sleep(200);
            guga.draw();
            guga.gravity(map);
            makeObjectsMove();
        }
        System.out.println(gameOver);
        guga.delete();
        restart.draw();

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
        //System.out.println(gameHasStarted);
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_P:
                pressedKey = KeyboardEvent.KEY_P;
                gameHasStarted = true;
                break;
            case KeyboardEvent.KEY_R:
                pressedKey = KeyboardEvent.KEY_R;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}








