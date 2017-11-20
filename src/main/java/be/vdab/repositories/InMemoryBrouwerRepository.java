package be.vdab.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

@Repository
class InMemoryBrouwerRepository implements BrouwerRepository {
	private Map<Long, Brouwer> brouwers = new ConcurrentHashMap<>();
	public InMemoryBrouwerRepository() {
		brouwers.put(1L, new Brouwer(1L, "InBev", 3_000_000, 
				new Adres("Kapelstraat", "12", 3000, "Brussel")));
		brouwers.put(2L, new Brouwer(2L, "Moortgat", 2_500_000, 
				new Adres("Torenstraat", "13", 2000, "Gent")));
		brouwers.put(3L, new Brouwer(3L, "Martins", 3_500_000, 
				new Adres("Kerkstraat", "225", 3500, "Hasselt")));
		brouwers.put(4L, new Brouwer(4L, "Leffe", 3_900_000, 
				new Adres("Waterstraat", "112", 3900, "Bree")));
	}
	@Override
	public void create(Brouwer brouwer) {
		brouwers.put(brouwer.getBrouwerNr(), brouwer);
	}
	@Override
	public List<Brouwer> findAll() {
		return new ArrayList<>(brouwers.values());
	}
	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		List<Brouwer> brouwersByNaam = new ArrayList<>();
		beginNaam = beginNaam.toUpperCase();
		for(Brouwer brouwer : brouwers.values()) {
			if(brouwer.getNaam().toUpperCase().startsWith(beginNaam)) {
				brouwersByNaam.add(brouwer);
			}
		}
		return brouwersByNaam;
	}
}