package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		// O fmt vai ler o formato que se espera da data.
		System.out.println("Entre com os dados do aluguel!");
		System.out.print("Modelo do carro: ");
		String carModel = sc.nextLine();

		System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);// aqui será lido a no sc.nextLine(), no formato
																		// fmt
		System.out.println("Retorno (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
		// aqui eu faço a instância do Obj CarRental e o objeto new Vehicle(carModel) e
		// instâciado assim, porque o new Vehicle(carModel) esta fazendo uma composição
		// na classe
		// CarRental, e sua composição e feita assim private Vehicle vehicle; na classe
		// CarRental.
		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

		System.out.println("Entre com o preço por Hora:");
		double privePerHour = sc.nextDouble();
		System.out.println("Entre com o preço por Dia:");
		double pricePerDay = sc.nextDouble();

		RentalService rentalService = new RentalService(privePerHour, pricePerDay, new BrazilTaxService());
		rentalService.processInvoice(carRental);

		System.out.println("Fatura:");
		System.out.println("Pagamento Básico: " + carRental.getInvoice().getBasicPayment());
		System.out.println("Imposto: " + carRental.getInvoice().getTax());
		System.out.println("Pagamento total: " + carRental.getInvoice().getTotalPayment());

		sc.close();
	}

}
