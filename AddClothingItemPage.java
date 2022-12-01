import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AddClothingItemPage implements ActionListener{
    private UserWardrobe user;

    //Java Swing components
    private JFrame frame;
    private JComboBox <Categories> categoryChoices;
    private JComboBox <Types> typeChoices;

    //default constructor
    public AddClothingItemPage(){
        initialize();
    }

    public AddClothingItemPage(UserWardrobe user){
        this.user = user;
        initialize();
    }

    public void initialize(){


        //initialization
        frame = new JFrame();
       //width and height
       frame.setSize(1000, 600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Wardrobe Tracker");
       frame.setResizable(false);
       //this makes it so that the window opens in the middle
       frame.setLocationRelativeTo(null);

       //-----------TITLE-----------
       JPanel titlePanel = new JPanel();
       titlePanel.setBackground(new Color(173,173,173));
       JLabel titleLabel = new JLabel("Enter New Piece Info:");
       titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
       titlePanel.add(titleLabel);
       
       

       //------------------NAME PANEL-----------------------
       JPanel namePanel = new JPanel();
       namePanel.setBackground(new Color(173,173,173));
       JLabel nameLabel = new JLabel("Name:");
       JTextField nameField = new JTextField(30);
       namePanel.add(nameLabel);
       namePanel.add(nameField);

       //------------------DESCRIPTION PANEL-----------------------
       JPanel descriptionPanel = new JPanel();
       descriptionPanel.setBackground(Color.ORANGE);
       JLabel descriptionLabel = new JLabel("Description:");
       JTextField descriptionField = new JTextField(30);
       descriptionPanel.add(descriptionLabel);
       descriptionPanel.add(descriptionField);

       //------------------QUANTITY PANEL-----------------------
       JPanel quantityPanel = new JPanel();
       quantityPanel.setBackground(new Color(173,173,173));
       JLabel quantityLabel = new JLabel("Quantity:");
       JTextField quantityField = new JTextField(30);
       quantityPanel.add(quantityLabel);
       quantityPanel.add(quantityField);

       //------------------SIZE PANEL-----------------------
       JPanel sizePanel = new JPanel();
       sizePanel.setBackground(new Color(173,173,173));
       JLabel sizeLabel = new JLabel("Size:");
       JTextField sizeField = new JTextField(30);
       sizePanel.add(sizeLabel);
       sizePanel.add(sizeField);


       //------------------BRAND PANEL-----------------------
       JPanel brandPanel = new JPanel();
       brandPanel.setBackground(new Color(173,173,173));
       JLabel brandLabel = new JLabel("Brand:");
       JTextField brandField = new JTextField(30);
       brandPanel.add(brandLabel);
       brandPanel.add(brandField);


       //------------------COLOR PANEL-----------------------
       JPanel colorPanel = new JPanel();
       colorPanel.setBackground(new Color(173,173,173));
       JLabel colorLabel = new JLabel("Color:");
       JTextField colorField = new JTextField(30);
       colorPanel.add(colorLabel);
       colorPanel.add(colorField);


       //------------------CATEGORY PANEL-----------------------
       JPanel categoryPanel = new JPanel();
       categoryPanel.setBackground(new Color(173,173,173));
       JLabel categoryLabel = new JLabel("Category:");
       categoryChoices = new JComboBox<>(Categories.values());
       //find way to make the first item of the combo box ...
       categoryChoices.insertItemAt(null, 0);
       categoryChoices.setSelectedIndex(0);
       categoryChoices.addActionListener(this);
       categoryPanel.add(categoryLabel);
       categoryPanel.add(categoryChoices);


       //------------------TYPE PANEL-----------------------
       //Make it so that the combo box only shows types applicable to the category
       JPanel typePanel = new JPanel();
       typePanel.setBackground(new Color(173,173,173));
       JLabel typeLabel = new JLabel("Type:");
       typeChoices = new JComboBox<>();
       //typeChoices.addActionListener
       typePanel.add(typeLabel);
       typePanel.add(typeChoices);


        //Add button panel
        JPanel addButtonPanel = new JPanel();
        addButtonPanel.setBackground(new Color(173, 173, 173));
        Button addClothingItemButton = new Button("Add Item");
        addButtonPanel.add(addClothingItemButton);



       Box form = Box.createVerticalBox();
       JPanel leftMargin = new JPanel();
       leftMargin.setBackground(Color.RED);
       JPanel rightMargin = new JPanel();
       rightMargin.setBackground(Color.RED);
       JPanel topMargin = new JPanel();
       topMargin.setBackground(Color.RED);
       Button backButton = new Button("Back");
       topMargin.add(backButton, BorderLayout.WEST);

       //panels are added
       form.add(topMargin, BorderLayout.WEST); 
       form.add(titlePanel);
       form.add(namePanel);
       form.add(descriptionPanel);
       form.add(quantityPanel);
       form.add(sizePanel);
       form.add(brandPanel);
       form.add(colorPanel);
       form.add(categoryPanel);
       form.add(typePanel);
       form.add(addButtonPanel);

       frame.add(form, BorderLayout.CENTER);
       //frame.add(topMargin, BorderLayout.NORTH);
       frame.add(leftMargin, BorderLayout.WEST);
       frame.add(rightMargin, BorderLayout.EAST);

       frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        //functionality for the category combo box
        if(e.getSource() == categoryChoices){

        JComboBox selectedCategory = (JComboBox) e.getSource();
        Object categoryObject = selectedCategory.getSelectedItem();
        Categories selectedString = (Categories) categoryObject;
        System.out.println(e.getSource());

        if(selectedString == Categories.TOP){

            typeChoices.removeAllItems();

            Types[] availableTypes = {Types.TSHIRT, Types.TANK_TOP,
                 Types.LONG_SLEEVE_SHIRT, Types.SHORT_SLEEVE_SHIRT, Types.BLOUSE, Types.OTHER};

            for(Types available : availableTypes){
                typeChoices.addItem(available);
            }


        }
        else if(selectedString == Categories.BOTTOM){

            typeChoices.removeAllItems();

            Types[] availableTypes = {Types.PANTS, Types.JEANS, Types.SHORTS, Types.SKIRT, Types.OTHER};

           for(Types available : availableTypes){
               typeChoices.addItem(available);
           }

        }
        else if(selectedString == Categories.FOOTWEAR){
            typeChoices.removeAllItems();
            Types[] availableTypes = {Types.SNEAKERS, Types.DRESS_SHOES, Types.BOOTS,
                Types.HEELS, Types.SLIPPERS, Types.SANDALS, Types.OTHER};

            for(Types available : availableTypes){
                typeChoices.addItem(available);
            }

        }
        else if(selectedString == Categories.ACCESSORIES){
            typeChoices.removeAllItems();
            Types[] availableTypes = {Types.HATS, Types.SUNGLASSES, Types.BELTS, Types.GLOVES, Types.SCARVES, Types.OTHER};

            for(Types available : availableTypes){
                typeChoices.addItem(available);
            }
        }
        else if(selectedString == Categories.OUTERWEAR){
            typeChoices.removeAllItems();
            Types[] availableTypes = {Types.HOODIE, Types.JACKET, Types.SWEATSHIRT, Types.SWEATER, Types.COAT, Types.OTHER};

            for(Types available : availableTypes){
                typeChoices.addItem(available);
            }
        }
        else if(selectedString == Categories.ONE_PIECE){
            typeChoices.removeAllItems();
            Types[] availableTypes = {Types.DRESS, Types.COVERALLS, Types.OVERALLS, Types.JUMPSUIT, Types.OTHER};

            for(Types available : availableTypes){
                typeChoices.addItem(available);
            }

        }
        else if(selectedString == Categories.UNDERGARMENTS){
            typeChoices.removeAllItems();
            Types[] availableTypes = {Types.UNDERWEAR, Types.SOCKS, Types.BRA, Types.OTHER};

            for(Types available : availableTypes){
                typeChoices.addItem(available);

            }
        }   


        }
    
        
    }

}