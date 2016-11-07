package pack1;


public class Frog extends FroggerItem {

    public static final int UP = 0, DOWN = 1;
    private double x, y, direction;

    public Frog(double x, double y) {
        super(40, 0, UP, x, y);
        Logger.logCodeMessage("Set up frog.");
    }

    public int getWidth() {
        return 40;
    }

}
