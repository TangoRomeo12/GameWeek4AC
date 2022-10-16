package GameObjects;

public enum ObjectType {

    GUGA,
    CODECADET,
    OBSTACLES,
    LIFE,
    JOKES;




    ObjectType( ){}


    public static ObjectType type(int choice){
        ObjectType[] type = ObjectType.values();
        return type[choice];
    }



}
