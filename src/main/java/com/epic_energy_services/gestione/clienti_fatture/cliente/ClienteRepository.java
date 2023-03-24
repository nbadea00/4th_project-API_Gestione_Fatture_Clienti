package com.epic_energy_services.gestione.clienti_fatture.cliente;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

public Optional<Cliente> findByPartitaIva (String partitaIva);
public Optional<Cliente> findByEmail (String email);
public Optional<Cliente> findByPec (String pec);
public Optional<Cliente> findByTelefono (String telefono);
public Optional<Cliente> findByEmailContatto (String emailContatto);
public Optional<Cliente> findByTelefonoContatto(String telefonoContatto);

public Optional<Cliente> findByPartitaIvaAndIdNot (String partitaIva, Long id);
public Optional<Cliente> findByEmailAndIdNot (String email, Long id);
public Optional<Cliente> findByPecAndIdNot (String pec, Long id);
public Optional<Cliente> findByTelefonoAndIdNot (String telefono, Long id);
public Optional<Cliente> findByEmailContattoAndIdNot (String emailContatto, Long id);
public Optional<Cliente> findByTelefonoContattoAndIdNot (String telefonoContatto, Long id);

@Query("SELECT c FROM Cliente c ORDER BY c.indirizzoSedeLegale.comune.provincia.nome")
public Page<Cliente> findByOrderByProvinciaSedeLegaleAsc(PageRequest pageRequest);

public Page<Cliente> findByFatturatoAnnualeBetween(BigDecimal fatturatoMinimo, BigDecimal fatturatoMassimo, PageRequest pageRequest);

public Page<Cliente> findByDataInserimentoBetween(Date dataIniziale, Date dataFinale, PageRequest pageRequest);

public Page<Cliente> findByDataUltimoContattoBetween(Date dataIniziale, Date dataFinale, PageRequest pageRequest);

public Page<Cliente> findByNomeContattoContains (String nome, PageRequest pageRequest);
}






