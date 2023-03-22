package com.epic_energy_services.gestione.clienti_fatture.cliente;

import java.util.List;

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
public ResponseEntity<Cliente> updateCliente (@RequestBody Cliente cliente){
	return new ResponseEntity<Cliente>(cService.updateCliente(cliente),HttpStatus.OK);

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
public ResponseEntity<List<Cliente>> getClienteNome(@RequestParam(value = "pagina",  defaultValue = "0") int pagina, @RequestParam(value = "dim", defaultValue = "5") int dim) {
	return new ResponseEntity<List<Cliente>>(cService.findByName(pagina, dim),HttpStatus.OK);


}

}
