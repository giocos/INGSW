package gui;

import java.util.List;

import javax.swing.JTable;

import model.ContoBancario;

public class TableConti extends JTable {
	
	private static final long serialVersionUID = 1L;

	private static String[] columnNames = { "Codice", "Saldo", "Codice Titolare", "Nome", "Cognome" };

	public TableConti(List<ContoBancario> c) {
		super(parseConti(c), columnNames);
	}

	public static Object[][] parseConti(List<ContoBancario> conti) {

		Object[][] data = new Object[conti.size()][5];
		for(int i = 0; i < conti.size(); i++) {
			for(int j = 0; j < 5; j++) {

				switch (j) {
				case 0:
					data[i][j] = conti.get(i).getCodConto();
					break;
				case 1:
					data[i][j] = new Double(conti.get(i).getAmount());
					break;
				case 2:
					data[i][j] = conti.get(i).getTitolare().getCodFisc();
					break;
				case 3:
					data[i][j] = conti.get(i).getTitolare().getNome();
					break;
				case 4:
					data[i][j] = conti.get(i).getTitolare().getCognome();
					break;
				default:
					break;
				}
			}
		}
		return data;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		TableConti.columnNames = columnNames;
	}
}