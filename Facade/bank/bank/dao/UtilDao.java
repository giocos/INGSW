package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bank.persistence.DataSource;
import bank.persistence.PersistenceException;

public class UtilDao {
	
	private DataSource dataSource;
	
	public UtilDao(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	public void dropDatabase() {
		
		Connection connection = dataSource.getConnection();
		try {
			String delete = "drop SEQUENCE if exists sequenza_id;"
				       + "drop table if exists conto_bancario;"
		               + "drop table if exists persona;";
		PreparedStatement statement = connection.prepareStatement(delete);
		statement.executeUpdate();
		System.out.println("Executed drop database");
			
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
	
	public void createDatabase(){
		
		Connection connection = dataSource.getConnection();
		try {
			String create = "create SEQUENCE sequenza_id;"
				+ "create table persona (\"codice_fiscale\" varchar(255) primary key, nome varchar(255), cognome varchar(255), password varchar(255));"
				+ "create table conto_bancario (\"codice\" bigint primary key, ammontare double precision , codice_titolare varchar(255) REFERENCES persona (\"codice_fiscale\"));";
			PreparedStatement statement = connection.prepareStatement(create);
			statement.executeUpdate();
			System.out.println("Executed create database");
			
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
	
	
	public void resetDatabase() {
			
		Connection connection = dataSource.getConnection();
		try {
			String delete = "delete FROM persona";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			delete = "delete FROM conto_bancario";
			statement = connection.prepareStatement(delete);
			
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
}
