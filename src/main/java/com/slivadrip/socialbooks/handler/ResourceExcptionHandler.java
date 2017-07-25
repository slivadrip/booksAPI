package com.slivadrip.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.slivadrip.socialbooks.domain.DetalhesErro;
import com.slivadrip.socialbooks.services.exceptions.AutorExistenteException;
import com.slivadrip.socialbooks.services.exceptions.AutorNaoEncontradoException;
import com.slivadrip.socialbooks.services.exceptions.LivroNaoEncrontadoExcption;

@ControllerAdvice
public class ResourceExcptionHandler {

	@ExceptionHandler(LivroNaoEncrontadoExcption.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontradoExcption
		(LivroNaoEncrontadoExcption e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O livro não pode ser encontrado");
		erro.setMensagemDesenvolvedor("http://erros.social.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}
	
	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<DetalhesErro> handleAutorExistenteException
		(AutorExistenteException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("O Autor ja existente");
		erro.setMensagemDesenvolvedor("http://erros.social.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
	}
	
	@ExceptionHandler(AutorNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleAutorNaoEncontradoException
		(AutorNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O autor não pode ser encontrado");
		erro.setMensagemDesenvolvedor("http://erros.social.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException
		(DataIntegrityViolationException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisão invalida");
		erro.setMensagemDesenvolvedor("http://erros.social.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
		
	}
}
