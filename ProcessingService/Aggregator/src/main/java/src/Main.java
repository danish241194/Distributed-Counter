package src;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import src.Utils.ConverterUtils;
import src.constants.MQConstants;
import src.data.DataPacket;

public class Main {

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(MQConstants.QUEUE_NAME_FOR_AGGREGATOR, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            DataPacket message = ConverterUtils.bytesToDatabaseData(delivery.getBody());
        };
        channel.basicConsume(MQConstants.QUEUE_NAME_FOR_AGGREGATOR, true, deliverCallback, consumerTag -> { });
    }
}
