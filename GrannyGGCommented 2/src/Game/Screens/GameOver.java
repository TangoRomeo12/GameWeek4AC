package Game.Screens;

import Game.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOver {

        private Map map;

        private Picture restart;


        public GameOver(Map map){
            this.restart = new Picture(472, 320, "src/resources/restart2.png");
        }

        public void draw(){
            restart.draw();
        }

        public void delete(){ restart.delete();}

    public Picture getRestart() {
        return restart;
    }
}
