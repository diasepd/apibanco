package br.ada.caixa.controller;

import br.ada.caixa.dto.response.ClienteResponsetDto;
import br.ada.caixa.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponsetDto>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }
}
