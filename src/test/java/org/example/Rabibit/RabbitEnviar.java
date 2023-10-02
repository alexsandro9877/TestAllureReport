package org.example.Rabibit;

import java.io.IOException;



public class RabbitEnviar {


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
