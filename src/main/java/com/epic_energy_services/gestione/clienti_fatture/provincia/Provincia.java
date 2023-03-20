package com.epic_energy_services.gestione.clienti_fatture.provincia;

import java.util.List;

import com.epic_energy_services.gestione.clienti_fatture.comune.Comune;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "province")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provincia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String nome;
	@Column(nullable = false, unique = true)
	private String sigla;
	@Column(nullable = false)
	private String regione;
	
	@OneToMany(mappedBy = "provincia")
	private List<Comune> comuni;

}
