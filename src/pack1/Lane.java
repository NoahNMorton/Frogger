package pack1;


import java.util.ArrayList;

public class Lane {

    public static final int LEFT = 0, RIGHT = 1;
    int y, direction;
    double speed;
    ArrayList<FroggerItem> froggerItems = new ArrayList<FroggerItem>();


    public Lane(double speed, int direction, int y) {
        this.speed = speed;
        this.direction = direction;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public double getSpeed() {
        return speed;
    }

    public ArrayList<FroggerItem> getFroggerItems() {
        return froggerItems;
    }

    void update() {
        //System.out.println("Moving all objects");
        for (FroggerItem froggerItem : froggerItems) {
            froggerItem.update();
        }
    }
}
