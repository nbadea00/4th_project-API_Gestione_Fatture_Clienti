package com.epic_energy_services.gestione.clienti_fatture.comune;

import java.util.List;

import com.epic_energy_services.gestione.clienti_fatture.indirizzo.Indirizzo;
import com.epic_energy_services.gestione.clienti_fatture.provincia.Provincia;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "comuni")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comune {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private Integer codiceProvincia;
	@Column(nullable = false)
	private Integer progressivoComune;
	
	@OneToMany(mappedBy = "comune", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@ToString.Exclude
	@JsonIgnore
	private List<Indirizzo> listaIndirizzi;

	@ManyToOne
	@JoinColumn(name = "id_provincia")
	@ToString.Exclude
	@JsonIgnore
	private Provincia provincia;

	public Comune(String nome, Integer codiceProvincia, Integer progressivoComune, Provincia provincia) {
		super();
		this.nome = nome;
		this.codiceProvincia = codiceProvincia;
		this.progressivoComune = progressivoComune;
		this.provincia = provincia;
	}

}
