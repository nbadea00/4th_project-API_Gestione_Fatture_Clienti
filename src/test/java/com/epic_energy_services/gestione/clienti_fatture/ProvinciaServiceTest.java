package com.epic_energy_services.gestione.clienti_fatture;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.epic_energy_services.gestione.clienti_fatture.provincia.Provincia;
import com.epic_energy_services.gestione.clienti_fatture.provincia.ProvinciaService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ProvinciaServiceTest {

@Autowired ProvinciaService provinciaService;
	
	static private Long id;
	
	@Test
	@Order(1)
	public void CreaNuovoProvincia() {
		Provincia p = Provincia.builder()
				.sigla("tsetSg")
				.nome("testNome")
				.regione("testRegione")
				.build();
		
		Provincia p2 = provinciaService.createProvincia(p);
		
		id = p2.getId();
		
		assertTrue(p2 != null);
	}
	
	@Test
	@Order(2)
	public void FindByIdProvincia() {
		Provincia p = provinciaService.findById(id);
		assertTrue(p != null);
	}
	
	@Test
	@Order(3)
	public void updateIdProvincia() {
		Provincia p = provinciaService.findById(id);
		p.setSigla("testUP");
		provinciaService.updateProvincia(p);
		assertTrue(provinciaService.findById(id).getSigla().equals("testUP"));
	}
	
	@Test
	@Order(4)
	public void DelByIdProvincia() {
		provinciaService.removeProvinciaById(id);
	}
	
	@Test
	@Order(5)
	public void FindByIdAfterDelProvincia() {
		provinciaService.findById(id);
	}
}
