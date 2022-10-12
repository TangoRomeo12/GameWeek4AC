package Game.Screens;

import Game.Map;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartGame implements KeyboardHandler {

    private Picture popUpStartGame;
    private Picture startGameButton;
    private Text startGame;


    public StartGame(Map map){
        this.popUpStartGame = new Picture(map.Padding, map.Padding, "StartGame.png");
        popUpStartGame.draw();

        keyboardStartGameInit();
    }

    public void keyboardStartGameInit(){
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent startGame = new KeyboardEvent();
        startGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        startGame.setKey(KeyboardEvent.KEY_P);
    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_P -> System.out.println("Invoke gameStart() from engine here");

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
