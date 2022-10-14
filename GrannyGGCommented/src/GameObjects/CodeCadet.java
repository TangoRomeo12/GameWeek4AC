package GameObjects;

import Game.Map;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CodeCadet extends GameObjects {

    private Picture codeCadet;
    private double velX = 1;
    private double velY = 1;
    private int damageDone = 1;





    CodeCadet(double x, double y){
        super(false, ObjectType.CODECADET);
          this.codeCadet = new Picture(x, y, "fabio.png")  ;
    }

    @Override
    public void move(){

        if(!(codeCadet.getX() <= Map.Padding)) {
            codeCadet.translate(-velX * 30, 0);
        } else{
            codeCadet.delete();
        }
    }

    public double getPosX() {
        return codeCadet.getX();
    }

    public double getPosY(){
        return codeCadet.getY();
    }

    public double getHight(){
        return codeCadet.getHeight();
    }
    public double getWidth(){
        return codeCadet.getWidth();
    }

    public int getDamageDone(){
        return this.damageDone;
    }


    public void codeCadetDraw(){
        codeCadet.draw();
        isVisible = true;
    }
    public void cadetDelete(){
        codeCadet.delete();
        isVisible = false;
    }
}
