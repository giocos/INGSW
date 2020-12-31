package bank.operation;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bank.dao.ContoBancarioDao;
import bank.dao.PersonaDao;
import model.ContoBancario;

public class Deposito {
	//CLASSE PREPOSTA AL DEPOSITO
	private ContoBancarioDao contoBancarioDao;
	private PersonaDao personaDao;

	public Deposito(PersonaDao pD, ContoBancarioDao cbD) {
		this.contoBancarioDao = cbD;
		this.setPersonaDao(pD);

	}

	public void deposita() {
		
		
	ContoBancario b = 	contoBancarioDao.findByPrimaryKey(Long.parseLong(JOptionPane.showInputDialog("INSERISCI COD CONTO")));
	Double deposito = Double.parseDouble(JOptionPane.showInputDialog("INSERISCI AMMONTARE DEPOSITO"));
	
	b.setAmount(b.getAmount()+deposito);
	
	contoBancarioDao.update(b);
	JFrame f = new JFrame();
	JOptionPane.showMessageDialog(f,
		    "Deposito Avvenuto con Successo.",
		    "Sistema",
		    JOptionPane.INFORMATION_MESSAGE);	
				f.dispose();
		
		
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