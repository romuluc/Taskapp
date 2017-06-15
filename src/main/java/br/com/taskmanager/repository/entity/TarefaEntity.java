package br.com.taskmanager.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tarefa")

@NamedQueries({
	 
	@NamedQuery(name = "TarefaEntity.findAll",query= "SELECT t FROM TarefaEntity t"),
	@NamedQuery(name = "TarefaEntity.GroupByConcluida",query= "SELECT t.concluida, count(t) as total FROM TarefaEntity t GROUP By t.concluida")
})

public class TarefaEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer codigo;
 
	@Column(name = "descricao")
	private String  descricao;
 
	@Column(name = "resposta")
	private String  resposta;
 
	@Column(name = "data_criacao")
	private LocalDateTime	dataCriacao;
 
	@Column(name = "data_conclusao")
	private LocalDateTime  dataConclusao;
 
	@Column(name = "concluida")
	private String  concluida;
 
	@OneToOne
	@JoinColumn(name="id_usuario_atrib")
	private UsuarioEntity usuarioEntity;
	 
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

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}


	
}