package service;

import java.sql.SQLException;
import java.util.List;

import dao.FuncionarioDAO;
import entity.Funcionario;

/**
 * Classe que contem a regra de negocio de Desconto
 * @author Michel Mendes 	10/06/2019
 */
public class FuncionarioService {
	
	private FuncionarioDAO dao;
	
	public FuncionarioService() throws ClassNotFoundException, SQLException {
		dao = new FuncionarioDAO();
	}
	
	public List<Funcionario> findAll() throws SQLException {
		return dao.findAll();
	}
	
	public void createTable() throws SQLException {
		dao.createTable();
	}
	
	public void loadData() throws SQLException {
		dao.loadData();
	}
	
	public void cleanTable() throws SQLException {
		dao.cleanTable();
	}

}
