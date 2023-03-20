package com.epic_energy_services.gestione.clienti_fatture.comune;

import org.springframework.data.repository.CrudRepository;

public interface ComuneRepository extends CrudRepository<Comune, Long> {
	
	public boolean existsByNome(String nome);

}
