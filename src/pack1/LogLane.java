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
            int location = -(int) (Math.random() * 49) - length - 40;
            if (froggerItems.size() == 0) { //adds a log if there is no logs, ie start of game
                froggerItems.add(new Log(speed, logType, RIGHT, location, y));
            }
            for (int i = 0; i < froggerItems.size(); i++) { //removes logs once they go offscreen
                if (froggerItems.get(i).getDirection() == Lane.RIGHT && froggerItems.get(i).getX() > 1000)
                    froggerItems.remove(i);
            }
            if ((int) froggerItems.get(froggerItems.size() - 1).getX() > 0) { //creates a new log

                Log newLog = new Log(speed, logType, RIGHT, location, y);
                froggerItems.add(newLog);
            }
        } else if (direction == LEFT) {
            int location = 700 + (int) (Math.random() * 49) + 40; //set location of log to spawn
            if (froggerItems.size() == 0) { //adds a log if there is no logs, ie start of game
                froggerItems.add(new Log(speed, logType, LEFT, location, y));
            }
            for (int i = 0; i < froggerItems.size(); i++) { //removes logs if they go offscreen
                if (froggerItems.get(i).getDirection() == Lane.LEFT && froggerItems.get(i).getX() < -200)
                    froggerItems.remove(i);
            }
            if ((int) froggerItems.get(froggerItems.size() - 1).getX() + froggerItems.get(froggerItems.size() - 1).getWidth() < 700) { //adds a new log periodically
                Log newLog = new Log(speed, logType, LEFT, location, y);
                froggerItems.add(newLog);
            }
        }
    }
}
