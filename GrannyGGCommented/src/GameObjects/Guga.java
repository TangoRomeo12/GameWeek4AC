package GameObjects;

import Game.Map;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Guga extends GameObjects implements KeyboardHandler {

    private Picture guga;
    private int life;
    private double velX = 1;
    private double velY = 1;
    private double mapHeight;  //The map should be the oneto know about this
    private double mapWidh;        // same thing
    private  boolean isOnAir = false;
    private int previousKey;


    public Guga(double x, double y) {
        super(false, ObjectType.GUGA);
        this.life = 5;
        this.guga = new Picture(x, y - 108, "guga.png");
        //guga.draw();

    }


    public void gravity(Map map) {
        this.mapHeight = map.getHeight() - Map.Padding;
        this.mapWidh = map.getWidth() - Map.Padding;
        if (!(guga.getY() >= map.getHeight() - 150)) {
            guga.translate(0, velY * 100);
        } else {
            isOnAir = false;
        }

    }


    public void keyboardInit() {
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

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                moveLeft();
                previousKey = KeyboardEvent.KEY_LEFT;
                break;
            case KeyboardEvent.KEY_RIGHT:
                moveRight();
                previousKey = KeyboardEvent.KEY_RIGHT;
                break;
            case KeyboardEvent.KEY_SPACE:
                jump();
                break;
            default:
        }
    }

    public void moveLeft() {
        if (guga.getX() - 10 >= Map.Padding) {
            guga.translate(-velX * 8, 0);

        }
    }

    public void moveRight() {
        if (guga.getX() - 10 <= mapWidh - 20) {
            guga.translate(velX * 8, 0);

        }
    }

    public void jump() {
        if (!isOnAir) {
            if (!(guga.getY() <= Map.Padding)) {

                if(previousKey == KeyboardEvent.KEY_LEFT) {
                    if(guga.getX() - 10 >= -10) {
                        guga.translate(-velX * 70, -velY * 300);
                        isOnAir = true;
                    }
                }

                if(previousKey == KeyboardEvent.KEY_RIGHT) {
                    if(guga.getX() -10 <= mapWidh - 20) {
                        guga.translate(velX * 70, -velY * 300);
                        isOnAir = true;
                    }
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {}

    public double getPosX() {
        return guga.getX();
    }

    public int getPosY(){
        return guga.getY();
    }

    public int getLife(){
        return this.life;
    }
    public double getWidth(){
        return guga.getWidth();
    }
    public double getHight(){
        return guga.getHeight();
    }

    public void setLife(int damage){
        this.life = life - damage;
    }

    public void delete(){
        guga.delete();
    }

    public void draw(){
        guga.draw();
    }

}
