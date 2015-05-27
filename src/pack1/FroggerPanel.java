package pack1;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class FroggerPanel extends JPanel implements KeyListener, Runnable {

    BufferedImage car1_Left, car1_Right, car2_Left, car2_Right, limo_Left, limo_Right, semi_Left, semi_Right, frogUp, frogDown,
            frogLeft, frogRight, hsTurtle, hmTurtle, hlTurtle, sTurtle, mTurtle, lTurtle, sLog, mLog, lLog, lilyPad, frogLife;
    FroggerGame game;
    //BufferedImage buffer;
    int updatesPerSecond;
    int framesPerSecond; //todo used?


    public FroggerPanel() {
        setSize(700, 640);

        Logger.logCodeMessage("Set size to " + getWidth() + "," + getHeight());
        reset();
        Thread pThread;

        try {
            pThread = new Thread(this);
            pThread.start();
            Logger.logCodeMessage("Successfully set up thread.");
        } catch (Exception e) {
            System.err.println("Error creating thread.");
            e.printStackTrace();
            Logger.logErrorMessage("Error creating thread. Stopping.");
            System.exit(-2);
        }

        try {
            car1_Left = ImageIO.read((new File("resource/Car1-Left.png")));
            car1_Right = ImageIO.read((new File("resource/Car1-Right.png")));
            car2_Left = ImageIO.read((new File("resource/Car2-Left.png")));
            car2_Right = ImageIO.read((new File("resource/Car2-Right.png")));
            limo_Left = ImageIO.read((new File("resource/Limo-Left.png")));
            limo_Right = ImageIO.read((new File("resource/Limo-Right.png")));
            semi_Left = ImageIO.read((new File("resource/Semi-Left.png")));
            semi_Right = ImageIO.read((new File("resource/Semi-Right.png")));
            frogUp = ImageIO.read((new File("resource/FrogUp.png")));
            frogDown = ImageIO.read((new File("resource/FrogDown.png")));
            frogLeft = ImageIO.read((new File("resource/FrogLeft.png")));
            frogRight = ImageIO.read((new File("resource/FrogRight.png")));
            hsTurtle = ImageIO.read((new File("resource/HS-Turtle.png")));
            hmTurtle = ImageIO.read((new File("resource/HM-Turtle.png")));
            hlTurtle = ImageIO.read((new File("resource/HL-Turtle.png")));
            sTurtle = ImageIO.read((new File("resource/S-Turtle.png")));
            mTurtle = ImageIO.read((new File("resource/M-Turtle.png")));
            lTurtle = ImageIO.read((new File("resource/L-Turtle.png")));
            sLog = ImageIO.read((new File("resource/S-Log.png")));
            mLog = ImageIO.read((new File("resource/M-Log.png")));
            lLog = ImageIO.read((new File("resource/L-Log.png")));
            lilyPad = ImageIO.read((new File("resource/lilyPad.png")));
            frogLife = ImageIO.read((new File("resource/FrogLife.png")));

            Logger.logOtherMessage("ImageLoader", "Succeeded.");
        } catch (Exception e) {
            System.err.println("Error Loading Images: " + e.getMessage());
            e.printStackTrace();
            Logger.logErrorMessage("Error with loading images. Exiting...");
            System.exit(-1); //if loading fails, end the program.
        }
        addKeyListener(this);

    }

    @Deprecated
    public void keyReleased(KeyEvent e) {
        //unused
    }

    @Deprecated
    public void keyPressed(KeyEvent e) {
        //unused

    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            update();
            repaint();
            try {
                Thread.sleep(35); //todo correct times per second?
            } catch (Exception e) {
                System.err.println("Error Sleeping.");
                Logger.logErrorMessage("Error Sleeping Thread.");
            }
        }
    }

    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
                if ((game.getPlayer().getY() - 40) > 30)
                    game.getPlayer().setY(game.getPlayer().getY() - 40);
                game.getPlayer().setDirection(Frog.UP);
                break;
            case 's':
                if ((game.getPlayer().getY() + 40) < getHeight() - 100)
                    game.getPlayer().setY(game.getPlayer().getY() + 40);
                game.getPlayer().setDirection(Frog.DOWN);
                break;
            case 'a':
                if ((game.getPlayer().getX() - 30) > 0)
                    game.getPlayer().setX(game.getPlayer().getX() - 40);
                game.getPlayer().setDirection(Frog.LEFT);
                break;
            case 'd':
                if ((game.getPlayer().getX() + 40) < getWidth() - 30)
                    game.getPlayer().setX(game.getPlayer().getX() + 40);
                game.getPlayer().setDirection(Frog.RIGHT);
                break;
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(0, 0, getWidth(), getHeight()); //fill the background
        g.setColor(Color.BLUE); //fill water on upper part of map
        g.fillRect(0, 65, getWidth(), 190);
        //small water inlets for lilypads----------
        g.fillRect(60, 20, 70, 50);
        g.fillRect(240, 20, 70, 50);
        g.fillRect(420, 20, 70, 50);
        g.fillRect(600, 20, 70, 50);
        //white lines of the road-------------------
        g.setColor(Color.white);
        g.drawLine(0, 300, getWidth(), 300);
        g.drawLine(0, 500, getWidth(), 500);
        //road--------------------------------------
        g.setColor(Color.GRAY);
        g.fillRect(0, 301, getWidth(), 199);
        //bottom black bar----------------------
        g.setColor(Color.BLACK);
        g.fillRect(0, getHeight() - 100, getWidth(), getHeight());
        //yellow lines on road----------------
        g.setColor(Color.yellow);
        for (int y = 341; y < 489; y += 39) {
            for (int x = 10; x < getWidth() - 10; x += 90) {
                g.fillRect(x, y, 60, 4);
            }
        }
        //lilypads------------------------------
        for (int i = 75; i <= 615; i += 179)
            g.drawImage(lilyPad, i, 30, null);

        //text----------------------------------
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));
        g.drawString("Livers:", 10, getHeight() - 15);
        g.drawString("Time Left:", 300, getHeight() - 15);

        //time left----------------
        int i = game.getTimeLeft();
        if (i >= 60) //change colour of bar based on time left
            g.setColor(Color.green);
        else if (i >= 40)
            g.setColor(Color.orange);
        else
            g.setColor(Color.RED);

        g.fillRect(500, getHeight() - 40, (i * 2) + 10, 20); //draw timer based on time left
        g.drawRect(500, getHeight() - 40, 170, 20); //timer outline

        //draw frog --------------------------
        switch (game.getPlayer().getDirection()) { //draw frog based on direction
            case Frog.UP:
                g.drawImage(frogUp, game.getPlayer().getX(), game.getPlayer().getY(), null);
                break;
            case Frog.DOWN:
                g.drawImage(frogDown, game.getPlayer().getX(), game.getPlayer().getY(), null);
                break;
            case Frog.LEFT:
                g.drawImage(frogLeft, game.getPlayer().getX(), game.getPlayer().getY(), null);
                break;
            case Frog.RIGHT:
                g.drawImage(frogRight, game.getPlayer().getX(), game.getPlayer().getY(), null);
                break;
        }
        //MOVING OBJECTS ---------------------------------------
        //cars ------------
        for (CarLane cl : game.getCarLanes()) //all car lanes
        {
            for (int p = 0; p < cl.laneItems.size(); p++) //each car in that lane
            {
                if (cl.laneItems.get(p).getDirection() == Lane.RIGHT && cl.laneItems.get(p).getType() == Car.CAR_1) {
                    g.drawImage(car1_Right, (int) cl.laneItems.get(p).getX(), (int) cl.laneItems.get(p).getY(), null);
                } else if (cl.laneItems.get(p).getDirection() == Lane.LEFT && cl.laneItems.get(p).getType() == Car.CAR_1) {
                    g.drawImage(car1_Left, (int) cl.laneItems.get(p).getX(), (int) cl.laneItems.get(p).getY(), null);
                } else if (cl.laneItems.get(p).getDirection() == Lane.RIGHT && cl.laneItems.get(p).getType() == Car.CAR_2) {
                    g.drawImage(car2_Right, (int) cl.laneItems.get(p).getX(), (int) cl.laneItems.get(p).getY(), null);
                } else if (cl.laneItems.get(p).getDirection() == Lane.LEFT && cl.laneItems.get(p).getType() == Car.CAR_2) {
                    g.drawImage(car1_Left, (int) cl.laneItems.get(p).getX(), (int) cl.laneItems.get(p).getY(), null);
                }
            }
        }
    }

    void update() {
        game.update();
    }
    public void addNotify() {
        super.addNotify();
        requestFocus();
        Logger.logCodeMessage("Requested focus on the window.");
    }

    void reset() {
        this.game = new FroggerGame();
    }


}
