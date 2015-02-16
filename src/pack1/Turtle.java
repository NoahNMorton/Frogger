package pack1;

/**
 * Created by noah on 2/16/15.
 */
public class Turtle extends LaneItem {
    public static final int ONE_TURTLE = 0, TWO_TURTLE = 1, THREE_TURTLE = 2; //type
    public static final int ALWAYS_UP = 4, UP = 0, HALF_UP = 1, DOWN = 2, HALF_DOWN = 3; //mode
    int mode, timer;

    public Turtle(double speed, int type, int direction, double x) {
        super(speed, type, direction, x);
        mode = (int) (Math.random() * 4);
    }

    public int getWidth() {
        //returns width based on type.
        return 0;
    }

    void update() {
        super.update();
        //changes mode periodically when mode is not ALWAYS_UP
    }


}
