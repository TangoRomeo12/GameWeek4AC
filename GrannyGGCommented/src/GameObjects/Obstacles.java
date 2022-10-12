package GameObjects;

import Game.Map;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Obstacles extends GameObjects {


    private Rectangle obstacle;  //Should be Picture
    private double velX = 1;
    private double velY = 1;



    Obstacles() {
        super(false, ObjectType.OBSTACLES);     //isVisible will help with spawn and delete of image

        //Spawn location opposite to Guga's X position, width -100, Padding -100 /=>/ -100 represents pictureAdjust
        this.obstacle = new Rectangle(10,10,10,10);                     //int pictureAdjust = -100
    }

    @Override
    public void move(){   //50% probability a obstacle won't spawn; used for timing and difficulty level
        super.move();
        int timeSpawn = (int) (Math.round(Math.random()*10));
        if(timeSpawn < 5){
            isVisible = true;
            obstacle.draw();
            moveLeft();
        }
    }

    @Override
    public void moveLeft(){
        super.moveLeft();
        //make can´t go left if obstcPosX <= Padding -100, therefore obstcPosX =  Padding -100
        //else this:
        obstacle.translate(-velX*10, 0);


    }
}
