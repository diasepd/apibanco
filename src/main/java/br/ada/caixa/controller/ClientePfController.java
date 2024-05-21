package br.ada.caixa.controller;

import br.ada.caixa.dto.filter.ClientePfFilterDto;
import br.ada.caixa.dto.request.ClientePfRequestDto;
import br.ada.caixa.dto.response.ClientePfResponsetDto;
import br.ada.caixa.enums.StatusCliente;
import br.ada.caixa.service.ClientePfService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes/pf")
public class ClientePfController {

    final private ClientePfService clientePfService;

    public ClientePfController(ClientePfService clientePfService) {
        this.clientePfService = clientePfService;
    }

    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody ClientePfRequestDto clientePfRequestDto) {
        ClientePfResponsetDto clientePfResponsetDto = clientePfService.inserir(clientePfRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientePfResponsetDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientePfResponsetDto> atualizar(@PathVariable Long id,
                                                           @RequestBody ClientePfRequestDto clientePf) {
        ClientePfResponsetDto clientePfResponsetDto = clientePfService.atualizar(id, clientePf);
        return ResponseEntity.ok(clientePfResponsetDto);
    }

    @DeleteMapping("/{testeId}")
    public void excluir(@PathVariable(name = "testeId") Long id) {
        clientePfService.excluir(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientePfResponsetDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(clientePfService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ClientePfResponsetDto>> listarTodos(ClientePfFilterDto filter) {
        List<ClientePfResponsetDto> listaClientesPf = clientePfService.listarTodos(filter);
        return ResponseEntity.ok(listaClientesPf);
    }

    @PatchMapping("/{cpf}/{status}")
    public ResponseEntity<?> atualizarStatus(@PathVariable String cpf,
                                             @PathVariable StatusCliente status) {
        return null;
    }
}