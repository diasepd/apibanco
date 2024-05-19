package br.ada.caixa.service;

import br.ada.caixa.dto.filter.ClientePfFilterDto;
import br.ada.caixa.dto.request.ClientePfRequestDto;
import br.ada.caixa.dto.response.ClientePfResponsetDto;
import br.ada.caixa.entity.ClientePf;
import br.ada.caixa.exceptions.ValidacaoException;
import br.ada.caixa.repository.ClientePfRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service //Ou @Component
public class ClientePfService {

    final private ClientePfRepository clientePfRepository;
    final private ModelMapper modelMapper;

    public ClientePfService(ClientePfRepository clientePfRepository, ModelMapper modelMapper) {
        this.clientePfRepository = clientePfRepository;
        this.modelMapper         = modelMapper;
    }

    @Transactional
    public ClientePfResponsetDto inserir(ClientePfRequestDto clientePfRequestDto) {
        ClientePf clientePf                         = modelMapper.map(clientePfRequestDto, ClientePf.class);
        clientePf = clientePfRepository.save(clientePf);
        ClientePfResponsetDto clientePfResponsetDto = modelMapper.map(clientePf, ClientePfResponsetDto.class);

        return clientePfResponsetDto;
    }

    public void excluir(Long id) {
        clientePfRepository.deleteById(id);
    }

    public ClientePfResponsetDto atualizar(Long id, ClientePfRequestDto clientePfRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        return clientePfRepository.findById(id)
                .map(clientePf -> {
                    modelMapper.map(clientePfRequestDto, clientePf);
                    return clientePfRepository.save(clientePf);
                })
                .map(ClientePf -> modelMapper.map(ClientePf, ClientePfResponsetDto.class))
                .orElseThrow(() -> new ValidacaoException("Cliente não existe"));
    }

    public ClientePfResponsetDto buscarPorId(Long clientepfId) {
        return clientePfRepository.findById(clientepfId)
                .map(clientePf -> modelMapper.map(clientePf, ClientePfResponsetDto.class))
                .orElseThrow(() -> new ValidacaoException("Cliente não encontrado"));
    }

    public List<ClientePfResponsetDto> listarTodos(ClientePfFilterDto filter) {
        return clientePfRepository.findAllByNomeContainsIgnoreCaseOrId(filter.getNome(),
                        filter.getId()).stream()
                .map(clientePf -> modelMapper.map(clientePf, ClientePfResponsetDto.class))
                .collect(Collectors.toList());
    }
}