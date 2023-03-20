package com.epic_energy_services.gestione.clienti_fatture.provincia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityExistsException;

@Service
public class ProvinciaService {
	
	@Autowired
	ProvinciaRepository repo;
	
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
	
	public Provincia getById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Provincia> getAll() {
		return (List<Provincia>) repo.findAll();
	}
	
	public Provincia getByNome(String s) {
		return repo.findByNome(s);
	}
}
