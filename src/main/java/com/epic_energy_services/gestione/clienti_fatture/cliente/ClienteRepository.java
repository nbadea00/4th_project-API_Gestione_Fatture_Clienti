package com.epic_energy_services.gestione.clienti_fatture.cliente;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

public List<Cliente> findAllByOrderByNomeContattoAsc(); 

public List<Cliente> findByOrderByFatturatoAnnualeAsc ();

public List<Cliente> findByOrderByDataInserimentoAsc ();

public List<Cliente> findByOrderByDataUltimoContattoAsc ();

@Query("SELECT c FROM Cliente c ORDER BY c.indirizzoSedeLegale.comune.provincia.nome")
public List<Cliente> findByOrderByProvinciaSedeLegaleAsc ();
}




