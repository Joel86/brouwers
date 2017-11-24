package be.vdab.entities;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import be.vdab.valueobjects.Adres;

public class Brouwer implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	@NotBlank @SafeHtml
	private String naam;
	@Min(0)
	private Integer omzet;
	@NotNull
	@Valid
	private Adres adres;
	public Brouwer() {}	
	public Brouwer(long brouwerNr, String naam, Integer omzet, Adres adres) {
		this.id = brouwerNr;
		this.naam = naam;
		this.omzet = omzet;
		this.adres = adres;
	}
	public long getId() {
		return id;
	}
	public void setId(long brouwerNr) {
		this.id = brouwerNr;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public Integer getOmzet() {
		return omzet;
	}
	public void setOmzet(Integer omzet) {
		this.omzet = omzet;
	}
	public Adres getAdres() {
		return adres;
	}
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
}
