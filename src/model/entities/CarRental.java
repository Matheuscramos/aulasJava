package model.entities;

import java.time.LocalDateTime;

public class CarRental {// CarRental: aluguelCarro.

	private LocalDateTime start;// início do aluguel.
	private LocalDateTime finish;// fim do aluguel.
	// LocalDateTime pega o dia e a hora.

	private Vehicle vehicle;
	private Invoice invoice;

	public CarRental() {

	}

	public CarRental(LocalDateTime start, LocalDateTime finish, Vehicle vehicle) {

		this.start = start;
		this.finish = finish;
		this.vehicle = vehicle;
		;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getFinish() {
		return finish;
	}

	public void setFinish(LocalDateTime finish) {
		this.finish = finish;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
