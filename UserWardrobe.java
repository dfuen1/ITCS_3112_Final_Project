import java.util.HashMap;

public class UserWardrobe {
    
    private String username;
    private HashMap<Integer, Clothing> wardrobe;

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






}
