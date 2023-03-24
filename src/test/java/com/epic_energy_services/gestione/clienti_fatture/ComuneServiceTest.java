package com.epic_energy_services.gestione.clienti_fatture;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.epic_energy_services.gestione.clienti_fatture.comune.Comune;
import com.epic_energy_services.gestione.clienti_fatture.comune.ComuneService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ComuneServiceTest {

@Autowired ComuneService comuneService;
	
	static private Long id;
	
	@Test
	@Order(1)
	public void CreaNuovoProvincia() {
		Comune c = Comune.builder()
				.nome("testC")
				.codiceProvincia(1)
				.progressivoComune(1)
				.build();
		
		Comune c2 = comuneService.createComune(c);
		
		id = c2.getId();
		
		assertTrue(c2 != null);
	}
	
	@Test
	@Order(2)
	public void FindByIdProvincia() {
		Comune c = comuneService.findById(id);
		assertTrue(c != null);
	}
	
	@Test
	@Order(3)
	public void updateIdProvincia() {
		Comune c = comuneService.findById(id);
		c.setNome("testUP");
		comuneService.updateComune(c);
		assertTrue(comuneService.findById(id).getNome().equals("testUP"));
	}
	
	@Test
	@Order(4)
	public void DelByIdProvincia() {
		comuneService.removeComuneById(id);
	}
	
	@Test
	@Order(5)
	public void FindByIdAfterDelProvincia() {
		comuneService.findById(id);
	}
}
