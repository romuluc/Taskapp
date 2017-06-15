package br.com.taskmanager.tarefa.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
 
import br.com.taskmanager.model.TarefaModel;
import br.com.taskmanager.repository.TarefaRepository;
import br.com.taskmanager.usuario.controller.UsuarioController;

@Named(value="consultarTarefaController")
@ViewScoped
public class ConsultarTarefaController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 
	@Inject
	UsuarioController usuarioController;
	
	@Inject transient
	private TarefaModel tarefaModel;
 
	@Produces 
	private List<TarefaModel> tarefas;
 
	@Inject transient
	private TarefaRepository tarefaRepository;
 
	public List<TarefaModel> getTarefas() {
		return tarefas;
	}
	public void setTarefas(List<TarefaModel> tarefas) {
		this.tarefas = tarefas;
	}		
	public TarefaModel getTarefaModel() {
		return tarefaModel;
	}
	public void setTarefaModel(TarefaModel tarefaModel) {
		this.tarefaModel = tarefaModel;
	}
 
	/***
	 * CARREGA AS TAREFAS NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		//RETORNAR AS TAREFAS CADASTRADAS
		this.tarefas = tarefaRepository.GetTarefas();
	}
	
	/***
	 * CARREGA INFORMAÇÕES DE UMA TAREFA PARA SER EDITADA
	 * @param tarefaModel
	 */
	public void Editar(TarefaModel tarefaModel){
		
		/*PEGA APENAS A PRIMEIRA LETRA DO CONCLUIDA PARA SETAR NO CAMPO(S OU N)*/
		tarefaModel.setConcluida(tarefaModel.getConcluida().substring(0, 1));
 
		this.tarefaModel = tarefaModel;
 
	}
	
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO (PEGAR TAREFA)
	 */
	public void PegarTarefa(){
		
		
		tarefaModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());
		
		this.tarefaRepository.PegarTarefa(this.tarefaModel);	
 
		/*RECARREGA OS REGISTROS*/
		this.init();
		
	}
	
	
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO (LARGAR TAREFA)
	 */
	public void LargarTarefa(){
		
		
		this.tarefaRepository.LargarTarefa(this.tarefaModel);
 
		/*RECARREGA OS REGISTROS*/
		this.init();
		
	}
	
	
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO (CONLUIR TAREFA)
	 */
	public void ConcluirTarefa(){
		
		this.tarefaRepository.ConcluirTarefa(this.tarefaModel);
 
		/*RECARREGA OS REGISTROS*/
		this.init();
		
	}

}
