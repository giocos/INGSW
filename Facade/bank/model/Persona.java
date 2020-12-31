package model;

public class Persona {

	private String nome;
	private String cognome;
	private String codFisc;
	private String passwordAssegnata;

	public Persona() {}

	public Persona(String n, String c, String cf) {
		
		this.nome = n;
		this.cognome = c;
		this.codFisc = cf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodFisc() {
		return codFisc;
	}

	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}

	@Override
	public String toString() {

		return "Nome : " + this.nome + " Cognome : " + this.cognome + " Cod : " + this.codFisc;
	}

	public String getPasswordAssegnata() {
		return passwordAssegnata;
	}

	public void setPasswordAssegnata(String passwordAssegnata) {
		this.passwordAssegnata = passwordAssegnata;
	}

}
