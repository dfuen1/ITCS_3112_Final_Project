public class Clothing {

    private String name;
    private String description;
    private int quantity;
    private String size;
    private String brand;
    private String color;
    private Categories category;
    private Types type;
    private int id;
    private static int totalItems = 0;

    public Clothing(){

    }

    public Clothing(String name, String description, int quantity, String size,
    String brand, String color, Categories category, Types type){
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.size = size;
        this.brand = brand;
        this.color = color;
        this.category = category;
        this.type = type;
        totalItems++;
        this.id = totalItems;
    }

    //ALL GETTERS AND SETTERS
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getQuantitiy(){
        return this.quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String getSize(){
        return this.size;
    }

    public void setSize(String size){
        this.size = size;
    }

    public String getBrand(){
        return this.brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public Categories getCategories(){
        return this.category;
    }

    public void setCategory(Categories category){
        this.category = category;
    }

    public Types getType(){
        return this.type;
    }

    public void setType(Types type){
        this.type = type;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    //toString method is used for displaying on JList
    @Override
    public String toString(){
        return this.name;
    }

    public String toStringFileSave(){
        
            return "Name:" + this.name + ", Description:" + this.description + ", Quantity:" + this.quantity + ", Size:"
            + this.size + ", Brand:" + this.brand + ", Color:" + this.color + ", Category:" + this.category
            + ", Type:" + this.type + ", ID:" + this.id;
        
    }


    
}
