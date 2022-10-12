package Game;

import Game.Screens.Level1;
import GameObjects.Guga;
import GameObjects.ObjectFactory;

public class Engine {  //Should Engine be the one responsible for comparing positioning for collision?
                        //Should engine have an arrayList of GameObjects, or should GameObjects?

    private int delay;
    private Map map;
    private ObjectFactory factory;

    private Guga guga;


    public Engine(int delay){
        this.delay = delay;
        this.map = new Map();
        this.factory = new ObjectFactory();
        //map.getStartGame();
        map.getLevel1();
        //map.getLevel2();
        this.guga = factory.spawnGuga( Map.Padding -100, map.getHeight() -100); // -100 it's de adjustment for the picture ffs
                                                                                        //kill me, or make int imageAdjust = -100

    }

    public void startGame(){
        guga.keyboardInit();  //keyboard MUST be here for the love of God
        while(true) {

            //slows down game, so we see it happen, and not just the result
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {       //Apparently we don't need to catch these exexions, but let it be for now
                System.out.println(ex.getMessage());
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            guga.gravity(map);
        }

        //StartGame startGame = new StartGame();

    }
}
