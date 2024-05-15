package proyectofinal4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BaseDatos {
	private Connection conn;
	
	public BaseDatos () {
		try {
			conn =DriverManager.getConnection("jdbc:mariadb://localhost:3306/gameverse","root",null);
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
	 public void insertarUsuario(String username, String password) throws SQLException {
	        String sql = "INSERT INTO usuarios (user, password) VALUES (?, ?)";
	        
	        try (PreparedStatement statement = conn.prepareStatement(sql)) {
	            statement.setString(1, username);
	            statement.setString(2, password);
	            int filasInsertadas = statement.executeUpdate();
	            if (filasInsertadas > 0) {
	                JOptionPane.showMessageDialog(null, "Usuario '" + username + "' añadido correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "No se pudo añadir el usuario '" + username + "'", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	
}