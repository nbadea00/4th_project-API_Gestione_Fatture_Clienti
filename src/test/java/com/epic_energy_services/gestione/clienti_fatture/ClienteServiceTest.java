package com.epic_energy_services.gestione.clienti_fatture;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.epic_energy_services.gestione.clienti_fatture.cliente.Cliente;
import com.epic_energy_services.gestione.clienti_fatture.cliente.ClienteService;
import com.epic_energy_services.gestione.clienti_fatture.cliente.TipoCliente;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ClienteServiceTest {
	
	@Autowired ClienteService clienteService;
	
	static private Long id;
	
	@Test
	@Order(1)
	public void CreaNuovoCliente() {
		Cliente c = Cliente.builder()
				.ragioneSociale("test")
				.cognomeContatto("test")
				.dataInserimento(new Date(0))
				.dataUltimoContatto(new Date(1))
				.email("test@test.com")
				.emailContatto("test@test.com")
				.fatturatoAnnuale(new BigDecimal(10000))
				.fatture(null)
				.partitaIva("testPartitaIva")
				.pec("testPec")
				.tipoCliente(TipoCliente.PA)
				.telefono("testNumeroTelefono")
				.telefonoContatto("testNumeroTelefono")
				.build();
		
		
		Cliente c2 = clienteService.createCliente(c);
		
		id = c2.getId();
		
		assertTrue(c2 != null);
	}
	
	@Test
	@Order(2)
	public void FindByIdCliente() {
		Cliente c = clienteService.findById(id);
		assertTrue(c != null);
	}
	
	@Test
	@Order(3)
	public void updateIdCliente() {
		Cliente c = clienteService.findById(id);
		c.setCognomeContatto("testNuovo");
		clienteService.updateCliente(c, id);
		assertTrue(clienteService.findById(id).getCognomeContatto().equals("testNuovo"));
	}
	
	@Test
	@Order(4)
	public void DelByIdCliente() {
		clienteService.removeClienteById(id);
	}
	
	@Test
	@Order(5)
	public void FindByIdAfterDelCliente() {
		clienteService.findById(id);
	}
	

}
