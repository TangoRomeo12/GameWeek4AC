package GameObjects;

public abstract class GameObjects {

    protected boolean isVisible;
    protected ObjectType type;

    protected double x;


    GameObjects(boolean isVisible, ObjectType type){
        this.isVisible = isVisible;
        this.type = type;
    }


    //Every object will move
    //Maybe the method will be empty here and then ov in the subclasses
    public void move(){}

    public void moveLeft(){};

    public double getX() {
        return x;
    }
}
