package Game.Screens;

import Game.Map;
import Game.SoundHandler;
import com.sun.source.tree.NewArrayTree;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level1 {

    private Map map;

    private Picture level1;


    public Level1(Map map){
       this.level1 = new Picture(map.Padding, map.Padding, "level1.jpg");
        SoundHandler.RunMusic("Resources/levelOne.wav");
    }

    public void draw(){
        level1.draw();
    }






}
