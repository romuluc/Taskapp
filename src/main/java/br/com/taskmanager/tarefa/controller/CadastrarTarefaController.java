package br.com.taskmanager.tarefa.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
 
import br.com.taskmanager.model.TarefaModel;
import br.com.taskmanager.repository.TarefaRepository;
import br.com.taskmanager.uteis.Uteis;

@Named(value="cadastrarTarefaController")
@RequestScoped
public class CadastrarTarefaController {
	
	@Inject
	TarefaModel tarefaModel;
 
	@Inject
	TarefaRepository tarefaRepository;
 
	public TarefaModel getTarefaModel() {
		return tarefaModel;
	}
 
	public void setTarefaModel(TarefaModel tarefaModel) {
		this.tarefaModel = tarefaModel;
	}
 
	/**
	 *SALVA UM NOVO REGISTRO
	 */
	public void SalvarNovaTarefa(){
 
		//pessoaModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());
 
		//INFORMANDO QUE O CADASTRO FOI VIA INPUT
		//pessoaModel.setOrigemCadastro("I");
 
		tarefaRepository.SalvarNovoRegistro(this.tarefaModel);
 
		this.tarefaModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}

}
