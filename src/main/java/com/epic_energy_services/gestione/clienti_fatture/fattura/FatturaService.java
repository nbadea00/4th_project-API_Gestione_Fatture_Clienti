package com.epic_energy_services.gestione.clienti_fatture.fattura;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.epic_energy_services.gestione.clienti_fatture.auth.exception.MyAPIException;
import com.epic_energy_services.gestione.clienti_fatture.auth.exception.ResourceNotFoundException;
import com.epic_energy_services.gestione.clienti_fatture.cliente.Cliente;
import com.epic_energy_services.gestione.clienti_fatture.cliente.ClienteService;

@Service
public class FatturaService {
	
	@Autowired FatturaRepository repo;
	@Autowired ClienteService cliServ;
	
	public Fattura createFattura (Fattura f, Long idCliente) {
		if(idCliente != -1) {
			Cliente c = cliServ.findById(idCliente);
			if(f.getData().before(c.getDataInserimento())) throw new MyAPIException(HttpStatus.BAD_REQUEST, "Data fattura precede Data insermento del cliente!");
			f.setCliente(c);
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(f.getData());
		
		if(cal.get(Calendar.YEAR) != f.getAnno()) throw new MyAPIException(HttpStatus.BAD_REQUEST, "Data fattura e anno fattura non corispondono!");
		
		return repo.save(f);
	}
	
	public Fattura updateFattura (Fattura f, Long id) {
		if( id == null) throw new MyAPIException(HttpStatus.NOT_FOUND, "Id non trovato");
		
		f.setId(id);
		if(f.getCliente() == null) f.setCliente(repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fattura", "id", id)).getCliente());
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(f.getData());
		
		if(cal.get(Calendar.YEAR) != f.getAnno()) throw new MyAPIException(HttpStatus.BAD_REQUEST, "Data fattura e anno fattura non corispondono!");
		if(f.getData().before(f.getCliente().getDataInserimento())) throw new MyAPIException(HttpStatus.BAD_REQUEST, "Data fattura precede Data insermento del cliente!");
		f.setId(id);
		return repo.save(f);
	}
	
	public void removeFattura (Fattura f) {
		repo.delete(f);
	}
	
	public void removeFatturaById(Long id) {
		repo.deleteById(id);
	}
	
	public Fattura findById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fattura", "id", id));
	}
	
	public Page<Fattura> findAll(int pagina, int dim) {
		return repo.findAll(PageRequest.of(pagina, dim));
	}
	
	public Page<Fattura> getFatturaByIdCliente(Long id,int pagina, int dim){
		return repo.findByCliente(cliServ.findById(id), PageRequest.of(pagina, dim));
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
