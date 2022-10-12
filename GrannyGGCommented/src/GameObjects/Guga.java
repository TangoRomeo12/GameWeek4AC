package GameObjects;

import Game.Map;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Guga extends GameObjects implements KeyboardHandler {

    private int humor;
    private Picture guga;
    private double posX;
    private double posY;
    private double velX = 1;
    private double velY = 1;
    private int previousKey;


    public Guga(double x, double y){
        super(false, ObjectType.GUGA);
        this.posX = x;
        this.posY = y;
        this.humor = 0;
        this.guga = new Picture(posX , posY ,"Guga.png");
        guga.draw();
    }

    //Missing collision with other gameObjects, if its is implemented
    //Missing life deducting from collision with obstacles and CodeCadets

    public void gravity(Map map) {
       if(!(guga.getY() >=  map.getHeight() - 150)){ //Again -150 represents pic adjustment to map
            guga.translate(0, velY*100);        //Pls assign it int pictureAdjust = -100
        }else{                                           //Starting to thing this should be static (no?)
           posY = (int) (map.getHeight() - 150);
       }
       //To think this was all we needed
    }
    public void keyboardInit(){
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent jump = new KeyboardEvent();
        jump.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        jump.setKey(KeyboardEvent.KEY_SPACE);

        keyboard.addEventListener(moveLeft);
        keyboard.addEventListener(moveRight);
        keyboard.addEventListener(jump);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch(keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:

                moveLeft();
                break;

            case KeyboardEvent.KEY_RIGHT:

                moveRight();
                break;

            case KeyboardEvent.KEY_SPACE:

                jump();
                break;

            default:
        }

    }

    public void moveLeft(){
        guga.translate(-velX * 10, 0);
        if (guga.getX() <= Map.Padding - 100) {
            posX = Map.Padding - 100;
        }
        previousKey = KeyboardEvent.KEY_LEFT;
    }

    public void moveRight(){
        guga.translate(velX * 10, 0);
        if (guga.getX() >= guga.getWidth() - 100) {
            posX = guga.getWidth() - 100;
        }
        previousKey = KeyboardEvent.KEY_RIGHT;
    }

    public void jump(){
        if (guga.getY() != guga.getY() + 300) {         //Needs to be a gradual thing... where's my rope??
            if (previousKey == KeyboardEvent.KEY_LEFT) {
                guga.translate(-velX * 200, -velY * 300);
            } else {
                guga.translate(velX * 200, -velY * 300);
            }
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
