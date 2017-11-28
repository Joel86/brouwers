package be.vdab.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Brouwer;

public interface BrouwerRepository extends JpaRepository<Brouwer, Long> {
	List<Brouwer> findByNaamStartingWith(String beginnaam);
	@Override
	Page<Brouwer> findAll(Pageable pageable);
}
