package main.core.dao;

import java.sql.Connection;

public interface BaseDAO {
	public Connection EstablishConnection();
	public void CloseConnection();
}
