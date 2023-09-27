package org.example.Rabibit;

import org.junit.jupiter.api.Test;

import java.io.IOException;



public class RabbitEnviar {

    @Test
    public void shouldSendOneMessageForRabbitTest() throws IOException {

        String filePath = "payloads/rabbitMQ";
        String fileName = "createCommercialOrderPayload";

        RabbitClient.sendMessageForQueue(
                "dev2",
                "create-commercial-order",
                "#",""
        );
    }
}
