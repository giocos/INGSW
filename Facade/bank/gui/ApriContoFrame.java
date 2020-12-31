/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;

import javax.swing.JOptionPane;

import bank.operation.ApriConto;
import model.ContoBancario;

public class ApriContoFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	//JFRAME ELEMENTS
	private javax.swing.JLabel amountLabel;
	private javax.swing.JTextField amoutText;
	private javax.swing.JLabel codFiscLabel;
	private javax.swing.JTextField codFiscText;
	private javax.swing.JButton confirmButton;
	private javax.swing.JLabel passwordLabel;
	private javax.swing.JPasswordField passwordText;
	private javax.swing.JLabel topLabel;

	//DB ELEMENTS
	private ApriConto apriConto;
	private ContoBancario contoDaRegistrare;
  
	public ApriContoFrame(ApriConto aC) {
		
		this.setApriConto(aC);
		initComponents();
	}

	private void initComponents() {

		codFiscLabel = new javax.swing.JLabel();
		codFiscText = new javax.swing.JTextField();
		amountLabel = new javax.swing.JLabel();
		amoutText = new javax.swing.JTextField();
		passwordLabel = new javax.swing.JLabel();
		passwordText = new javax.swing.JPasswordField();
		confirmButton = new javax.swing.JButton();
		topLabel = new javax.swing.JLabel();

		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		codFiscLabel.setText("CodiceFiscTitolare");
		amountLabel.setText("AmmontareIniziale");
		passwordLabel.setText("PasswordTitolare");
		passwordText.setText("jPasswordField1");
		confirmButton.setText("OK!");
		confirmButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				confirmButtonActionPerformed(evt);
			}
		});

		topLabel.setText("APRI CONTO");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout
												.createSequentialGroup()
												.addComponent(codFiscLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(44, 44, 44).addComponent(codFiscText,
														javax.swing.GroupLayout.PREFERRED_SIZE, 186,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
														javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(44, 44, 44)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(amoutText, javax.swing.GroupLayout.DEFAULT_SIZE,
																186, Short.MAX_VALUE)
														.addComponent(passwordText)))))
						.addGroup(layout.createSequentialGroup().addGap(134, 134, 134).addComponent(confirmButton,
								javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(143, 143, 143).addComponent(topLabel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(51, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addComponent(
						topLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(codFiscLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(codFiscText, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(37, 37, 37)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(amoutText, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(28, 28, 28)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18).addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(30, Short.MAX_VALUE)));

		pack();
		this.setSize(new Dimension(400, 400));
		this.setLocationRelativeTo(null);
		this.setTitle("REGISTRA");
		this.setVisible(true);
	}

	private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {
		contoDaRegistrare = new ContoBancario();
		contoDaRegistrare.setAmount(Double.parseDouble(amoutText.getText()));
		contoDaRegistrare.setTitolare(apriConto.getPersonaDao().findByPrimaryKey(codFiscText.getText()));
		
	
		apriConto.getContoBancarioDao().save(contoDaRegistrare);
		JOptionPane.showMessageDialog(this,
				"CONTO REGISTRATO CON NUMERO " +contoDaRegistrare.getCodConto() , "FATTO!",
				JOptionPane.INFORMATION_MESSAGE, null);
		dispose();
	}

	public ApriConto getApriConto() {
		return apriConto;
	}

	public void setApriConto(ApriConto apriConto) {
		this.apriConto = apriConto;
	}
}
