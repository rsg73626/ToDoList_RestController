package br.senai.sp.todolist.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Item implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=3)
	private String descricao;
	private boolean feito;
	@ManyToOne
	@JoinColumn(name="tarefa_id")
	Tarefa tarefa;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFeito() {
		return feito;
	}
	public void setFeito(boolean feito) {
		this.feito = feito;
	}
	public Tarefa getTarefa() {
		return tarefa;
	}
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	

}
