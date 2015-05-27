package pack1;

public class Log extends LaneItem {
    public static final int SHORT = 0, MEDIUM = 1, LONG = 2;

    public Log(double speed, int type, int direction, double x, double y) {
        super(speed, type, direction, x, y);
    }

    /**
     * Gets the width of the log.
     *
     * @return int based on the length of the log.
     */
    public int getWidth() {

        if (type == SHORT)
            return 80;
        if (type == MEDIUM)
            return 120;
        if (type == LONG)
            return 200;
        return 0;
    }
}
