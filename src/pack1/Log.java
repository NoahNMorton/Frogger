package pack1;

public class Log extends LaneItem {
    public static final int SHORT = 0, MEDIUM = 1, LONG = 2;

    public Log(double speed, int type, int direction, double x) {
        super(speed, type, direction, x);
    }

    public int getWidth() {
        //returns width based on type.
        return 0;
    }
}
