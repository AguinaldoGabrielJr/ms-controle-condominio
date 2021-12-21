package br.com.controlecondominio.ccresident.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.controlecondominio.ccresident.entities.Resident;
import br.com.controlecondominio.ccresident.repositories.ResidentRepository;

@Service
public class ResidentService {

	@Autowired
	private ResidentRepository repository;

	public Resident findById(Long id) {
		return repository.findById(id).get();
	}

	public List<Resident> findAll() {
		return repository.findAll();
	}

	public Page<Resident> findAll(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Resident> pages = repository.findAll(pageRequest);	
		return pages;
	}

	public Resident save(Resident resident) {
		return repository.save(resident);
	}
	
	public Resident save(Resident resident, Long id) {
		resident.setId(id);
		resident = repository.save(resident);
		return resident;
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
