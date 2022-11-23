import java.io.Writer;
import java.util.*;

import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import java.awt.*;


public class FrontPage extends JFrame{
  

public void initialize(){


       JFrame frame = new JFrame();
       JPanel navBar = new JPanel(); 
       JPanel mainArea = new JPanel();
       JPanel nameDisplay = new JPanel();
       JLabel displayUserName = new JLabel("Hello Daniel!");
       JTextField searchBar = new JTextField();

       //initialization
       //width and height
       frame.setSize(1000, 600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Test");
       frame.setResizable(false);
       //this makes it so that the window opens in the middle
       frame.setLocationRelativeTo(null);
       //frame.pack();

       //additions to the frame 
       Button navButton1 = new Button("Tops");
       Button navButton2 = new Button("Bottoms");
       Button navButton3 = new Button("Footwear");
       Button navButton4 = new Button("Outerwear");
       Button navButton5 = new Button("Accessories");
       Button navButton6 = new Button("Undergarments");
       Button navButton7 = new Button("One Piece");

       

       //this layouts the buttons within the nav
       navBar.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
       navBar.setBackground(Color.BLUE);
       navBar.setBounds(0,80, 600, 100);
       navBar.add(navButton1);
       navBar.add(navButton2);
       navBar.add(navButton3);
       navBar.add(navButton4);
       navBar.add(navButton5);
       navBar.add(navButton6);
       navBar.add(navButton7);


       //layout for search bar area 
       Box searchAndNav = Box.createVerticalBox();
       nameDisplay.setBackground(Color.ORANGE);
       nameDisplay.add(displayUserName);
       searchAndNav.add(nameDisplay);
       searchAndNav.add(navBar);


       //this final puts everything into the main frame
       mainArea.setBackground(Color.RED);
       frame.add(mainArea, BorderLayout.SOUTH);
       frame.add(searchAndNav, BorderLayout.NORTH);

       
       //frame.add(panel);

       //frame.add(button2);
       frame.setVisible(true);
       //just using setBackground will not work for setting color
       frame.getContentPane().setBackground(new Color(173,173,173));



        //DUMMY INFO
        //Parameters of Clothing class
        //(String name, String description, int quantity, String size, String brand, String color, Categories category, Types type, int id)
        Clothing cl1 = new Clothing("Nike Red Tee", "Red Nike Shirt", 1, "M", "Nike", "Red", Categories.TOP, Types.TSHIRT, 001);
        System.out.println(cl1.toString());

}

    
}

