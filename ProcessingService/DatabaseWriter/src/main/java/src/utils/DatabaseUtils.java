package src.utils;

import src.model.DatabaseData;

public class DatabaseUtils {
    public static boolean sendDataToDB(DatabaseData databaseData){
        System.out.println("Sending Data To Database "+databaseData.count +" "+databaseData.id);
        return true;
    }
}
