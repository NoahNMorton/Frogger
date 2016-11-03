package pack1;


public class LogLane extends Lane {

    public LogLane(double speed, int direction, int y) {
        super(speed, direction, y);
    }

    void update() {
        super.update();
        int logType = (int) (Math.random() * 3);
        int length = 0;
        switch (logType) {
            case Log.LONG:
                length = 200;
                break;
            case Log.MEDIUM:
                length = 120;
                break;
            case Log.SHORT:
                length = 80;
                break;
        }
        if (direction == RIGHT) {
            int location = -120 - (int) (Math.random() * 49) - length;
            if (froggerItems.size() == 0) {
                froggerItems.add(new Log(speed, (int) (Math.random() * 4), RIGHT, location, y));
            }
            for (int i = 0; i < froggerItems.size(); i++) {
                if (froggerItems.get(i).getDirection() == Lane.LEFT && froggerItems.get(i).getX() < -20)
                    froggerItems.remove(i);
                if (froggerItems.get(i).getDirection() == Lane.RIGHT && froggerItems.get(i).getX() > 720)
                    froggerItems.remove(i);

            }
            if ((int) froggerItems.get(froggerItems.size() - 1).getX() + froggerItems.get(froggerItems.size() - 1).getWidth() > 0) {

                Log newLog = new Log(speed, logType, RIGHT, location, y);
                newLog.setX(location - newLog.getWidth());
                froggerItems.add(newLog);
            }
        } else if (direction == LEFT) {
            int location = 700 + (int) (Math.random() * 49) + length; //set location of car to spawn
            if (froggerItems.size() == 0) {
                froggerItems.add(new Log(speed, (int) (Math.random() * 4), LEFT, location, y));
            }
            for (int i = 0; i < froggerItems.size(); i++) {
                if (froggerItems.get(i).getDirection() == Lane.RIGHT && froggerItems.get(i).getX() > 720)
                    froggerItems.remove(i);
            }
            if ((int) froggerItems.get(froggerItems.size() - 1).getX() + froggerItems.get(froggerItems.size() - 1).getWidth() < 700) {
                froggerItems.add(new Log(speed, logType, LEFT, location, y));
            }
        }
    }

}
