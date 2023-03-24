package com.epic_energy_services.gestione.clienti_fatture;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.epic_energy_services.gestione.clienti_fatture.fattura.Fattura;
import com.epic_energy_services.gestione.clienti_fatture.fattura.FatturaService;
import com.epic_energy_services.gestione.clienti_fatture.fattura.StatoFattura;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class FatturaServiceTest {

@Autowired FatturaService fatturaService;
	
	static private Long id;
	
	@Test
	@Order(1)
	public void CreaNuovoFattura() {
		
		Date d = Date.valueOf("2023-1-12");
		
		Fattura f = Fattura.builder()
				.data(d)
				.anno(2023)
				.importo(new BigDecimal(0))
				.numero(10)
				.statoFattura(StatoFattura.NON_PAGATA)
				.build();
		
		Fattura f2 = fatturaService.createFattura(f, 1l);
		
		id = f2.getId();
		
		assertTrue(f2 != null);
	}
	
	@Test
	@Order(2)
	public void FindByIdFattura() {
		Fattura f = fatturaService.findById(id);
		assertTrue(f != null);
	}
	
	@Test
	@Order(3)
	public void updateIdFattura() {
		Fattura f = fatturaService.findById(id);
		f.setStatoFattura(StatoFattura.PAGATA);
		fatturaService.updateFattura(f, id);
		assertTrue(fatturaService.findById(id).getAnno().equals(2000));
	}
	
	@Test
	@Order(4)
	public void DelByIdFattura() {
		fatturaService.removeFatturaById(id);
	}
	
	@Test
	@Order(5)
	public void FindByIdAfterDelFattura() {
		fatturaService.findById(id);
	}
	

}
