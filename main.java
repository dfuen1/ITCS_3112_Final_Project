
public class main{
    public static void main (String[] args){

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

        //this is the launching point of the app
        UserSelect start = new UserSelect();


        

        


    } 
}

