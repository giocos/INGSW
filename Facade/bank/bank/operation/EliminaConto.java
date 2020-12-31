package bank.operation;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bank.dao.ContoBancarioDao;
import bank.dao.PersonaDao;
import model.ContoBancario;

public class EliminaConto {
	private ContoBancarioDao contoBancarioDao;
	private PersonaDao personaDao;

	public EliminaConto(PersonaDao pD, ContoBancarioDao cbD) {
		this.contoBancarioDao = cbD;
		this.setPersonaDao(pD);

	}

	public void elimina() {

		ContoBancario b = contoBancarioDao
				.findByPrimaryKey(Long.parseLong(JOptionPane.showInputDialog("INSERISCI COD CONTO")));

		contoBancarioDao.delete(b);
		JFrame f = new JFrame();
		JOptionPane.showMessageDialog(f, "Eliminazione Avvenuta con Successo.", "Sistema",
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
