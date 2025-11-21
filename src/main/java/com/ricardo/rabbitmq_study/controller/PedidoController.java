package com.ricardo.rabbitmq_study.controller;

import com.ricardo.rabbitmq_study.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<String> criarPedido(@RequestBody String mensagem) {
        pedidoService.enviarPedido(mensagem);
        return ResponseEntity.ok("Pedido enviado com sucesso: " + mensagem);
    }

    @PostMapping("/teste")
    public ResponseEntity<String> teste() {
        pedidoService.enviarPedido("Pedido de teste criado");
        return ResponseEntity.ok("Mensagem de teste enviada!");
    }

    @PostMapping("/devolucao")
    public ResponseEntity<String> criarSolicitacaoDeDevolucao(@RequestBody String mensagem) {
        pedidoService.criarPedidoDeDevolucao(mensagem);
        return ResponseEntity.ok("Pedido enviado com sucesso: " + mensagem);
    }
}

