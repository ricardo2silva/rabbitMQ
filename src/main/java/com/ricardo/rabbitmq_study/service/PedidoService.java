package com.ricardo.rabbitmq_study.service;

import com.ricardo.rabbitmq_study.producer.PedidoProducer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ricardo.rabbitmq_study.constants.RabbitMQConstants.*;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoProducer pedidoProducer;

    public void enviarPedido(String mensagem) {
       pedidoProducer.enviarPedido(mensagem);
    }

    public void criarPedidoDeDevolucao(String mensagem) {
        pedidoProducer.criarPedidoDeDevolucao(mensagem);
    }

    public void notificarLojas(String mensagem) {
        pedidoProducer.notificarLojas(mensagem);
    }
}

