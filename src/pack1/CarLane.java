package pack1;


public class CarLane extends Lane {

    public CarLane(double speed, int direction, int y) {
        super(speed, direction, y);

    }

    void update() {
        super.update();
        //todo adds/removes cars
        if (laneItems.size() == 0) {
            laneItems.add(new Car(speed, Car.CAR_1, RIGHT, (0 - 100) + (int) (Math.random() * 49) + 1));
        }


    }


}
