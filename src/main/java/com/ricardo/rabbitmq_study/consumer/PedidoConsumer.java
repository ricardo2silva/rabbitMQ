package com.ricardo.rabbitmq_study.consumer;

import static com.ricardo.rabbitmq_study.constants.RabbitMQConstants.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoConsumer {
    //@RabbitListener(queues = QUEUE_PEDIDOS)
    @RabbitListener(queues = "devolucao.errada.queue")
    public void receberMensagem(String mensagem){
        System.out.println("mensagem recebida: " + mensagem);

    }
}
