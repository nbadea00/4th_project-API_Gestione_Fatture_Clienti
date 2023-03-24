package com.epic_energy_services.gestione.clienti_fatture.provincia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epic_energy_services.gestione.clienti_fatture.auth.exception.ResourceNotFoundException;

@Service
public class ProvinciaService {
	
	@Autowired ProvinciaRepository repo;
	
	public Provincia createProvincia (Provincia p) {
		repo.save(p);
		System.out.println("Provincia creata");
		return p;
	}
	
	public Provincia updateProvincia (Provincia p) {
		repo.save(p);
		System.out.println("Provincia aggiornata");
		return p;
	}
	
	public void removeProvincia (Provincia p) {
		repo.delete(p);
		System.out.println("Provincia rimossa");
	}
	
	public void removeProvinciaById (Long id) {
		repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Provincia", "id", id));
		repo.deleteById(id);
		System.out.println("Provincia rimossa");
	}
	
	public Provincia findById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Provincia", "id", id));
	}
	
	public List<Provincia> findAll() {
		return (List<Provincia>) repo.findAll();
	}
	
	public Provincia findByNome(String s) {
		return repo.findByNome(s);
	}
}
