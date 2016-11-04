package pack1;


import java.awt.*;

public class Frog extends FroggerItem {

    public static final int UP = 0, DOWN = 1;
    Rectangle waterRect = new Rectangle();
    private double x, y, direction;

    public Frog(double x, double y) {
        super(40, 0, UP, x, y);
        Logger.logCodeMessage("Set up frog.");
    }

    public int getWidth() {
        return 40;
    }

    public Rectangle getWaterRect() {
        return waterRect;
    }
}
