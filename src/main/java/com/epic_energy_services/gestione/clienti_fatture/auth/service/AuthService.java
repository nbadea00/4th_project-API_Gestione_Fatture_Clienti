package com.epic_energy_services.gestione.clienti_fatture.auth.service;

import com.epic_energy_services.gestione.clienti_fatture.auth.payload.LoginDto;
import com.epic_energy_services.gestione.clienti_fatture.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
