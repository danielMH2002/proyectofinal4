package Proyecto;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Biblioteca extends JFrame {
	BaseDatos basedatos = new BaseDatos();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Connection conn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Biblioteca frame = new Biblioteca(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Biblioteca(String user) {
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border compoundBorder = BorderFactory.createCompoundBorder(lineBorder, emptyBorder);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/Icono.jpg"));
		setTitle("GV");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("añadir Juego");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirjuego(user);
			}
		});
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaPrincipal volver=new PaginaPrincipal(user);
				volver.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(172, 252, 120, 31);
		contentPane.add(btnNewButton);
		btnNewButton_1.setBounds(33, 252, 142, 31);
		contentPane.add(btnNewButton_1);
		
		
		
		
		 DefaultTableModel modelo=new DefaultTableModel();
		 try {
			 
			 conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/gameverse","root",null);
			 
			 String id=basedatos.obtenerIdUser(user);

	            String consulta = "SELECT v.nombre " +
	                    "FROM videojuegos v " +
	                    "INNER JOIN biblioteca b ON v.id = b.videojuego_id " +
	                    "INNER JOIN usuarios u ON u.id = b.usuario_id " +
	                    "WHERE u.user = ?";
	            PreparedStatement statement = conn.prepareStatement(consulta);
	            ResultSet resultSet = statement.executeQuery();

	           modelo= new DefaultTableModel();

	            int columnCount = resultSet.getMetaData().getColumnCount();
	            for (int i = 1; i <= columnCount; i++) {
	                modelo.addColumn(resultSet.getMetaData().getColumnName(i));
	            }

	            // Agregar filas a modelo con los datos obtenidos de la base de datos
	            while (resultSet.next()) {
	                Object[] fila = new Object[columnCount];
	                for (int i = 0; i < columnCount; i++) {
	                    fila[i] = resultSet.getObject(i + 1);
	                }
	                modelo.addRow(fila);
	            };

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Cerrar la conexión
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		 JTable tabla = new JTable(modelo);
        		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(31, 281, 698, 365);		
		scrollPane.setViewportView(tabla);		
		contentPane.add(scrollPane);
		
		JLabel lblBiblioteca_1 = new JLabel("Biblioteca de "+user);
		lblBiblioteca_1.setOpaque(true);
		lblBiblioteca_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblBiblioteca_1.setBackground(new Color(255, 255, 255, 150));
		lblBiblioteca_1.setBounds(10, 0, 301, 65);
		contentPane.add(lblBiblioteca_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("./img/paginaprincipal1.jpg"));
		lblNewLabel_1.setBounds(10, 0, 766, 666);
		contentPane.add(lblNewLabel_1);

	}
	 private void añadirjuego(String user) {
	        // Obtener el nombre del juego desde el JTextField
	        String nombreJuego = JOptionPane.showInputDialog(null, "Escribe el juego que quieras añadir");;

	        // Verificar que el nombre del juego no esté vacío
	        if (!nombreJuego.isEmpty()) {
				basedatos.insertarJuegoFav(nombreJuego, user);
				
	        } else {
	            JOptionPane.showMessageDialog(null, "Por favor, ingresa un nombre para el juego.");
	        }
	    }
	 
}