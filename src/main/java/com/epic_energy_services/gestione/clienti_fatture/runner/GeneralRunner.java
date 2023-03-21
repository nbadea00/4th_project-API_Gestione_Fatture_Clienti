package com.epic_energy_services.gestione.clienti_fatture.runner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epic_energy_services.gestione.clienti_fatture.comune.Comune;
import com.epic_energy_services.gestione.clienti_fatture.comune.ComuneService;
import com.epic_energy_services.gestione.clienti_fatture.provincia.Provincia;
import com.epic_energy_services.gestione.clienti_fatture.provincia.ProvinciaService;
import com.opencsv.CSVReader;

@Component
public class GeneralRunner implements ApplicationRunner {
	
	@Autowired ComuneService comuneService;
	@Autowired ProvinciaService provinciaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("General Runner run...");
		
		//popolaDbProvince();
		//popolaDbComuni();
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
