package com.epic_energy_services.gestione.clienti_fatture.cliente;

import java.math.BigDecimal;
import java.sql.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public ResponseEntity<Page<Cliente>> getAllClienti (@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim) {
	return new ResponseEntity<Page<Cliente>>(cService.findAll(pagina, dim),HttpStatus.OK); 
	
}

@GetMapping("/{id}")
public ResponseEntity<Cliente> getClientibyId (@PathVariable Long id) {
	return new ResponseEntity<Cliente>(cService.findById(id),HttpStatus.OK);
}

@PostMapping
public ResponseEntity<Cliente> createCliente( @RequestBody Cliente cliente){
	return  new ResponseEntity<Cliente>(cService.createCliente(cliente),HttpStatus.OK);

}

@PutMapping("/{id}")
public ResponseEntity<Cliente> updateCliente (@RequestBody Cliente cliente, @PathVariable Long id){
	return new ResponseEntity<Cliente>(cService.updateCliente(cliente, id),HttpStatus.OK);
}


@DeleteMapping 
public ResponseEntity<String> removeCliente (@RequestBody Cliente cliente){
cService.removeCliente(cliente);
   return ResponseEntity.ok("utente è stato eliminato") ;

} 

@DeleteMapping("/{id}")
public ResponseEntity<String> removeClienteById (@PathVariable Long id){
	return new ResponseEntity<String>(cService.removeClienteById(id),HttpStatus.OK);
	
}

@GetMapping("/orderby/nome")
public ResponseEntity<Page<Cliente>> getClienteNome(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim) {
	return new ResponseEntity<Page<Cliente>>(cService.orderByName(pagina, dim),HttpStatus.OK);


}

@GetMapping("/orderby/fatturato")
public ResponseEntity<Page<Cliente>> getFatturato(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim) {
	return new ResponseEntity<Page<Cliente>>(cService.orderByFatturato(pagina, dim),HttpStatus.OK);

}

@GetMapping("/orderby/datainserimento")
public ResponseEntity<Page<Cliente>> getDataInserimento(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim) {
	return new ResponseEntity<Page<Cliente>>(cService.orderByDataInserimento(pagina, dim),HttpStatus.OK);

}

@GetMapping("/orderby/dataultimocontatto")
public ResponseEntity<Page<Cliente>> getDataUltimoContatto(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim) {
	return new ResponseEntity<Page<Cliente>>(cService.orderByDataUltimoContatto(pagina, dim),HttpStatus.OK);

}

@GetMapping("/orderby/provinciasedelegale")

public ResponseEntity<Page<Cliente>> getProvinciaSedeLegale(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim) {
	return new ResponseEntity<Page<Cliente>>(cService.orderByProvinciaSedeLegale(pagina, dim),HttpStatus.OK);

}

@GetMapping("/findby/fatturatoannuale")

public ResponseEntity<Page<Cliente>> findByFatturatoAnnuale(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim, @RequestParam(value = "min",  defaultValue = "0") String min, @RequestParam(value = "max",  defaultValue = "0") String max) {

	return new ResponseEntity<Page<Cliente>>(cService.findByFatturatoAnnuale(new BigDecimal(min), new BigDecimal (max), pagina, dim),HttpStatus.OK);

}


@GetMapping("/findby/datainserimento")

public ResponseEntity<Page<Cliente>> findByDataInserimento(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim, @RequestParam(value = "inizio",  defaultValue = "0") Date inizio, @RequestParam(value = "fine",  defaultValue = "0") Date fine) {
	return new ResponseEntity<Page<Cliente>>(cService.findByDataInserimento(inizio, fine, pagina, dim),HttpStatus.OK);

}

@GetMapping("/findby/dataultimocontatto")

public ResponseEntity<Page<Cliente>> findByDataUltimoContatto(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim, @RequestParam(value = "inizio",  defaultValue = "0") Date inizio, @RequestParam(value = "fine",  defaultValue = "0") Date fine) {
	return new ResponseEntity<Page<Cliente>>(cService.findByDataUltimoContatto(inizio, fine, pagina, dim),HttpStatus.OK);

}

@GetMapping("/findby/partenomecontatto")

public ResponseEntity<Page<Cliente>> findByParteNome(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim, @RequestParam(value = "nome",  defaultValue = "0") String nome) {
	return new ResponseEntity<Page<Cliente>>(cService.findbyParteNome(nome,pagina, dim),HttpStatus.OK);

}


}
