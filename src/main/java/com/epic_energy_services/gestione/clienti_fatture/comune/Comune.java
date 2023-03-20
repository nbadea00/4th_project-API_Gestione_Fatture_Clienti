package com.epic_energy_services.gestione.clienti_fatture.comune;

import com.epic_energy_services.gestione.clienti_fatture.provincia.Provincia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comuni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comune {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String nome;
	@Column(nullable = false, unique = true)
	private Integer codiceProvincia;
	@Column(nullable = false)
	private Integer progressivoComune;

	@ManyToOne
	@JoinColumn(name = "id_provincia")
	private Provincia provincia;

}
