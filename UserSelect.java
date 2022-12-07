import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class UserSelect {
private JFrame frame;

    public void initialize(){


        //initialization
        frame = new JFrame();
       //width and height
       frame.setSize(1000, 600);
       frame.getContentPane().setBackground(new Color(173, 173, 173));
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Wardrobe Tracker");
       frame.setResizable(false);
       //this makes it so that the window opens in the middle
       frame.setLocationRelativeTo(null);
    }
    
}
