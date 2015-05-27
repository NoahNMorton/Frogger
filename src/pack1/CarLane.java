package pack1;


public class CarLane extends Lane {

    public CarLane(double speed, int direction, int y) {
        super(speed, direction, y);

    }

    void update() {
        super.update();
        //todo adds/removes cars

        if (laneItems.size() == 0) {
            int location = -100 + (int) (Math.random() * 49) + 1;
            laneItems.add(new Car(speed, Car.CAR_1, RIGHT, location, y));
            //System.out.println("Added a car at "+location);
        }
        for (int i = 0; i < laneItems.size(); i++) {
            if (laneItems.get(i).getDirection() == Lane.LEFT && laneItems.get(i).getX() < -20) laneItems.remove(i);
            if (laneItems.get(i).getDirection() == Lane.RIGHT && laneItems.get(i).getX() > 720) laneItems.remove(i);
            //System.out.println("Removed a car.");
        }


    }


}
