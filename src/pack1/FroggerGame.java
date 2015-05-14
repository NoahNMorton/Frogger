package pack1;


public class FroggerGame {

    public static final int PLAYING = 0, DEAD = 1, PLAYER_WINS = 2, MAX_LIFE_TIME = 80;

    int status, lives, startLifeTime;
    boolean reachedMiddle;
    Frog player;
    //LogLane[] logLanes;
    //CarLane[] carLanes;
    //LilyPad[] lilyPadses; //I'm leaving it like that. It's required. #smeagle

    public FroggerGame() {
        status = FroggerGame.PLAYING;
        reachedMiddle = false;
        lives = 3;

        /*
        todo Sets the lifeTimer
        todo Puts the frog in the starting grass
        todo Creates all the lanes
        */

    }

    void update() {
        //todo moves cars logs turtles, calls runChecks >help
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
        //return logLanes;
        return null;
    }

    public CarLane[] getCarLanes() {
        //return carLanes;
        return null;
    }

    public LilyPad[] getLilyPadses() {
        //return lilyPadses;
        return null;
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
