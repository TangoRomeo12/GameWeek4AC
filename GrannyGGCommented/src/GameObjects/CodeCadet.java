package GameObjects;

import Game.Map;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class CodeCadet extends GameObjects {

    private Rectangle codeCadet;
    private double velX = 1;
    private double velY = 1;
    private double x;
    private double y;


    CodeCadet(double x, double y){
        super(false, ObjectType.CODECADET);
        this.x = x;
        this.y = y;
        this.codeCadet = new Rectangle(x, y , 90,90);

    }

    @Override
    public void move(){
        super.move();
            isVisible = true;
            codeCadet.setColor(Color.MAGENTA);
            codeCadet.fill();
            moveLeft();


    }

    @Override
    public void moveLeft(){
        super.moveLeft();
        if(!(codeCadet.getX() == Map.Padding)) {
            codeCadet.translate(-velX*30, 0);
        }
    }

    @Override
    public double getX() {
        super.getX();
        return x;
    }
}
