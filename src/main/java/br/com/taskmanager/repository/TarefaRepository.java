package br.com.taskmanager.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import br.com.taskmanager.model.TarefaModel;
import br.com.taskmanager.model.UsuarioModel;
import br.com.taskmanager.repository.entity.TarefaEntity;
import br.com.taskmanager.repository.entity.UsuarioEntity;
import br.com.taskmanager.uteis.Uteis;

public class TarefaRepository {
	
	@Inject
	TarefaEntity tarefaEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVA TAREFA
	 * @param tarefaModel
	 */
	public void SalvarNovoRegistro(TarefaModel tarefaModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		tarefaEntity = new TarefaEntity();
		tarefaEntity.setDataCriacao(LocalDateTime.now());
		tarefaEntity.setDescricao(tarefaModel.getDescricao());
		tarefaEntity.setConcluida("N");
 
		//UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, pessoaModel.getUsuarioModel().getCodigo()); 
 
		//pessoaEntity.setUsuarioEntity(usuarioEntity);
 
		entityManager.persist(tarefaEntity);
 
	}
	
	/***
	 * MÉTODO PARA CONSULTAR AS TAREFAS
	 * @return
	 */
	public List<TarefaModel> GetTarefas(){
 
		List<TarefaModel> tarefasModel = new ArrayList<TarefaModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("TarefaEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<TarefaEntity> tarefasEntity = (Collection<TarefaEntity>)query.getResultList();
 
		TarefaModel tarefaModel = null;
 
		for (TarefaEntity tarefaEntity : tarefasEntity) {
 
			tarefaModel = new TarefaModel();
			tarefaModel.setCodigo(tarefaEntity.getCodigo());
			tarefaModel.setDescricao(tarefaEntity.getDescricao());
			tarefaModel.setDataCriacao(tarefaEntity.getDataCriacao());
			tarefaModel.setDataConclusao(tarefaEntity.getDataConclusao());
			tarefaModel.setResposta(tarefaEntity.getResposta());
			if(tarefaEntity.getConcluida().equals("N"))
				tarefaModel.setConcluida("Não");
			else
				tarefaModel.setConcluida("Sim");
			
			if (tarefaEntity.getUsuarioEntity() != null) {
				UsuarioEntity usuarioEntity =  tarefaEntity.getUsuarioEntity();	
				UsuarioModel usuarioModel = new UsuarioModel();
				usuarioModel.setCodigo(usuarioEntity.getCodigo());
				usuarioModel.setNome(usuarioEntity.getNome());
				tarefaModel.setUsuarioModel(usuarioModel);
			}
			tarefasModel.add(tarefaModel);
		}
 
		return tarefasModel;
 
	}
	
	/***
	 * CONSULTA UMA TAREFA CADASTRADA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	private TarefaEntity GetTarefa(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(TarefaEntity.class, codigo);
	}
	
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param tarefaModel
	 */
	public void PegarTarefa(TarefaModel tarefaModel){
 
		
		entityManager =  Uteis.JpaEntityManager();
 
		TarefaEntity tarefaEntity = this.GetTarefa(tarefaModel.getCodigo());
 
		tarefaEntity.setDescricao(tarefaModel.getDescricao());
		tarefaEntity.setConcluida(tarefaModel.getConcluida());
		
		UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, tarefaModel.getUsuarioModel().getCodigo()); 
		
		tarefaEntity.setUsuarioEntity(usuarioEntity);
		entityManager.merge(tarefaEntity);
		
	}
	
	public void LargarTarefa(TarefaModel tarefaModel){
 
		
		entityManager =  Uteis.JpaEntityManager();
 
		TarefaEntity tarefaEntity = this.GetTarefa(tarefaModel.getCodigo());
 
		tarefaEntity.setDescricao(tarefaModel.getDescricao());
		tarefaEntity.setConcluida(tarefaModel.getConcluida());
		
		tarefaEntity.setUsuarioEntity(null);
		entityManager.merge(tarefaEntity);
		
	}

	
	public void ConcluirTarefa(TarefaModel tarefaModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		TarefaEntity tarefaEntity = this.GetTarefa(tarefaModel.getCodigo());
 
		tarefaEntity.setDescricao(tarefaModel.getDescricao());
		tarefaEntity.setConcluida("S");
		tarefaEntity.setResposta(tarefaModel.getResposta());
		tarefaEntity.setDataConclusao(LocalDateTime.now());
		
		UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, tarefaModel.getUsuarioModel().getCodigo()); 
		
		tarefaEntity.setUsuarioEntity(usuarioEntity);
		entityManager.merge(tarefaEntity);
		
	}
	
	/***
	 * RETORNA OS TIPOS DE TAREFA AGRUPADAmS
	 * @return
	 */
	public Hashtable<String, Integer> GetConcluida(){
 
		Hashtable<String, Integer> hashtableRegistros = new Hashtable<String,Integer>(); 
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("TarefaEntity.GroupByConcluida");
 
		@SuppressWarnings("unchecked")
		Collection<Object[]> collectionRegistros  = (Collection<Object[]>)query.getResultList();
 
		for (Object[] objects : collectionRegistros) {
 
 
			String tarefaConcluida 		= (String)objects[0];
			int	   totalDeRegistros = ((Number)objects[1]).intValue();
 
			if(tarefaConcluida.equals("N"))
				tarefaConcluida = "ABERTAS";
			else
				tarefaConcluida = "FINALIZADAS";
 
			hashtableRegistros.put(tarefaConcluida, totalDeRegistros);
 
		}
 
		return hashtableRegistros;
 
	}
}
