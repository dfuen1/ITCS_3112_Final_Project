import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main{
    public static void main (String[] args) throws Exception{

        //DUMMY INFO
        //Parameters of Clothing class
        //(String name, String description, int quantity, String size, String brand, String color, Categories category, Types type, int id)
        Clothing cl1 = new Clothing("Nike Red Tee", "Red Nike Shirt", 1, "M", "Nike", "Red", Categories.TOP, Types.TSHIRT);
        Clothing cl2 = new Clothing("Nike Cortez", "White Nike Cortez shoes from 2014", 1, "8", "Nike", "White/Black", Categories.FOOTWEAR, Types.SNEAKERS);
        Clothing cl3 = new Clothing("Levi Blue Jeans", "Baby's Wearing Blue Jeans", 1, "30x32", "Levi's", "Medium Wash", Categories.BOTTOM, Types.JEANS);
        Clothing cl4 = new Clothing("Levi Black Jeans", "Baby's Wearing Black Jeans", 1, "30x32", "Levi's", "Black", Categories.BOTTOM, Types.JEANS);
        Clothing cl5 = new Clothing("Levi Red Jeans", "Baby's Wearing Red Jeans", 1, "30x32", "Levi's", "Red", Categories.BOTTOM, Types.JEANS);
        Clothing cl6 = new Clothing("Birkenstock Sandals", "Jesus Sandals", 1, "8", "Birkenstock", "Brown", Categories.FOOTWEAR, Types.SANDALS);
        Clothing cl7 = new Clothing("Hanes Black Boxers", "Boxers", 3, "M", "Hanes", "Black", Categories.UNDERGARMENTS, Types.UNDERWEAR);
        Clothing cl8 = new Clothing("Hanes Gray Boxers", "Boxers", 4, "M", "Hanes", "Gray", Categories.UNDERGARMENTS, Types.UNDERWEAR);
        Clothing cl9 = new Clothing("Blue Overalls", "Overall Enthusiasm, Overall Enthusiasm", 1, "M", "Lee's", "Blue", Categories.ONE_PIECE, Types.OVERALLS);
        Clothing cl10 = new Clothing("Black Bomber Jacket", "Slightly distressed, from the 90s", 1, "M", "Capital Sun", "Black", Categories.OUTERWEAR, Types.JACKET);
        Clothing cl11 = new Clothing("Red Sweater", "My dad's old sweater", 1, "L", "Jazzerman", "Maroon", Categories.OUTERWEAR, Types.SWEATER);
        Clothing cl12 = new Clothing("Momma Chain", "My mom's old chain", 1, "L", "N/A", "Gold", Categories.ACCESSORIES, Types.OTHER);
        
        


        UserWardrobe mainUser = new UserWardrobe("Daniel");
        mainUser.addClothingItem(cl1);
        mainUser.addClothingItem(cl2);
        mainUser.addClothingItem(cl3);
        mainUser.addClothingItem(cl4);
        mainUser.addClothingItem(cl5);
        mainUser.addClothingItem(cl6);
        mainUser.addClothingItem(cl7);
        mainUser.addClothingItem(cl8);
        mainUser.addClothingItem(cl9);
        mainUser.addClothingItem(cl10);
        mainUser.addClothingItem(cl11);
        mainUser.addClothingItem(cl12);

        //UserWardrobe mainUser = new SaveFile().loadUserData("DanielWardrobe.txt");


        //this is the launching point of the app
        FrontPage starter = new FrontPage(mainUser);
        //AddClothingItemPage test = new AddClothingItemPage(mainUser);


        

        


    } 

    //how to read objects from a text file: https://www.youtube.com/watch?v=klCmA2Eeu70

    // public static UserWardrobe loadUserData(String filename) throws FileNotFoundException{

    //     File file = new File("SaveFiles/" + filename + "/");
        
        
    //     UserWardrobe user = new UserWardrobe("Daniel");
    //     Scanner scan = new Scanner(file);

    //     //while there are lines for the scanner to skip in the file
        

    //     while(scan.hasNextLine()){

    //         //get the current line
    //         String line = scan.nextLine();

    //         //split the parts of the string into indexes of a string array
    //         String[] objectData = line.split("\\|");

    //         //(String name, String description, int quantity, String size, String brand, String color, Categories category, Types type, int id)
    //         //create a Clothing object and add set all its appropiate values, then add to wardrobe

    //         String name = objectData[0];
    //         String description = objectData[1];
    //         int quantity = Integer.parseInt(objectData[2]);
    //         String size = objectData[3];
    //         String brand = objectData[4]; 
    //         String color = objectData[5];
    //         String[] cat = objectData[6].split("\\.");
    //         Categories category = Categories.valueOf(cat[1]);
    //         String[] typ = objectData[7].split("\\.");
    //         Types type = Types.valueOf(typ[1]);
    //         Clothing savedPiece = new Clothing(name, description, quantity, size, brand, color, category, type);

    //         user.addClothingItem(savedPiece);


    //     }

    //     return user;
    // }
}

