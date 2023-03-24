package com.epic_energy_services.gestione.clienti_fatture.cliente;


import java.math.BigDecimal;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.epic_energy_services.gestione.clienti_fatture.auth.exception.MyAPIException;
import com.epic_energy_services.gestione.clienti_fatture.auth.exception.ResourceNotFoundException;

import jakarta.persistence.EntityExistsException;

@Service
public class ClienteService {
	
	@Autowired ClienteRepository repo;
	
	public Cliente createCliente (Cliente c) {
		
		if(c.getDataInserimento().after(c.getDataUltimoContatto())) throw new MyAPIException(HttpStatus.FORBIDDEN,"Data Ultimo Contatto precede Data Inserimento");		
		if(repo.findByEmail(c.getEmail()).isPresent()) throw new EntityExistsException("Email già in uso");
		if(repo.findByEmailContatto(c.getEmailContatto()).isPresent()) throw new EntityExistsException("Email contatto già in uso");
		if(repo.findByPartitaIva(c.getPartitaIva()).isPresent()) throw new EntityExistsException("Partita Iva già in uso");
		if(repo.findByPec(c.getEmailContatto()).isPresent()) throw new EntityExistsException("Pec già in uso");
		if(repo.findByTelefonoContatto(c.getTelefonoContatto()).isPresent()) throw new EntityExistsException("Telefono contatto già in uso");
		if(repo.findByTelefono(c.getTelefono()).isPresent()) throw new EntityExistsException("Telefono già in uso");
		return repo.save(c);
	}
	
	public Cliente updateCliente (Cliente c, Long id) {
		
		c.setId(id);
		
		if(c.getId() == null) throw new MyAPIException(HttpStatus.NOT_FOUND, "Id non trovato");
		if(c.getDataInserimento().after(c.getDataUltimoContatto())) throw new MyAPIException(HttpStatus.FORBIDDEN,"Data Ultimo Contatto precede Data Inserimento");		
		if(repo.findByEmailAndIdNot(c.getEmail(), c.getId()).isPresent()) throw new EntityExistsException("Email già in uso");
		if(repo.findByEmailContattoAndIdNot(c.getEmailContatto(), c.getId()).isPresent()) throw new EntityExistsException("Email contatto già in uso");
		if(repo.findByPartitaIvaAndIdNot(c.getPartitaIva(), c.getId()).isPresent()) throw new EntityExistsException("Partita Iva già in uso");
		if(repo.findByPecAndIdNot(c.getEmailContatto(), c.getId()).isPresent()) throw new EntityExistsException("Pec già in uso");
		if(repo.findByTelefonoContattoAndIdNot(c.getTelefonoContatto(), c.getId()).isPresent()) throw new EntityExistsException("Telefono contatto già in uso");
		if(repo.findByTelefonoAndIdNot(c.getTelefono(), c.getId()).isPresent()) throw new EntityExistsException("Telefono già in uso");
		return repo.save(c);
	}
	
	public void removeCliente (Cliente c) {
		repo.delete(c);
	}
	
	public String removeClienteById (Long id) {
		repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));
		repo.deleteById(id);
		return "Cliente rimossso by id";
	}
	
	
	public Cliente findById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));
	}
	
	public Page<Cliente> findAll(int pagina, int dimensioniPagina) {
		return repo.findAll(PageRequest.of(pagina, dimensioniPagina));
	}
	
	
	public Page<Cliente> orderByName(int pagina, int dimensioniPagina) {
		return repo.findAll(PageRequest.of(pagina, dimensioniPagina, Sort.by("nomeContatto").ascending())); 		
	}
	
	public Page<Cliente> orderByFatturato(int pagina, int dimensioniPagina){
		return repo.findAll(PageRequest.of(pagina, dimensioniPagina, Sort.by("fatturatoAnnuale").ascending())); 
	}
	
	public Page<Cliente> orderByDataInserimento(int pagina, int dimensioniPagina){
		return repo.findAll(PageRequest.of(pagina, dimensioniPagina, Sort.by("dataInserimento").ascending())); 
		
	}
	
	public Page<Cliente> orderByDataUltimoContatto(int pagina, int dimensioniPagina){
		return repo.findAll(PageRequest.of(pagina, dimensioniPagina, Sort.by("dataUltimoContatto").ascending())); 
		
	}
	
	public Page<Cliente> orderByProvinciaSedeLegale(int pagina, int dimensioniPagina){
		return repo.findByOrderByProvinciaSedeLegaleAsc(PageRequest.of(pagina, dimensioniPagina)); 
		
	}
	
	
	public Page<Cliente> findByFatturatoAnnuale(BigDecimal fatturatoMinimo, BigDecimal fatturatoMassimo, int pagina, int dimensioniPagina) {
		return repo.findByFatturatoAnnualeBetween(fatturatoMinimo, fatturatoMassimo,PageRequest.of(pagina, dimensioniPagina));
	}

	
	public Page<Cliente> findByDataInserimento(Date dataInizio,Date dataFine, int pagina, int dimensioniPagina) {
		return repo.findByDataInserimentoBetween(dataInizio, dataFine,PageRequest.of(pagina, dimensioniPagina));
	
	}

	public Page<Cliente> findByDataUltimoContatto(Date dataInizio,Date dataFine, int pagina, int dimensioniPagina) {
		return repo.findByDataUltimoContattoBetween(dataInizio, dataFine,PageRequest.of(pagina, dimensioniPagina));
	
	}


	public Page<Cliente> findbyParteNome(String nome, int pagina, int dimensioniPagina) {
		return repo.findByNomeContattoContains(nome,PageRequest.of(pagina, dimensioniPagina));
	
	}

}




	

