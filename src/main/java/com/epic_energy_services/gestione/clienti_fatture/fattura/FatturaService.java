package com.epic_energy_services.gestione.clienti_fatture.fattura;

import java.math.BigDecimal;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.epic_energy_services.gestione.clienti_fatture.cliente.Cliente;
import com.epic_energy_services.gestione.clienti_fatture.cliente.ClienteService;

@Service
public class FatturaService {
	
	@Autowired
	FatturaRepository repo;
	@Autowired
	ClienteService cliServ;
	
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
	
	public Page<Fattura> findAll() {
		return (Page<Fattura>) repo.findAll();
	}
	
	public void removeFatturaById(Long id) {
		repo.deleteById(id);
	}
	
	public Page<Fattura> getFatturaByIdCliente(Long id,int pagina, int dim){
		Cliente c = cliServ.findById(id);
		return repo.findByCliente(c, PageRequest.of(pagina, dim));
	}
	
	public Page<Fattura> getFatturaByStatoFattura(StatoFattura stato,int pagina, int dim){
		return repo.findByStatoFattura(stato, PageRequest.of(pagina, dim));
	}
	
	public Page<Fattura> getFatturaByData(Date data,int pagina, int dim){
		return repo.findByData(data, PageRequest.of(pagina, dim));
	}
	
	public Page<Fattura> getFatturaByAnno(Integer anno,int pagina, int dim){
		return repo.findByAnno(anno, PageRequest.of(pagina, dim));
	}
	
	public Page<Fattura> getFatturaByRangeImport(BigDecimal imp1,BigDecimal imp2,int pagina, int dim){
		return repo.findByImportoBetween(imp1, imp2, PageRequest.of(pagina, dim));
	}
}
