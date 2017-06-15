package br.com.taskmanager.tarefa.controller;

import java.util.Hashtable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
 
import org.primefaces.model.chart.PieChartModel;

import br.com.taskmanager.repository.TarefaRepository;

@Named(value="graficoPizzaTarefaController")
@RequestScoped
public class GraficoPizzaTarefaController {
	
	@Inject
	private TarefaRepository tarefaRepository;
 
 
	private PieChartModel pieChartModel;
 
	public PieChartModel getPieChartModel() {
		return pieChartModel;
	}
 
	@PostConstruct
	public  void init(){
 
		this.pieChartModel = new PieChartModel();
 
		this.MontaGrafico();
	}
 
	/***
	 * MONTA O GRÁFICO NA PÁGINA
	 */
	private void MontaGrafico(){
 
		//CONSULTA OS DADOS PARA MONTAR O GRÁFICO
		Hashtable<String, Integer> hashtableRegistros = tarefaRepository.GetConcluida();
 
 
		//INFORMANDO OS VALORES PARA MONTAR O GRÁFICO
		hashtableRegistros.forEach((chave,valor) -> {
 
 
			pieChartModel.set(chave, valor);
 
		});
 
		pieChartModel.setTitle("Gráfico de Rendimento de Conclusão de Tarefas");
		pieChartModel.setShowDataLabels(true);
		pieChartModel.setLegendPosition("e");
 
 
	}

}
