package com.epic_energy_services.gestione.clienti_fatture.fattura;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epic_energy_services.gestione.clienti_fatture.cliente.Cliente;

public interface FatturaRepository extends CrudRepository<Fattura, Long> {
				
	 List<Fattura> findByCliente(Cliente c);

	 List<Fattura> findByStatoFattura(StatoFattura statoFattura);

	 List<Fattura> findByData(Date data);

	 List<Fattura> findByAnno(Integer anno);
	 
	 List<Fattura> findByImportoBetween(BigDecimal importoIniziale, BigDecimal importoFinale);

	
}
