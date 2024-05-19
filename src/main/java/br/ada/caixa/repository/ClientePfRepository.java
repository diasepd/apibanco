package br.ada.caixa.repository;

import br.ada.caixa.entity.ClientePf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //opcional
public interface ClientePfRepository extends JpaRepository<ClientePf, Long> { //camada de crud no BD

    // simples
    List<ClientePf> findAllByNomeContainsIgnoreCaseOrId(String nome, Long id);

    //Complexo
    @Query("select c from ClientePf c              "+
           " where upper(c.nome) like upper(:nome) "+
           "    or c.id  = :id                     "+
           "    or c.cpf = :cpf                    ")
    List<ClientePf> pesquisar(String nome
                            , Long id
                            , String cpf
//    List<ClientePf> pesquisar(@Param("nome") String nome
//                            , @Param("id") Long id
//                            , @Param("cpf") String cpf
    );
}