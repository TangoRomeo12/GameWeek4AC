package Game.Screens;

import Game.Map;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartGame{

    private Picture startGame;


    public StartGame(Map map){
        this.startGame = new Picture(map.Padding, map.Padding, "StartGame.jpg");

    }

    public void delete(){
        startGame.delete();
    }

    public void draw(){
        startGame.draw();
    }

}
