package org.ProjetoSpringBoot.Controllers;

import java.util.List;
import org.ProjetoSpringBoot.Models.Comida;
import org.ProjetoSpringBoot.Services.ComidasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/comidas")
public class ComidasController {

	private final ComidasService comidasService;
	
	public ComidasController(ComidasService comidasService) {
		this.comidasService = comidasService;
	}
	
	@GetMapping
	public List<Comida> obterComidas() {
		return comidasService.obterTodasAsComidas();
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Buscar comida por ID")
	@ApiResponses({
	        @ApiResponse(responseCode = "200", description = "Comida encontrada"),
	        @ApiResponse(responseCode = "404", description = "Comida não encontrada"),
	        @ApiResponse(responseCode = "500", description = "Erro interno")
	})
	public ResponseEntity<Comida> obterComida(@Valid @PathVariable Long id) {
	    return ResponseEntity.ok(comidasService.obterComidaPorId(id));
	}
	
	@PostMapping
	public Comida adicionarComida(@Valid @RequestBody Comida comida) {
		return comidasService.adicionarComida(comida);
	}
	
	@PutMapping("/{id}")
	public Comida atualizarComida(@Valid @PathVariable Long id, @RequestBody Comida comida) {
		return comidasService.atualizarComida(id, comida);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarComida(@Valid @PathVariable Long id) {
	    comidasService.deletarComida(id);
	    return ResponseEntity.noContent().build();
	}
}