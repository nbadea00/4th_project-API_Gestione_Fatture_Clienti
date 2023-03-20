package com.epic_energy_services.gestione.clienti_fatture.indirizzo;

import com.epic_energy_services.gestione.clienti_fatture.cliente.Cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "indirizzi")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	@Column(nullable = false)
	private String comune; // cambiare da String a Comune
	
	@OneToOne(mappedBy="indirizzoSedeLegale")
	private Cliente clienteLegale;
	
	@OneToOne(mappedBy="indirizzoSedeOperativa")
	private Cliente clienteOperativa;

}
