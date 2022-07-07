package formationJdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Context {

	private Connection connection;

	private static Context singleton = null;

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		if (singleton != null) {
			try {
				singleton.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			singleton = null;
		}
	}

	public static Context getInstance() {
		if (singleton == null) {
			singleton = new Context();
		}
		return singleton;
	}

	private Context() {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/hr", "postgres", "postgres");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}
}
