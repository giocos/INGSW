package bank.operation;

import bank.dao.PersonaDao;
import bank.security.GeneratorePasswordUtenti;
import gui.RegistraUtenteFrame;


//Classe preposta alla registrazione di un nuovo utente

public class RegistraUtente {
	private PersonaDao personaDao; 
	private GeneratorePasswordUtenti generatorePassword;

	public RegistraUtente(PersonaDao pd, GeneratorePasswordUtenti g) {
		this.personaDao = pd;
		this.generatorePassword = g;

	}

	public void registraNuovoUtente() {
		new RegistraUtenteFrame(this, generatorePassword);

	}

	public PersonaDao getPersonaDao() {
		return personaDao;
	}

	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}



}
