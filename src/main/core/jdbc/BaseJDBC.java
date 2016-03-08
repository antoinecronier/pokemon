package main.core.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import main.core.dao.BaseDAO;

public class BaseJDBC implements BaseDAO{
	/** Constructeur privé */
	private BaseJDBC()
	{}
 
	/** Instance unique non préinitialisée */
	private static BaseJDBC INSTANCE = null;
 
	/** Point d'accès pour l'instance unique du singleton */
	public static BaseJDBC getInstance()
	{			
		if (INSTANCE == null)
		{ 	INSTANCE = new BaseJDBC();	
		}
		return INSTANCE;
	}
	
	private Connection connection = null;

	@Override
	public Connection EstablishConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if (connection == null)
				connection = DriverManager
						.getConnection("jdbc:mysql://localhost/pokemon?user=root&password=");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return connection;
	}
	
	@Override
	public void CloseConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			// do nothing
		}
	}
}
