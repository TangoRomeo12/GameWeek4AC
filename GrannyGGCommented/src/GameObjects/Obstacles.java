package GameObjects;

import Game.Map;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Obstacles extends GameObjects {


    private Rectangle obstacle;  //Should be Picture
    private double velX = 1;
    private double velY = 1;
    private double x;
    private double y;


    public Obstacles(double x, double y) {
        super(false, ObjectType.OBSTACLES);
        this.x = x;
        this.y = y;

        this.obstacle = new Rectangle(x,y,80,80);

    }

    @Override
    public void move(){
            isVisible = true;
            obstacle.setColor(Color.BLACK);
            obstacle.fill();
            moveLeft();

    }

    @Override
    public void moveLeft(){
        if(!(obstacle.getX() == Map.Padding)) {
            obstacle.translate(-velX*35, 0);
        }
    }

    @Override
    public double getX() {
        super.getX();
        return x;
    }


}
