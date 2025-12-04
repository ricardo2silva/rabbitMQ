package com.ricardo.rabbitmq_study.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.ricardo.rabbitmq_study.constants.RabbitMQConstants.QUEUE_LOJA_B;

@Component
public class LojaBConsumer {

    @RabbitListener(queues = QUEUE_LOJA_B)
    public void receberNotificacaoProdutoNovo(String mensagem){
        System.out.println("Loja B recebendo mensagem: " + mensagem);
    }
}
