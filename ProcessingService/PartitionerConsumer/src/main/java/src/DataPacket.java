package src;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

public class DataPacket implements Serializable {
    private String objectID;
    private Timestamp timeStamp;

    public DataPacket(String objectID, Timestamp timeStamp) {
        this.timeStamp = timeStamp;
        this.objectID = objectID;
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
