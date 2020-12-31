package model;

public class ContoBancario {

	private Persona titolare;
	private Long codConto;
	private double amount;

	public ContoBancario() {}

	public ContoBancario(Persona tit, double cash) {
		
		this.titolare = tit;
		this.amount = cash;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Persona getTitolare() {
		return titolare;
	}

	public void setTitolare(Persona titolare) {
		this.titolare = titolare;
	}

	public Long getCodConto() {
		return codConto;
	}

	public void setCodConto(Long codConto) {
		this.codConto = codConto;
	}

	@Override
	public String toString() {
		return "Conto n° : " + codConto + " Titolare : " + titolare.getCodFisc();
	}
}
