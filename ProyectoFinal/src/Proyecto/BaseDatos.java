package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Clase BaseDatos que maneja las operaciones de la base de datos para la aplicación.
 * Esta clase incluye métodos para iniciar sesión, registrar usuarios, obtener información
 * de la base de datos y realizar operaciones de inserción y eliminación.
 */
public class BaseDatos {
    private Connection conn;

    /**
     * Constructor de la clase BaseDatos.
     * Establece la conexión con la base de datos utilizando JDBC.
     */
    public BaseDatos() {
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gameverse", "root", null);
            Statement stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para iniciar sesión en la base de datos.
     * @param username El nombre de usuario.
     * @param password La contraseña del usuario.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
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

    /**
     * Método para insertar un nuevo usuario en la base de datos.
     * @param username El nombre de usuario.
     * @param password La contraseña del usuario.
     * @throws SQLException Si ocurre un error durante la inserción.
     */
    public void insertarUsuario(String username, String password) throws SQLException {
        String sql = "INSERT INTO usuarios (user, password) VALUES (?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "Usuario '" + username + "' añadido correctamente", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo añadir el usuario '" + username + "'", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para obtener el ID de un usuario por su nombre.
     * @param nombre El nombre del usuario.
     * @return El ID del usuario.
     */
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
            e.printStackTrace();
        }

        return id;
    }

    /**
     * Método para obtener el ID de un videojuego por su nombre.
     * @param nombre El nombre del videojuego.
     * @return El ID del videojuego.
     */
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
            e.printStackTrace();
        }

        return id;
    }

    /**
     * Método para comprobar si la contraseña proporcionada coincide con la del usuario en la base de datos.
     * @param nombre El nombre del usuario.
     * @param contraseñaUsuario La contraseña del usuario.
     * @return true si la contraseña es correcta, false en caso contrario.
     */
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
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return password.equals(contraseñaUsuario);
    }

    /**
     * Método para insertar un juego favorito en la biblioteca de un usuario.
     * @param nombreJuego El nombre del juego.
     * @param nombreUsuario El nombre del usuario.
     */
    public void insertarJuegoFav(String nombreJuego, String nombreUsuario) {
        String idUsuario = obtenerIdUser(nombreUsuario);
        String idVideojuego = obtenerIdVideojuego(nombreJuego);

        if (idUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El usuario o el videojuego no existen");
        }

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO biblioteca (usuario_id, videojuego_id) VALUES (?,?)");
            stmt.setString(1, idUsuario);
            stmt.setString(2, idVideojuego);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Juego insertado correctamente en la biblioteca del usuario.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para insertar un nuevo videojuego en la base de datos.
     * @param nombreJuego El nombre del videojuego.
     * @param categoria La categoría del videojuego.
     * @throws SQLException Si ocurre un error durante la inserción.
     */
    public void insertarJuego(String nombreJuego, String categoria) throws SQLException {
        String sql = "INSERT INTO videojuegos (nombre, categoria) VALUES (?,?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, nombreJuego);
            statement.setString(2, categoria);
            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "Videojuego '" + nombreJuego + "' añadido correctamente", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo añadir el videojuego '" + nombreJuego + "'", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para eliminar un videojuego de la base de datos.
     * @param nombreJuego El nombre del videojuego.
     */
    public void eliminarJuego(String nombreJuego) {
        String sql = "DELETE FROM videojuegos WHERE nombre = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, nombreJuego);
            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "Videojuego '" + nombreJuego + "' eliminado correctamente", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el videojuego '" + nombreJuego + "'", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
