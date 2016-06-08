import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class runner
{
    public static void main(String args[])
    {
        nbaGui gui = new nbaGui();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);
        gui.setTitle("NBA Predictor");
    }
}