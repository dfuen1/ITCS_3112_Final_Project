import java.util.ArrayList;
import java.util.HashMap;

public class UserWardrobe {
    
    private String username;
    private ArrayList<Clothing> wardrobe = new ArrayList<>();

    //default constructor
    public UserWardrobe(){

    }

    public UserWardrobe(String username){
        this.username = username;

    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public ArrayList<Clothing> getWardrobe(){
        return this.wardrobe;
    }

    //this method will return the names of the items
    public String[] getWardrobeItemNames(){
        String[] itemNames = new String[wardrobe.size()];

        for(int i = 0; i < wardrobe.size(); i++){
            itemNames[i] = wardrobe.get(i).getName();
        }

        return itemNames;
    }

    //takes category as input and will return a string array
    //of the items that fit the input category
    public String[] getItemsByCategory(Categories category){
        String[] categorizedItemNames = new String[wardrobe.size()];

        for(int i = 0; i < wardrobe.size(); i++){
            if(wardrobe.get(i).getCategories() == category){
                categorizedItemNames[i] = wardrobe.get(i).getName();
            }
            
        }

        return categorizedItemNames;

    }

    //
    public void addClothingItem(String name, String description, int quantity, String size,
    String brand, String color, Categories category, Types type, int id){
        //Parameters of Clothing class
        //(String name, String description, int quantity, String size, String brand, String color, Categories category, Types type, int id)
        Clothing clothingItem = new Clothing(name, description, quantity, size, brand, color, category, type, id);
        
        wardrobe.add(clothingItem);

        System.out.println("Clothing piece successfully added");
    }

    //this is for adding clothing objects
    public void addClothingItem(Clothing item){
        //Parameters of Clothing class
        //(String name, String description, int quantity, String size, String brand, String color, Categories category, Types type, int id)
        //Clothing clothingItem = new Clothing(item.getName(), item.getDescription(), item.getQuantitiy(), item.getSize(), item.getBrand(), item.getColor(), item.getCategories(), item.getType(), item.getId());
        
        wardrobe.add(item);

        System.out.println("Clothing piece successfully added");
    }

    //find the clothing item to be removed by ID and removes it from arraylist
    public void removeClothingItem(int id){
        
        for(int i = 0; i < wardrobe.size(); i++){
            if(wardrobe.get(i).getId() == id){
                wardrobe.remove(i);
                break;
            }

        }

        System.out.println("Clothing piece successfully removed");

    }

    //this "edits" a clothing item by first removing it, saving its id
    //and creating a new clothing item with the same id
    public void editClothingItem(int id, Clothing editedItem){
        int savedId = id;

        removeClothingItem(id);
        editedItem.setId(savedId);
        addClothingItem(editedItem);



    }






}
