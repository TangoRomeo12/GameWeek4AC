package Game;

public class Map {

    public static int Padding = 10;
    private int rows = 80;
    private int cols = 150;
    public final static int cellSize = 10;
    private double height;
    private double width;
    private double y = Padding;
    private double x = Padding;

    public Map(){
        this.width =  cols * cellSize;
        this.height =  rows * cellSize;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }






}
