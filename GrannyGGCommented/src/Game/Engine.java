package Game;

import GameObjects.GameObjects;
import GameObjects.Guga;
import GameObjects.ObjectFactory;

public class Engine{

    private GameObjects[] gameObjects = new GameObjects[10];
    private int delay;
    private Map map;
    private ObjectFactory factory;
    private Guga guga;

    public Engine(int delay){
        this.delay = delay;
        this.map = new Map();
        this.factory = new ObjectFactory();
        map.getLevel1();
        this.guga = factory.spawnGuga(Map.Padding, map.getHeight());
        for(int i = 0; i < gameObjects.length;  i++){
            gameObjects[i] = factory.spawnObjects(map.getWidth(), map.getHeight() - 60);
        }
    }


    public void startGame() throws InterruptedException {
        guga.keyboardInit();
        while (true) {
            Thread.sleep(delay);
            guga.gravity(map);
            gameObjects[0].move();
            
            for (int i = 1; i < gameObjects.length - 1;  i++){
                gameObjects[i].move();
                while(gameObjects[i].getX() >= Map.Padding) {

                }
                gameObjects[i + 1].move();

//Not right, need to create space between them
            }

        }
    }




}
