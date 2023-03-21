package com.epic_energy_services.gestione.clienti_fatture.cliente;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
//@Component
public class ClienteRunner implements ApplicationRunner {
	@Autowired ClienteService cService;
	@Override
	public void run(ApplicationArguments args) throws Exception {

    Cliente c1 = new Cliente();
    c1.setCognomeContatto("rossi");
    c1.setDataInserimento(new Date(2023, 3, 4));
    c1.setDataUltimoContatto(null);
    c1.setEmail("rsossi5@email.com");
    c1.setEmailContatto("rsossi3@email.com");
    //c1.setFatturatoAnnuale(4.0);
    //c1.setFatture(null);
    //c1.setIndirizzoSedeLegale(null);
    //c1.setIndirizzoSedeOperativa();
    c1.setNomeContatto("mrossi");
    c1.setPartitaIva("ciao2");
    c1.setPec("tre");
    c1.setRagioneSociale("ciao");
    c1.setTelefono("3456");
    c1.setTelefonoContatto("34567");
    c1.setTipoCliente(TipoCliente.PA);
		
    cService.createCliente(c1);
    
	}

}
