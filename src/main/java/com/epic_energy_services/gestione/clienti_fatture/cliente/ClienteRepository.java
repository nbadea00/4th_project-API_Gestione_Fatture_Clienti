package com.epic_energy_services.gestione.clienti_fatture.cliente;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

//public List<Cliente> findAllByOrderByNomeContattoAsc(Pageable p); 

/*public List<Cliente> findByOrderByFatturatoAnnualeAsc ();

public List<Cliente> findByOrderByDataInserimentoAsc ();

public List<Cliente> findByOrderByDataUltimoContattoAsc ();*/

@Query("SELECT c FROM Cliente c ORDER BY c.indirizzoSedeLegale.comune.provincia.nome")
public Page<Cliente> findByOrderByProvinciaSedeLegaleAsc(PageRequest pageRequest);

public Page<Cliente> findByFatturatoAnnualeBetween(BigDecimal fatturatoMinimo, BigDecimal fatturatoMassimo, PageRequest pageRequest);

public Page<Cliente> findByDataInserimentoBetween(Date dataIniziale, Date dataFinale, PageRequest pageRequest);

public Page<Cliente> findByDataUltimoContattoBetween(Date dataIniziale, Date dataFinale, PageRequest pageRequest);

public Page<Cliente> findByNomeContattoLike(String nome, PageRequest pageRequest);
}






