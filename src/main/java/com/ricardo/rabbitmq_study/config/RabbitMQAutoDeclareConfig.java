package com.ricardo.rabbitmq_study.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

/**
 * Configuração que declara automaticamente todos os beans do tipo
 * Queue, Exchange e Binding no RabbitMQ.
 * 
 * Esta solução é escalável: ao adicionar novos beans, eles serão
 * automaticamente detectados e declarados, sem necessidade de
 * modificar este código.
 */
@Configuration
public class RabbitMQAutoDeclareConfig {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQAutoDeclareConfig.class);

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void declareAllResources() {
        try {
            logger.info("Iniciando declaração automática de recursos do RabbitMQ...");

            // Declara todas as Exchanges
            Collection<Exchange> exchanges = applicationContext.getBeansOfType(Exchange.class).values();
            for (Exchange exchange : exchanges) {
                rabbitAdmin.declareExchange(exchange);
                logger.info("Exchange '{}' declarada com sucesso", exchange.getName());
            }

            // Declara todas as Queues
            Collection<Queue> queues = applicationContext.getBeansOfType(Queue.class).values();
            for (Queue queue : queues) {
                rabbitAdmin.declareQueue(queue);
                logger.info("Queue '{}' declarada com sucesso", queue.getName());
            }

            // Declara todos os Bindings
            Collection<Binding> bindings = applicationContext.getBeansOfType(Binding.class).values();
            for (Binding binding : bindings) {
                rabbitAdmin.declareBinding(binding);
                logger.info("Binding declarado: {} -> {} com routing key '{}'",
                        binding.getDestination(), binding.getExchange(), binding.getRoutingKey());
            }

            logger.info("Declaração automática concluída! Total: {} exchanges, {} queues, {} bindings",
                    exchanges.size(), queues.size(), bindings.size());

        } catch (Exception e) {
            logger.error("Erro ao declarar recursos do RabbitMQ", e);
            throw new RuntimeException("Falha ao declarar recursos do RabbitMQ", e);
        }
    }
}

