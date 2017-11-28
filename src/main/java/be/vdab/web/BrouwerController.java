package be.vdab.web;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;
import be.vdab.valueobjects.BrouwerBeginnaam;

@Controller
@RequestMapping("/brouwers")
class BrouwerController {
	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BEGINNNAAM_VIEW = "brouwers/beginnaam";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
	private static final String BROUWERS_OP_ALFABET_VIEW = "brouwers/opalfabet";
	private static final String REDIRECT_NA_TOEVOEGEN = "redirect:/brouwers";
	private final char[] alfabet = new char['Z' - 'A' + 1];
	private final BrouwerService brouwerService;
	public BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
		for(char letter = 'A' ; letter <= 'Z' ; letter++) {
			alfabet[letter - 'A'] = letter;
		}
	}
	@GetMapping
	ModelAndView findAll(Pageable pageable) {
		return new ModelAndView(BROUWERS_VIEW, "page", brouwerService.findAll(pageable));
	}
	@GetMapping("beginnaam")
	ModelAndView findByBeginnaamForm() {
		BrouwerBeginnaam beginnaam = new BrouwerBeginnaam();
		return new ModelAndView(BEGINNNAAM_VIEW).addObject(beginnaam);
	}
	@GetMapping(params = "beginnaam")
	ModelAndView findByBeginnaam(@Valid BrouwerBeginnaam beginnaam, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(BEGINNNAAM_VIEW);
		if(!bindingResult.hasErrors()) {
			modelAndView.addObject("brouwers", brouwerService.findByBeginnaam(beginnaam));
		}
		return modelAndView;
	}
	@GetMapping("toevoegen")
	ModelAndView toevoegForm() {
		return new ModelAndView(TOEVOEGEN_VIEW).addObject(new Brouwer());
	}
	@PostMapping
	String create(@Valid Brouwer brouwer, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return TOEVOEGEN_VIEW;
		}
		brouwerService.create(brouwer);
		return REDIRECT_NA_TOEVOEGEN;
	}
	@GetMapping("opalfabet")
	ModelAndView opAlfabetform() {
		return new ModelAndView(BROUWERS_OP_ALFABET_VIEW, "alfabet", alfabet);
	}
	@GetMapping(params = "letter")
	ModelAndView opAlfabet(@RequestParam char letter) {
		BrouwerBeginnaam beginnaam = new BrouwerBeginnaam();
		beginnaam.setBeginnaam(String.valueOf(letter));
		return new ModelAndView(BROUWERS_OP_ALFABET_VIEW)
				.addObject("alfabet", alfabet)
				.addObject("brouwers", brouwerService.findByBeginnaam(beginnaam));
	}
	@InitBinder("brouwer")
	void initBinderBrouwer(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
}
