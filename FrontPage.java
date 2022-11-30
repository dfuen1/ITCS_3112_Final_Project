import java.io.Writer;
import java.util.*;

import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrontPage implements ActionListener, ListSelectionListener{
private UserWardrobe user;

//JavaSwing components initialization for access throughout different methods
private JFrame frame;
private JPanel nameDisplay;
private JLabel displayUserName;
private JTextField searchBar;
private JPanel searchBarArea;
private JPanel navBar;
private JPanel mainArea;
private JPanel itemListArea;
private JList<String> itemList;
private JScrollPane scrollableItemList;
private JPanel footerArea;
private Button allButton;
private Button topsButton;
private Button bottomsButton;
private Button footwearButton;
private Button outerwearButton;
private Button accessoriesButton;
private Button undergarmentsButton;
private Button onepieceButton;
private JEditorPane itemDescription;

//default constructor
public FrontPage(){
   initialize();
}

public FrontPage(UserWardrobe user){
    this.user = user;
    initialize();
  
}


  

public void initialize(){


    //components
       frame = new JFrame();
       nameDisplay = new JPanel();
       displayUserName = new JLabel("Hello " + user.getUsername() + "!");
       searchBar = new JTextField(50);
       searchBarArea = new JPanel();
       navBar = new JPanel(); 
       mainArea = new JPanel();
       itemListArea = new JPanel();
       //itemList will contain the data to be displayed
       //add itemList to scrollablItemList will make it scrollable
       itemList = new JList<>();
       scrollableItemList = new JScrollPane(itemList);
       scrollableItemList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       footerArea = new JPanel();


    //initialization
       //width and height
       frame.setSize(1000, 600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Wardrobe Tracker");
       frame.setResizable(false);
       //this makes it so that the window opens in the middle
       frame.setLocationRelativeTo(null);
       //frame.pack();

       //nav bar buttons 
       allButton = new Button("All");
       topsButton = new Button("Tops");
       bottomsButton = new Button("Bottoms");
       footwearButton = new Button("Footwear");
       outerwearButton = new Button("Outerwear");
       accessoriesButton = new Button("Accessories");
       undergarmentsButton = new Button("Undergarments");
       onepieceButton = new Button("One Piece");


       //this layouts the buttons within the nav
       navBar.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 5));
       navBar.setBackground(Color.BLUE);
       //navBar.setBounds(0,90, 600, 90);
       navBar.add(allButton);
       navBar.add(topsButton);
       navBar.add(bottomsButton);
       navBar.add(footwearButton);
       navBar.add(outerwearButton);
       navBar.add(accessoriesButton);
       navBar.add(undergarmentsButton);
       navBar.add(onepieceButton);

       //adding action listeners to the buttons
       allButton.addActionListener(this);
       topsButton.addActionListener(this);
       bottomsButton.addActionListener(this);
       footwearButton.addActionListener(this);
       outerwearButton.addActionListener(this);
       accessoriesButton.addActionListener(this);
       undergarmentsButton.addActionListener(this);
       onepieceButton.addActionListener(this);



       //----------------TOP AREA---------------------
       Box searchAndNav = Box.createVerticalBox();
       nameDisplay.setBackground(Color.ORANGE);
       Button searchBarButton = new Button("Search");
       //default layout of searchBarArea is FlowLayout\
       searchBarArea.add(searchBar);
       searchBarArea.add(searchBarButton);
       nameDisplay.add(displayUserName);
       searchAndNav.add(nameDisplay);
       searchAndNav.add(searchBarArea);
       searchAndNav.add(navBar);

       //----------------MAIN AREA---------------------
       //dimensions of main area: w: 999 or 1000, h: 458
       //since the app will always open with the inventory displayed
       mainArea.setLayout(null);
       mainArea.setBackground(Color.PINK);
       //mainArea.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 5));

       //----------------ITEM LIST AREA---------------------
       //scollableItemList will be the list displayed on the JFrame
       itemList.setListData(user.getWardrobeItemNames());
       scrollableItemList.setBounds(160, 80, 300, 300);
       //listen to changes in the itemList
       itemList.addListSelectionListener(this);


       //----------------ITEM DESCRIPTION AREA---------------------
       itemDescription = new JEditorPane();
       itemDescription.setBackground(Color.WHITE);
       itemDescription.setBounds(560, 80, 300, 300);
       
       //itemDescription.setLineWrap(true);
       //prevents the text area from being editable
       itemDescription.setEditable(false);
       //insets is an object that represents the margins of a container
       itemDescription.setMargin(new Insets(10, 10, 10, 10));
       mainArea.add(scrollableItemList);
       mainArea.add(itemDescription);
       
       




       //this final puts everything into the main frame
       footerArea.setBackground(Color.RED);
       frame.add(mainArea, BorderLayout.CENTER);
       frame.add(footerArea, BorderLayout.SOUTH);
       frame.add(searchAndNav, BorderLayout.NORTH);

       
       //frame.add(panel);

       //frame.add(button2);
       frame.setVisible(true);
       //just using setBackground will not work for setting color
       frame.getContentPane().setBackground(new Color(173,173,173));



}

