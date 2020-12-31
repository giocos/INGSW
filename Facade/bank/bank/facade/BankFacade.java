package bank.facade;

import java.awt.Dimension;

import bank.dao.ContoBancarioDao;
import bank.dao.DAOFactory;
import bank.dao.PersonaDao;
import bank.dao.UtilDao;
import bank.operation.*;
import bank.security.GeneratorePasswordUtenti;

public class BankFacade extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	// Variabili del JFRAME
	private javax.swing.JButton CreaContoButton;
	private javax.swing.JButton DepositaButton;
	private javax.swing.JButton EXITBUTTON;
	private javax.swing.JButton EliminaConto;
	private javax.swing.JButton VisualizzaConti;
	private javax.swing.JButton creaUtenteButton;
	private javax.swing.JButton prelevaButton;

	// DAO, oggetti comuni usati dagli oggetti nella facciata
	private static DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
	private ContoBancarioDao contoBancarioDao;
	private PersonaDao personaDao;
	private UtilDao util;
	// OGGETTI RACCHIUSI NELLA FACCIATA
	private ApriConto apriConto;
	private Deposito deposito;
	private EliminaConto eliminaConto;
	private Prelievo prelievo;
	private RegistraUtente registraUtente;
	private VisualizzaConti visualizzaConti;

	public BankFacade() {
		
		util = factory.getUtilDAO();
		contoBancarioDao = factory.getContoBancarioDAO();
		personaDao = factory.getPersonaDAO();
		apriConto = new ApriConto(personaDao, contoBancarioDao);
		deposito = new Deposito(personaDao, contoBancarioDao);
		eliminaConto = new EliminaConto(personaDao, contoBancarioDao);
		prelievo = new Prelievo(personaDao, contoBancarioDao);
		registraUtente = new RegistraUtente(personaDao, new GeneratorePasswordUtenti());
		visualizzaConti = new VisualizzaConti(contoBancarioDao);
		initComponents();
	}

	private void initComponents() {

		creaUtenteButton = new javax.swing.JButton();
		CreaContoButton = new javax.swing.JButton();
		DepositaButton = new javax.swing.JButton();
		prelevaButton = new javax.swing.JButton();
		EliminaConto = new javax.swing.JButton();
		EXITBUTTON = new javax.swing.JButton();
		VisualizzaConti = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		creaUtenteButton.setText("Registra Utente");
		creaUtenteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				creaUtenteButtonActionPerformed(evt);
			}
		});

		CreaContoButton.setText("Apri Conto");
		CreaContoButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CreaContoButtonActionPerformed(evt);
			}
		});

		DepositaButton.setText("Deposita");
		DepositaButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DepositaButtonActionPerformed(evt);
			}
		});

		prelevaButton.setText("Preleva");
		prelevaButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				prelevaButtonActionPerformed(evt);
			}
		});

		EliminaConto.setText("Elimina Conto");
		EliminaConto.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				EliminaContoActionPerformed(evt);
			}
		});

		EXITBUTTON.setText("EXIT");
		EXITBUTTON.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				EXITBUTTONActionPerformed(evt);
			}
		});

		VisualizzaConti.setText("Visualizza Saldo");
		VisualizzaConti.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				VisualizzaContiActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addContainerGap()
										.addComponent(creaUtenteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(CreaContoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(DepositaButton,
												javax.swing.GroupLayout.PREFERRED_SIZE, 173,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addContainerGap()
										.addComponent(prelevaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(EliminaConto, javax.swing.GroupLayout.PREFERRED_SIZE, 173,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(VisualizzaConti,
												javax.swing.GroupLayout.PREFERRED_SIZE, 173,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(238, 238, 238).addComponent(EXITBUTTON,
										javax.swing.GroupLayout.PREFERRED_SIZE, 88,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(20, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(creaUtenteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(CreaContoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(DepositaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(36, 36, 36)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(prelevaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(EliminaConto, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(VisualizzaConti, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(35, 35, 35).addComponent(EXITBUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(33, Short.MAX_VALUE)));

		pack();
		this.setSize(new Dimension(600, 400));
		this.setLocationRelativeTo(null);
		this.setTitle("WELCOME TO BANK");
		this.setVisible(true);
	}

	private void EXITBUTTONActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(EXIT_ON_CLOSE);
	}

	private void creaUtenteButtonActionPerformed(java.awt.event.ActionEvent evt) {
		registraUtente.registraNuovoUtente();
	}

	private void CreaContoButtonActionPerformed(java.awt.event.ActionEvent evt) {
		apriConto.registraNuovoConto();
	}

	private void DepositaButtonActionPerformed(java.awt.event.ActionEvent evt) {
		deposito.deposita();
	}

	private void prelevaButtonActionPerformed(java.awt.event.ActionEvent evt) {
		prelievo.preleva();
	}

	private void EliminaContoActionPerformed(java.awt.event.ActionEvent evt) {
		eliminaConto.elimina();
	}

	private void VisualizzaContiActionPerformed(java.awt.event.ActionEvent evt) {
		visualizzaConti.visualizzaConti();
	}

	public ApriConto getApriConto() {
		return apriConto;
	}

	public void setApriConto(ApriConto apriConto) {
		this.apriConto = apriConto;
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

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

	public EliminaConto getEliminaConto() {
		return eliminaConto;
	}

	public void setEliminaConto(EliminaConto eliminaConto) {
		this.eliminaConto = eliminaConto;
	}

	public UtilDao getUtil() {
		return util;
	}

	public void setUtil(UtilDao util) {
		this.util = util;
	}

	public Prelievo getPrelievo() {
		return prelievo;
	}

	public void setPrelievo(Prelievo prelievo) {
		this.prelievo = prelievo;
	}

	public RegistraUtente getRegistraUtente() {
		return registraUtente;
	}

	public void setRegistraUtente(RegistraUtente registraUtente) {
		this.registraUtente = registraUtente;
	}

	public VisualizzaConti getVisualizzaConti() {
		return visualizzaConti;
	}

	public void setVisualizzaConti(VisualizzaConti visualizzaConti) {
		this.visualizzaConti = visualizzaConti;
	}
}
