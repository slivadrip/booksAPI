package com.slivadrip.socialbooks.services.exceptions;

public class AutorExistenteException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4336546444992223184L;

	public AutorExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public AutorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
