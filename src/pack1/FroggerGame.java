package pack1;


public class FroggerGame {

    public static final int PLAYING = 0, DEAD = 1, PLAYER_WINS = 2, MAX_LIFE_TIME = 80;
    boolean reachedMiddle;
    Frog player;
    LogLane[] logLanes;
    CarLane[] carLanes;
    TurtleLane[] turtleLanes;
    LilyPad[] lilyPadses; //I'm leaving it like that. It's required. #smeagle
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

    void playerDeath() {
        status=DEAD;
        lives--;

        /*Updates the lives, player position and status
        anytime the player dies
        */
    }

    /**
     * Checks to see if a car killed the player.
     */
    void carCheck() { //todo check >prime focus
        for (int i = 0; i < carLanes.length; i++) {
            for (int j = 0; j < carLanes[i].getFroggerItems().size(); j++) {
                if (carLanes[i].getFroggerItems().get(j).getRect().intersects(player.getRect())) {
                    playerDeath();
                }
            }
        }
    }

    void logCheck() {
        //todo moves player if on log with log, otherwise kills
    }

    void turtleCheck() {
        //todo moves player with non-down turtle, otherwise kills
    }

    void lilyCheck() {
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

    void runChecks() {
        //todo calls correct check methods based on y pos
        //for now, just call carchecks
        carCheck();
    }


}
