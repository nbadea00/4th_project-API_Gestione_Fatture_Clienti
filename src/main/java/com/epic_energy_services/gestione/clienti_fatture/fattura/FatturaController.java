package com.epic_energy_services.gestione.clienti_fatture.fattura;

import java.math.BigDecimal;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fatture")
public class FatturaController {

	@Autowired FatturaService fatturaServ;	
	
	@GetMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Page<Fattura>> getAllFatture(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim){
		return ResponseEntity.ok(fatturaServ.findAll(pagina, dim));
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Fattura> getFatturaById(@PathVariable Long id){
		return ResponseEntity.ok(fatturaServ.findById(id));
	}
	
	@PostMapping("/id_cliente={idCliente}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Fattura> addFattura(@RequestBody Fattura fattura,
			@PathVariable Long idCliente){
		return ResponseEntity.ok(fatturaServ.createFattura(fattura, idCliente));
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Fattura> modificaFattura(@RequestBody Fattura fattura, @PathVariable Long id){
		return ResponseEntity.ok(fatturaServ.updateFattura(fattura, id));
	}
	
	@DeleteMapping
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
	
	@GetMapping("/findby/cliente={id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Page<Fattura>> trovaFatturaByCliente(@PathVariable Long id, @RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim){
		return ResponseEntity.ok(fatturaServ.getFatturaByIdCliente(id, pagina, dim));
	}
	
	@GetMapping("/findby/stato={stato}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Page<Fattura>> trovaFatturaByStato(@PathVariable StatoFattura stato,@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim){
		return ResponseEntity.ok(fatturaServ.getFatturaByStatoFattura(stato, pagina, dim));
	}
	
	@GetMapping("/findby/anno={anno}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Page<Fattura>> trovaFatturaByAnno(@PathVariable Integer anno, @RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim){
		return ResponseEntity.ok(fatturaServ.getFatturaByAnno(anno,pagina, dim));
	}
	
	@GetMapping("/findby")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Page<Fattura>> trovaFatturaByImportoRange(
			@RequestParam(value = "imp1", defaultValue = "0") BigDecimal imp1,@RequestParam(value = "imp2", defaultValue = "10_000") BigDecimal imp2, @RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim){
		return ResponseEntity.ok(fatturaServ.getFatturaByRangeImport(imp1, imp2,pagina, dim));
		}

	@GetMapping("/findby/data={data}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Page<Fattura>> trovaFatturaByData(@PathVariable Date data, @RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim){
		return ResponseEntity.ok(fatturaServ.getFatturaByData(data, pagina, dim));
	}
}
