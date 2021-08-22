package src.utils;

import src.model.DatabaseData;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class ConverterUtils {
    public static DatabaseData bytesToDatabaseData(byte[] bytesArray){
        ByteArrayInputStream bis = new ByteArrayInputStream(bytesArray);
        ObjectInput in = null;
        DatabaseData databaseData = null;
        try {
            in = new ObjectInputStream(bis);
            databaseData = (DatabaseData) in.readObject();

            System.out.println(" [x] Received '" + databaseData.id + "'" +" "+ databaseData.count);

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                // ignore close exception
            }
        }
        return databaseData;
    }
}
