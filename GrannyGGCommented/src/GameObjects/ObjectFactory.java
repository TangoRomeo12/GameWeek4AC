package GameObjects;

import Game.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ObjectFactory {

    public ObjectFactory() {

    }

    public Guga spawnGuga(double x, double y) {
        return new Guga(x, y);
    }

    public CodeCadet spawnCodeCadets(double x, double y) {
        return new CodeCadet(x, y);

    }
}
