package Game;

import Game.Screens.Level1;
import Game.Screens.StartGame;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Map {


    public static int Padding = 10;
    private Rectangle backGround;
    private int rows = 80;
    private int cols = 150;
    public final static int cellSize = 10;
    private double height;
    private double width;
    private double y = Padding;
    private double x = Padding;

    private StartGame startGame;
    private Level1 level1;

    public Map(){
        this.width =  cols * cellSize;
        this.height =  rows * cellSize;
        this.backGround = new Rectangle(Padding, Padding, width, height);
        backGround.setColor(Color.BLACK);
        backGround.fill();
        this.level1 = new Level1(this);


    }

    public Level1 getLevel1() {
        return this.level1 =  new Level1(this);
    }


    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


}
