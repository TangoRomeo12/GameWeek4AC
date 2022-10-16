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
        pickCodeCadet(x,y);
    }

    public void pickCodeCadet(double x, double y){
        int randomCadetPick = ((int) Math.round(Math.random()*3));
        switch(randomCadetPick){

            case 0:
                this.codeCadet = new Picture(x,y,"src/resources/Daniel.png");
                break;
            case 1:
                this.codeCadet = new Picture(x,y,"src/resources/fabio.png");
                break;
            case 2:
                this.codeCadet = new Picture(x,y,"src/resources/Marco.png");
                break;
            case 3:
                this.codeCadet = new Picture(x,y,"src/resources/Romeu.png");
                break;
            case 4:
                this.codeCadet = new Picture(x,y,"src/resources/joana.png");
                break;

        }
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
