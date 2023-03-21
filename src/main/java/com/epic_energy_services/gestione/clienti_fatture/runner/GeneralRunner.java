package com.epic_energy_services.gestione.clienti_fatture.runner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epic_energy_services.gestione.clienti_fatture.cliente.Cliente;
import com.epic_energy_services.gestione.clienti_fatture.cliente.ClienteService;
import com.epic_energy_services.gestione.clienti_fatture.cliente.TipoCliente;
import com.epic_energy_services.gestione.clienti_fatture.comune.Comune;
import com.epic_energy_services.gestione.clienti_fatture.comune.ComuneService;
import com.epic_energy_services.gestione.clienti_fatture.fattura.Fattura;
import com.epic_energy_services.gestione.clienti_fatture.fattura.FatturaService;
import com.epic_energy_services.gestione.clienti_fatture.fattura.StatoFattura;
import com.epic_energy_services.gestione.clienti_fatture.provincia.Provincia;
import com.epic_energy_services.gestione.clienti_fatture.provincia.ProvinciaService;
import com.opencsv.CSVReader;

@Component
public class GeneralRunner implements ApplicationRunner {
	
	@Autowired ComuneService comuneService;
	@Autowired ProvinciaService provinciaService;
	@Autowired ClienteService clientService;
	@Autowired FatturaService fatturaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("General Runner run...");
		
		popolaDbProvince();
		popolaDbComuni();
//		
//		Cliente c = new Cliente("Azienda B", "IT000555666", "aziendaB@email.com", Date.valueOf("2022-07-02"), Date.valueOf("2022-07-02"), new BigDecimal(100000), "pecB", "034265345", "emailB@contatto.it", "nomecontatto", "cognomecontatto", "46543345"	, TipoCliente.SPA, null, null, null);
//		
//		clientService.createCliente(c);
//	
//		Fattura f = new Fattura(Date.valueOf("2023-03-03"), new BigDecimal(10000), 1, StatoFattura.NON_PAGATA);
//		 
//		fatturaService.createFattura(f);
//		
 
//		Fattura f = fatturaService.findById(1L);
//		System.out.println(f);
//		f.setCliente(clientService.findById(1L));
//		System.out.println(f);
//		fatturaService.updateFattura(f);
		
		

	}
	
	
	
	
	// PROVINCE
	public void popolaDbProvince() {
		try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/assets/province-italiane.csv"));) {
		    String[] values = null;
		    
		    String provincia_nome;
		    String provincia_sigla;
		    String provincia_regione;
		    
		    int n = 0;
		    while ((values = csvReader.readNext()) != null) {
		    	String value = values[0];
		    	String[] splitValue = value.split(";");
		    	
		    	if(n != 0) {
		    		provincia_sigla = splitValue[0];
		    		provincia_nome = splitValue[1];
		    		provincia_regione = splitValue[2];
		    		
		    		System.out.println(provincia_sigla + " - " + provincia_nome + " - " + provincia_regione);
		    		
		    		Provincia p = new Provincia(provincia_nome, provincia_sigla, provincia_regione);
		    		provinciaService.createProvincia(p);
		    	}
		    	
		    	n++;
		    	
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// COMUNI
	public void popolaDbComuni() {
		try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/assets/comuni-italiani.csv"))) {
		    String[] values = null;
		    
		    String codiceProvincia;
		    String progressivoComune;
			String comune_nome;
			String nomeProvincia;
			int n = 0;
		    
			
		    while ((values = csvReader.readNext()) != null) {
		    	String[] splitValue = values[0].split(";");
		    	
		    	if(n != 0) {
		    		codiceProvincia = splitValue[0];
		    		progressivoComune = splitValue[1];
		    		comune_nome = splitValue[2];
		    		nomeProvincia = splitValue[3];
		    		
		    		Provincia p = provinciaService.getByNome(nomeProvincia);
		    		
		    		Comune c = new Comune(comune_nome, Integer.parseInt(codiceProvincia), Integer.parseInt(progressivoComune), p);
		    		comuneService.createComune(c);
		    	}
		    	
		    	n++;
		    	
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
