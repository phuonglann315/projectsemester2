package commom;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnecDB {
	private static Connection connect = null;
	private static String url = "jdbc:sqlserver://";
	private static String serverName = "DESKTOP-K7L1PKL";
	private static String portNumber = "1433";
	private static String databaseName = "Labour";
	private static String username = "sa";
	private static String password = "123456";

	public static String getURL() {
		return url + serverName + ":" + portNumber + "; databaseName=" + databaseName + "; user=" + username
				+ "; password=" + password;
	}

	public static Connection getConnect() {
		try {
			connect = DriverManager.getConnection(getURL());
		} catch (Exception e) {
			e.printStackTrace();
			connect = null;
		}

		return connect;
	}

	public Connection getConn() {
		try {
			connect = DriverManager.getConnection(getURL());
		} catch (Exception e) {
			e.printStackTrace();
			connect = null;
		}

		return connect;
	}
}
