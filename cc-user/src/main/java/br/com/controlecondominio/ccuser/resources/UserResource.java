package br.com.controlecondominio.ccuser.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlecondominio.ccuser.entities.User;
import br.com.controlecondominio.ccuser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository repository;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = repository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {

		Optional<User> optionalUser = repository.findById(id);
		User user = optionalUser.get();
		return ResponseEntity.ok(user);

	}

	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {

		User user = repository.findByEmail(email);
		return ResponseEntity.ok(user);

	}

	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user) {
		System.out.println(passwordEncoder.encode(user.getPassword()));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user = repository.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
}
