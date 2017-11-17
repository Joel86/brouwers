package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brouwers")
class BrouwerController {
	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BEGINNNAAM_VIEW = "brouwers/beginnaam";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
	@GetMapping
	String findAll() {
		return BROUWERS_VIEW;
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