//what will happen if FrontPage is notified an action has been performed
@Override
public void actionPerformed(ActionEvent e) {
    
    //if the ALL button is clicked, displays all items in wardrobe 
    if(e.getSource() == allButton){
        itemList.setListData(user.getWardrobeItemNames());
    }

    //if the TOPS button is clicked, displays items in TOP category
    if(e.getSource() == topsButton){
        String[] tops = user.getItemsByCategory(Categories.TOP);
        itemList.setListData(tops);
        
    }
    //if the BOTTOMS button is clicked, displays items in BOTTOM category
    if(e.getSource() == bottomsButton){
        String[] bottoms = user.getItemsByCategory(Categories.BOTTOM);
        itemList.setListData(bottoms);
        
    }

    //if the FOOTWEAR button is clicked, displays items in FOOTWEAR category
    if(e.getSource() == footwearButton){
        String[] footwear = user.getItemsByCategory(Categories.FOOTWEAR);
        itemList.setListData(footwear);
        
    }

    //if the OUTERWEAR button is clicked, displays items in OUTERWEAR category
    if(e.getSource() == outerwearButton){
        String[] outerwear = user.getItemsByCategory(Categories.OUTERWEAR);
        itemList.setListData(outerwear);
            
    }

    //if the ACCESSORIES button is clicked, displays items in ACCESSORIES category
    if(e.getSource() == accessoriesButton){
        String[] accessories = user.getItemsByCategory(Categories.ACCESSORIES);
        itemList.setListData(accessories);
            
    }

    //if the UNDERGARMENTS button is clicked, displays items in UNDERGARMENTS category
    if(e.getSource() == undergarmentsButton){
        String[] undergarments = user.getItemsByCategory(Categories.UNDERGARMENTS);
        itemList.setListData(undergarments);
            
    }

    //if the ONE_PIECE button is clicked, displays items in ONE PIECE category
    if(e.getSource() == onepieceButton){
        String[] onepiece = user.getItemsByCategory(Categories.ONE_PIECE);
        itemList.setListData(onepiece);
            
    }
}

@Override
public void valueChanged(ListSelectionEvent e) {

    //do something only until the value stops adjusting 
    if(!e.getValueIsAdjusting()){

        ArrayList <Clothing> wardrobe = user.getWardrobe();

       
        for(int i = 0; i < wardrobe.size(); i++){
            if(wardrobe.get(i).getName() == this.itemList.getSelectedValue()){
                itemDescription.setText(wardrobe.get(i).getName() + "\n"
                + "\n" + "Description: " + wardrobe.get(i).getDescription() + "\n"
                + "Quantity: " + wardrobe.get(i).getQuantitiy() + "\n"
                + "Size: " + wardrobe.get(i).getSize() + "\n"
                + "Brand: " + wardrobe.get(i).getBrand() + "\n"
                + "Color: " + wardrobe.get(i).getColor() + "\n"
                + "Category: " + wardrobe.get(i).getCategories() + "\n"
                + "Type: " + wardrobe.get(i).getType() + "\n"
                + "ID: " + wardrobe.get(i).getId());

                break;
            }
            
        }
        
    }
    
}




    
}

