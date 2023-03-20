package com.epic_energy_services.gestione.clienti_fatture.provincia;

import org.springframework.data.repository.CrudRepository;

public interface ProvinciaRepository extends CrudRepository<Provincia, Long> {
	
	public Provincia findByNome(String nome);
	public boolean existsByNome(String nome);

}
