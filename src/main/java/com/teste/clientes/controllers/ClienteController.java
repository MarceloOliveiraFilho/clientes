package com.teste.clientes.controllers;

import com.teste.clientes.dtos.ClienteDTO;
import com.teste.clientes.entidades.Cliente;
import com.teste.clientes.security.interfaces.ClienteService;
import com.teste.clientes.uteis.EnvelopeRespostaDTO;
import com.teste.clientes.uteis.ResponseEntityFactory;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ClienteController {

    @Value("${version}")
    private String version;
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Autowired


    @ResponseBody
    @RequestMapping(value = "/health", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnvelopeRespostaDTO> health() {
        return ResponseEntityFactory.ok(version);
    }

    @ResponseBody
    @RequestMapping(value = "/clientes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnvelopeRespostaDTO> listaClientes() {
        try {
            return ResponseEntityFactory.ok(clienteService.listClientes());
        } catch (ServiceException e) {
            return ResponseEntityFactory.erroInterno(e.getMessage(), "Erro ao consultar clientes.");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnvelopeRespostaDTO> findById(@PathVariable Long id) {
        try {
            return ResponseEntityFactory.ok(clienteService.findById(id));
        } catch (ServiceException e) {
            return ResponseEntityFactory.erroInterno(e.getMessage(), "Erro ao consultar cliente.");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/cliente/nome", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnvelopeRespostaDTO> findByNome(@RequestParam String nome) {
        try {
            return ResponseEntityFactory.ok(clienteService.findByNome(nome));
        } catch (ServiceException e) {
            return ResponseEntityFactory.erroInterno(e.getMessage(), "Erro ao consultar clientes.");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/cliente/cpf", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnvelopeRespostaDTO> findByCpf(@RequestParam String cpf) {
        try {
            return ResponseEntityFactory.ok(clienteService.findByCpf(cpf));
        } catch (ServiceException e) {
            return ResponseEntityFactory.erroInterno(e.getMessage(), "Erro ao consultar clientes.");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/cliente/endereco", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnvelopeRespostaDTO> findByEndereco(@RequestParam String endereco) {
        try {
            return ResponseEntityFactory.ok(clienteService.findByEndereco(endereco));
        } catch (ServiceException e) {
            return ResponseEntityFactory.erroInterno(e.getMessage(), "Erro ao consultar clientes.");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/cliente/idade", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnvelopeRespostaDTO> findByIdade(@RequestParam Long idade) {
        try {
            return ResponseEntityFactory.ok(clienteService.findByIdade(idade));
        } catch (ServiceException e) {
            return ResponseEntityFactory.erroInterno(e.getMessage(), "Erro ao consultar clientes.");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/cliente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnvelopeRespostaDTO> incluirCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            Cliente cliente = new Cliente(clienteDTO);
            return ResponseEntityFactory.ok(clienteService.insertCliente(cliente));
        } catch (ServiceException e) {
            return ResponseEntityFactory.erroInterno(e.getMessage(), "Erro ao inserir clientes.");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnvelopeRespostaDTO> atualizarCliente(@PathVariable long id) {
        try {
            clienteService.deleteCliente(id);
            return ResponseEntityFactory.ok("Cliente excluido com sucesso.");
        } catch (ServiceException e) {
            return ResponseEntityFactory.erroInterno(e.getMessage(), "Erro ao excluir cliente.");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/cliente", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnvelopeRespostaDTO> updateCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            clienteService.updateCliente(clienteDTO);
            return ResponseEntityFactory.ok("Cliente alterado com sucesso.");
        } catch (ServiceException e) {
            return ResponseEntityFactory.erroInterno(e.getMessage(), "Erro ao atualizar cliente.");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/cliente/paginado", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnvelopeRespostaDTO> findByIdade(@RequestParam Integer size,@RequestParam Integer page) {
        try {
            return ResponseEntityFactory.ok(clienteService.findAllPaginated(page,size));
        } catch (ServiceException e) {
            return ResponseEntityFactory.erroInterno(e.getMessage(), "Erro ao consultar clientes.");
        }
    }

}
