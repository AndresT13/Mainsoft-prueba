package com.mainsoft.app.ecommerce.servicesImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class UsuarioService implements UserDetailsService {
	
	public static String[] obtenerUser() throws IOException {

		File file = ResourceUtils.getFile("classpath:user.txt");

		String content = new String(Files.readAllBytes(file.toPath()));
		String users[] = content.split("\\|");
		return users;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		String user = "";
		String password = "";

		try {
			String users[] = obtenerUser();
			for (String us : users) {
				String autenticacion[] = us.split("\\,");
				String userNew = autenticacion[0];
				String pass = autenticacion[1];

				if (username.equals(autenticacion[0])) {
					user = userNew;
					password = pass;
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return new User(user, encoder.encode(password), globalAuth(3));

	}

	public List<GrantedAuthority> globalAuth(int rol) {
		String[] roles = { "READER", "USER", "ADMIN" };

		List<GrantedAuthority> autorizacion = new ArrayList<>();

		for (int i = 0; i < rol; i++) {
			autorizacion.add(new SimpleGrantedAuthority(roles[i]));
		}

		return autorizacion;
	}

}
