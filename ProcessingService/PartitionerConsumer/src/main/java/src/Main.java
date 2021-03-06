package src;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import src.constants.MQConstants;
import src.data.DataPacket;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(MQConstants.QUEUE_HOST);
        // randomly generate packet
        DataPacket packet = new DataPacket(UUID.randomUUID().toString(), new Timestamp(System.currentTimeMillis()));

        Connection connection = null;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel() ;
            channel.queueDeclare(MQConstants.QUEUE_NAME_FOR_AGGREGATOR, false, false, false, null);
            channel.basicPublish("", MQConstants.QUEUE_NAME_FOR_AGGREGATOR, null, MessageUtils.serializeObject(packet));
//            connection.close();
            System.out.println(" [x] Sent '");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


//        CqlSession session = CqlSession.builder().build();
//        Row rs = session.execute("SELECT * FROM videodb.videos;").one();
//        System.out.println(rs.getString("description"));
    }
}
