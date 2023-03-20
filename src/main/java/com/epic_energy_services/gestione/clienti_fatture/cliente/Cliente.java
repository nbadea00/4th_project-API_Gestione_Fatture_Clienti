package com.epic_energy_services.gestione.clienti_fatture.cliente;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.epic_energy_services.gestione.clienti_fatture.fattura.Fattura;
import com.epic_energy_services.gestione.clienti_fatture.indirizzo.Indirizzo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clienti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String ragioneSociale;
	@Column(nullable = false, unique = true)
	private String partitaIva;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private Date dataInserimento;
	private Date dataUltimoContatto;
	private BigDecimal fatturatoAnnuale;
	@Column(nullable = false, unique = true)
	private String pec;
	@Column(nullable = false, unique = true)
	private String telefono;
	@Column(nullable = false, unique = true)
	private String emailContatto;
	private String nomeContatto;
	private String cognomeContatto;
	@Column(nullable = false, unique = true)
	private String telefonoContatto;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoCliente tipoCliente;
	
	@OneToOne
	private Indirizzo indirizzoSedeLegale;
	
	@OneToOne
	private Indirizzo indirizzoSedeOperativa;
	
	@OneToMany(mappedBy="cliente")
	private List<Fattura> fatture;
	

	

}
