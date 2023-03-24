package com.epic_energy_services.gestione.clienti_fatture.fattura;

import java.math.BigDecimal;
import java.sql.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import com.epic_energy_services.gestione.clienti_fatture.cliente.Cliente;

public interface FatturaRepository extends JpaRepository<Fattura, Long> {
				
	 Page<Fattura> findByCliente(Cliente c, PageRequest p);

	 Page<Fattura> findByStatoFattura(StatoFattura statoFattura, PageRequest p);

	 Page<Fattura> findByData(Date data, PageRequest p);

	 Page<Fattura> findByAnno(Integer anno, PageRequest p);
	 
	 Page<Fattura> findByImportoBetween(BigDecimal importoIniziale, BigDecimal importoFinale, PageRequest p);

	
}
