package sep3.project.persistance;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static boolean isTest = false;
	private static final String user = "postgres";
	private static final String pw = "admin";


	public DBConnection() throws SQLException {
		DriverManager.registerDriver(new org.postgresql.Driver());
	}

	public static void setToProduction() {
		isTest = false;
	}

	public static void setToTest() {
		isTest = true;
	}

	public static Connection getConnection() throws SQLException {
		String url = "";
		if(isTest) {
			url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=photoguardtest";
		} else {
			url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=photoguard";
		}

		Connection connection = null;
		connection = DriverManager.getConnection(url, user, pw);

		return connection;
	}

	public static void restartTestDatabase() throws SQLException, FileNotFoundException {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		Connection connection = DriverManager.getConnection(url, user, pw);
		System.out.println("Connection established......");
		ScriptRunner sr = new ScriptRunner(connection);
		Reader reader = new BufferedReader(new FileReader("src/main/java/sep3/project/static/photoguardtest_DDL_DML.sql"));
		sr.runScript(reader);
	}
}
