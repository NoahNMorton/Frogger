package pack1;


public class Turtle extends FroggerItem {
    public static final int ONE_TURTLE = 0, TWO_TURTLE = 1, THREE_TURTLE = 2; //type
    public static final int ALWAYS_UP = 4, UP = 0, HALF_UP = 1, DOWN = 2, HALF_DOWN = 3; //mode
    private int mode, timer, type;

    public Turtle(double speed, int type, int direction, double x, double y) {
        super(speed, type, direction, x, y);
        mode = (int) (Math.random() * 4);
        this.type = type;
    }

    /**
     * Returns the width based on the size of the turtle platform.
     *
     * @return width of image based on type of turtle, ONE_TURTLE, etc
     */
    public int getWidth() {
        switch (type) {
            case ONE_TURTLE:
                return 40;
            case TWO_TURTLE:
                return 80;
            case THREE_TURTLE:
                return 120;
        }
        return 0;
    }

    void update() {
        super.update();
        //todo changes mode periodically when mode is not ALWAYS_UP
    }

    public int getMode() {
        return mode;
    }
}
