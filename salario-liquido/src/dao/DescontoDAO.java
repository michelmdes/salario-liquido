package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Desconto;

/**
 * Classe de acesso a dados da tabela Desconto
 * @author Michel Mendes 	10/06/2019
 */
public class DescontoDAO {
	
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	
	public List<Desconto> findByFuncionario(Long idFuncionario) throws SQLException {
		String sql = "SELECT id_desconto, vl_desconto FROM desconto WHERE id_cliente = ? ";
		List<Desconto> list = null;
		Desconto desc = null;
		Connection conn = ConnectionFactory.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, idFuncionario);
			rs = pst.executeQuery();
			while (rs.next()) {
				desc = new Desconto();
				desc.setIdDesconto(rs.getLong("id_desconto"));
				desc.setVlDesconto(rs.getDouble("vl_desconto"));
				
				if (list == null)
					list = new ArrayList<Desconto>();
				
				list.add(desc);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DescontoDAO.findByFuncionario: "+e.getMessage());
		} finally {
			rs.close();
			pst.close();
			conn.close();
		}
		return list;
	}
	
	public void createTable() throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		try {
			System.out.println("Criando tabela Desconto");
			st = conn.createStatement();
			String sql =  "CREATE TABLE Desconto " + 
					"(id_cliente BIGINT not NULL, " + 
					" id_desconto BIGINT not NULL, " + 
					" vl_desconto DOUBLE, " + 
					" PRIMARY KEY ( id_desconto ))"; 
			st.executeUpdate(sql);
			System.out.println("Tabela Desconto criada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Tabela já existe");
		} finally {
			st.close();
			conn.close();
		}
	}
	
	public void loadData() throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sqlInsert = "INSERT INTO Desconto ";
		try {
			System.out.println("Carregando dados na tabela Desconto");
			st = conn.createStatement();
			
			// Cliente 1
			String sql = sqlInsert + "VALUES (1, 1, 80)"; 
	        st.executeUpdate(sql);
	        sql = sqlInsert + "VALUES (1, 2, 40)"; 
	        st.executeUpdate(sql);
	        sql = sqlInsert + "VALUES (1, 3, 300)"; 
	        st.executeUpdate(sql);
	        
	        // Cliente 2
	        sql = sqlInsert + "VALUES (2, 4, 50)"; 
	        st.executeUpdate(sql);
	        sql = sqlInsert + "VALUES (2, 5, 450)"; 
	        st.executeUpdate(sql);
	        
	        // Cliente 3
	        sql = sqlInsert + "VALUES (3, 6, 100)"; 
	        st.executeUpdate(sql);
	        
	     // Cliente 3
	        sql = sqlInsert + "VALUES (4, 7, 10)"; 
	        st.executeUpdate(sql);
	        sql = sqlInsert + "VALUES (4, 8, 140)"; 
	        st.executeUpdate(sql);
	        sql = sqlInsert + "VALUES (4, 9, 320)"; 
	        st.executeUpdate(sql);
	        sql = sqlInsert + "VALUES (4, 10, 1100)"; 
	        st.executeUpdate(sql);
	        
			System.out.println("Dados carregados na tabela Desconto com sucesso!");
		} catch (SQLException e) {
			System.out.println("Dados já existem");
		} finally {
			st.close();
			conn.close();
		}
	}
	
	public void cleanTable() throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "DELETE FROM Desconto ";
		try {
			System.out.println("DELETANDO todos os dados da tabela Desconto");
			st = conn.createStatement();
	        st.executeUpdate(sql);
			System.out.println("Dados DELETADOS da tabela Desconto com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao deletar dados da tabela Desconto");
		} finally {
			st.close();
			conn.close();
		}
	}

}
