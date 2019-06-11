package service;

import java.sql.SQLException;
import java.util.List;

import dao.DescontoDAO;
import entity.Desconto;

/**
 * Classe que contem a regra de negocio de Desconto
 * @author Michel Mendes 	10/06/2019
 */
public class DescontoService {
	
	private DescontoDAO dao;
	
	public DescontoService() throws ClassNotFoundException, SQLException {
		dao = new DescontoDAO();
	}
	
	public List<Desconto> findByFuncionario(Long idFuncionario) throws SQLException {
		return dao.findByFuncionario(idFuncionario);
	}
	
	public Double totalDescontosByFuncionario(Long idFuncionario) {
		Double total = Double.valueOf(0);
		try {
			List<Desconto> descontos = dao.findByFuncionario(idFuncionario);
			if (descontos != null)
				for (Desconto desconto : descontos) {
					if (desconto != null && desconto.getVlDesconto() != null)
						total = total + desconto.getVlDesconto();
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
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
