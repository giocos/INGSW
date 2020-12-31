package bank.dao;

import java.util.List;

import model.ContoBancario;

public interface ContoBancarioDao {
	
	public void save(ContoBancario cb);//Create
	public ContoBancario findByPrimaryKey(Long codice);//Retrieve
	public List<ContoBancario> findAll();       
	public void update(ContoBancario cb); //Update
	public void delete(ContoBancario cb); //Delete	
	public List<ContoBancario> findByProprietario(String codFisc);
}
