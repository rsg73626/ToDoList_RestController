package br.senai.sp.todolist.controller;

import java.net.URI;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.todolist.dao.TarefaDAO;
import br.senai.sp.todolist.model.Item;
import br.senai.sp.todolist.model.Tarefa;

@RestController
public class TarefaRestController {
	@Autowired
	private TarefaDAO dao;

	@RequestMapping(value="lista", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> create(@RequestBody Tarefa tarefa){
		try{
			for(Item i:tarefa.getItens()){
				i.setTarefa(tarefa);
			}
			dao.create(tarefa);
			return ResponseEntity.created(new URI("/lista/"+tarefa.getId())).body(tarefa);
		}catch(ConstraintViolationException cve){
			String message = "";
			for(ConstraintViolation<?> constrain:cve.getConstraintViolations()){
				message+=constrain.getMessage()+"\n";
			}
			return ResponseEntity.badRequest().body(message);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
