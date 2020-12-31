package bank.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import bank.dao.ContoBancarioDao;
import bank.dao.PersonaDao;
import model.ContoBancario;
import model.Persona;

public class ContoBancarioJDBC implements ContoBancarioDao {
	
	private DataSource dataSource;

	public ContoBancarioJDBC(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(ContoBancario cb) {

		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			cb.setCodConto(id);
			String insert = "insert into conto_bancario(codice, ammontare, codice_titolare) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, cb.getCodConto());
			statement.setDouble(2, cb.getAmount());
			statement.setString(3, cb.getTitolare().getCodFisc());
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
	public ContoBancario findByPrimaryKey(Long codice) {
		
		Connection connection = this.dataSource.getConnection();
		ContoBancario conto = null;
		try {
			PreparedStatement statement;
			String query = "select * from conto_bancario where codice = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, codice);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				
				conto = new ContoBancario();
				conto.setCodConto(result.getLong("codice"));
				conto.setAmount(result.getDouble("ammontare"));
				
				PersonaDao personaDao = new PersonaDaoJDBC(dataSource);
				Persona titolare = personaDao.findByPrimaryKey(result.getString("codice_titolare"));
				conto.setTitolare(titolare);
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
		return conto;
	}

	@Override
	public List<ContoBancario> findAll() {
		
		Connection connection = this.dataSource.getConnection();
		List<ContoBancario> conti = new LinkedList<>();
		try {
			ContoBancario contoBancario;
			PreparedStatement statement;
			String query = "select * from conto_bancario";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				
				contoBancario = new ContoBancario();
				contoBancario.setCodConto((result.getLong("codice")));
				contoBancario.setAmount(result.getDouble("ammontare"));

				PersonaDao personaDao = new PersonaDaoJDBC(dataSource);
				Persona titolare = personaDao.findByPrimaryKey(result.getString("codice_titolare"));
				contoBancario.setTitolare(titolare);
				conti.add(contoBancario);
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
		return conti;
	}

	@Override
	public void update(ContoBancario cb) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update conto_bancario SET ammontare = ? where codice = ?";
			PreparedStatement statement = connection.prepareStatement(update);// inserire eventuale controllo
			statement.setDouble(1, cb.getAmount()); // per verificare la presenza del titolare
			statement.setLong(2, cb.getCodConto());
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
	public void delete(ContoBancario cb) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM conto_bancario WHERE codice = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, cb.getCodConto());
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

	public List<ContoBancario> findByProprietario(String codFisc) {
		
		Connection connection = this.dataSource.getConnection();
		List<ContoBancario> conti = new LinkedList<>();
		try {
			ContoBancario contoBancario;
			PreparedStatement statement;
			String query = "select * from conto_bancario where codice_titolare = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, codFisc);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				
				contoBancario = new ContoBancario();
				contoBancario.setCodConto((result.getLong("codice")));
				contoBancario.setAmount(result.getDouble("ammontare"));

				PersonaDao personaDao = new PersonaDaoJDBC(dataSource);
				Persona titolare = personaDao.findByPrimaryKey(result.getString("codice_titolare"));
				contoBancario.setTitolare(titolare);
				conti.add(contoBancario);
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
		return conti;
	}
}
