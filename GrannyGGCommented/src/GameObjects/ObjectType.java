package GameObjects;

public enum ObjectType {

    GUGA(5 ),
    CODECADET(2),
    OBSTACLES(0),
    JOKES(0);


    private int MaxDamage;

    ObjectType( int MaxDamage){

        this.MaxDamage = MaxDamage;
    }

    //Game.GameObjects.GameObjects.ObjectFactory can only create these types of Objects
    //Should also be used in the subclasses, assign the correspondent type to their type variable
    public static ObjectType type(int choice){
        ObjectType[] type = ObjectType.values();
        return type[choice];
    }



}
