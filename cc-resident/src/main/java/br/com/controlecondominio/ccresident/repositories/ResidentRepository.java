package br.com.controlecondominio.ccresident.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlecondominio.ccresident.entities.Resident;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long>{

}
