package com.teste.clientes.security.interfaces;

import com.teste.clientes.dtos.ClienteDTO;
import com.teste.clientes.entidades.Cliente;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> listClientes();

    Optional<Cliente> findById(Long id);

    List<Cliente> findByNome(String nome);

    List<Cliente> findByEndereco(String endereco);

    List<Cliente> findByCpf(String cpf);

    List<Cliente> findByIdade(Long idade);

    Cliente insertCliente(Cliente cliente);

    void deleteCliente(Long id) throws ServiceException;

    void updateCliente(ClienteDTO cliente) throws ServiceException;

    Page<Cliente> findAllPaginated(int page, int size);

}
