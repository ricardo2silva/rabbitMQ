package com.ricardo.rabbitmq_study.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.ricardo.rabbitmq_study.constants.RabbitMQConstants.QUEUE_DEVOLUCOES_DESISTENCIA;

@Component
public class DevolucaoDesistenciaConsumer {

    @RabbitListener(queues = QUEUE_DEVOLUCOES_DESISTENCIA)
    public void receberMensagem(String mensagem){
        System.out.println("mensagem recebida de devolucao por desistencia: " + mensagem);

    }
}
