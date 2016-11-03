package pack1;


public class FroggerGame {

    public static final int PLAYING = 0, DEAD = 1, PLAYER_WINS = 2, MAX_LIFE_TIME = 80;

    private int status, lives, startLifeTime;
    boolean reachedMiddle;
    Frog player;
    LogLane[] logLanes;
    CarLane[] carLanes;
    TurtleLane[] turtleLanes;
    LilyPad[] lilyPadses; //I'm leaving it like that. It's required. #smeagle

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
        logLanes = new LogLane[3]; //todo create all the log lanes in order up : turtle, log, log, turtle, log
        turtleLanes = new TurtleLane[2]; //todo create all turtle lanes

        carLanes[0] = new CarLane(6, Lane.RIGHT, 300);
        carLanes[1] = new CarLane(3, Lane.LEFT, 340);
        carLanes[2] = new CarLane(1, Lane.RIGHT, 380);
        carLanes[3] = new CarLane(6, Lane.LEFT, 420);
        carLanes[4] = new CarLane(3, Lane.RIGHT, 460);
        Logger.logOtherMessage("Lanes", "Setup car lanes.");

        logLanes[0] = new LogLane(2, Lane.RIGHT, 100);
        logLanes[1] = new LogLane(2, Lane.RIGHT, 140);
        logLanes[2] = new LogLane(2, Lane.LEFT, 180); //todo set y value correctly -test
        Logger.logOtherMessage("Lanes","Setup log lanes.");

        //turtle lanes ---------------------
        turtleLanes[0] = new TurtleLane(2, Lane.LEFT, 120);
        turtleLanes[1] = new TurtleLane(2, Lane.RIGHT, 220);
        Logger.logOtherMessage("Lanes","Setup turtle lanes.");

        /*
        todo Sets the lifeTimer
        todo Creates all the lanes
        */

        for (int t = 0; t < 1000; t++) //calls update on all lanes before loading game
            update();
    }

    void update() {
        //todo moves cars logs turtles, calls runChecks >help
        for (int u = 0; u < carLanes.length; u++)
            carLanes[u].update();
        for (int y = 0; y < logLanes.length; y++)
            logLanes[y].update();
        for (int k = 0; k < turtleLanes.length; k++)
            turtleLanes[k].update();

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
        /*Updates the lives, player position and status
        anytime the player dies
        */
    }

    void carCheck() {
        //todo kills player when contacting car
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
    }


}
