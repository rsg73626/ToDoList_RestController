package br.senai.sp.todolist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.sp.todolist.model.Tarefa;

@Repository
public class TarefaDAO {
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void create(Tarefa tarefa){
		manager.persist(tarefa);
	}
	
	public List<Tarefa> read(){
		return manager.createQuery("SELECT t FROM Tarefa t", Tarefa.class).getResultList();
	}
}
