package com.teste.clientes.uteis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityFactory {

    /**
     * Popula um objeto {@link ResponseEntity} com o objeto no corpo e o status http
     *
     * @param payload    Corpo da mensagem
     * @param httpStatus Status http da entidade
     * @param <C>        Classe DTO do objeto que vai no corpo da mensagem
     * @return Uma instância de {@link ResponseEntity}
     */
    public static <C> ResponseEntity<C> of(C payload, HttpStatus httpStatus) {
        return new ResponseEntity<C>(payload, httpStatus);
    }

    /**
     * Popula um objeto {@link ResponseEntity} com o objeto no corpo e o status {@link HttpStatus#OK}
     *
     * @param envelopeRespostaDTO Corpo da mensagem
     * @return Uma instância de {@link ResponseEntity}
     */
    public static ResponseEntity<EnvelopeRespostaDTO> ok(EnvelopeRespostaDTO envelopeRespostaDTO) {
        return of(envelopeRespostaDTO, HttpStatus.OK);
    }

    /**
     * Popula um objeto {@link ResponseEntity} com um objeto {@link EnvelopeRespostaDTO} no corpo e o
     * status {@link HttpStatus#OK}
     *
     * @param payload      Corpo da mensagem
     * @param paginadorDTO Objeto de paginação
     * @return Uma instância de {@link ResponseEntity}
     */
    public static ResponseEntity<EnvelopeRespostaDTO> ok(Object payload, PaginadorDTO paginadorDTO) {
        return of(EnvelopeRespostaDTO.of(payload, paginadorDTO), HttpStatus.OK);
    }

    /**
     * Popula um objeto {@link ResponseEntity} com um objeto {@link EnvelopeRespostaDTO} no corpo e o
     * status {@link HttpStatus#OK}
     *
     * @param payload Corpo da mensagem
     * @return Uma instância de {@link ResponseEntity}
     */
    public static ResponseEntity<EnvelopeRespostaDTO> ok(Object payload) {
        return of(EnvelopeRespostaDTO.of(payload), HttpStatus.OK);
    }

    /**
     * Popula um objeto {@link ResponseEntity} sem corpo
     *
     * @return Uma instância de {@link ResponseEntity}
     * @see ResponseEntityFactory#ok(EnvelopeRespostaDTO)
     */
    public static ResponseEntity<EnvelopeRespostaDTO> ok() {
        return ok(EnvelopeRespostaDTO.emBranco());
    }

    /**
     * Constrói uma entidade de resposta com o status {@link HttpStatus#INTERNAL_SERVER_ERROR}
     *
     * @param erro         Marcador do erro
     * @param errorMessage Mensagem detalhando o erro
     * @return Uma instância de {@link ResponseEntity} com os dados do erro interno
     * @see ResponseEntityFactory#of(Object, HttpStatus)
     */
    public static ResponseEntity<EnvelopeRespostaDTO> erroInterno(String erro, String errorMessage) {
        return of(EnvelopeRespostaDTO.erro(erro, errorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public static ResponseEntity<EnvelopeRespostaDTO> erroConhecido(String erro, String errorMessage) {
        return of(EnvelopeRespostaDTO.erro(erro, errorMessage), HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<EnvelopeRespostaDTO> erroRegistroDuplicado(String erro, String errorMessage) {
        return of(EnvelopeRespostaDTO.erro(erro, errorMessage), HttpStatus.CONFLICT);
    }

    public static ResponseEntity<EnvelopeRespostaDTO> erroRegistroEstaSendoUtilizado(String erro, String errorMessage) {
        return of(EnvelopeRespostaDTO.erro(erro, errorMessage), HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<EnvelopeRespostaDTO> erroRegistroNotFoun(String erro, String errorMessage) {
        return of(EnvelopeRespostaDTO.erro(erro, errorMessage), HttpStatus.NOT_FOUND);
    }
    public static ResponseEntity<EnvelopeRespostaDTO> erroNoContent(String erro, String errorMessage) {
        return of(EnvelopeRespostaDTO.erro(erro, errorMessage), HttpStatus.NO_CONTENT);
    }

    /**
     * Constrói uma resposta padrão da API com o status de erro {@link HttpStatus#FORBIDDEN} setado
     *
     * @param envelopeRespostaDTO Conteúdo da mensagem de erro
     * @return
     */
    public static ResponseEntity<EnvelopeRespostaDTO> proibido(EnvelopeRespostaDTO envelopeRespostaDTO) {
        return of(envelopeRespostaDTO, HttpStatus.FORBIDDEN);
    }

    /**
     * Constrói uma de erro com os dados padrão
     * <ul>
     * <li>erro: sem_permissao</li>
     * <li>errorMessage: Não tem permissão para requisitar esse endpoint.</li>
     * </ul>
     *
     * @return O objeto de resposta padrão da API preenchido
     */
    public static ResponseEntity<EnvelopeRespostaDTO> proibido() {
        return proibido(EnvelopeRespostaDTO.erro("sem_permissao", "Não tem permissão para requisitar esse endpoint."));
    }

}