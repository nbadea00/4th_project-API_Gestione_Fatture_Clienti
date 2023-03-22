package com.epic_energy_services.gestione.clienti_fatture.cliente;


import java.math.BigDecimal;
import java.sql.Date;
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
		return repo.findByNomeContattoLike(nome,PageRequest.of(pagina, dimensioniPagina));
	
	}

	
	

}




	

