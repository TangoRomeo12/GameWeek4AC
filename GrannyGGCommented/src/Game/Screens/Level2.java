package Game.Screens;

import Game.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level2 {

    private Map map;

    private Picture level2;

    public Level2(Map map){
        this.level2 = new Picture(map.Padding, map.Padding, "level2.png");
        level2.draw();
    }


}
