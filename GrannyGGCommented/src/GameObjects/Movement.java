package GameObjects;

public enum Movement {

    LEFT,
    RIGHT,
    JUMP;


    //need to find a connection that's useful
    Movement(){}


   //should connect with interfaces Payable and NonPlayable
    //Cant play a NonPlayable object, but they still move

    public static Movement movements(int choice){
        Movement[] movements = Movement.values();
        return movements[choice];
    }


}
