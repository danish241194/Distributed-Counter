package src.Utils;


import src.data.DataPacket;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class ConverterUtils {
    public static DataPacket bytesToDatabaseData(byte[] bytesArray){
        ByteArrayInputStream bis = new ByteArrayInputStream(bytesArray);
        ObjectInput in = null;
        DataPacket databaseData = null;
        try {
            in = new ObjectInputStream(bis);
            databaseData = (DataPacket) in.readObject();

            System.out.println(" [x] Received '" + databaseData.getObjectID() );

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
