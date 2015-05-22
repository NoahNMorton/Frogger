package pack1;


public class LaneItem {

    double speed, x;
    int direction;
    int type;

    public LaneItem(double speed, int type, int direction, double x) {
        this.speed = speed;
        this.type = type;
        this.direction = direction;
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getDirection() {
        return direction;
    }

    int getWidth() {
        return 40;
    }

    public int getType() {
        return type;
    }

    void update() {
        if (direction == Lane.RIGHT)
            setX(x + speed);
        else if (direction == Lane.LEFT)
            setX(x - speed);
    }
}
