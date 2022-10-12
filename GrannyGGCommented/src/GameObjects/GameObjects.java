package GameObjects;

public abstract class GameObjects {

    protected boolean isVisible;
    protected ObjectType type;

    GameObjects(boolean isVisible, ObjectType type){
        this.isVisible = isVisible;
        this.type = type;
    }


    //Every object will move
    //Maybe the method will be empty here and then ov in the subclasses
    public void move(){
        System.out.println("MAKE METHOD MOVE OV FOR SUBCLASSES Game.GameObjects.Game.GameObjects.CC OBST AND Game.GameObjects.Game.GameObjects.GG");
    }

    public void moveLeft(){};


}
