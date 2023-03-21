package com.epic_energy_services.gestione.clienti_fatture.fattura_controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epic_energy_services.gestione.clienti_fatture.cliente.Cliente;
import com.epic_energy_services.gestione.clienti_fatture.cliente.ClienteService;
import com.epic_energy_services.gestione.clienti_fatture.fattura.Fattura;
import com.epic_energy_services.gestione.clienti_fatture.fattura.FatturaService;

@RestController
@RequestMapping("/fatture")
public class FatturaController {

	@Autowired FatturaService fatturaServ;
	@Autowired ClienteService clienteServ;
	
	@GetMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<Fattura>> getAllFatture(){
		return ResponseEntity.ok(fatturaServ.findAll());
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Fattura> getFatturaById(@PathVariable Long id){
		return ResponseEntity.ok(fatturaServ.findById(id));
	}
	
	@PostMapping("/aggiungi")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> addFattura(@RequestBody Fattura fattura){
		ResponseEntity.ok(fatturaServ.createFattura(fattura));
		return ResponseEntity.ok("Fattura Creata!");
	}
	
	@PutMapping("/modifica")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> modificaFattura(@RequestBody Fattura fattura){
		ResponseEntity.ok(fatturaServ.updateFattura(fattura));
		return ResponseEntity.ok("Fattura Aggiornata!");
	}
	
	@DeleteMapping()
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> eliminaFattura(@RequestBody Fattura fattura){
		fatturaServ.removeFattura(fattura);
		return ResponseEntity.ok("Fattura Cancellata!");
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> eliminaFatturaById(@PathVariable Long id){
		fatturaServ.removeFatturaById(id);
		return ResponseEntity.ok("Fattura Cancellata!");
	}
	
	@GetMapping("cliente/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
		return ResponseEntity.ok(clienteServ.findById(id));
	}
	
	@PostMapping("/cliente")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> addCliente(@RequestBody Cliente cliente){
		ResponseEntity.ok(clienteServ.createCliente(cliente));
		return ResponseEntity.ok("Cliente Creata!");
	}
}
