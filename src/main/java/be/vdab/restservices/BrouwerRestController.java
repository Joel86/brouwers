package be.vdab.restservices;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import be.vdab.entities.Brouwer;
import be.vdab.exceptions.BrouwerNietGevondenException;
import be.vdab.services.BrouwerService;
import be.vdab.valueobjects.BrouwerBeginnaam;

@RestController
@ExposesResourceFor(Brouwer.class)
@RequestMapping("/brouwers")
class BrouwerRestController {
	private final BrouwerService brouwerService;
	private final EntityLinks entityLinks;
	BrouwerRestController(BrouwerService brouwerService, EntityLinks entityLinks) {
		this.brouwerService = brouwerService;
		this.entityLinks = entityLinks;
	}
	@GetMapping("{brouwer}")
	BrouwerResource read(@PathVariable Brouwer brouwer) {
		if(brouwer == null) {
			throw new BrouwerNietGevondenException();
		}
		return new BrouwerResource(brouwer, entityLinks);
	}
	@ExceptionHandler(BrouwerNietGevondenException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	void brouwerNietGevonden() {}
	
	@GetMapping(params="beginnaam")
	BrouwersResource findAll(String beginnaam) {
		BrouwerBeginnaam brouwerBeginnaam = new BrouwerBeginnaam();
		brouwerBeginnaam.setBeginnaam(beginnaam);
		return new BrouwersResource(brouwerService.findByBeginnaam(
				brouwerBeginnaam), entityLinks);
	}
}
