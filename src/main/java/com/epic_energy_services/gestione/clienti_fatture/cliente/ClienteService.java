package com.epic_energy_services.gestione.clienti_fatture.cliente;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	public Page<Cliente> findAll(int pagina, int dimensioniPagina) {
		return repo.findAll(PageRequest.of(pagina, dimensioniPagina));
	}
	
	
	public List<Cliente> findByName(int pagina, int dimensioniPagina) {
		return repo.findAllByOrderByNomeContattoAsc(PageRequest.of(pagina, dimensioniPagina, Sort.by("nomeContatto").ascending())); 		
	}
	
	public List<Cliente> findByFatturato(){
		return repo.findByOrderByFatturatoAnnualeAsc(); 
	}
	
	public List<Cliente> findByDataInserimento(){
		return repo.findByOrderByDataInserimentoAsc(); 
		
	}
	
	public List<Cliente> findByDataUltimoContatto(){
		return repo.findByOrderByDataUltimoContattoAsc(); 
		
	}
	
	public List<Cliente> findByProvinciaSedeLegale(){
		return repo.findByOrderByProvinciaSedeLegaleAsc(); 
		
	}
	
	}

	
	

