import java.io.Writer;
import java.util.*;

import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import java.awt.*;


public class mainPage extends JFrame{
    public static void main (String[] args) {

    //    JFrame frame = new JFrame();
    //    JPanel panel = new JPanel(); 

    //    frame.setSize(400, 400);
    //    //panel.setBorder(BorderFactory.createEmptyBorder(100,300,300,300));
    //    //panel.setLayout(new GridLayout(0,1));
    //    //frame.add(panel, BorderLayout.CENTER);
    //    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //    frame.setTitle("Test");
    //    frame.setResizable(false);
    //    //frame.pack();
    //    frame.setVisible(true);
    //    //just using setBackground will not work for setting color
    //    frame.getContentPane().setBackground(new Color(173,173,173));

        //Parameters of Clothing class
        //(String name, String description, int quantity, String size, String brand, String color, Categories category, Types type, int id)
        Clothing cl1 = new Clothing("Nike Red Tee", "Red Nike Shirt", 1, "M", "Nike", "Red", Categories.TOP, Types.TSHIRT, 001);
        System.out.println(cl1.toString());



    } 
}

