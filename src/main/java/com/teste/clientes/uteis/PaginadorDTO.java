package com.teste.clientes.uteis;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginadorDTO {

    private static final String SEPARADOR_ORDENACOES = ";";
    private static final String SEPARADOR_ORDENACAO = ",";
    private static final int INDEX_CAMPO_ORDENAR = 0;
    private static final int INDEX_DIRECAO_ORDENACAO = 1;

    private Long size;
    private Long page;
    private String sort;
    private Map<String, String> sortMap;
    private Long quantidadeTotalElementos;


    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
        carregarSortMap();
    }

    public Map<String, String> getSortMap() {
        return sortMap;
    }

    public Long getQuantidadeTotalElementos() {
        return quantidadeTotalElementos;
    }

    public void setQuantidadeTotalElementos(Long quantidadeTotalElementos) {
        this.quantidadeTotalElementos = quantidadeTotalElementos;
    }

    public String getSQLOrderBy(){
        StringBuilder orderBy = new StringBuilder();
        if ((getSortMap() != null) && (getSortMap().size() > 0)) {
            for (Map.Entry<String, String> entry : getSortMap().entrySet()){
                if (orderBy.length() >=1){
                    orderBy.append(",");
                }
                orderBy.append(entry.getKey()).append(" ").append(entry.getValue());
            }
        }
        if (orderBy.length() > 0){
            orderBy.insert(0," ORDER BY ");
        }
        return orderBy.toString();
    }

    public String getSQLOrderByUse(){
        StringBuilder orderBy = new StringBuilder();
        if ((getSortMap() != null) && (getSortMap().size() > 0)) {
            for (Map.Entry<String, String> entry : getSortMap().entrySet()){
                if (orderBy.length() >=1){
                    orderBy.append(",");
                }
                orderBy.append(entry.getKey()).append(" ").append(entry.getValue());
            }
        }
        if (orderBy.length() > 0){
            orderBy.insert(0," ORDER BY ");
        }
        return orderBy.toString();
    }

    private void carregarSortMap() {
        if (isBlank(sort)) {
            return;
        }

        final String[] ordenacoes = sort.split(SEPARADOR_ORDENACOES);
        if (ordenacoes.length < 1) {
            return;
        }

        this.sortMap = new HashMap<>();
        for (String ordenacao : ordenacoes) {
            final String[] ordem = ordenacao.split(SEPARADOR_ORDENACAO);
            if (ordem.length < 2) {
                continue;
            }

            this.sortMap.put(ordem[INDEX_CAMPO_ORDENAR], ordem[INDEX_DIRECAO_ORDENACAO]);
        }
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

}
