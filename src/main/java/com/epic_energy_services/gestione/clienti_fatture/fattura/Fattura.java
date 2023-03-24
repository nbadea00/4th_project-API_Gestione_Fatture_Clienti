package com.epic_energy_services.gestione.clienti_fatture.fattura;

import java.math.BigDecimal;
import java.sql.Date;

import com.epic_energy_services.gestione.clienti_fatture.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "fatture")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fattura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Integer anno;
	@Column(nullable = false)
	private Date data;
	@Column(nullable = false)
	private BigDecimal importo;
	@Column(nullable = false)
	private Integer numero;
	
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	@ToString.Exclude
	@JsonIgnore
	private Cliente cliente; 
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StatoFattura statoFattura;
	
public Fattura(Date data, BigDecimal importo, Integer numero, StatoFattura statoFattura) {
	super();
	this.data = data;
	this.importo = importo;
	this.numero = numero;
	this.statoFattura = statoFattura;
}
	
}
