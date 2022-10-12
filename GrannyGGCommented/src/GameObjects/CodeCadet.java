package GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CodeCadet extends GameObjects {

    //Every Object has something that represents them in the Game.Map, in this case, a Picture (from library)
    private Picture codeCadet;


    CodeCadet(){
        super(false, ObjectType.CODECADET);
        this.codeCadet = new Picture(40, 40 , "PUT IMAGE URL HERE");

    }

    @Override
   public void move(){
        super.move();
   }
}
