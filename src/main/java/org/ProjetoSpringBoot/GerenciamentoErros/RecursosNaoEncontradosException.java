package org.ProjetoSpringBoot.GerenciamentoErros;

public class RecursosNaoEncontradosException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecursosNaoEncontradosException(String message) {
		super(message);
	}
}