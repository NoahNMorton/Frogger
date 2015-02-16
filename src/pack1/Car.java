package pack1;


public class Car extends LaneItem {

    public static final int SEMI = 0, LIMO = 1, CAR_1 = 2, CAR_2 = 3;

    public Car(double speed, int type, int direction, double x) {
        super(speed, type, direction, x);
    }

    public int getWidth() {
        //returns width based on type.
        return 0;
    }
}
