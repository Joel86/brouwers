package be.vdab.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
class BrouwerController {
	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BEGINNNAAM_VIEW = "brouwers/beginnaam";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
	private final BrouwerService brouwerService;
	public BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
	}
	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerService.findAll());
	}
	@GetMapping("beginnaam")
	String beginnaam() {
		return BEGINNNAAM_VIEW;
	}
	@GetMapping("toevoegen")
	String toevoegForm() {
		return TOEVOEGEN_VIEW;
	}
}