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


    public static ObjectType type(int choice){
        ObjectType[] type = ObjectType.values();
        return type[choice];
    }



}
