package com.epic_energy_services.gestione.clienti_fatture.indirizzo;


import com.epic_energy_services.gestione.clienti_fatture.cliente.Cliente;
import com.epic_energy_services.gestione.clienti_fatture.comune.Comune;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "indirizzi")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Indirizzo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String via;
	@Column(nullable = false)
	private String civico;
	@Column(nullable = false)
	private String località;
	@Column(nullable = false)
	private String cap;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	@JsonIgnore
	private Comune comune;
	
	@OneToOne(mappedBy="indirizzoSedeLegale", cascade = CascadeType.ALL)
	@JsonIgnore
	@ToString.Exclude
	private Cliente clienteLegale;
	
	@OneToOne(mappedBy="indirizzoSedeOperativa", cascade = CascadeType.ALL)
	@JsonIgnore
	@ToString.Exclude
	private Cliente clienteOperativa;

}
