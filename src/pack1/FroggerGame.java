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
    private int status, lives, startLifeTime, difficulty;

    public FroggerGame(int difficulty) {
        status = FroggerGame.PLAYING;
        reachedMiddle = false;
        lives = 3;
        this.difficulty = difficulty;
        if (difficulty == 0) difficulty = 1; //so stuff still moves in god mode.
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

        carLanes[0] = new CarLane(difficulty * 2, Lane.RIGHT, 300); //speed is based on the difficulty.
        carLanes[1] = new CarLane(difficulty * 2, Lane.LEFT, 340);
        carLanes[2] = new CarLane(difficulty, Lane.RIGHT, 380);
        carLanes[3] = new CarLane(difficulty * 2, Lane.LEFT, 420);
        carLanes[4] = new CarLane(difficulty * 2, Lane.RIGHT, 460);
        Logger.logOtherMessage("Lanes", "Setup car lanes.");

        logLanes[0] = new LogLane(difficulty, Lane.RIGHT, 70);
        logLanes[1] = new LogLane(difficulty, Lane.RIGHT, 140);
        logLanes[2] = new LogLane(difficulty, Lane.LEFT, 180);
        Logger.logOtherMessage("Lanes", "Setup log lanes.");

        //turtle lanes ---------------------
        turtleLanes[0] = new TurtleLane(difficulty * 1.3, Lane.LEFT, 100);
        turtleLanes[1] = new TurtleLane(difficulty * 1.3, Lane.RIGHT, 220);
        Logger.logOtherMessage("Lanes", "Setup turtle lanes.");


        //todo Sets the lifeTimer


        for (int t = 0; t < 1000; t++) //calls update on all lanes before loading game
            update();
    }

    void update() {
        for (CarLane carLane : carLanes) carLane.update();
        for (LogLane logLane : logLanes) logLane.update();
        for (TurtleLane turtleLane : turtleLanes) turtleLane.update();
        //move the frog when he's on a moving platform
        if (player.getY() == 60 || player.getY() == 140) //if on a right bound lane
            player.setX(player.getX() + difficulty); //move frog same speed as log.
        else if (player.getY() == 180) //if on a left bound log lane
            player.setX(player.getX() - difficulty); //move frog same speed as log.

        if (player.getY() == 100)  //left bound turtle lane
            player.setX(player.getX() - (difficulty * 1.3));
        else if (player.getY() == 220)
            player.setX(player.getX() + (difficulty * 1.3));

        //keep the player on screen at all times
        if (player.getX() < 0)
            player.setX(0);
        if (player.getX() > 660)
            player.setX(660);

        //win the game if all lilypads are filled
        if (lilyPadses[0].isFrog() && lilyPadses[1].isFrog() && lilyPadses[2].isFrog() && lilyPadses[3].isFrog())
            status = PLAYER_WINS;

        if(player.getY()==260)
            reachedMiddle=true;

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
        if (reachedMiddle)
            player = new Frog(320, 260); //set player back to middle
        else
            player = new Frog(320, 500); //set player back at spawn point
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
        boolean dead = true;
        for (LogLane logLane : logLanes) {
            ArrayList<FroggerItem> fIOfLogLane = logLane.getFroggerItems();
            for (FroggerItem aFIOfLogLane : fIOfLogLane) {
                if (aFIOfLogLane.getRect().intersects(player.getRect())) { //if they do intersect, aka on the log
                    dead = false;
                }
            }
        }
        if (dead) playerDeath(); //if still marked for death, kill the frog.
    }

    private void turtleCheck() {
        boolean dead = true;
        for (TurtleLane turtleLane : turtleLanes) {
            ArrayList<FroggerItem> fIOfTurtleLane = turtleLane.getFroggerItems();
            for (FroggerItem aFIOfTurtleLane : fIOfTurtleLane) {
                if (aFIOfTurtleLane.getRect().intersects(player.getRect())) { //if they do intersect, aka on the log
                    dead = false;
                }
            }
        }
        if (dead) playerDeath(); //if still marked for death, kill the frog.
    }

    public boolean lilyCheck() {
        double playerX = player.getX();
        if (playerX >= 60 && playerX <= 130) {
            lilyPadses[0].setFrog(true);
            return true;
        } else if (playerX >= 240 && playerX <= 310) {
            lilyPadses[1].setFrog(true);
            return true;
        } else if (playerX >= 420 && playerX <= 490) {
            lilyPadses[2].setFrog(true);
            return true;
        } else if (playerX >= 600 && playerX <= 670) {
            lilyPadses[3].setFrog(true);
            return true;
        } else
            return false;
    }

    public boolean isReachedMiddle() {
        return reachedMiddle;
    }

    public void setReachedMiddle(boolean reachedMiddle) {
        this.reachedMiddle = reachedMiddle;
    }

    private void runChecks() {
        if (difficulty == 0) { //don't do checks if in god mode.
            return;
        }
        double y = player.getY();
        if (y <= 460 && y >= 300) { //in car lanes
            carCheck();
        } else if (y == 220 || y == 100) { //in a turtle lane
            turtleCheck();
        } else if (y == 180 || y == 140 || y == 60) { //in a log lane.
            logCheck();
        }

    }

}
