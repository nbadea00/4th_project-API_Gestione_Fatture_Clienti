package com.epic_energy_services.gestione.clienti_fatture.fattura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FatturaService {
	
	@Autowired
	FatturaRepository repo;
	
	public Fattura createFattura (Fattura f) {
		repo.save(f);
		System.out.println("Fattura creata");
		return f;
	}
	
	public Fattura updateFattura (Fattura f) {
		repo.save(f);
		System.out.println("Fattura aggiornata");
		return f;
	}
	
	public void removeFattura (Fattura f) {
		repo.delete(f);
		System.out.println("Fattura rimossa");
	}
	
	public Fattura findById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Fattura> findAll() {
		return (List<Fattura>) repo.findAll();
	}

}
