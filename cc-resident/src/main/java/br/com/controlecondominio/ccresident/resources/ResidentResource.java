package br.com.controlecondominio.ccresident.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlecondominio.ccresident.entities.Resident;
import br.com.controlecondominio.ccresident.repositories.ResidentRepository;

@RestController
@RequestMapping(value = "/residents")
public class ResidentResource {

	@Autowired
	private ResidentRepository repository;

	@GetMapping(value = "/{id}")
	private ResponseEntity<Resident> findById(@PathVariable Long id) {
		System.out.println(id);
		System.out.println(repository);
		System.out.println(repository.findById(id));
		Resident resident = repository.findById(id).get();
		return ResponseEntity.ok(resident);
	}

	@GetMapping
	private ResponseEntity<List<Resident>> findAll() {
		System.out.println(repository);
		List<Resident> listResidents = repository.findAll();
		return ResponseEntity.ok(listResidents);

	}

	@GetMapping(value = "/page")
	private ResponseEntity<Page<Resident>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Resident> findAll = repository.findAll(pageRequest);
		return ResponseEntity.ok(findAll);
	}

	@PostMapping
	private ResponseEntity<Resident> salvar(@RequestBody Resident resident) {
		resident = repository.save(resident);
		return ResponseEntity.status(HttpStatus.CREATED).body(resident);
	}

	@PutMapping(value = "/{id}")
	private ResponseEntity<Resident> edit(@RequestBody Resident resident, @PathVariable Long id) {
		resident.setId(id);
		resident = repository.save(resident);
		return ResponseEntity.status(HttpStatus.CREATED).body(resident);
	}

	@DeleteMapping(value = "/{id}")
	private ResponseEntity<Void> delete(@PathVariable Long id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();

	}
}
