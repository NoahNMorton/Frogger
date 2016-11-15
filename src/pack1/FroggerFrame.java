package pack1;

import javax.swing.*;
import java.awt.*;

/**
 * @author othscs120
 *         Created on: 11/4/2014 , Time is :  1:28 PM
 *         Part of Project: Frogger
 */

@SuppressWarnings("WeakerAccess")
public class FroggerFrame extends JFrame {

    public FroggerFrame() {

        super("Frogger");

        // Sets the close button to exit the program
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // makes the window not able to be re-sized
        setResizable(false);
        // creates the window
        pack();
        // creates the panel
        FroggerPanel p = new FroggerPanel();
        // gets the frames insets
        Insets frameInsets = getInsets();
        // calculates panel size
        int frameWidth = p.getWidth()
                + (frameInsets.left + frameInsets.right);
        int frameHeight = p.getHeight()
                + (frameInsets.top + frameInsets.bottom);
        // sets the frame's size
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        // turns off the layout options
        setLayout(null);
        // adds the panel to the frame
        add(p);
        // adjusts the window to meet its new preferred size
        pack();
        // shows the frame
        setVisible(true);


        Logger.logOtherMessage("Window", "Window Created.");
    }


}