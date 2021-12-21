package br.com.controlecondominio.ccoauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.controlecondominio.ccoauth.entities.User;
import br.com.controlecondominio.ccoauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;

	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		validarUser(user, "Email", email);
		logger.info("Email found: " + email);
		return user;
	}

	public User getUser(long userId) {
		User user = userFeignClient.findById(userId).getBody();
		validarUser(user, "Id" , String.valueOf(userId));
		logger.info("UserId found: " + userId);
		return user;
	}

	private void validarUser(User user, String descricaoCampo, String valorCampo) {
		if (user == null) {
			logger.error( descricaoCampo + " not found " + valorCampo);
			throw new UsernameNotFoundException(descricaoCampo + " not found");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(username).getBody();
		validarUser(user, "Email", username);
		logger.info("Email found: " + username);
		return user;
	}

}
