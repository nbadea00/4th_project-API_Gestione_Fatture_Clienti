package com.epic_energy_services.gestione.clienti_fatture.runner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epic_energy_services.gestione.clienti_fatture.cliente.Cliente;
import com.epic_energy_services.gestione.clienti_fatture.comune.Comune;

import com.epic_energy_services.gestione.clienti_fatture.fattura.Fattura;
import com.epic_energy_services.gestione.clienti_fatture.indirizzo.Indirizzo;
import com.epic_energy_services.gestione.clienti_fatture.provincia.Provincia;
import com.opencsv.CSVReader;

@Component
public class GeneralRunner implements ApplicationRunner {
	@Autowired FactoryGenericaProva factoryGenericaProva;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("General Runner run...");
		//popolaDb();
	}
	
	public void popolaDb() {
		popolaDbProvince();
		popolaDbComuni();
		popolaDbIndirizzi();
		popolaDbClienti();
		popolaDbFatture();
	}
	
	public void popolaDbProvince() {
		try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/assets/province-italiane.csv"))) {
		    String[] values = null;
		    String[] keys = csvReader.readNext();
		    Map<String, String> mapProvincia = new HashMap<String, String>();
		    
		    while ((values = csvReader.readNext()) != null) {	    	
		    	for(int i = 0; i < keys.length; i++) {
		    		mapProvincia.put(keys[i], values[i]);
		    	}
		    	
		    	Provincia p = factoryGenericaProva.creaProvincia(mapProvincia, keys);
		    	
		    	System.out.println(p);
		    	
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("fine");
	}
	
	public void popolaDbComuni() {
		try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/assets/comuni-italiani.csv"))) {
		    String[] values = null;
		    String[] keys = csvReader.readNext();
		    Map<String, String> mapComuni = new HashMap<String, String>();
		    
		    while ((values = csvReader.readNext()) != null) {	    	
		    	for(int i = 0; i < keys.length; i++) {
		    		mapComuni.put(keys[i], values[i]);
		    	}
		    	
		    	Comune c = factoryGenericaProva.creaComune(mapComuni, keys);
		    	
		    	System.out.println(c);
		    	
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("fine");
	}
	
	public void popolaDbClienti() {
		try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/assets/clienti_db.csv"))) {
		    String[] values = null;
		    String[] keys = csvReader.readNext();
		    Map<String, String> mapCliente = new HashMap<String, String>();
		    
		    while ((values = csvReader.readNext()) != null) {	    	
		    	for(int i = 0; i < keys.length; i++)
		    		mapCliente.put(keys[i], values[i]);
		    	
		    	Cliente c = factoryGenericaProva.creaCriente(mapCliente, keys);
		    	
		    	System.out.println(c);
		    	
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("fine");
	}
	
	public void popolaDbIndirizzi() {
		try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/assets/indirizzi_db.csv"))) {
		    String[] values = null;
		    String[] keys = csvReader.readNext();
		    Map<String, String> mapIndirizzi = new HashMap<String, String>();
		    
		    while ((values = csvReader.readNext()) != null) {	    	
		    	for(int i = 0; i < keys.length; i++)
		    		mapIndirizzi.put(keys[i], values[i]);
		    	
		    	Indirizzo i = factoryGenericaProva.creaIndirizzo(mapIndirizzi, keys);
		    	
		    	System.out.println(i);
		    	
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("fine");
	}
	
	public void popolaDbFatture() {
		try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/assets/fatture_db.csv"))) {
		    String[] values = null;
		    String[] keys = csvReader.readNext();
		    Map<String, String> mapFatture = new HashMap<String, String>();
		    
		    while ((values = csvReader.readNext()) != null) {	    	
		    	for(int i = 0; i < keys.length; i++)
		    		mapFatture.put(keys[i], values[i]);
		    	
		    	Fattura f = factoryGenericaProva.creaFatture(mapFatture, keys);
		    	
		    	System.out.println(f);
		    	
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("fine");
	}

}
