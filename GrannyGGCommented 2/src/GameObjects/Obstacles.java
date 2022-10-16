package GameObjects;

import Game.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacles extends  GameObjects{

    private Picture fallingObstacle;
    private double velX = 1;
    private double velY = 1;
    private boolean isOnAir = true;

    public Obstacles(Map map){
        super(false, ObjectType.OBSTACLES);
        pickObject(map);
    }

    public void pickObject(Map map){
        double randomPosX = Math.round(Math.random() * map.getWidth());
        this.fallingObstacle = new Picture(randomPosX + Map.Padding, Map.Padding,"src/resources/obstaclegit.png");
    }

    public void fall(Map map){
        if (!(fallingObstacle.getY() >= map.getHeight() - 90)) {
            fallingObstacle.translate(0, velY * 60);
        } else {
            fallingObstacle.delete();
            isOnAir = false;
        }
    }

    public double getPosX() {
        return fallingObstacle.getX();
    }

    public double getPosY(){
        return fallingObstacle.getY();
    }

    public double getHeight(){
        return fallingObstacle.getHeight();
    }
    public double getWidth(){
        return fallingObstacle.getWidth();
    }

    public void obstacleDraw(){
       fallingObstacle.draw();
        isVisible = true;
    }
    public void obstacleDelete(){
        fallingObstacle.delete();
        isVisible = false;
    }



}
