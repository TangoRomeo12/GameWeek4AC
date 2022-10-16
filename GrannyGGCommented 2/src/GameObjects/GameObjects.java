package GameObjects;

public abstract class GameObjects {

    protected boolean isVisible;
    protected ObjectType type;


    GameObjects(boolean isVisible, ObjectType type){
        this.isVisible = isVisible;
        this.type = type;
    }

    public void move(){}



}
