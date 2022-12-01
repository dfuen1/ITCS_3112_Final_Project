import java.io.Writer;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;



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
private JPanel wardrobeButtonsArea;
private JList<Object> itemList;
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
private JLabel wardrobeButtonsLabel;
private Button addClothingItem;
private Button editClothingItem;
private Button deleteClothingItem;

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

       //try putting in the clothing objects themselves into the JList
       //then create a method for only displaying the object's name in the JList
       itemList.setListData(user.getWardrobe().toArray());
       //System.out.println(user.getWardrobe().toArray().getClass());
       scrollableItemList.setBounds(200, 80, 300, 300);
       //listen to changes in the itemList
       itemList.addListSelectionListener(this);


       //----------------ITEM DESCRIPTION AREA---------------------
       itemDescription = new JEditorPane();
       itemDescription.setBackground(Color.WHITE);
       itemDescription.setBounds(520, 80, 300, 300);
       
       //itemDescription.setLineWrap(true);
       //prevents the text area from being editable
       itemDescription.setEditable(false);
       //insets is an object that represents the margins of a container
       itemDescription.setMargin(new Insets(10, 10, 10, 10));

        //----------------WARDROBE EDIT AREA---------------------
        wardrobeButtonsArea = new JPanel();
        wardrobeButtonsArea.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 5));
        wardrobeButtonsArea.setBackground(Color.CYAN);
        wardrobeButtonsArea.setBounds(860, 140, 100, 140);
        wardrobeButtonsLabel = new JLabel("Wardrobe Options");
        wardrobeButtonsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        addClothingItem = new Button("Add");
        editClothingItem = new Button("Edit");
        editClothingItem.setEnabled(false);
        deleteClothingItem = new Button("Delete");
        deleteClothingItem.setEnabled(false);
        wardrobeButtonsArea.add(wardrobeButtonsLabel);
        wardrobeButtonsArea.add(addClothingItem);
        wardrobeButtonsArea.add(editClothingItem);
        wardrobeButtonsArea.add(deleteClothingItem);

        //giving buttons action listeners
        addClothingItem.addActionListener(this);
        editClothingItem.addActionListener(this);
        deleteClothingItem.addActionListener(this);


        //Add components to mainArea 
        mainArea.add(scrollableItemList);
        mainArea.add(itemDescription);
        mainArea.add(wardrobeButtonsArea);
       
       




       //this finally puts everything into the main frame
       footerArea.setBackground(Color.RED);
       frame.add(searchAndNav, BorderLayout.NORTH);
       frame.add(mainArea, BorderLayout.CENTER);
       frame.add(footerArea, BorderLayout.SOUTH);
       


       //make frame visible
       frame.setVisible(true);
       //just using setBackground will not work for setting color
       frame.getContentPane().setBackground(new Color(173,173,173));



}

//what will happen if FrontPage is notified an action has been performed
@Override
public void actionPerformed(ActionEvent e) {
    
    //if the ALL button is clicked, displays all items in wardrobe 
    if(e.getSource() == allButton){
        itemList.setListData(user.getWardrobe().toArray());
        editClothingItem.setEnabled(false);
        deleteClothingItem.setEnabled(false);
    }

    //if the TOPS button is clicked, displays items in TOP category
    if(e.getSource() == topsButton){
        Object[] tops = user.getItemsByCategory(Categories.TOP);
        //weird error coming from setting the list data?
        itemList.setListData(tops);
        editClothingItem.setEnabled(false);
        deleteClothingItem.setEnabled(false);
        
    }
    //if the BOTTOMS button is clicked, displays items in BOTTOM category
    if(e.getSource() == bottomsButton){
        Object[] bottoms = user.getItemsByCategory(Categories.BOTTOM);
        itemList.setListData(bottoms);
        editClothingItem.setEnabled(false);
        deleteClothingItem.setEnabled(false);
        
    }

    //if the FOOTWEAR button is clicked, displays items in FOOTWEAR category
    if(e.getSource() == footwearButton){
        Object[] footwear = user.getItemsByCategory(Categories.FOOTWEAR);
        itemList.setListData(footwear);
        editClothingItem.setEnabled(false);
        deleteClothingItem.setEnabled(false);
        
    }

    //if the OUTERWEAR button is clicked, displays items in OUTERWEAR category
    if(e.getSource() == outerwearButton){
        Object[] outerwear = user.getItemsByCategory(Categories.OUTERWEAR);
        itemList.setListData(outerwear);
        editClothingItem.setEnabled(false);
        deleteClothingItem.setEnabled(false);
            
    }

    //if the ACCESSORIES button is clicked, displays items in ACCESSORIES category
    if(e.getSource() == accessoriesButton){
        Object[] accessories = user.getItemsByCategory(Categories.ACCESSORIES);
        itemList.setListData(accessories);
        editClothingItem.setEnabled(false);
        deleteClothingItem.setEnabled(false);
            
    }

    //if the UNDERGARMENTS button is clicked, displays items in UNDERGARMENTS category
    if(e.getSource() == undergarmentsButton){
        Object[] undergarments = user.getItemsByCategory(Categories.UNDERGARMENTS);
        itemList.setListData(undergarments);
        editClothingItem.setEnabled(false);
        deleteClothingItem.setEnabled(false);
            
    }

    //if the ONE_PIECE button is clicked, displays items in ONE PIECE category
    if(e.getSource() == onepieceButton){
        Object[] onepiece = user.getItemsByCategory(Categories.ONE_PIECE);
        itemList.setListData(onepiece);
        editClothingItem.setEnabled(false);
        deleteClothingItem.setEnabled(false);
            
    }

    if(e.getSource() == addClothingItem){
        AddClothingItemPage add = new AddClothingItemPage(user);
        frame.setVisible(false);
        frame.dispose();
    }

    //delete clothing item button
    if(e.getSource() == deleteClothingItem){
        int input = JOptionPane.showConfirmDialog(frame,"Are you sure you want to delete?");  

        if(input == JOptionPane.YES_OPTION){

            //casts selected object to a clothing object and extracts ID value to delete
            Clothing selectedClothingPiece = (Clothing) itemList.getSelectedValue();
            user.removeClothingItem(selectedClothingPiece.getId());

            //"refreshes the page" but disposing the old and create a new JFrame
            FrontPage refresh = new FrontPage(user);
            frame.setVisible(false);
            frame.dispose();
        }

    }
}

@Override
public void valueChanged(ListSelectionEvent e) {

    //do something only until the value stops adjusting 
    if(!e.getValueIsAdjusting()){
        editClothingItem.setEnabled(true);
        deleteClothingItem.setEnabled(true);

        //cast selected value back to a Clothing object to use its getters and setters
        Clothing selectedClothingPiece = (Clothing) itemList.getSelectedValue();
        System.out.println(selectedClothingPiece.getId());

       
        //format and description in itemDescription JEditorPane

        itemDescription.setText(selectedClothingPiece.getName() + "\n"
                + "\n" + "Description: " + selectedClothingPiece.getDescription() + "\n"
                + "Quantity: " + selectedClothingPiece.getQuantitiy() + "\n"
                + "Size: " + selectedClothingPiece.getSize() + "\n"
                + "Brand: " + selectedClothingPiece.getBrand() + "\n"
                + "Color: " + selectedClothingPiece.getColor() + "\n"
                + "Category: " + selectedClothingPiece.getCategories() + "\n"
                + "Type: " + selectedClothingPiece.getType() + "\n"
                + "ID: " + selectedClothingPiece.getId());


        
    }
    
}




    
}

