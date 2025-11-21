package com.ricardo.rabbitmq_study.constants;

public class RabbitMQConstants {
    /**##################### EXCHANGEs###########################*/
    public static final String EXCHANGE_PEDIDOS ="pedidos.direct";
    public static final String EXCHANGE_DEVOLUCOES = "devolucoes.topic";

    /**#######################QUEUES###############################*/
    public static final String QUEUE_PEDIDOS = "pedido.criado.queue";

    public static final String QUEUE_DEVOLUCOES_AVARIA ="devolucao.avaria.queue";
    public static final String QUEUE_DEVOLUCOES_ERRADA ="devolucao.errada.queue";
    public static final String QUEUE_DEVOLUCOES_DESISTENCIA ="devolucao.desistencia.queue";

    /**########################ROUNTING_KEYS#######################*/
    public static final String ROUTING_KEY_PEDIDOS= "pedido.criado";

    /**#########################BINDINGS#####################################*/

    public static final  String BINDING_DEVOLUCOES = "devolucao.#";
}
