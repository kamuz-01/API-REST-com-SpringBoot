package org.ProjetoSpringBoot.Repository;

import org.ProjetoSpringBoot.Models.Comida;
import org.springframework.data.jpa.repository.JpaRepository;

/* O repositório pede dois parâmetros: a entidade que representa o 
 * domínio e o tipo do ID do domínio */
public interface ComidasRepository extends JpaRepository<Comida, Long> {}