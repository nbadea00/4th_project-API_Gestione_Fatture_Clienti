package com.epic_energy_services.gestione.clienti_fatture.runner;

import java.util.Date;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epic_energy_services.gestione.clienti_fatture.cliente.Cliente;
import com.epic_energy_services.gestione.clienti_fatture.cliente.ClienteService;
import com.epic_energy_services.gestione.clienti_fatture.cliente.TipoCliente;
import com.epic_energy_services.gestione.clienti_fatture.comune.Comune;
import com.epic_energy_services.gestione.clienti_fatture.comune.ComuneService;
import com.epic_energy_services.gestione.clienti_fatture.fattura.Fattura;
import com.epic_energy_services.gestione.clienti_fatture.fattura.FatturaService;
import com.epic_energy_services.gestione.clienti_fatture.fattura.StatoFattura;
import com.epic_energy_services.gestione.clienti_fatture.indirizzo.Indirizzo;
import com.epic_energy_services.gestione.clienti_fatture.indirizzo.IndirizzoService;
import com.epic_energy_services.gestione.clienti_fatture.provincia.Provincia;
import com.epic_energy_services.gestione.clienti_fatture.provincia.ProvinciaService;

@Component
public class FactoryGenericaProva {
	
	@Autowired IndirizzoService indirizzoService;
	@Autowired ProvinciaService provinciaService;
	@Autowired ComuneService comuneService;
	@Autowired ClienteService clienteService;
	@Autowired FatturaService fatturaService;
	
	private static String dataFormat = "yyyy-MM-dd HH:mm:ss.SSS";
	private static SimpleDateFormat formatter = new SimpleDateFormat(dataFormat);
	
	public Cliente creaCriente(Map<String, String> map, String[] keys) {
		
		Cliente c = new Cliente();
		c.setCognomeContatto(map.get(keys[0]));
		
		String data = map.get(keys[1]);
		
		while(data.toCharArray().length < dataFormat.length()) data += "0";
		try {
			Date d = formatter.parse(data);
			c.setDataInserimento(new java.sql.Date(d.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		data = map.get(keys[2]);
		while(data.toCharArray().length < dataFormat.length()) data += "0";
		try {
			Date d = formatter.parse(data);
			c.setDataUltimoContatto(new java.sql.Date(d.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		c.setEmail( map.get(keys[3]));
		c.setEmailContatto( map.get(keys[4]));
		c.setFatturatoAnnuale(new BigDecimal(map.get(keys[5])));
		c.setNomeContatto(map.get(keys[6]));
		c.setPartitaIva(map.get(keys[7]));
		c.setPec(map.get(keys[8]));
		c.setRagioneSociale(map.get(keys[9]));
		c.setTelefono(map.get(keys[10]));
		c.setTelefonoContatto(map.get(keys[11]));
		c.setTipoCliente(TipoCliente.valueOf(map.get(keys[12])));
		c.setIndirizzoSedeLegale(indirizzoService.findById(Long.parseLong(map.get(keys[13]))));
		c.setIndirizzoSedeOperativa(indirizzoService.findById(Long.parseLong(map.get(keys[14]))));
		
		
		return clienteService.createCliente(c);
	}
	
	public Comune creaComune(Map<String, String> map, String[] keys) {
		Comune comune = new Comune();
		
		comune.setCodiceProvincia(Integer.parseInt(map.get(keys[0])));
		comune.setProgressivoComune(Integer.parseInt(map.get(keys[1])));
		comune.setNome(map.get(keys[2]));
		comune.setProvincia(provinciaService.findByNome(map.get(keys[3])));
		
		return comuneService.createComune(comune);
	}
	
	public Indirizzo creaIndirizzo(Map<String, String> map, String[] keys) {
		Indirizzo indirizzo = new Indirizzo();
		
		indirizzo.setCap(map.get(keys[0]));
		indirizzo.setCivico(map.get(keys[1]));
		indirizzo.setLocalità(map.get(keys[2]));
		indirizzo.setVia(map.get(keys[3]));
		indirizzo.setComune(comuneService.findById(Long.parseLong(map.get(keys[4]))));
		
		return indirizzoService.createIndirizzo(indirizzo);
	}
	
	public Fattura creaFatture(Map<String, String> map, String[] keys) {
		Fattura fattura = new Fattura();
		
		fattura.setAnno(Integer.parseInt(map.get(keys[0])));
		String data = map.get(keys[1]);
		while(data.toCharArray().length < dataFormat.length()) data += "0";
		try {
			Date d = formatter.parse(data);
			fattura.setData(new java.sql.Date(d.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		fattura.setImporto(new BigDecimal(map.get(keys[2])));
		fattura.setNumero(Integer.parseInt(map.get(keys[3])));
		fattura.setStatoFattura(StatoFattura.valueOf(map.get(keys[4])));
		
		fattura.setCliente(clienteService.findById(Long.parseLong(map.get(keys[5]))));
		
		return fatturaService.createFattura(fattura, -1l);
	}
	
	public Provincia creaProvincia(Map<String, String> map, String[] keys) {
		Provincia provincia = new Provincia();
		
		provincia.setSigla(map.get(keys[0]));
		provincia.setNome(map.get(keys[1]));
		provincia.setRegione(map.get(keys[2]));
		
		return provinciaService.createProvincia(provincia);
	}

}
