package com.teste.clientes.entidades;

import com.teste.clientes.dtos.ClienteDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @ApiModelProperty(value = "Código da cliente")
    private Long id;

    @ApiModelProperty(value = "Nome do cliente")
    private String nome;

    @ApiModelProperty(value = "Endereço do cliente")
    private String endereco;

    @ApiModelProperty(value = "CPF do cliente")
    private String cpf;

    @ApiModelProperty(value = "Idade do cliente")
    private Long idade;

    public Cliente(){
        super();
    }

    public Cliente(ClienteDTO clienteDTO) {
        this.nome = clienteDTO.getNome();
        this.endereco = clienteDTO.getEndereco();
        this.cpf = clienteDTO.getCpf();
        this.idade = clienteDTO.getIdade();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getIdade() {
        return idade;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }
}
