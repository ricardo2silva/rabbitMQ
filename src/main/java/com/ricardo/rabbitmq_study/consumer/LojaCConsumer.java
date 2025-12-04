package com.ricardo.rabbitmq_study.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.ricardo.rabbitmq_study.constants.RabbitMQConstants.QUEUE_LOJA_C;

@Component
public class LojaCConsumer {
    @RabbitListener(queues = QUEUE_LOJA_C)
    public void receberNotificacaoProdutoNovo(String mensagem){
        System.out.println("Loja C recebendo mensagem: " + mensagem);
    }
}
