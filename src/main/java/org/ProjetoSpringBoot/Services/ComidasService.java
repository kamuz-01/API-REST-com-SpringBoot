package org.ProjetoSpringBoot.Services;

import java.util.List;
import org.ProjetoSpringBoot.GerenciamentoErros.RecursosNaoEncontradosException;
import org.ProjetoSpringBoot.Models.Comida;
import org.ProjetoSpringBoot.Repository.ComidasRepository;
import org.springframework.stereotype.Service;

@Service
public class ComidasService {
	
	private final ComidasRepository comidasRepository;
	
	public ComidasService(ComidasRepository comidasRepository) {
		this.comidasRepository = comidasRepository;
	}

	// Método para obter (LISTAR) todas as comidas
	public List<Comida> obterTodasAsComidas() {
		return comidasRepository.findAll();
	}
	
	// Método para obter uma comida pelo ID
	/*public Comida obterComidaPorId(Long id) {
		return comidasRepository.findById(id).orElse(null);
	}*/
	
	public Comida obterComidaPorId(Long id) {
	    return comidasRepository.findById(id)
	        .orElseThrow(() ->
	            new RecursosNaoEncontradosException("Comida com id " + id + " não encontrada")
	        );
	}

	// Método para adicionar uma comida
	public Comida adicionarComida(Comida comida) {
		return comidasRepository.save(comida);
	}
	
	// Método para deletar uma comida
	public void deletarComida(Long id) {

	    Comida comida = comidasRepository.findById(id)
	        .orElseThrow(() ->
	            new RecursosNaoEncontradosException("Comida com id " + id + " não encontrada")
	        );

	    comidasRepository.delete(comida);
	}
	
	// Método para atualizar uma comida
	public Comida atualizarComida(Long id, Comida comida) {

	    Comida existente = comidasRepository.findById(id)
	        .orElseThrow(() ->
	            new RecursosNaoEncontradosException("Comida com id " + id + " não encontrada")
	        );

	    existente.setNome(comida.getNome());
	    existente.setQuantidade(comida.getQuantidade());
	    existente.setDataValidade(comida.getDataValidade());

	    return comidasRepository.save(existente);
	}
}