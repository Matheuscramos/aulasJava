package model.entities;

public class Invoice {// Invoice:fatura

	private Double basicPayment;// basicPayment:PagamentoBasico
	private Double tax;// tax:imposto

	public Invoice(Double basicPayment, Double tax) {

		this.basicPayment = basicPayment;
		this.tax = tax;
	}

	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getTotalPayment() {
		return getBasicPayment() + getTax();// foi usado os gets e não os atriputos da classe, porque no tax que e o
											// imposto pode ser incluido alguma regra de taxação do governo.
	}
}
