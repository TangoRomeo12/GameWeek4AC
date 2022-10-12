package Game;

import Game.Screens.Level1;
import Game.Screens.Level2;
import Game.Screens.StartGame;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Map {

    //If objects are instanced here, since the map is instanced in Engine, and Engine in the main
    //In *theory* all have contact, so they will all show
    //*Maybe* instantiate here the screens too and make the logic of when to switch in the Engine class, method startGame
    public static int Padding = 10;
    private Rectangle backGround;
    private int rows = 80;
    private int cols = 150;
    public final static int cellSize = 10;
    private int height;
    private int width;
    private int middleY = height/2;
    private double y = Padding;
    private double x = Padding;
    private int middleX = width/2;
    private StartGame startGame;
    private Level1 level1;
    private Level2 level2;

    public Map(){
        this.width =  cols * cellSize;
        this.height =  rows * cellSize;
        this.backGround = new Rectangle(Padding, Padding, width, height);
        backGround.setColor(Color.BLACK);
        backGround.fill();                          //Missing for screen appearance: make levelUp condition
        this.level1 = new Level1(this);         //Note that Guga should only appear after the startGame screen
        //this.level2 = new Level2(this);
        //this.startGame = new StartGame(this);

    }

    public StartGame getStartGame() {
        return this.startGame = new StartGame(this);
    }

    public Level1 getLevel1() {
        return this.level1 =  new Level1(this);
    }

    public Level2 getLevel2() {
        return this.level2 =  new Level2(this);
    }

    public double getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getX() {
        return x;
    }

    public int getMiddleX() {
        return middleX;
    }

    public int getMiddleY() {
        return middleY;
    }
}
