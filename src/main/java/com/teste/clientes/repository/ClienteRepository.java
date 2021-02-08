package com.teste.clientes.repository;

import com.teste.clientes.entidades.Cliente;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    List<Cliente> findAllByOrderByIdAsc();

    Optional<Cliente> findById(Long id);

    List<Cliente> findByNome(String nome);

    List<Cliente> findByEndereco(String endereco);

    List<Cliente> findByCpf(String cpf);

    List<Cliente> findByIdade(Long idade);

}
