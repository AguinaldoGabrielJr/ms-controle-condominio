package br.com.controlecondominio.ccuser.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlecondominio.ccuser.entities.User;
import br.com.controlecondominio.ccuser.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/users")
@Api(value = "User")
public class UserResource {

	@Autowired
	private UserService service;

	@ApiOperation(value = "Buscar todos")
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@ApiOperation(value = "Buscar todos os Users por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {

		User user = service.findById(id);
		return ResponseEntity.ok(user);

	}

	@ApiOperation(value = "Buscar todos os User por email")
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {

		User user = service.findByEmail(email);
		return ResponseEntity.ok(user);

	}

	@ApiOperation(value = "Salvar User")
	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user) {
		user = service.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
}
