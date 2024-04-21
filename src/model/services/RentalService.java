package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private Double pricePerHour;
	private Double pricePerDay;

	private TaxService TaxService;

	public RentalService(Double pricePerHour, Double pricePerDay, TaxService TaxService) {

		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.TaxService = TaxService;
	}

	public void processInvoice(CarRental carRental) {
//Duration.between pega o instante entre duas datas;
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hours = minutes / 60.0;

		double basicPayment;
		if (hours <= 12) {
			basicPayment = pricePerHour * Math.ceil(hours);
		} else {
			basicPayment = pricePerDay * Math.ceil(hours / 24.0);
		}
		double tax = TaxService.tax(basicPayment);
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}
