package bank.operation;

import bank.dao.ContoBancarioDao;
import bank.dao.PersonaDao;
import gui.ApriContoFrame;

public class ApriConto {
	// Classe preposta all'apertura di un nuovo conto
	
	private ContoBancarioDao contoBancarioDao;
	private PersonaDao personaDao;


	public ApriConto( PersonaDao pD, ContoBancarioDao cbD) {
		this.contoBancarioDao = cbD;
		this.setPersonaDao(pD);

	}

	public void registraNuovoConto() {
		new ApriContoFrame(this);
	}

	public ContoBancarioDao getContoBancarioDao() {
		return contoBancarioDao;
	}

	public void setContoBancarioDao(ContoBancarioDao contoBancarioDao) {
		this.contoBancarioDao = contoBancarioDao;
	}



	public PersonaDao getPersonaDao() {
		return personaDao;
	}

	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}

}
