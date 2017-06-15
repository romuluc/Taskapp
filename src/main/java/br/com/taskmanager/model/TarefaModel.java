package br.com.taskmanager.model;

import java.time.LocalDateTime;

public class TarefaModel {
	
	private Integer 	codigo;
	private String  	descricao;
	private String  	resposta;
	private LocalDateTime	dataCriacao;
	private LocalDateTime	dataConclusao;
	private String  	concluida;
	private UsuarioModel    usuarioModel;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public LocalDateTime getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(LocalDateTime dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public String getConcluida() {
		return concluida;
	}
	public void setConcluida(String concluida) {
		this.concluida = concluida;
	}
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
}
