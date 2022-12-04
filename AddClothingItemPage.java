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
    private Button backButton;
    private JTextField nameField;
    private JTextField descriptionField;
    private JTextField quantityField;
    private JTextField sizeField;
    private JTextField brandField;
    private JTextField colorField;
    private Button addClothingItemButton;
    private JSpinner quantityOfItem;

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
       frame.getContentPane().setBackground(new Color(173, 173, 173));
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
       titlePanel.setBounds(600, 0, 300, 50);
       
       

       //------------------NAME PANEL-----------------------
       JPanel namePanel = new JPanel();
       namePanel.setBackground(new Color(173,173,173));
       JLabel nameLabel = new JLabel("Name:");
       nameField = new JTextField(30);
       //nameField.setText("d");
       namePanel.add(nameLabel);
       namePanel.add(nameField);

       //------------------DESCRIPTION PANEL-----------------------
       JPanel descriptionPanel = new JPanel();
       descriptionPanel.setBackground(new Color(173,173,173));
       JLabel descriptionLabel = new JLabel("Description:");
       descriptionField = new JTextField(30);
       descriptionPanel.add(descriptionLabel);
       descriptionPanel.add(descriptionField);

       //------------------QUANTITY PANEL-----------------------
       JPanel quantityPanel = new JPanel();
       //quantityPanel.setLayout(BorderLayout.CENTER);
       quantityPanel.setBackground(new Color(173,173,173));
       JLabel quantityLabel = new JLabel("Quantity:");
       //quantityField = new JTextField(30);
       //quantityField.setText(" ");
       //i don't think someone will have more than 100,000 of the same piece of clothing in their closet
       quantityOfItem = new JSpinner(new SpinnerNumberModel(1, 1, 100000, 1));
       quantityOfItem.setPreferredSize(new Dimension(100, 30));
       quantityPanel.add(quantityLabel);
       quantityPanel.add(quantityOfItem);
       //quantityPanel.add(quantityField);

       //------------------SIZE PANEL-----------------------
       JPanel sizePanel = new JPanel();
       sizePanel.setBackground(new Color(173,173,173));
       JLabel sizeLabel = new JLabel("Size:");
       sizeField = new JTextField(30);
       sizePanel.add(sizeLabel);
       sizePanel.add(sizeField);


       //------------------BRAND PANEL-----------------------
       JPanel brandPanel = new JPanel();
       brandPanel.setBackground(new Color(173,173,173));
       JLabel brandLabel = new JLabel("Brand:");
       brandField = new JTextField(30);
       brandPanel.add(brandLabel);
       brandPanel.add(brandField);


       //------------------COLOR PANEL-----------------------
       JPanel colorPanel = new JPanel();
       colorPanel.setBackground(new Color(173,173,173));
       JLabel colorLabel = new JLabel("Color:");
       colorField = new JTextField(30);
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
        addClothingItemButton = new Button("Add Item");
        addClothingItemButton.addActionListener(this);
        addButtonPanel.add(addClothingItemButton);



       Box form = Box.createVerticalBox();
       //form.setSize(300, 572);
       //JPanel form = new JPanel();
       //form.setLayout(new FlowLayout(FlowLayout.CENTER));
       JPanel leftMargin = new JPanel();
       leftMargin.setBackground(new Color(173, 173, 173));
       JPanel rightMargin = new JPanel();
       rightMargin.setBackground(new Color(173, 173, 173));
       JPanel topMargin = new JPanel();
       topMargin.setBackground(new Color(50, 90, 156));
       topMargin.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 6));
       //topMargin.setSize(600, 300);
       backButton = new Button("Back");
       //give button a listener
       backButton.addActionListener(this);
       
       topMargin.add(backButton);

       //panels are added
       //approximate dimensions of the form area:
       //x: 980,  y:572
       form.add(topMargin); 
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

       //THE PIXEL
    //    JPanel measure = new JPanel();
    //    measure.setBackground(Color.BLACK);
    //    measure.setBounds(0, 0, 980, 572);
    //    form.add(measure);

        frame.add(form);
       //frame.add(topMargin, BorderLayout.NORTH);
       //frame.add(leftMargin, BorderLayout.WEST);
       //frame.add(rightMargin, BorderLayout.EAST);

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

        if(selectedString == null){

            typeChoices.removeAllItems();
        }

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

        if(e.getSource() == addClothingItemButton){

            String message = "The following fields are empty: \n";
            int emptyFields = 0;
           
            if(nameField.getText().isBlank()){
                message = message + "Name\n";
                emptyFields++;
            }
            if(descriptionField.getText().isBlank()){
                message = message + "Description\n";
                emptyFields++;
            }
            if(sizeField.getText().isBlank()){
                message = message + "Size\n";
                emptyFields++;
            }
            if(brandField.getText().isBlank()){
                message = message + "Brand\n";
                emptyFields++;
            }
            if(colorField.getText().isBlank()){
                message = message + "Color\n";
                emptyFields++;
            }
            if(categoryChoices.getSelectedItem() == null){
                message = message + "Category\n";
                emptyFields++;
            }
            if(typeChoices.getSelectedItem() == null){
                message = message + "Type\n";
                emptyFields++;
            }

            if(emptyFields > 0){
                JOptionPane.showMessageDialog(frame, message);
            }
            else{
                
                String name = nameField.getText();
                String description = descriptionField.getText();
                int quantity = (Integer)quantityOfItem.getValue();
                String size = sizeField.getText();
                String brand = brandField.getText(); 
                String color = colorField.getText();
                Categories category = categoryChoices.getItemAt(categoryChoices.getSelectedIndex());
                Types type = typeChoices.getItemAt(typeChoices.getSelectedIndex());
                Clothing newPiece = new Clothing(name, description, quantity, size, brand, color, category, type);
                user.addClothingItem(newPiece);
                FrontPage home = new FrontPage(user);
                frame.setVisible(false);
                frame.dispose();
                
            }

            
            
            
            

        }

        //takes user back to FrontPage
        if(e.getSource() == backButton){
            FrontPage home = new FrontPage(user);
            frame.setVisible(false);
            frame.dispose();
        }
    
        
    }

}

