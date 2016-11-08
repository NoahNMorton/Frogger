package pack1;


import java.util.ArrayList;

public class FroggerGame {

    public static final int PLAYING = 0, DEAD = 1, PLAYER_WINS = 2, MAX_LIFE_TIME = 80;
    private boolean reachedMiddle;
    private Frog player;
    private LogLane[] logLanes;
    private CarLane[] carLanes;
    private TurtleLane[] turtleLanes;
    private LilyPad[] lilyPadses; //I'm leaving it like that. It's required. #smeagle
    private int status, lives, startLifeTime;

    public FroggerGame() {
        status = FroggerGame.PLAYING;
        reachedMiddle = false;
        lives = 3;
        player = new Frog(320, 500);
        //lilly pads------------------------
        lilyPadses = new LilyPad[4];
        lilyPadses[0] = new LilyPad(75, 30);
        lilyPadses[1] = new LilyPad(254, 30);
        lilyPadses[2] = new LilyPad(433, 30);
        lilyPadses[3] = new LilyPad(612, 30);
        //log and car lanes -------------
        carLanes = new CarLane[5];
        logLanes = new LogLane[3];
        turtleLanes = new TurtleLane[2];

        carLanes[0] = new CarLane(6, Lane.RIGHT, 300);
        carLanes[1] = new CarLane(3, Lane.LEFT, 340);
        carLanes[2] = new CarLane(1, Lane.RIGHT, 380);
        carLanes[3] = new CarLane(6, Lane.LEFT, 420);
        carLanes[4] = new CarLane(3, Lane.RIGHT, 460);
        Logger.logOtherMessage("Lanes", "Setup car lanes.");

        logLanes[0] = new LogLane(2, Lane.RIGHT, 70);
        logLanes[1] = new LogLane(2, Lane.RIGHT, 140);
        logLanes[2] = new LogLane(2, Lane.LEFT, 180);
        Logger.logOtherMessage("Lanes", "Setup log lanes.");

        //turtle lanes ---------------------
        turtleLanes[0] = new TurtleLane(2, Lane.LEFT, 100);
        turtleLanes[1] = new TurtleLane(2, Lane.RIGHT, 220);
        Logger.logOtherMessage("Lanes", "Setup turtle lanes.");


        //todo Sets the lifeTimer


        for (int t = 0; t < 1000; t++) //calls update on all lanes before loading game
            update();
    }

    void update() {
        for (CarLane carLane : carLanes) carLane.update();
        for (LogLane logLane : logLanes) logLane.update();
        for (TurtleLane turtleLane : turtleLanes) turtleLane.update();

        runChecks();
    }

    public int getStatus() {
        return status;
    }

    public int getLives() {
        return lives;
    }

    public Frog getPlayer() {
        return player;
    }

    public LogLane[] getLogLanes() {
        return logLanes;
    }

    public CarLane[] getCarLanes() {
        return carLanes;
    }

    public LilyPad[] getLilyPadses() {
        return lilyPadses;
    }

    public TurtleLane[] getTurtleLanes() {
        return turtleLanes;
    }

    public int getTimeLeft() {
        return MAX_LIFE_TIME - startLifeTime;
    }

    /**
     * Preforms actions to "kill the player", such as removing a life, re-spawning, etc
     */
    private void playerDeath() {
        Logger.logUserMessage("User died.");
        lives--;
        if (lives == 0) { //if game over
            status = DEAD;
            Logger.logUserMessage("Game over.");
        }
        player = new Frog(320,500); //set player back at spawn point
    }

    /**
     * Checks to see if a car killed the player.
     */
    private void carCheck() {
        for (CarLane carLane : carLanes) {
            ArrayList<FroggerItem> fIOfCarLane = carLane.getFroggerItems();
            for (FroggerItem aFIOfCarLane : fIOfCarLane) {
                if (aFIOfCarLane.getRect().intersects(player.getRect())) { //if frog touching car
                    playerDeath();
                }
            }
        }
    }

    private void logCheck() {
        //todo moves player if on log with log, otherwise kills
        for (LogLane logLane : logLanes) {
            ArrayList<FroggerItem> fIOfLogLane = logLane.getFroggerItems();
            for (FroggerItem aFIOfLogLane : fIOfLogLane) {
                if (!aFIOfLogLane.getRect().intersects(player.getRect())) { //if they don't intersect, aka off the log
                    playerDeath();
                } else {
                    //move frog
                }
            }
        }
    }

    private void turtleCheck() {
        //todo moves player with non-down turtle, otherwise kills
    }

    private void lilyCheck() {
        /* todo lilyCheck
        Processes the games response when the player is in
        the lane with the lily pads. If the player is on the
        last lily pad he/she will win. When the players is on
        a lily pad that is not the last one it will be set to
        store a frog and teleport the player back to the start.
        When the player is not on an empty lily pad he/she
        will be pushed back into the log lane.
         */
    }

    private void runChecks() {
        //todo calls correct check methods based on y pos
        //for now, just call carchecks
        carCheck();
    }


}
