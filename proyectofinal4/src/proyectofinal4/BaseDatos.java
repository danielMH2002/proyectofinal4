package proyectofinal4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {
	private Connection conn;
	
	public BaseDatos () {
		try {
			conn =DriverManager.getConnection("jdbc:mariadb://localhost:3306/pruebaexamen","root",null);
			 Statement stmt = conn.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public boolean loginBD(String user, String pass) {
		boolean loginOK =false;
		 String consulta = "SELECT * FROM usuarios WHERE "+ user +" = ? AND " + pass +" = ?";
		 
		 try {
			Statement stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return loginOK;
	}
	
}