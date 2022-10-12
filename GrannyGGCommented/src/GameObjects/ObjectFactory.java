package GameObjects;

public class ObjectFactory {


    public ObjectFactory(){

    }

    public Guga spawnGuga(double x, double y){
       return new Guga(x, y);
    }

    public GameObjects spawnObjects(double x, double y){

            double CCToObstRatio = 0.40;
            double jokesRatio = 0.70;
            double randomSpawn = Math.random();
            if (randomSpawn > CCToObstRatio) {
                return new Obstacles(x, y);
            }
            if (randomSpawn > jokesRatio) {
                return new Jokes();
            }
            return new CodeCadet(x,y);
        }

}
