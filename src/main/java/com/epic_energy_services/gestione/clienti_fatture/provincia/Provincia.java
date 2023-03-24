package com.epic_energy_services.gestione.clienti_fatture.provincia;

import java.util.List;

import com.epic_energy_services.gestione.clienti_fatture.comune.Comune;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "province")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
	
	@OneToMany(mappedBy = "provincia", fetch = FetchType.LAZY)
	@ToString.Exclude
	@JsonIgnore
	private List<Comune> comuni;

	public Provincia(String nome, String sigla, String regione) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.regione = regione;
	}
	
	

}
