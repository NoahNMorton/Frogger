package pack1;


public class CarLane extends Lane {

    public CarLane(double speed, int direction, int y) {
        super(speed, direction, y);

    }

    void update() {
        super.update();
        int carType = (int) (Math.random() * 4);
        int length;
        switch (carType) {
            case Car.SEMI: //if semi
                length = 120;
                break;
            case Car.CAR_2: //if limo
                length = 80;
                break;
            default: //else is type of car
                length = 40;
                break;
        }
        if (direction == RIGHT) {
            int location = -120 - (int) (Math.random() * 49) - length;
            if (laneItems.size() == 0) {
                laneItems.add(new Car(speed, (int) (Math.random() * 4), RIGHT, location, y));
            }
            for (int i = 0; i < laneItems.size(); i++) {
                if (laneItems.get(i).getDirection() == Lane.LEFT && laneItems.get(i).getX() < -20) laneItems.remove(i);
                if (laneItems.get(i).getDirection() == Lane.RIGHT && laneItems.get(i).getX() > 720) laneItems.remove(i);

            }
            if ((int) laneItems.get(laneItems.size() - 1).getX() + laneItems.get(laneItems.size() - 1).getWidth() > 0) {

                Car newCar = new Car(speed, carType, RIGHT, location, y);
                newCar.setX(location - newCar.getWidth());
                laneItems.add(newCar);
            }
        } else if (direction == LEFT) {
            int location = 700 + (int) (Math.random() * 49) + length; //set location of car to spawn
            if (laneItems.size() == 0) {
                laneItems.add(new Car(speed, (int) (Math.random() * 4), LEFT, location, y));
            }
            for (int i = 0; i < laneItems.size(); i++) {
                if (laneItems.get(i).getDirection() == Lane.RIGHT && laneItems.get(i).getX() > 720) laneItems.remove(i);
            }
            if ((int) laneItems.get(laneItems.size() - 1).getX() + laneItems.get(laneItems.size() - 1).getWidth() < 700) {
                laneItems.add(new Car(speed, carType, LEFT, location, y));
            }
        }
    }
}
