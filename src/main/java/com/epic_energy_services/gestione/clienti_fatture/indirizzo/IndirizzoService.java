package com.epic_energy_services.gestione.clienti_fatture.indirizzo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epic_energy_services.gestione.clienti_fatture.auth.exception.ResourceNotFoundException;

@Service
public class IndirizzoService {
	
	@Autowired
	IndirizzoRepository repo;
	
	public Indirizzo createIndirizzo (Indirizzo i) {
		repo.save(i);
		System.out.println("Indirizzo creato");
		return i;
	}
	
	public Indirizzo updateIndirizzo (Indirizzo i) {
		repo.save(i);
		System.out.println("Indirizzo aggiornato");
		return i;
	}
	
	public void removeIndirizzo (Indirizzo i) {
		repo.delete(i);
		System.out.println("Indirizzo rimosso");
	}
	
	public Indirizzo findById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Indirizzo", "id", id));
	}
	
	public List<Indirizzo> findAll() {
		return (List<Indirizzo>) repo.findAll();
	}

	public void removeIndirizzoById(Long id) {
		repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Indirizzo", "id", id));
		repo.deleteById(id);
		System.out.println("Indirizzo rimosso");
	}

}
