package src;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import src.constants.MQConstants;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(MQConstants.QUEUE_HOST);
        // randomly generate packet
        DataPacket packet = new DataPacket(new Timestamp(System.currentTimeMillis()));

        Connection connection = null;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel() ;
            channel.queueDeclare(MQConstants.QUEUE_NAME_FOR_AGGREGATOR, false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", MQConstants.QUEUE_NAME_FOR_AGGREGATOR, null, MessageUtils.serializeObject(packet));
            System.out.println(" [x] Sent '" + message + "'");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
