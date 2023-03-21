package com.epic_energy_services.gestione.clienti_fatture.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repo;
	
	public Cliente createCliente (Cliente c) {
		repo.save(c);
		System.out.println("Cliente creato");
		return c;
	}
	
	public Cliente updateCliente (Cliente c) {
		repo.save(c);
		System.out.println("Cliente aggiornato");
		return c;
	}
	
	public void removeCliente (Cliente c) {
		repo.delete(c);
		System.out.println("Cliente rimosso");
	}
	
	public String removeClienteById (Long id) { 
		repo.deleteById(id);
		return "Cliente rimossso by id";
	}
	
	
	
	public Cliente findById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Cliente> findAll() {
		return (List<Cliente>) repo.findAll();
	}

	
	
}
