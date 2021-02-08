package com.teste.clientes.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDTO {
    private Long id;

    private String nome;

    private String endereco;

    private String cpf;

    private Long idade;

    public ClienteDTO(Long id, String nome, String endereco, String cpf, Long idade) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.idade = idade;
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
