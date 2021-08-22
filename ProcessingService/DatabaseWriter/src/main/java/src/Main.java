package src;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import src.model.DatabaseData;
import src.utils.ConverterUtils;
import src.utils.DatabaseUtils;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main  {
    public static void main(String[] args){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare("dana", false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            DeliverCallback deliverCallback = getDeliverCallback();
            channel.basicConsume("dana", true, deliverCallback, consumerTag -> { });
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private static DeliverCallback getDeliverCallback() {
        return (consumerTag, delivery) -> {
            DatabaseData databaseData = ConverterUtils.bytesToDatabaseData(delivery.getBody());
            if (databaseData != null){
                DatabaseUtils.sendDataToDB(databaseData);
            }
        };
    }
}
