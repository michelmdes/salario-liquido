package main;

import java.sql.SQLException;

import service.DescontoService;
import service.FuncionarioService;
import view.salarioLiquidoView;

/**
 * Classe principal que inicia o sistema
 * @author Michel Mendes 	10/06/2019
 */
public class Run {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		// Criando banco e tabelas no banco de teste H2
		createDataBase();
		
		// Iniciando janela de salario liquido
		new salarioLiquidoView().setVisible(true);
	}
	
	private static void createDataBase() throws ClassNotFoundException, SQLException {
		
		FuncionarioService funcionarioService = new FuncionarioService();
		DescontoService descontoService = new DescontoService();
		System.out.println("Criando tabelas no banco H2");
			
		// Criando tabelas
		try {
			funcionarioService.createTable();
			descontoService.createTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Carregando tabelas com dados iniciais
		try {
			funcionarioService.cleanTable();
			funcionarioService.loadData();
			
			descontoService.cleanTable();
			descontoService.loadData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
