package br.ada.caixa.service;

import br.ada.caixa.dto.response.ClienteResponsetDto;
import br.ada.caixa.entity.Cliente;
import br.ada.caixa.entity.ClientePf;
import br.ada.caixa.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRespository;
    private final ModelMapper modelMapper;

    public ClienteService(ClienteRepository clienteRespository, ModelMapper modelMapper) {
        this.clienteRespository = clienteRespository;
        this.modelMapper = modelMapper;
    }

    public List<ClienteResponsetDto> listarTodos() {
        List<Cliente> clientes = clienteRespository.findAll();
        return clientes.stream().map(cliente -> {
            ClienteResponsetDto clienteResponseDto = modelMapper.map(cliente, ClienteResponsetDto.class);
            clienteResponseDto.setTipo((cliente instanceof ClientePf) ? "PF" : "PJ");
            return clienteResponseDto;
        }).collect(Collectors.toList());
    }
}