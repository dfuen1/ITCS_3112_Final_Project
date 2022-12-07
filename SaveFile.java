import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveFile{

    public SaveFile(){
        
    }

    //method for loading file data into a UserWardrobe object
    public UserWardrobe loadUserData(String filename) throws FileNotFoundException{

        File file = new File("SaveFiles/" + filename + "/");
        
        
        UserWardrobe user = new UserWardrobe("Daniel");
        Scanner scan = new Scanner(file);

        //while there are lines for the scanner to skip in the file
        

        while(scan.hasNextLine()){

            //get the current line
            String line = scan.nextLine();

            //split the parts of the string into indexes of a string array
            String[] objectData = line.split("\\|");

            //(String name, String description, int quantity, String size, String brand, String color, Categories category, Types type, int id)
            //create a Clothing object and add set all its appropiate values, then add to wardrobe

            String name = objectData[0];
            String description = objectData[1];
            int quantity = Integer.parseInt(objectData[2]);
            String size = objectData[3];
            String brand = objectData[4]; 
            String color = objectData[5];
            //String[] cat = objectData[6].split("\\.");
            Categories category = Categories.valueOf(objectData[6]);
            //String[] typ = objectData[7].split("\\.");
            Types type = Types.valueOf(objectData[7]);
            Clothing savedPiece = new Clothing(name, description, quantity, size, brand, color, category, type);

            user.addClothingItem(savedPiece);


        }

        return user;
    }

    public void writeUserData(String data, String filename ){
        String file = "SaveFiles/" + filename + "/";
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(data + "\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
    
}