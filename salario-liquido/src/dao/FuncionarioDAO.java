package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Funcionario;

/**
 * Classe de acesso a dados da tabela Funcionario
 * @author Michel Mendes 	1-/06/2019
 */
public class FuncionarioDAO {
	
	//private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	
//	public FuncionarioDAO () throws ClassNotFoundException, SQLException {
//		conn = new ConnectionFactory().getConnection();
//	}
	
	public List<Funcionario> findAll() throws SQLException {
		String sql = "SELECT id_cliente, nm_cliente, vl_salario_bruto FROM funcionario ";
		List<Funcionario> list = null;
		Funcionario f = null;
		Connection conn = ConnectionFactory.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				f = new Funcionario();
				f.setIdCliente(rs.getLong("id_cliente"));
				f.setNmCliente(rs.getString("nm_cliente"));
				f.setVlSalarioBruto(rs.getDouble("vl_salario_bruto"));
				
				if (list == null)
					list = new ArrayList<Funcionario>();
				
				list.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("FuncionarioDAO.findAll: "+e.getMessage());
		} finally {
			rs.close();
			st.close();
			conn.close();
		}
		return list;
	}
	
	public void createTable() throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		try {
			System.out.println("Criando tabela funcionario");
			st = conn.createStatement();
			String sql =  "CREATE TABLE Funcionario " + 
					"(id_cliente BIGINT not NULL, " + 
					" nm_cliente VARCHAR(255) not NULL, " +  
					" vl_salario_bruto DOUBLE not NULL, " +  
					" PRIMARY KEY ( id_cliente ))";  
			st.executeUpdate(sql);
			System.out.println("Tabela funcionario criada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Tabela já existe");
			//e.printStackTrace();
//			throw new RuntimeException("FuncionarioDAO.createTable: " + e.getMessage());
		} finally {
			st.close();
			conn.close();
		}
	}
	
	public void loadData() throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sqlInsert = "INSERT INTO Funcionario ";
		try {
			System.out.println("Carregando dados na tabela funcionario");
			st = conn.createStatement();
			String sql = sqlInsert + "VALUES (1, 'Funcionario 01', 1800)"; 
	        st.executeUpdate(sql);
	        sql = sqlInsert + "VALUES (2, 'Funcionario 02', 2800)"; 
	        st.executeUpdate(sql); 
	        sql = sqlInsert + "VALUES (3, 'Funcionario 03', 3800)"; 
	        st.executeUpdate(sql); 
	        sql = sqlInsert + "VALUES (4, 'Funcionario 04', 4800)"; 
	        st.executeUpdate(sql); 
	        sql = sqlInsert + "VALUES (5, 'Funcionario 05', 5800)"; 
	        st.executeUpdate(sql); 
			System.out.println("Dados carregados na tabela funcionario com sucesso!");
		} catch (SQLException e) {
			System.out.println("Dados já existem");
//			e.printStackTrace();
//			throw new RuntimeException("FuncionarioDAO.loadData: " + e.getMessage());
		} finally {
			st.close();
			conn.close();
		}
	}
	
	public void cleanTable() throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "DELETE FROM Funcionario ";
		try {
			System.out.println("DELETANDO todos os dados da tabela funcionario");
			st = conn.createStatement();
	        st.executeUpdate(sql);
			System.out.println("Dados DELETADOS da tabela funcionario com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao deletar dados da tabela Funcionario");
		} finally {
			st.close();
			conn.close();
		}
	}

}
