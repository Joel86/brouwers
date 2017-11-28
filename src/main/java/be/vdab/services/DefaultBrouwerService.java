package be.vdab.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.vdab.entities.Brouwer;
import be.vdab.repositories.BrouwerRepository;
import be.vdab.valueobjects.BrouwerBeginnaam;

@ReadOnlyTransactionalService
class DefaultBrouwerService implements BrouwerService {
	private final BrouwerRepository brouwerRepository;
	public DefaultBrouwerService(BrouwerRepository brouwerRepository) {
		this.brouwerRepository = brouwerRepository;
	}
	@Override
	@ModifyingTransactionalServiceMethod
	public void create(Brouwer brouwer) {
		brouwerRepository.save(brouwer);
	}
	@Override
	public Page<Brouwer> findAll(Pageable pageable) {
		return brouwerRepository.findAll(pageable);
	}
	@Override
	public List<Brouwer> findByBeginnaam(BrouwerBeginnaam beginnaam) {
		return brouwerRepository.findByNaamStartingWith(beginnaam.getBeginnaam());
	}
}
