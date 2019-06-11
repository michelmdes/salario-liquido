package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsavel por criar a conexao com o banco de dados
 * @author Michel Mendes 	10/06/2019
 */
public class ConnectionFactory {
	// JDBC driver name and database URL 
	private static final String JDBC_DRIVER = "org.h2.Driver";   
	private static final String DB_URL = "jdbc:h2:~/test"; 
	private static Connection conn = null;
	
//	private ConnectionFactory connectionFactory = null;
//	public ConnectionFactory getConnectionFactory() {
//		if (connectionFactory == null) {
//			connectionFactory = new ConnectionFactory();
//		}
//		return connectionFactory;
//	}
	
	public static Connection getConnection() throws SQLException {
		if (conn == null || conn.isClosed())
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, "sa","");
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("ConnectionFactory: " + e.getMessage());
			}
		return conn;
	}

}
