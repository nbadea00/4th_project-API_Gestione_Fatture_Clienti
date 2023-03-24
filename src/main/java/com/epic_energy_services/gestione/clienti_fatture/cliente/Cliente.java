package com.epic_energy_services.gestione.clienti_fatture.cliente;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;


import com.epic_energy_services.gestione.clienti_fatture.fattura.Fattura;
import com.epic_energy_services.gestione.clienti_fatture.indirizzo.Indirizzo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "clienti")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String ragioneSociale;
	@Column(nullable = false, unique = true)
	private String partitaIva;
	@Column(nullable = false, unique = true)
	@Email
	private String email;
	@Column(nullable = false)
	private Date dataInserimento;
	private Date dataUltimoContatto;
	private BigDecimal fatturatoAnnuale;
	@Column(nullable = false, unique = true)
	private String pec;
	@Column(nullable = false, unique = true)
	@Size(min = 10, max = 20)
	private String telefono;
	@Column(nullable = false, unique = true)
	private String emailContatto;
	private String nomeContatto;
	private String cognomeContatto;
	@Column(nullable = false, unique = true)
	@Size(min = 10, max = 20)
	private String telefonoContatto;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoCliente tipoCliente;
	
	@OneToOne
	@ToString.Exclude
	private Indirizzo indirizzoSedeLegale;
	
	@OneToOne
	@ToString.Exclude
	private Indirizzo indirizzoSedeOperativa;
	
	
	@OneToMany(mappedBy="cliente", fetch = FetchType.LAZY)
	@ToString.Exclude
	@JsonIgnore
	private List<Fattura> fatture;

	public Cliente(String ragioneSociale, String partitaIva, String email, Date dataInserimento,
			Date dataUltimoContatto, BigDecimal fatturatoAnnuale, String pec, String telefono, String emailContatto,
			String nomeContatto, String cognomeContatto, String telefonoContatto, TipoCliente tipoCliente,
			Indirizzo indirizzoSedeLegale, Indirizzo indirizzoSedeOperativa, List<Fattura> fatture) {
		super();
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
		this.email = email;
		this.dataInserimento = dataInserimento;
		this.dataUltimoContatto = dataUltimoContatto;
		this.fatturatoAnnuale = fatturatoAnnuale;
		this.pec = pec;
		this.telefono = telefono;
		this.emailContatto = emailContatto;
		this.nomeContatto = nomeContatto;
		this.cognomeContatto = cognomeContatto;
		this.telefonoContatto = telefonoContatto;
		this.tipoCliente = tipoCliente;
		this.indirizzoSedeLegale = indirizzoSedeLegale;
		this.indirizzoSedeOperativa = indirizzoSedeOperativa;
		this.fatture = fatture;
	}
	
	
	

}
