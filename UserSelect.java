import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserSelect implements ActionListener, ListSelectionListener{
    private JFrame frame;
    private Button addButton;
    private Button accessButton;
    private Button deleteButton;
    private JList<Object> userSelect;
    private JScrollPane scrollableUserSelect;
    private File[] saveFiles;
    //private ArrayList<SaveFile> userSaveFiles;


    public UserSelect(){
        initialization();
    }


    public void initialization(){
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


    //general positioning of panels
    JPanel middleArea = new JPanel();
    middleArea.setBackground(new Color(173, 173, 173));
    JPanel menuPanel = new JPanel();
    menuPanel.setPreferredSize(new Dimension(300, 90));
    menuPanel.setBackground(new Color(50, 90, 156));
    middleArea.setLayout(new BoxLayout(middleArea, BoxLayout.X_AXIS));
    middleArea.add(Box.createHorizontalGlue());
    middleArea.add(menuPanel);
    middleArea.add(Box.createHorizontalGlue());

    //Add content to menuPanel
    //menu title section
    menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
    JPanel menuTitlePanel = new JPanel();
    menuTitlePanel.setBackground(new Color(50, 90, 156));
    JLabel menuTitle = new JLabel("Welcome");
    menuTitlePanel.add(menuTitle);
    menuTitlePanel.setPreferredSize(new Dimension(300, 20));
    menuTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    menuTitle.setForeground(Color.WHITE);


    //user select section
    JPanel userSelectPanel = new JPanel();
    userSelectPanel.setPreferredSize(new Dimension(300, 150));
    userSelectPanel.setLayout(null);
    userSelectPanel.setBackground(new Color(50, 90, 156));
    userSelect = new JList<>();
    userSelect.addListSelectionListener(this);
    scrollableUserSelect = new JScrollPane(userSelect);
    scrollableUserSelect.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollableUserSelect.setBounds(10, 20, 510, 200);
    //get the files in the SaveFiles folder and load them to JList 
    //find a way to only print out the name of the JList
    //File saveFileFolder = new File("/Users/dfuen01/VSCFolder/ITCS_3112_Final_Project/SaveFiles");
    File saveFileFolder = new File("SaveFiles");
    //userSaveFiles = new ArrayList<>();
    //list all the text files currently in the SaveFiles folder
    saveFiles = saveFileFolder.listFiles();
    //put the text files into SaveFile objects and put them into the JList 
    ArrayList<SaveFile> saveFileObjects = fileToSaveFiles(saveFiles);
    userSelect.setListData(saveFileObjects.toArray());
    userSelectPanel.add(scrollableUserSelect);

    //buttons
    JPanel buttonsPanel = new JPanel();
    addButton = new Button("Add New Wardrobe");
    accessButton = new Button("Access Wardrobe");
    deleteButton = new Button("Delete Wardrobe");

    //initially these buttons will be disabled until a value is selected from JList
    accessButton.setEnabled(false);
    deleteButton.setEnabled(false);

    buttonsPanel.add(addButton);
    buttonsPanel.add(accessButton);
    buttonsPanel.add(deleteButton);
    addButton.addActionListener(this);
    accessButton.addActionListener(this);
    deleteButton.addActionListener(this);
    buttonsPanel.setBackground(new Color(50, 90, 156));

    //structure of the menu panel
    menuPanel.add(menuTitlePanel);
    //menuPanel.add(Box.createVerticalGlue());
    menuPanel.add(userSelectPanel);
    menuPanel.add(Box.createVerticalGlue());
    menuPanel.add(buttonsPanel);









    //middleArea.setAlignmentX(CENTER_ALIGNMENT);
    JPanel top = new JPanel();
    top.setBackground(new Color(173, 173, 173));
    JPanel bottom = new JPanel();
    bottom.setBackground(new Color(173, 173, 173));
    frame.add(top, BorderLayout.NORTH);
    frame.add(bottom, BorderLayout.SOUTH);
    frame.add(middleArea);
    






    frame.setVisible(true);
    }


    //create folder objects here and check for exceptions in this window
    //the file can be set to a UserWardrobe object and be accessed for changes
    //to the save file later 
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if(e.getSource() == addButton){
            String userName = JOptionPane.showInputDialog("Please enter your name");
            
            //first check the user has actually put something in the option pane
            if(userName != null){

                userName = userName.replaceAll("\\s", "");

                boolean fileCheck = doesFileNameExist(userName);
                //check that the user didn't just put spaces and that the name
                //doesn't match an existing user
                if(!userName.isEmpty() && !fileCheck){
                    File file = new File("SaveFiles/" + userName + "Wardrobe.txt");
                            try {
                                file.createNewFile();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            System.out.println("New File Successfully added");
                            frame.setVisible(false);
                            frame.dispose();
                            UserSelect reload = new UserSelect();
                            System.out.println("reached");
                }
                else{
    
                    JOptionPane.showMessageDialog(frame, "File may already exist or something else went wrong");
                }

            }
            



        }

        if(e.getSource() == accessButton){

                SaveFile selectedUser = (SaveFile) userSelect.getSelectedValue();
                //some.setFile(selectedFile);
                UserWardrobe selectedUserWardrobe = selectedUser.loadUserData();
                //since the username is loaded in SaveFile's loadUserData method
                //there is no need to load it in here

    
                //"refreshes the page" but disposing the old and create a new JFrame
                FrontPage start = new FrontPage(selectedUserWardrobe, selectedUser);
                frame.setVisible(false);
                frame.dispose();
 
            
        }

        if(e.getSource() == deleteButton){

            int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this file?");

            //see if the user chose the yes option
            if(response == JOptionPane.YES_OPTION){
                SaveFile selectedFile = (SaveFile) userSelect.getSelectedValue();

                File fileToDelete = selectedFile.getFile();

                fileToDelete.delete();
                System.out.println("Item deleted");
                
                UserSelect reload = new UserSelect();
                frame.setVisible(false);
                frame.dispose();
            }

            //otherwise nothing will happen

        }
        
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {

        if(!e.getValueIsAdjusting()){
            accessButton.setEnabled(true);
            deleteButton.setEnabled(true);
        }
        
    }

    public Boolean doesFileNameExist(String name){
        String newFileName = name + "Wardrobe.txt";
        boolean doesFileExist = false;

        for(File f : saveFiles){
            if(f.getName().equals(newFileName)){
                doesFileExist = true;
                break;
            }
        }
  

        return doesFileExist;
    }


    // @Override 
    // public Component getListCellRendererComponent(JList <File>l list, File file, int index, boolean isSelected,
    //         boolean cellHasFocus) {
    //     // TODO Auto-generated method stub

        
    //     return this;
    // }

    public ArrayList<SaveFile> fileToSaveFiles(File [] files){

        ArrayList<SaveFile> saveFileObjects = new ArrayList<>();

        for(File f : files){
            String filename = f.getName();

            String[] ownerOfSavedFile = filename.split("Wardrobe.txt");

            //this should get the name of the user attached to the name of the file
            SaveFile savedFile = new SaveFile(ownerOfSavedFile[0]);
            savedFile.setFile(f);
            saveFileObjects.add(savedFile);
        }


        return saveFileObjects;

    }



}
