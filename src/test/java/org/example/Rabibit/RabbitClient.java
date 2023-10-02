package org.example.Rabibit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.commons.logging.Log;
public class RabbitClient {
    private static Log log;

    public static void sendMessageForQueue(String virtualHost, String exchange, String routingKey, String payload) {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setConnectionTimeout(3000);
        try (Connection connection = connectionFactory.newConnection()) {
            Channel channel = connection.createChannel();
            channel.basicPublish(exchange, routingKey,
                    null, payload.getBytes());
        } catch (Exception e) {
            log.info("Erro ao enviar mensagem");
        }
    }
}
