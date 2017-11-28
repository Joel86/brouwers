package be.vdab.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.BrouwerBeginnaam;

public interface BrouwerService {
	void create(Brouwer brouwer);
	Page<Brouwer> findAll(Pageable pageable);
	List<Brouwer> findByBeginnaam(BrouwerBeginnaam beginnaam);
}
