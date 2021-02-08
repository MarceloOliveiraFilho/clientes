package com.teste.clientes.repository;

import com.teste.clientes.entidades.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class ClienteInsertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public int insertWithQuery(Cliente cliente) {
        return entityManager.createNativeQuery("INSERT INTO cliente (nome, endereco, cpf, idade) VALUES(?, ?, ?, ?);")
                .setParameter(1, cliente.getNome())
                .setParameter(2, cliente.getEndereco())
                .setParameter(3, cliente.getCpf())
                .setParameter(4, cliente.getIdade())
                .executeUpdate();
    }

}
