package com.teste.clientes.security.implement;

import com.teste.clientes.dtos.ClienteDTO;
import com.teste.clientes.entidades.Cliente;
import com.teste.clientes.repository.ClienteInsertRepository;
import com.teste.clientes.repository.ClienteRepository;
import com.teste.clientes.security.interfaces.ClienteService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

private ClienteRepository clienteRepository;
private ClienteInsertRepository clienteInsertRepository;
private EntityManagerFactory entityManagerFactory;
private EntityManager em;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository,
                              ClienteInsertRepository clienteInsertRepository,
                              EntityManagerFactory entityManagerFactory) {
        this.clienteInsertRepository = clienteInsertRepository;
        this.clienteRepository = clienteRepository;
        this.entityManagerFactory = entityManagerFactory;
        this.em = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<Cliente> listClientes(){
        return clienteRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()){
            throw new ServiceException("Nenhum cliente não encontrado.");
        }
        return cliente;
    }

    @Override
    public List<Cliente> findByNome(String nome) {
        List<Cliente> cliente = clienteRepository.findByNome(nome);
        if (cliente.isEmpty()){
            throw new ServiceException("Nenhum cliente não encontrado.");
        }
        return cliente;
    }

    @Override
    public List<Cliente> findByEndereco(String endereco) {
        List<Cliente> cliente = clienteRepository.findByEndereco(endereco);
        if (cliente.isEmpty()){
            throw new ServiceException("Nenhum cliente não encontrado.");
        }
        return cliente;
    }

    @Override
    public List<Cliente> findByCpf(String cpf) {
        List<Cliente> cliente = clienteRepository.findByCpf(cpf);
        if (cliente.isEmpty()){
            throw new ServiceException("Nenhum cliente não encontrado.");
        }
        return cliente;
    }

    @Override
    public List<Cliente> findByIdade(Long idade) {
        List<Cliente> cliente = clienteRepository.findByIdade(idade);
        if (cliente.isEmpty()){
            throw new ServiceException("Nenhum cliente não encontrado.");
        }
        return cliente;
    }

    @Override
    public Cliente insertCliente(Cliente cliente){
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        return cliente;
    }

    @Override
    public void deleteCliente(Long id) throws ServiceException {
        em.getTransaction().begin();
        int isSuccessful = em.createQuery("DELETE FROM Cliente WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
        if (isSuccessful == 0) {
            throw new ServiceException("Erro ao excluir cliente.");
        }
    }

    @Override
    public void updateCliente(ClienteDTO cliente) throws ServiceException {
        em.getTransaction().begin();
        int isSuccessful = em.createQuery("UPDATE Cliente " +
                "SET endereco=:endereco,idade=:idade,cpf=:cpf,nome=:nome " +
                "WHERE id=:id")
                .setParameter("id", cliente.getId())
                .setParameter("endereco", cliente.getEndereco())
                .setParameter("idade", cliente.getIdade())
                .setParameter("cpf", cliente.getCpf())
                .setParameter("nome", cliente.getNome())
                .executeUpdate();
        em.getTransaction().commit();
        if (isSuccessful == 0) {
            throw new ServiceException("Erro ao alterar cliente.");
        }
    }

    @Override
    public Page<Cliente> findAllPaginated(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return clienteRepository.findAll(pageable);
    }

}
