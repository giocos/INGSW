package bank.dao;

import bank.persistence.ContoBancarioJDBC;
import bank.persistence.DataSource;
import bank.persistence.PersonaDaoJDBC;

public class PostgresDAOFactory extends DAOFactory {

	private static  DataSource dataSource;
	
	// --------------------------------------------

	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			//questi vanno messi in file di configurazione!!!	
			//dataSource=new DataSource("jdbc:postgresql://52.39.164.176:5432/xx","xx","p@xx");
			dataSource=new DataSource("jdbc:postgresql://localhost:5432/bank","postgres","postgres");
		} 
		catch(Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}
	
	// --------------------------------------------
	
	@Override
	public PersonaDao getPersonaDAO() {
		return new PersonaDaoJDBC(dataSource);
	}

	@Override
	public ContoBancarioDao getContoBancarioDAO() {
		return new ContoBancarioJDBC(dataSource);
	}
	
	@Override
	public UtilDao getUtilDAO(){
		return new UtilDao(dataSource);
	}
}
