package com.pica.demo.security.oauth2.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		 
		/** 
		 * TODO: Implementar correctamente esta logica para:
		 * 	- Recibir user / pass encriptado con RSA-2048
		 * 	- Consultar los servicios de backend correspondientes para validar user / pass. 
		 */
		String name = authentication.getName();
	    String password = authentication.getCredentials().toString();
	    if ("admin".equals(name) && "system".equals(password)) {
	        List<GrantedAuthority> grantedAuths = new ArrayList<>();
	        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
	        return new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
	        
	    } else {
	        throw new BadCredentialsException("Invalid credentials!");
	    }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
