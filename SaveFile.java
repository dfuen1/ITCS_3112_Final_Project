import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class SaveFile{

    private String name;
    private File saveFile;

    public SaveFile(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setFile(File saveFile){
        this.saveFile = saveFile;
    }

    public File getFile(){
        return this.saveFile;
    }


    //load clothing objects from saveFile into the user's wardrobe
    //when there is a savefile to load from
    //what i referenced for this method: https://www.youtube.com/watch?v=klCmA2Eeu70&t=403s
    public UserWardrobe loadUserData(){

        Scanner scan = null;

        try{
            scan = new Scanner(saveFile);
        }
        catch(Exception e){
            System.out.println("Something went wrong");
            return null;
        }
    
    
        //while there are lines for the scanner to skip in the file
        UserWardrobe newUser = new UserWardrobe(this.name);
            
    
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
        
                newUser.addClothingItem(savedPiece);
        
        
                }

            scan.close();
            return newUser;
    
        }

        //overwrite what's currently on the save file with new info
        //this is used for updating the save file when an object is deleted or edited
        public void overwriteUserData(UserWardrobe wardrobe){

            ArrayList<Clothing> updatedWardrobe = wardrobe.getWardrobe();

            FileWriter writer = null;

            try{
                writer = new FileWriter(saveFile);
            }
            catch(Exception e){
                System.out.println("Something went wrong");
                e.getStackTrace();
            }
             
            for(Clothing c : updatedWardrobe){
                String name = c.getName();
                String description = c.getDescription();
                int quantity = c.getQuantitiy();
                String size = c.getSize();
                String brand = c.getBrand();
                String color = c.getColor();
                String category = c.getCategories().toString();
                String type = c.getType().toString();


                String saveItem = name + "|" + description + "|" + quantity + "|" + size + "|" + brand +
                "|" + color + "|" + category + "|" + type;

                try{
                    writer.write(saveItem + "\n");
                }
                catch (Exception e){
                    System.out.println("Data cannot be written to save file");
                    e.printStackTrace();
                }
                
                

            }

            try{
                writer.close();
            }
            catch (Exception e1){
                e1.printStackTrace();
            }





        }


    public void writeUserData(String data){
        try {
            FileWriter writer = new FileWriter(saveFile, true);
            writer.write(data + "\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name;
    }


    
}