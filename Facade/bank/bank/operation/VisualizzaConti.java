package bank.operation;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import bank.dao.ContoBancarioDao;
import gui.TableConti;

public class VisualizzaConti {

	private TableConti tabella;

	private ContoBancarioDao contoBancarioDao;

	public VisualizzaConti(ContoBancarioDao daoBank) {
		this.setContoBancarioDao(daoBank);
	}

	public ContoBancarioDao getContoBancarioDao() {
		return contoBancarioDao;
	}

	public void setContoBancarioDao(ContoBancarioDao daoBank) {
		this.contoBancarioDao = (ContoBancarioDao) daoBank;
	}

	public TableConti getTabella() {
		return tabella;
	}

	public void setTabella(TableConti tabella) {
		this.tabella = tabella;
	}
	
	public void visualizzaConti() {
		JFrame f = new JFrame();
		tabella = new TableConti(contoBancarioDao.findAll());
		f.add(new JScrollPane(tabella));
		f.setVisible(true);
		f.setSize(600, 500);

		
		
	}

}
