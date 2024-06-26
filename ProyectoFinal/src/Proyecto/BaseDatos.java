package Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BaseDatos {
	private Connection conn;
	private String user;
	
	public BaseDatos () {
		try {
			conn =DriverManager.getConnection("jdbc:mariadb://localhost:3306/gameverse","root",null);
			 Statement stmt = conn.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public boolean loginBD(String username, String password) {
	    boolean loginOK = false;
	    String consulta = "SELECT * FROM usuarios WHERE user = ? AND password = ?";

	    try (PreparedStatement stmt = conn.prepareStatement(consulta)) {
	        stmt.setString(1, username);
	        stmt.setString(2, password);
	        ResultSet rs = stmt.executeQuery();
	        loginOK = rs.next();
	    } catch (SQLException e) {
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
	 
	 
//		 public void mostrarJuegos(String usuario) throws SQLException {
//			 String sql = "SELECT v.nombre, v.categoria "
//			 		+ "FROM videojuegos v "
//			 		+ "INNER JOIN biblioteca b ON v.id = b.videojuego_id "
//			 		+ "INNER JOIN usuarios u ON u.id = b.usuario_id "
//			 		+ "WHERE "+ usuario + " = u.nombre;";
//			 
//			// Crear un Statement
//	         Statement statement = conn.createStatement();
//	         // Ejecutar la consulta
//	         ResultSet resultado = statement.executeQuery(sql);
//	         
//	         while (resultado.next()) {
//	             String nombre = resultado.getString("nombre");
//	             String categoria = resultado.getString("categoria");
//	             System.out.println("Nombre: " + nombre + ", Categoría: " + categoria);
//	             // Aquí puedes mostrar los resultados en la interfaz gráfica
//	         }
//			 
//		 }
		 
		public String obtenerIdUser(String nombre) {
			 String id = "";
			 PreparedStatement stmt = null;
		     ResultSet rs = null;
		        
			 String sql = "SELECT id FROM usuarios WHERE user = ?";
	         try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, nombre);
				
				rs = stmt.executeQuery();
				
				 if (rs.next()) {
		                id = rs.getString("id");
		            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			return id;
			
		}
		public String obtenerIdVideojuego(String nombre) {
			 String id = "";
			 PreparedStatement stmt = null;
		     ResultSet rs = null;
		        
			 String sql = "SELECT id FROM videojuegos WHERE nombre = ?";
	         try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, nombre);
				
				rs = stmt.executeQuery();
				
				 if (rs.next()) {
		                id = rs.getString("id");
		            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			return id;
			
		}
		public boolean comprobarContraseña(String nombre, String contraseñaUsuario) {
			 String password = "";
			 PreparedStatement stmt = null;
		     ResultSet rs = null;
		        
			 String sql = "SELECT password FROM usuarios WHERE user = ?";
			 try {
			        stmt = conn.prepareStatement(sql);
			        stmt.setString(1, nombre);
			        
			        rs = stmt.executeQuery();
			        
			        if (rs.next()) {
			        	password = rs.getString("password");
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    } finally {
			        // Asegúrate de cerrar los recursos
			        try {
			            if (rs != null) rs.close();
			            if (stmt != null) stmt.close();
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			    }
	        
			return password.equals(contraseñaUsuario);
			
		}
		 public void insertarJuegoFav(String nombreJuego, String nombreUsuario) {
		        // Obtener las ID del usuario y del videojuego
		        String idUsuario = obtenerIdUser(nombreUsuario);
		        String idVideojuego = obtenerIdVideojuego(nombreJuego);
		        
		        if (idUsuario.isEmpty() ) {
		        	JOptionPane.showMessageDialog(null, "El usuario o el videojuego no existen");
		            
		        }
		        
		        PreparedStatement stmt = null;
		        try {
		            // Preparar la consulta de inserción
		        	stmt = conn.prepareStatement("INSERT INTO biblioteca (usuario_id, videojuego_id) VALUES (?,?)");
		            stmt.setString(1, idUsuario);
		            stmt.setString(2, idVideojuego);
		            
		            // Ejecutar la inserción
		            stmt.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Juego insertado correctamente en la biblioteca del usuario.");

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }

		 public void insertarJuego(String nombreJuego,String categoria) throws SQLException {
		        String sql = "INSERT INTO videojuegos (nombre,categoria) VALUES (?,?)";
		        
		        try (PreparedStatement statement = conn.prepareStatement(sql)) {
		            statement.setString(1, nombreJuego);
		            statement.setString(2, categoria);
		            int filasInsertadas = statement.executeUpdate();
		            if (filasInsertadas > 0) {
		                JOptionPane.showMessageDialog(null, "Videojuego '" + nombreJuego + "' añadido correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		            } else {
		                JOptionPane.showMessageDialog(null, "No se pudo añadir el videojuego '" + nombreJuego + "'", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (SQLException e) {
		        	JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }

		public void eliminarJuego(String nombreJuego) {
			String sql = "DELETE FROM videojuegos WHERE nombre = ?";
	        
	        try (PreparedStatement statement = conn.prepareStatement(sql)) {
	            statement.setString(1, nombreJuego);
	            int filasInsertadas = statement.executeUpdate();
	            if (filasInsertadas > 0) {
	                JOptionPane.showMessageDialog(null, "Videojuego '" + nombreJuego + "' eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "No se pudo eliminar el videojuego '" + nombreJuego + "'", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
			
		}
	}
		
	 
	
