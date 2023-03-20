package com.epic_energy_services.gestione.clienti_fatture.runner;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

@Component
public class GeneralRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("General Runner run...");
		
		List<List<String>> comuni = new ArrayList<List<String>>();
		try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/assets/comuni-italiani.csv"));) {
		    String[] values = null;
		    while ((values = csvReader.readNext()) != null) {
//		    	values[i].split(";");
		    	comuni.add(Arrays.asList(values));
		    }
		}
		
		System.out.println(comuni.get(1));
		System.out.println(comuni.get(1).get(0));
		
		System.out.println(comuni.get(1).get(0).split(";"));
		
		

	}

}
