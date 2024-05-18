package Proyecto;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.JScrollBar;

public class PaginaPrincipal extends JFrame {
	
	BaseDatos bbdd=new BaseDatos();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabla;
	private Connection conn;
	private   DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaPrincipal frame = new PaginaPrincipal(user);
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
	public PaginaPrincipal(String user) {
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
		
		
		
		JLabel lblJuegos = new JLabel("          Juegos");
		lblJuegos.setForeground(new Color(0, 0, 0));
		lblJuegos.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblJuegos.setBounds(32, 252, 155, 31);
		lblJuegos.setOpaque(true);
		lblJuegos.setBorder(compoundBorder);
		contentPane.add(lblJuegos);
		
		JLabel lblNewLabel_1 = new JLabel("Juegos que te pueden gustar");
		lblNewLabel_1.setBackground(new Color(255, 255, 255,125));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(0, 136, 356, 31);	
		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblBienvenido = new JLabel("Bienvenido "+user);
		lblBienvenido.setForeground(new Color(0, 0, 0));
		lblBienvenido.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblBienvenido.setBackground(new Color(255, 255, 255,150));
		lblBienvenido.setOpaque(true);
		lblBienvenido.setBounds(0, 0, 301, 65);	
		lblBienvenido.setBorder(compoundBorder);			
		contentPane.add(lblBienvenido);
			modelo=new DefaultTableModel();
		 try {
			
			 conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/gameverse","root",null);

	            String consulta = "SELECT * FROM videojuegos";
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
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(31, 281, 698, 365);		
		scrollPane.setViewportView(tabla);		
		contentPane.add(scrollPane);
		
		JButton btnEliminarVideojuego = new JButton("Eliminar videojuego");
		btnEliminarVideojuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarvideojuego();
				ActualizarInterfaz p=new ActualizarInterfaz(user);
				dispose();
				
			}
		});
		modelo.fireTableDataChanged(); 
		//        
				JButton btnVolver = new JButton("Volver");
				btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 13));
				btnVolver.setBounds(566, 252, 103, 31);
				contentPane.add(btnVolver);
				
				btnVolver.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						Login volver=new Login(user);
						volver.setVisible(true);
						contentPane.setVisible(false);
						dispose();
					}
					
				});
		btnEliminarVideojuego.setBounds(425, 252, 144, 31);
		contentPane.add(btnEliminarVideojuego);
		
		;
		JButton btnAñadirJuego = new JButton("Añadir videojuego");
		btnAñadirJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirvideojuego();
				ActualizarInterfaz p=new ActualizarInterfaz(user);
				dispose();
			}
		});
		; 
			            // Crear una JTable con el modelo creado
			            
		btnAñadirJuego.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAñadirJuego.setBounds(294, 252, 133, 31);
		contentPane.add(btnAñadirJuego);
		
		JButton btnVerBiblioteca_1 = new JButton("Ver biblioteca");
		btnVerBiblioteca_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Biblioteca.main(null,user);
				dispose();
				
			}
		});
		btnVerBiblioteca_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnVerBiblioteca_1.setBounds(182, 252, 116, 31);
		contentPane.add(btnVerBiblioteca_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\aleja\\OneDrive\\Escritorio\\Perrolfauta.png"));
		lblNewLabel.setBounds(0, 0, 768, 668);
		contentPane.add(lblNewLabel);
		

        // Hacer visible el marco
		contentPane.setVisible(true);
    }

	protected void eliminarvideojuego() {
		String nombreJuego = JOptionPane.showInputDialog(null, "Introduce el nombre del videojuego");

		
		
		 if (nombreJuego != null && !nombreJuego.isEmpty()) {
		        bbdd.eliminarJuego(nombreJuego);
		    } else {
		        JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		
	}


	protected void añadirvideojuego() {
		String nombreJuego = JOptionPane.showInputDialog(null, "Introduce el nombre del videojuego");
		String categoriaJuego = JOptionPane.showInputDialog(null, "Introduce la categoría del videojuego");
		
		
		 if (nombreJuego != null && categoriaJuego != null && !nombreJuego.isEmpty() && !categoriaJuego.isEmpty()) {
		        try {
		            bbdd.insertarJuego(nombreJuego, categoriaJuego);
		            
		            
		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error al insertar el videojuego: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    } else {
		        JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
		    }
	

	}
}
