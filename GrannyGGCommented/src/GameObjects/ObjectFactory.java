package GameObjects;

public class ObjectFactory {

    public ObjectFactory(){

    }

    public Guga spawnGuga(double x, double y){
       return new Guga(x, y);
    }

    public GameObjects spawnObjects(){    //Appears to be all good, for now
        double CCToObstRatio = 0.40;
        double jokesRatio = 0.70;
        double randomSpawn = Math.random();
        if(randomSpawn > CCToObstRatio){
            return new Obstacles();
        }
        if(randomSpawn > jokesRatio){
            return new Jokes();
        }
        return new CodeCadet();
    }


}
