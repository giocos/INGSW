package bank.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import bank.dao.PersonaDao;
import model.Persona;

public class PersonaDaoJDBC implements PersonaDao {
	
	private DataSource dataSource;

	public PersonaDaoJDBC(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	@Override
	public void save(Persona persona) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into persona(codice_fiscale, nome, cognome, password) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, persona.getCodFisc());
			statement.setString(2, persona.getNome());
			statement.setString(3, persona.getCognome());
			statement.setString(4, persona.getPasswordAssegnata());
			statement.executeUpdate();
		
		} catch(SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch(SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public Persona findByPrimaryKey(String codFisc) {
		
		Connection connection = this.dataSource.getConnection();
		Persona persona = null;
		try {
			PreparedStatement statement;
			String query = "select * from persona where codice_fiscale = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, codFisc);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				
				persona = new Persona();
				persona.setCodFisc(result.getString("codice_fiscale"));				
				persona.setNome(result.getString("nome"));
				persona.setCognome(result.getString("cognome"));
			    persona.setPasswordAssegnata(result.getString("password"));
			}
		} catch(SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch(SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}	
		return persona;
	}
	

	@Override
	public List<Persona> findAll() {
		
		Connection connection = this.dataSource.getConnection();
		List<Persona> persone = new LinkedList<>();
		try {
			Persona persona;
			PreparedStatement statement;
			String query = "select * from persona";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				
				persona = new Persona();
				persona.setCodFisc(result.getString("codice_fiscale"));
				persona.setNome(result.getString("nome"));
				persona.setCognome(result.getString("cognome"));
				persona.setPasswordAssegnata(result.getString("password"));
				persone.add(persona);
			}
		} catch(SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch(SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return persone;
	}

	@Override
	public void update(Persona persona) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update persona SET codice_fiscale = ?, nome = ?, cognome = ?, password = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, persona.getCodFisc());
			statement.setString(2, persona.getNome());
			statement.setString(3, persona.getCognome());
			statement.setString(4, persona.getPasswordAssegnata());
			statement.executeUpdate();
		
		} catch(SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch(SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public void delete(Persona persona) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM persona WHERE codice_fiscale = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, persona.getCodFisc());
			statement.executeUpdate();
		
		} catch(SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch(SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public boolean alreadyRegistered(String codFisc) {
		
		Connection connection = this.dataSource.getConnection();
		Persona persona = null;
		try {
			PreparedStatement statement;
			String query = "select * from persona where codice_fiscale = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, codFisc);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				
				persona = new Persona();
				persona.setCodFisc(result.getString("codice_fiscale"));
				persona.setNome(result.getString("nome"));
				persona.setCognome(result.getString("cognome"));
			}
		} catch(SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch(SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return persona == null ? false : true;
	}
}