package src.model;

public class DatabaseData implements java.io.Serializable  {
    public String id;
    public int count;
    public DatabaseData(String id, int count){
        this.id = id;
        this.count = count;
    }

}
