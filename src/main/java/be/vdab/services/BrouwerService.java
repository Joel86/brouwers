package be.vdab.services;

import java.util.List;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.BrouwerBeginnaam;

public interface BrouwerService {
	void create(Brouwer brouwer);
	List<Brouwer> findAll();
	List<Brouwer> findByNaam(String beginNaam);
	List<Brouwer> findByBeginnaam(BrouwerBeginnaam beginnaam);
}
