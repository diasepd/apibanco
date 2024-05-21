package br.ada.caixa.repository;

import br.ada.caixa.entity.Cliente;
import br.ada.caixa.entity.ClientePf;
import br.ada.caixa.entity.ClientePj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    @Query("select c from ClientePF c")
    List<ClientePf> findAllPF();

    @Query("select c from ClientePJ c")
    List<ClientePj> findAllPJ();
}
