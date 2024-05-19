package proyecto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * La clase ActualizarInterfaz se encarga de actualizar la interfaz de usuario
 * y redirigir al usuario a la página principal.
 */
public class ActualizarInterfaz extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Método principal para lanzar la aplicación.
     * @param args Argumentos de línea de comando.
     * @param user El nombre de usuario que se utilizará en la interfaz.
     */
    public static void main(String[] args, String user) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ActualizarInterfaz frame = new ActualizarInterfaz(user);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Constructor de la clase ActualizarInterfaz.
     * Crea el marco, inicializa sus componentes y redirige al usuario a la página principal.
     * @param user El nombre de usuario que se utilizará en la interfaz.
     */
    public ActualizarInterfaz(String user) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        // Crear instancia de PaginaPrincipal y hacerla visible
        PaginaPrincipal p = new PaginaPrincipal(user);
        p.setVisible(true);

        // Cerrar la ventana actual
        dispose();
    }
}
