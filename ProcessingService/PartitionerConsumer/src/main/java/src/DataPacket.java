package src;

import java.sql.Timestamp;
import java.util.UUID;

public class DataPacket {
    private String objectID;
    private Timestamp timeStamp;

    public DataPacket(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
        this.objectID = UUID.randomUUID().toString();
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }
}
