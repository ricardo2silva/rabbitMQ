package com.ricardo.rabbitmq_study.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.ricardo.rabbitmq_study.constants.RabbitMQConstants.*;


@Configuration
public class RabbitConfig {

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin admin = new RabbitAdmin(connectionFactory);
        admin.setAutoStartup(true);
        return admin;
    }
    /**
     * Configurando direct exchange  */
    @Bean
    public Queue queue(){
        return QueueBuilder.durable(QUEUE_PEDIDOS).build();
    }

    @Bean
    public DirectExchange directExchange(){
        return ExchangeBuilder.directExchange(EXCHANGE_PEDIDOS)
                .durable(true)
                .build();
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(directExchange())
                .with(ROUTING_KEY_PEDIDOS);
    }
    /**
     * Configurando topic Exchange */

    @Bean
    public Queue devolucaoAvariaQueue(){
        return QueueBuilder.durable(QUEUE_DEVOLUCOES_AVARIA).build();
    }

    @Bean
    public Queue devolucaoErradaQueue(){
        return QueueBuilder.durable(QUEUE_DEVOLUCOES_ERRADA).build();
    }

    @Bean
    public Queue devolucaoDesistenciaQueue(){
        return QueueBuilder.durable(QUEUE_DEVOLUCOES_DESISTENCIA).build();

    }

    @Bean
    public TopicExchange devolucaoTopicExchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE_DEVOLUCOES)
                .durable(true)
                .build();

    }

    @Bean
    public Binding devolucaoAvariaBinding(){
        return BindingBuilder
                .bind(devolucaoAvariaQueue())
                .to(devolucaoTopicExchange())
                .with(BINDING_DEVOLUCOES);
    }
    @Bean
    public Binding devolucaoDesistenciaBinding(){
        return BindingBuilder
                .bind(devolucaoDesistenciaQueue())
                .to(devolucaoTopicExchange())
                .with(BINDING_DEVOLUCOES);
    }
    @Bean
    public Binding devolucaoErradaBinding(){
        return BindingBuilder
                .bind(devolucaoErradaQueue())
                .to(devolucaoTopicExchange())
                .with(BINDING_DEVOLUCOES);
    }

    /** configurando fanout exchange */

    @Bean
    public FanoutExchange fanoutExchange(){
        return  ExchangeBuilder.fanoutExchange(EXCHANGE_PRODUTOS).build();
    }

    @Bean
    public Queue produtoLojaAQueue(){
        return QueueBuilder.durable(QUEUE_LOJA_A).build();
    }

    @Bean
    public Queue produtoLojaBQueue(){
        return QueueBuilder.durable(QUEUE_LOJA_B).build();
    }

    @Bean
    public Queue produtoLojaCQueue(){
        return QueueBuilder.durable(QUEUE_LOJA_C).build();
    }

    @Bean
    public Binding lojaABinding(){
        return BindingBuilder.bind(produtoLojaAQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding lojaBBinding(){
        return BindingBuilder.bind(produtoLojaBQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding lojaCBinding(){
        return BindingBuilder.bind(produtoLojaCQueue()).to(fanoutExchange());
    }



}
