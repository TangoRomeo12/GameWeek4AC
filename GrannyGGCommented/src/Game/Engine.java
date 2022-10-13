package Game;


import GameObjects.CodeCadet;
import GameObjects.Guga;
import GameObjects.ObjectFactory;

public class Engine{

    private CodeCadet codeCadet;
    private int delay;
    private Map map;
    private ObjectFactory factory;
    private Guga guga;

    public Engine(int delay) throws InterruptedException {
        this.delay = delay;
        this.map = new Map();
        this.factory = new ObjectFactory();
        map.getLevel1();
        this.guga = factory.spawnGuga(Map.Padding, map.getHeight());


    }


    public void startGame() throws InterruptedException {
        this.codeCadet = factory.spawnCodeCadets(map.getWidth(), map.getHeight() - 60);
        guga.keyboardInit();
        while (true) {
            Thread.sleep(delay);

            guga.gravity(map);

            codeCadet.move();
            System.out.println(codeCadet.getPosX());


        }

    }




}
