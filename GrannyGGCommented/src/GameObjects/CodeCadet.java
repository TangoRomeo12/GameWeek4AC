package GameObjects;

import Game.Map;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class CodeCadet extends GameObjects {

    private Rectangle codeCadet;
    private double velX = 1;
    private double velY = 1;




    CodeCadet(double x, double y){
        super(false, ObjectType.CODECADET);

        this.codeCadet = new Rectangle(x, y, 90,90);
        codeCadet.fill();

    }

    @Override
    public void move(){

        if(!(codeCadet.getX() <= Map.Padding)) {
            System.out.println("boi");
            codeCadet.translate(-velX * 30, 0);
            System.out.println("caralho");
        } else{
            codeCadet.delete();
        }
    }


    public double getPosX() {
        return codeCadet.getX();
    }
}
