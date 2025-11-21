package com.ricardo.rabbitmq_study.producer;

import com.ricardo.rabbitmq_study.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.ricardo.rabbitmq_study.constants.RabbitMQConstants.EXCHANGE_PEDIDOS;
import static com.ricardo.rabbitmq_study.constants.RabbitMQConstants.ROUTING_KEY_PEDIDOS;

@Service
@RequiredArgsConstructor
public class PedidoProducer {
    private static final Logger logger = LoggerFactory.getLogger(PedidoService.class);


    private final RabbitTemplate rabbitTemplate;

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
}
