package pack1;


import java.util.ArrayList;

public class Lane {

    public static final int LEFT = 0, RIGHT = 1;
    int y, direction;
    double speed;
    ArrayList<LaneItem> laneItems = new ArrayList<LaneItem>();


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

    public ArrayList<LaneItem> getLaneItems() {
        return laneItems;
    }

    void update() {
        for (int i = 0; i < laneItems.size(); i++) {
            laneItems.get(i).update();
        }
    }
}
