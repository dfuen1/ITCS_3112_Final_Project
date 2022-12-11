
import java.util.ArrayList;

public class UserWardrobe {

    private String username;
    private ArrayList<Clothing> wardrobe = new ArrayList<>();

    // default constructor
    public UserWardrobe() {

    }

    public UserWardrobe(String username) {
        this.username = username;

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public ArrayList<Clothing> getWardrobe() {
        return this.wardrobe;
    }

    // this method will return the names of the items
    public String[] getWardrobeItemNames() {
        String[] itemNames = new String[wardrobe.size()];

        for (int i = 0; i < wardrobe.size(); i++) {
            itemNames[i] = wardrobe.get(i).getName();
        }

        return itemNames;
    }

    // takes category as input and will return a string array
    // of the items that fit the input category
    public Object[] getItemsByCategory(Categories category) {
        ArrayList<Object> categorizedItemNames = new ArrayList<>();

        for (int i = 0; i < wardrobe.size(); i++) {
            if (wardrobe.get(i).getCategories() == category) {
                categorizedItemNames.add(wardrobe.get(i));
            }

        }

        return categorizedItemNames.toArray();

    }

    //
    public void addClothingItem(String name, String description, int quantity, String size,
            String brand, String color, Categories category, Types type, int id) {
        // Parameters of Clothing class
        // (String name, String description, int quantity, String size, String brand,
        // String color, Categories category, Types type, int id)
        Clothing clothingItem = new Clothing(name, description, quantity, size, brand, color, category, type);

        wardrobe.add(clothingItem);

        System.out.println("Clothing piece successfully added");
    }

    // this is for adding clothing objects
    public void addClothingItem(Clothing item) {
        // Parameters of Clothing class
        // (String name, String description, int quantity, String size, String brand,
        // String color, Categories category, Types type, int id)
        // Clothing clothingItem = new Clothing(item.getName(), item.getDescription(),
        // item.getQuantitiy(), item.getSize(), item.getBrand(), item.getColor(),
        // item.getCategories(), item.getType(), item.getId());

        wardrobe.add(item);

        System.out.println("Clothing piece successfully added");
    }

    // find the clothing item to be removed by ID and removes it from arraylist
    public void removeClothingItem(int id) {

        for (int i = 0; i < wardrobe.size(); i++) {
            if (wardrobe.get(i).getId() == id) {
                wardrobe.remove(i);
                break;
            }

        }

        System.out.println("Clothing piece successfully removed");

    }

    public Clothing findClothingPiece(int id) {
        Clothing foundPiece = null;

        for (int i = 0; i < wardrobe.size(); i++) {
            if (wardrobe.get(i).getId() == id) {
                foundPiece = wardrobe.get(i);
                break;
            }
        }
        return foundPiece;
    }

    // used for search functionality in front page
    public ArrayList<Clothing> findClothingBySearchCriteria(String searchCriteria) {

        String searchCriteriaUpper = searchCriteria.toUpperCase();

        // using the string obtained from the search bar, display items
        // from the wardrobe that contain that string sequence

        ArrayList<Clothing> results = new ArrayList<>();

        for (int i = 0; i < getWardrobe().size(); i++) {
            String currentObject = getWardrobe().get(i).getName().toUpperCase();

            // if the name of the current object contains the search criteria, add to
            // results
            if (currentObject.contains(searchCriteriaUpper)) {
                results.add(getWardrobe().get(i));
            }

        }

        return results;
    }

}
