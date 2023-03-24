package com.epic_energy_services.gestione.clienti_fatture;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.epic_energy_services.gestione.clienti_fatture.indirizzo.Indirizzo;
import com.epic_energy_services.gestione.clienti_fatture.indirizzo.IndirizzoService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class IndirizzoServiceTest {

@Autowired IndirizzoService indirizzoService;
	
	static private Long id;
	
	@Test
	@Order(1)
	public void CreaNuovoProvincia() {
		Indirizzo i = Indirizzo.builder()
				.cap("testCap")
				.via("testVia")
				.civico("testCiv")
				.località("testL")
				.build();
		
		Indirizzo i2 = indirizzoService.createIndirizzo(i);
		
		id = i2.getId();
		
		assertTrue(i2 != null);
	}
	
	@Test
	@Order(2)
	public void FindByIdProvincia() {
		Indirizzo i = indirizzoService.findById(id);
		assertTrue(i != null);
	}
	
	@Test
	@Order(3)
	public void updateIdProvincia() {
		Indirizzo i = indirizzoService.findById(id);
		i.setCap("testcap");
		indirizzoService.updateIndirizzo(i);
		assertTrue(indirizzoService.findById(id).getCap().equals("testUP"));
	}
	
	@Test
	@Order(4)
	public void DelByIdProvincia() {
		indirizzoService.removeIndirizzoById(id);
	}
	
	@Test
	@Order(5)
	public void FindByIdAfterDelProvincia() {
		indirizzoService.findById(id);
	}
}
