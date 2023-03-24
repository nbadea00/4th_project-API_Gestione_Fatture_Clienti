package com.epic_energy_services.gestione.clienti_fatture.cliente;

import java.math.BigDecimal;
import java.sql.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/clienti")
public class ClienteController {
	
@Autowired ClienteService cService;

@GetMapping
@PreAuthorize("hasRole('USER')")
public ResponseEntity<Page<Cliente>> getAllClienti (@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim) {
	return ResponseEntity.ok(cService.findAll(pagina, dim)); 
	
}

@GetMapping("/{id}")
@PreAuthorize("hasRole('USER')")
public ResponseEntity<Cliente> getClientibyId (@PathVariable Long id) {
	return ResponseEntity.ok(cService.findById(id));
}

@PostMapping
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<Cliente> createCliente( @RequestBody Cliente cliente){
	return ResponseEntity.ok(cService.createCliente(cliente));

}

@PutMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<Cliente> updateCliente (@RequestBody Cliente cliente, @PathVariable Long id){
	return ResponseEntity.ok(cService.updateCliente(cliente, id));
}


@DeleteMapping
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<String> removeCliente (@RequestBody Cliente cliente){
cService.removeCliente(cliente);
   return ResponseEntity.ok("utente è stato eliminato") ;
} 

@DeleteMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<String> removeClienteById (@PathVariable Long id){
	return ResponseEntity.ok(cService.removeClienteById(id));	
}

@GetMapping("/orderby/nome")
@PreAuthorize("hasRole('USER')")
public ResponseEntity<Page<Cliente>> getClienteNome(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim) {
	return ResponseEntity.ok(cService.orderByName(pagina, dim));
}

@GetMapping("/orderby/fatturato")
@PreAuthorize("hasRole('USER')")
public ResponseEntity<Page<Cliente>> getFatturato(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim) {
	return ResponseEntity.ok(cService.orderByFatturato(pagina, dim));
}

@GetMapping("/orderby/datainserimento")
@PreAuthorize("hasRole('USER')")
public ResponseEntity<Page<Cliente>> getDataInserimento(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim) {
	return ResponseEntity.ok(cService.orderByDataInserimento(pagina, dim));

}

@GetMapping("/orderby/dataultimocontatto")
@PreAuthorize("hasRole('USER')")
public ResponseEntity<Page<Cliente>> getDataUltimoContatto(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim) {
	return ResponseEntity.ok(cService.orderByDataUltimoContatto(pagina, dim));

}

@GetMapping("/orderby/provinciasedelegale")
@PreAuthorize("hasRole('USER')")
public ResponseEntity<Page<Cliente>> getProvinciaSedeLegale(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim) {
	return new ResponseEntity<Page<Cliente>>(cService.orderByProvinciaSedeLegale(pagina, dim),HttpStatus.OK);

}

@GetMapping("/findby/fatturatoannuale")
@PreAuthorize("hasRole('USER')")
public ResponseEntity<Page<Cliente>> findByFatturatoAnnuale(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim, @RequestParam(value = "min",  defaultValue = "0") BigDecimal min, @RequestParam(value = "max",  defaultValue = "0") BigDecimal max) {
	return ResponseEntity.ok(cService.findByFatturatoAnnuale(min, max, pagina, dim));
}


@GetMapping("/findby/datainserimento")
@PreAuthorize("hasRole('USER')")
public ResponseEntity<Page<Cliente>> findByDataInserimento(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim, @RequestParam(value = "inizio",  defaultValue = "0") Date inizio, @RequestParam(value = "fine",  defaultValue = "0") Date fine) {
	return ResponseEntity.ok(cService.findByDataInserimento(inizio, fine, pagina, dim));
}

@GetMapping("/findby/dataultimocontatto")
@PreAuthorize("hasRole('USER')")
public ResponseEntity<Page<Cliente>> findByDataUltimoContatto(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim, @RequestParam(value = "inizio",  defaultValue = "0") Date inizio, @RequestParam(value = "fine",  defaultValue = "0") Date fine) {
	return ResponseEntity.ok(cService.findByDataUltimoContatto(inizio, fine, pagina, dim));
}

@GetMapping("/findby/partenomecontatto")
@PreAuthorize("hasRole('USER')")
public ResponseEntity<Page<Cliente>> findByParteNome(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim, @RequestParam(value = "nome",  defaultValue = "0") String nome) {
	return ResponseEntity.ok(cService.findbyParteNome(nome, pagina, dim));
}


}
