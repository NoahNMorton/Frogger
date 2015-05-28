package pack1;


public class CarLane extends Lane {

    public CarLane(double speed, int direction, int y) {
        super(speed, direction, y);

    }

    void update() {
        super.update();
        //todo adds/removes cars
        int location = -100 + (int) (Math.random() * 49) - 20;
        if (laneItems.size() == 0) {

            laneItems.add(new Car(speed, (int) (Math.random() * 4), RIGHT, location, y));
            //System.out.println("Added a car at "+location);
        }
        for (int i = 0; i < laneItems.size(); i++) {
            if (laneItems.get(i).getDirection() == Lane.LEFT && laneItems.get(i).getX() < -20) laneItems.remove(i);
            if (laneItems.get(i).getDirection() == Lane.RIGHT && laneItems.get(i).getX() > 720) laneItems.remove(i);
            //System.out.println("Removed a car.");
        }
        if ((int) laneItems.get(laneItems.size() - 1).getX() + laneItems.get(laneItems.size() - 1).getWidth() > 0) {
            int carType = (int) (Math.random() * 4);
            Car newCar = new Car(speed, carType, RIGHT, location, y);
            newCar.setX(location - newCar.getWidth());
            laneItems.add(newCar);
        }
    }
}
