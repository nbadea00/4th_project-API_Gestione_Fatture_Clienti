package com.epic_energy_services.gestione.clienti_fatture.fattura;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<Fattura> findAll() {
		return (List<Fattura>) repo.findAll();
	}
	
	public void removeFatturaById(Long id) {
		repo.deleteById(id);
	}
	
	public List<Fattura> getFatturaByIdCliente(Long id){
		Cliente c = cliServ.findById(id);
		return repo.findByCliente(c);
	}
	
	public List<Fattura> getFatturaByStatoFattura(StatoFattura stato){
		return repo.findByStatoFattura(stato);
	}
	
	public List<Fattura> getFatturaByData(Date data){
		return repo.findByData(data);
	}
	
	public List<Fattura> getFatturaByAnno(Integer anno){
		return repo.findByAnno(anno);
	}
	
	public List<Fattura> getFatturaByRangeImport(BigDecimal imp1,BigDecimal imp2){
		return repo.findByImportoBetween(imp1, imp2);
	}
}
