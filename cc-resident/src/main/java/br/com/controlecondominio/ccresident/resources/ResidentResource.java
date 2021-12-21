package br.com.controlecondominio.ccresident.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import br.com.controlecondominio.ccresident.services.ResidentService;

@RestController
@RequestMapping(value = "/residents")
public class ResidentResource {

	@Autowired
	private ResidentService service;
	
	@GetMapping(value = "/{id}")
	private ResponseEntity<Resident> findById(@PathVariable Long id) {
		Resident resident = service.findById(id);
		return ResponseEntity.ok(resident);
	}

	@GetMapping
	private ResponseEntity<List<Resident>> findAll() {
		List<Resident> listResidents = service.findAll();
		return ResponseEntity.ok(listResidents);

	}

	@GetMapping(value = "/page")
	private ResponseEntity<Page<Resident>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		return ResponseEntity.ok(service.findAll(page, linesPerPage, orderBy, direction));
	}

	@PostMapping
	private ResponseEntity<Resident> salvar(@RequestBody Resident resident) {
		resident = service.save(resident);
		return ResponseEntity.status(HttpStatus.CREATED).body(resident);
	}

	@PutMapping(value = "/{id}")
	private ResponseEntity<Resident> edit(@RequestBody Resident resident, @PathVariable Long id) {
		resident = service.save(resident, id);
		return ResponseEntity.status(HttpStatus.CREATED).body(resident);
	}

	@DeleteMapping(value = "/{id}")
	private ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();

	}
}
