# Estudo sobre RabbitMQ

## O que é RabbitMQ ?


 RabbitMQ é um sistema de mensageria open-source que implementa o padrão AMQP (Advanced Message Queuing Protocol). 
 
Ele permite que aplicações se comuniquem entre si de forma assíncrona e desacoplada, trocando mensagens por meio 
de filas e exchanges, em vez de chamadas diretas entre sistemas.

 

Em outras palavras, ele funciona como um correio interno entre sistemas:

- Um producer (produtor) envia mensagens para uma exchange.
- A exchange direciona essas mensagens para uma ou mais filas, usando regras chamadas de bindings e routing keys.
- Um consumer (consumidor) lê as mensagens dessas filas no seu próprio ritmo.

# Principais vantagens do RabbitMQ:
- 
- Desacoplamento entre sistemas.
- Escalabilidade, permitindo múltiplos consumidores e produtores.
- Persistência das mensagens para garantir confiabilidade.
- Flexibilidade de roteamento de mensagens (direct, fanout, topic, headers).

## Vantagens do RabbitMQ
- Desacoplamento: produtores e consumidores não precisam saber nada sobre a implementação um do outro.
- Confiabilidade: mensagens podem ser persistidas em disco, garantindo entrega mesmo em caso de falhas.
- Flexibilidade de roteamento: exchanges do tipo direct, fanout, topic e headers permitem cenários complexos de 
  distribuição de mensagens.
- Suporte a múltiplos protocolos: além de AMQP, suporta MQTT, STOMP, HTTP, entre outros.
- Escalável: suporta múltiplos consumidores e balanceamento de carga. 
- Confirmations e acknowledgements: você sabe se a mensagem foi recebida com sucesso pelo consumidor.

## Desvantagens do RabbitMQ

- Latência maior que comunicação direta: é um middleware, então há overhead no envio e recebimento de mensagens.
- Complexidade: exige configuração de exchanges, bindings, filas e políticas de persistência.
- Gerenciamento de memória: filas muito grandes podem consumir muita RAM, exigindo cuidado com limites e TTL.
- Não é ideal para streaming massivo em tempo real: sistemas como Kafka podem ser mais eficientes para grandes volumes de dados contínuos.
- Operação e manutenção: requer monitoramento, backup de filas persistentes e tuning para desempenho.
 

# Dependência no projeto
 

Para que nossa aplicaçao tenha acesso ao RabbitMQ, devemos adicionar essa lib no pom.xml

```xml

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
 ```

# O que precisamos para rodar o RabbitMQ

Na aplicação já possui um docker compose  do Rabbit, apenas de o seguinte comando no terminal, garanta que esse comando 
 seja no mesmo local onde seu arquivo docker-compose.yml esteja nele:

```
 docker compose up
```

depois vá para localhost:15672

   ![img.png](img.png)

 no campo username e password digite guest e clique no login

