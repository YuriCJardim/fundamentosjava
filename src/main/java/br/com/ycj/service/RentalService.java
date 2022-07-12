package br.com.ycj.service;

import br.com.ycj.model.CarRental;
import br.com.ycj.model.Invoice;

/**
 * Classe de servi�o responsavel por processar o aluguel
 * @author layeyuri
 *
 */
public class RentalService {

	private Double pricePerHour;
	private Double pricePerDay;
	private BrasilTaxService taxService;

	public RentalService() {
	}

	public RentalService(Double pricePerHour, Double pricePerDay, BrasilTaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public BrasilTaxService getBrasiltax() {
		return taxService;
	}

	public void setBrasiltax(BrasilTaxService taxService) {
		this.taxService = taxService;
	}

	/**
	 * Processando o recibo
	 * @param carRental
	 */
	public Invoice processInvoice(CarRental carRental) {

		long T1 = carRental.getStart().getTime();
		long T2 = carRental.getFinish().getTime();

		double hours = (double) (T2 - T1) / 1000 / 60 / 60;

		double basicPayment;
		if (hours <= 12) {
			basicPayment = Math.ceil(hours) * pricePerHour;
		} else {
			basicPayment = Math.ceil(hours / 24) * pricePerDay;
		}
		double tax = taxService.tax(basicPayment);

		return new Invoice(basicPayment, tax);

	}

}
