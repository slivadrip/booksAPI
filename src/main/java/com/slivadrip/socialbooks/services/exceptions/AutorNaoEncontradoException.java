package com.slivadrip.socialbooks.services.exceptions;

public class AutorNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5584220636560061629L;

	public AutorNaoEncontradoException(String menssagem) {
			super(menssagem);
		}
	
	public AutorNaoEncontradoException(String menssagem, Throwable causa) {
		super(menssagem, causa);
		}
}
