package pack1;


import java.awt.*;

public class Frog extends FroggerItem {

    public static final int UP =0, DOWN=1;
    private double x, y, direction;
    Rectangle waterRect = new Rectangle();

    public Frog(double x, double y) {
        super(40,0,UP,x,y);
    }

    public int getWidth() {
        return 40;
    }

    public Rectangle getWaterRect() {
        return waterRect;
    }
}
