package com.epic_energy_services.gestione.clienti_fatture.comune;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComuneService {
	
	@Autowired
	ComuneRepository repo;
	
	public Comune createComune (Comune c) {
		repo.save(c);
		System.out.println("Comune creato");
		return c;
	}
	
	public Comune updateComune (Comune c) {
		repo.save(c);
		System.out.println("Comune aggiornato");
		return c;
	}
	
	public void removeComune (Comune c) {
		repo.delete(c);
		System.out.println("Comune rimosso");
	}
	
	public Comune findById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Comune> findAll() {
		return (List<Comune>) repo.findAll();
	}
}
