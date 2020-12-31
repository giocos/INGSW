
package gui;

import java.awt.Dimension;

import javax.swing.JOptionPane;

import bank.operation.RegistraUtente;
import bank.security.GeneratorePasswordUtenti;
import model.Persona;

public class RegistraUtenteFrame extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//Button e textFields
	private javax.swing.JLabel codFiscLabel;
	private javax.swing.JTextField codFiscText;
	private javax.swing.JLabel cognomeLabel;
	private javax.swing.JTextField cognomeText;
	private javax.swing.JTextField nameText;
	private javax.swing.JLabel nomeLabel;
	private javax.swing.JButton registerButton;
	private javax.swing.JLabel topRegisterLabel;

	//Oggetti preposti alla creazione della Persona
	private Persona personaDaRegistrare;
	private RegistraUtente registratoreDiUtenti;
	private GeneratorePasswordUtenti generatorePassword;

	public RegistraUtenteFrame(RegistraUtente ru, GeneratorePasswordUtenti g) {
		
		this.registratoreDiUtenti = ru;
		this.generatorePassword = g;
		initComponents();
	}

	private void initComponents() {

		nomeLabel = new javax.swing.JLabel();
		cognomeLabel = new javax.swing.JLabel();
		codFiscLabel = new javax.swing.JLabel();
		nameText = new javax.swing.JTextField();
		cognomeText = new javax.swing.JTextField();
		codFiscText = new javax.swing.JTextField();
		topRegisterLabel = new javax.swing.JLabel();
		registerButton = new javax.swing.JButton();

		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		nomeLabel.setText("nome");
		cognomeLabel.setText("cognome");
		codFiscLabel.setText("codFisc");
		topRegisterLabel.setText("REGISTRA UTENTE");
		registerButton.setText("OK!");
		registerButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				registerButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(31, 31, 31)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(layout.createSequentialGroup()
										.addComponent(cognomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(cognomeText))
								.addGroup(layout.createSequentialGroup()
										.addComponent(codFiscLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(codFiscText, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(topRegisterLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
														128, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(nameText))))
						.addContainerGap(53, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(registerButton).addGap(131, 131, 131)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(topRegisterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(41, 41, 41)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(53, 53, 53)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cognomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cognomeText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(40, 40, 40)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(codFiscText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(codFiscLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18).addComponent(registerButton).addContainerGap(27, Short.MAX_VALUE)));

		pack();
		this.setSize(new Dimension(400, 400));
		this.setLocationRelativeTo(null);
		this.setTitle("REGISTRA");
		this.setVisible(true);

	}

	private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
		
		personaDaRegistrare = new Persona();
		personaDaRegistrare.setNome(nameText.getText());
		personaDaRegistrare.setCognome(cognomeText.getText());
		personaDaRegistrare.setCodFisc(codFiscText.getText());
		personaDaRegistrare.setPasswordAssegnata(generatorePassword.generaPassRandom());
		JOptionPane.showMessageDialog(this,
				"UTENTE REGISTRATO CON PASSWORD " + personaDaRegistrare.getPasswordAssegnata(), "FATTO!",
				JOptionPane.INFORMATION_MESSAGE, null);
	
		registratoreDiUtenti.getPersonaDao().save(personaDaRegistrare);// SALVO L'UTENTE SUL DB
		dispose();
	}
}
