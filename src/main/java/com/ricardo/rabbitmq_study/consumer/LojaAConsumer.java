package com.ricardo.rabbitmq_study.consumer;

import static com.ricardo.rabbitmq_study.constants.RabbitMQConstants.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class LojaAConsumer {

    @RabbitListener(queues = QUEUE_LOJA_A)
    public void receberNotificacaoProdutoNovo(String mensagem){
        System.out.println("Loja A recebendo mensagem: " + mensagem);
    }
}
