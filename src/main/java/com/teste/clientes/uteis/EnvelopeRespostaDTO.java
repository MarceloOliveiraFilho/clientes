package com.teste.clientes.uteis;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnvelopeRespostaDTO {

    private Meta meta;
    private Object content;
    private Long totalElements;
    private Long totalPages;
    private Boolean first;
    private Boolean last;
    private Long numberOfElements;
    private Long size;
    private Long number;

    /**
     * @param meta Metadados da resposta HTTP
     * @return Uma instância de {@link EnvelopeRespostaDTO} com os metadados inseridos.
     */
    public static EnvelopeRespostaDTO of(Meta meta) {
        return of(meta, (Object) null);
    }

    /**
     * @return Uma instancia de {@link EnvelopeRespostaDTO} sem qualquer dado preenchido
     */
    public static EnvelopeRespostaDTO emBranco() {
        return new EnvelopeRespostaDTO();
    }

    /**
     * @param erro         Marcador do erro
     * @param errorMessage Mensagem de erro mais detalhada
     * @return Uma instância de {@link EnvelopeRespostaDTO} com os metadados inseridos.
     */
    public static EnvelopeRespostaDTO erro(String erro, String errorMessage) {
        return of(new Meta(erro, errorMessage));
    }

    /**
     * @param content Conteúdo da resposta HTTP
     * @return Uma instância de {@link EnvelopeRespostaDTO} com o conteúdo inserido.
     */
    public static EnvelopeRespostaDTO of(Object content) {
        return of(null, content);
    }

    /**
     * @param meta    Metadados da resposta HTTP
     * @param content Conteúdo da resposta HTTP
     * @return Uma instância de {@link EnvelopeRespostaDTO} com os metadados e o conteúdo inseridos.
     */
    public static EnvelopeRespostaDTO of(Meta meta, Object content) {
        return of(meta, content, null);
    }

    /**
     * @param content      Conteúdo da resposta HTTP
     * @param paginadorDTO Objeto de paginação da aplicação
     * @return Uma instância de {@link EnvelopeRespostaDTO} com os metadados e o conteúdo inseridos.
     */
    public static EnvelopeRespostaDTO of(Object content, PaginadorDTO paginadorDTO) {
        return of(null, content, paginadorDTO);
    }

    /**
     * @param meta         Metadados da resposta HTTP
     * @param content      Conteúdo da resposta HTTP
     * @param paginadorDTO Objeto de paginação
     * @return Uma instância de {@link EnvelopeRespostaDTO} com os metadados e o conteúdo inseridos.
     */
    public static EnvelopeRespostaDTO of(Meta meta, Object content, PaginadorDTO paginadorDTO) {
        EnvelopeRespostaDTO envelopeRespostaDTO = new EnvelopeRespostaDTO();
        envelopeRespostaDTO.setMeta(meta);
        envelopeRespostaDTO.setContent(content);

        if (paginadorDTO != null && content instanceof List) {
            List contentList = (List) content;
            Boolean primeiraPagina = paginadorDTO.getPage() == null || paginadorDTO.getPage() == 0;
            Boolean ultimaPagina = contentList.size() < paginadorDTO.getSize() ||
                    (paginadorDTO.getQuantidadeTotalElementos() - paginadorDTO.getSize() <= paginadorDTO.getPage() * paginadorDTO.getSize());

            envelopeRespostaDTO.setTotalElements(paginadorDTO.getQuantidadeTotalElementos());
            envelopeRespostaDTO.setTotalPages(paginadorDTO.getQuantidadeTotalElementos() / paginadorDTO.getSize());
            envelopeRespostaDTO.setFirst(primeiraPagina);
            envelopeRespostaDTO.setLast(ultimaPagina);
            envelopeRespostaDTO.setTotalElements(paginadorDTO.getQuantidadeTotalElementos());
            envelopeRespostaDTO.setSize(paginadorDTO.getSize());
            envelopeRespostaDTO.setNumber(paginadorDTO.getPage());
        }

        return envelopeRespostaDTO;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Boolean getFirst() {
        return first;
    }

    public void setFirst(Boolean first) {
        this.first = first;
    }

    public Boolean getLast() {
        return last;
    }

    public void setLast(Boolean last) {
        this.last = last;
    }

    public Long getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(Long numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public static class Meta {
        private String error;
        private String message;

        public Meta(String error, String message) {
            this.error = error;
            this.message = message;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
