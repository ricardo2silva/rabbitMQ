package com.ricardo.rabbitmq_study.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ricardo.rabbitmq_study.constants.RabbitMQConstants.*;

@Service
public class PedidoService {

    private static final Logger logger = LoggerFactory.getLogger(PedidoService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarPedido(String mensagem) {
        try {
            logger.info("Enviando mensagem para a exchange '{}' com routing key '{}'", 
                    EXCHANGE_PEDIDOS, ROUTING_KEY_PEDIDOS);
            
            rabbitTemplate.convertAndSend(EXCHANGE_PEDIDOS, ROUTING_KEY_PEDIDOS, mensagem);
            
            logger.info("Mensagem enviada com sucesso: {}", mensagem);
        } catch (Exception e) {
            logger.error("Erro ao enviar mensagem", e);
            throw new RuntimeException("Falha ao enviar mensagem", e);
        }
    }


    public void criarPedidoDeDevolucao(String mensagem){
        try{
            logger.info("Enviando mensagem para a exchange '{}' com routing key '{}'",
                    EXCHANGE_DEVOLUCOES, BINDING_DEVOLUCOES);
            rabbitTemplate.convertAndSend(EXCHANGE_DEVOLUCOES, BINDING_DEVOLUCOES, mensagem);
            logger.info("Mensagem enviada com sucesso: {}", mensagem);
        } catch (Exception e) {
            logger.error("Erro ao enviar mensagem", e);
            throw new RuntimeException("Falha ao enviar mensagem", e);
        }
    }
}

