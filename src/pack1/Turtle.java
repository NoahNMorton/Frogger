package pack1;


@SuppressWarnings("CanBeFinal")
public class Turtle extends FroggerItem {
    public static final int ONE_TURTLE = 0, TWO_TURTLE = 1, THREE_TURTLE = 2; //type
    public static final int ALWAYS_UP = 4, UP = 0, HALF_UP = 1, DOWN = 2, HALF_DOWN = 3; //mode
    private int mode, timer = 0, type, rate;


    public Turtle(double speed, int type, int direction, double x, double y) {
        super(speed, type, direction, x, y);
        //set mode and rate based on difficulty
        if (FroggerGame.difficulty == 0 || FroggerGame.difficulty == 1) {
            mode = ALWAYS_UP;
            rate = 0; //because it doesn't matter, since Always up
        } else if (FroggerGame.difficulty == 2) {
            mode = (int) (Math.random() * 4);
            rate = 200;
        } else {
            mode = (int) (Math.random() * 4);
            rate = 100;
        }
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
        timer++;
        if (mode != ALWAYS_UP) { //only change if the turtle is not always up
            if (mode == DOWN && timer == rate) {
                mode = HALF_UP;
                timer = 0;
            }
            if (mode == HALF_UP && timer == rate) {
                mode = UP;
                timer = 0;
            }
            if (mode == UP && timer == rate) {
                mode = HALF_DOWN;
                timer = 0;
            }
            if (mode == HALF_DOWN && timer == rate) {
                mode = DOWN;
                timer = 0;
            }
        }
    }


    int getMode() {
        return mode;
    }
}
