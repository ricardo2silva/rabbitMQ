package com.ricardo.rabbitmq_study.constants;

public class RabbitMQConstants {
    /**##################### EXCHANGEs###########################*/
    public static final String EXCHANGE_PEDIDOS ="pedidos.direct";
    public static final String EXCHANGE_DEVOLUCOES = "devolucoes.topic";
    public static final String EXCHANGE_PRODUTOS = "produtos.fanout";

    /**#######################QUEUES###############################*/
    public static final String QUEUE_PEDIDOS = "pedido.criado.queue";

    public static final String QUEUE_DEVOLUCOES_AVARIA ="devolucao.avaria.queue";
    public static final String QUEUE_DEVOLUCOES_ERRADA ="devolucao.errada.queue";
    public static final String QUEUE_DEVOLUCOES_DESISTENCIA ="devolucao.desistencia.queue";

    public static final String QUEUE_LOJA_A="loja.a.queue";
    public static final String QUEUE_LOJA_B="loja.b.queue";
    public static final String QUEUE_LOJA_C="loja.c.queue";

    /**########################ROUNTING_KEYS#######################*/
    public static final String ROUTING_KEY_PEDIDOS= "pedido.criado";

    /**#########################BINDINGS#####################################*/

    public static final  String BINDING_DEVOLUCOES = "devolucao.#";
}
