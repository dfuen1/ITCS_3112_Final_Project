
public class main{
    public static void main (String[] args) {

        //DUMMY INFO
        //Parameters of Clothing class
        //(String name, String description, int quantity, String size, String brand, String color, Categories category, Types type, int id)
        Clothing cl1 = new Clothing("Nike Red Tee", "Red Nike Shirt", 1, "M", "Nike", "Red", Categories.TOP, Types.TSHIRT, 1);
        Clothing cl2 = new Clothing("Nike Cortez", "White Nike Cortez shoes from 2014", 1, "8", "Nike", "White/Black", Categories.FOOTWEAR, Types.SNEAKERS, 2);
        Clothing cl3 = new Clothing("Levi Blue Jeans", "Baby's Wearing Blue Jeans", 1, "30x32", "Levi's", "Medium Wash", Categories.BOTTOM, Types.JEANS, 3);
        Clothing cl4 = new Clothing("Levi Black Jeans", "Baby's Wearing Black Jeans", 1, "30x32", "Levi's", "Black", Categories.BOTTOM, Types.JEANS, 4);
        Clothing cl5 = new Clothing("Levi Red Jeans", "Baby's Wearing Red Jeans", 1, "30x32", "Levi's", "Red", Categories.BOTTOM, Types.JEANS, 5);
        Clothing cl6 = new Clothing("Birkenstock Sandals", "Jesus Sandals", 1, "8", "Birkenstock", "Brown", Categories.FOOTWEAR, Types.SANDALS, 6);
        Clothing cl7 = new Clothing("Hanes Black Boxers", "Boxers", 3, "M", "Hanes", "Black", Categories.UNDERGARMENTS, Types.UNDERWEAR, 7);
        Clothing cl8 = new Clothing("Hanes Gray Boxers", "Boxers", 4, "M", "Hanes", "Gray", Categories.UNDERGARMENTS, Types.UNDERWEAR, 8);
        Clothing cl9 = new Clothing("Blue Overalls", "Overall Enthusiasm, Overall Enthusiasm", 1, "M", "Lee's", "Blue", Categories.ONE_PIECE, Types.OVERALLS, 9);
        Clothing cl10 = new Clothing("Black Bomber Jacket", "Slightly distressed, from the 90s", 1, "M", "Capital Sun", "Black", Categories.OUTERWEAR, Types.JACKET, 10);
        Clothing cl11 = new Clothing("Red Sweater", "My dad's old sweater", 1, "L", "Jazzerman", "Maroon", Categories.OUTERWEAR, Types.SWEATER, 11);
        
        


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


        //this is the launching point of the app
        FrontPage starter = new FrontPage(mainUser);
        //starter.initialize();



    } 
}

