package Game.Screens;

import Game.Map;
import Game.SoundHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level1 {

    private Map map;

    private Picture level1;


    public Level1(Map map){
       this.level1 = new Picture(map.Padding, map.Padding, "src/resources/level1.jpg");
        SoundHandler.RunMusic("src/resources/levelOne.wav");
    }

    public void draw(){
        level1.draw();
    }






}
