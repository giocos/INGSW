package bank.dao;

import java.util.List;

import model.Persona;


public interface PersonaDao {
	
	public void save(Persona persona);// Create
	public Persona findByPrimaryKey(String codFisc);// Retrieve
	public List<Persona> findAll();       
	public void update(Persona persona);//Update
	public void delete(Persona persona);//Delete	
	public boolean alreadyRegistered(String codFisc);
}
