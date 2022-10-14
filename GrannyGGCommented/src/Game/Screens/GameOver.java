package Game.Screens;

import Game.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOver {

        private Map map;

        private Picture restart;


        public GameOver(Map map){
            this.restart = new Picture(472, 320, "restart2.png");
        }

        public void draw(){
            restart.draw();
        }




    }
