package GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Life extends GameObjects {

    private Picture life;


    public Life(double x, double y) {
        super(false,ObjectType.LIFE);
        this.life = new Picture(x,y, "src/resources/life.png");
    }

    public void lifeDraw(){
        life.draw();
        isVisible = true;
    }

    public void lifeDelete(){
        life.delete();
        isVisible = false;
    }



    public double getPosX() {
        return life.getX();
    }

    public double getPosY(){
        return life.getY();
    }

    public double getHight(){
        return life.getHeight();
    }
    public double getWidth(){
        return life.getWidth();
    }

}