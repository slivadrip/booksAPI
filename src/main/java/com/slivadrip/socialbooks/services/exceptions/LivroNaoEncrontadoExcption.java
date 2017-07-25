package com.slivadrip.socialbooks.services.exceptions;

public class LivroNaoEncrontadoExcption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7125025476742882749L;

	public LivroNaoEncrontadoExcption(String mensagem){
		super(mensagem);
	}
	
	public LivroNaoEncrontadoExcption(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
