package GameObjects;

import Game.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Jokes extends GameObjects {

    private Picture jokes;

    Jokes() {
        super(false, ObjectType.JOKES);
        this.jokes = new Picture(40,40,"PUT IMAGE URL HERE");
    }


    @Override
    public void move(){
        super.move();
        int timeSpawn = (int) (Math.round(Math.random()*10));
        if(timeSpawn < 5){
            isVisible = true;
            jokes.draw();
            moveLeft();
        }
    }

    @Override
    public void moveLeft(){
        super.moveLeft();
        //if getpositiionX >= 0 position =<0 (n\ao pode andar mais para a esquerda)
        //else isto :
        jokes.translate(-Map.cellSize, 0);
    }

}
