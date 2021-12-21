package br.com.controlecondominio.ccoauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.controlecondominio.ccoauth.entities.User;

@Component
@FeignClient(name = "cc-user", path = "/users")
public interface UserFeignClient {

	@GetMapping(value = "/{id}")
	ResponseEntity<User> findById(@PathVariable Long id);

	@GetMapping(value = "/search")
	ResponseEntity<User> findByEmail(@RequestParam String email);
}
