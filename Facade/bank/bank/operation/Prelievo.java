package bank.operation;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bank.dao.ContoBancarioDao;
import bank.dao.PersonaDao;
import model.ContoBancario;

public class Prelievo {
	private ContoBancarioDao contoBancarioDao;
	private PersonaDao personaDao;

	public Prelievo(PersonaDao pD, ContoBancarioDao cbD) {
		this.contoBancarioDao = cbD;
		this.setPersonaDao(pD);

	}

	public void preleva() {

		ContoBancario b = contoBancarioDao
				.findByPrimaryKey(Long.parseLong(JOptionPane.showInputDialog("INSERISCI COD CONTO")));
		Double prelievo = Double
				.parseDouble(JOptionPane.showInputDialog("INSERISCI AMMONTARE PRELIEVO, MAX :" + b.getAmount()));

		if (prelievo > b.getAmount()) {
			prelievo = b.getAmount();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "IMPORTO MASSIMO DI PRELIEVO MODIFICATO A : " + b.getAmount(), "Sistema",
					JOptionPane.INFORMATION_MESSAGE);
			f.dispose();

		}
		b.setAmount(b.getAmount() - prelievo);

		contoBancarioDao.update(b);
		JFrame f = new JFrame();
		JOptionPane.showMessageDialog(f, "Prelievo Avvenuto con Successo.", "Sistema", JOptionPane.INFORMATION_MESSAGE);
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
