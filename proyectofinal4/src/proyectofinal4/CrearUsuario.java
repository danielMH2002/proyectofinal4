package Proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class CrearUsuario extends JFrame {
	
	BaseDatos baseDatos = new BaseDatos();
    

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUser;
	private JPasswordField passwordFieldConfirm;
	private JPasswordField passwordField;
	Connection conn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearUsuario frame = new CrearUsuario();
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
	public CrearUsuario() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/Icono.jpg"));
		setTitle("GV");
		try {
			conn =DriverManager.getConnection("jdbc:mariadb://localhost:3306/gameverse","root",null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Crea tu cuenta");
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblTitulo.setBounds(241, 57, 243, 95);
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(85, 188, 100, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblContrasea.setBounds(85, 268, 137, 42);
		contentPane.add(lblContrasea);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar \r\n\r\r\n");
		lblConfirmarContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblConfirmarContrasea.setBounds(85, 345, 117, 42);
		contentPane.add(lblConfirmarContrasea);
		
		JLabel lblContrasea_1 = new JLabel("contraseña");
		lblContrasea_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblContrasea_1.setBounds(85, 377, 117, 42);
		contentPane.add(lblContrasea_1);
		
		textFieldUser = new JTextField();
		textFieldUser.setToolTipText("Introduce el nombre del usuario");
		textFieldUser.setColumns(10);
		textFieldUser.setBounds(232, 196, 280, 34);
		contentPane.add(textFieldUser);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Recuerdame");
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(232, 425, 122, 21);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnVolver.setBounds(232, 464, 103, 28);
		contentPane.add(btnVolver);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnContinuar.setBounds(409, 464, 103, 28);
		contentPane.add(btnContinuar);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setBounds(232, 353, 280, 34);
		contentPane.add(passwordFieldConfirm);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(232, 273, 280, 34);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("./img/CrearUser.jpg"));
		lblNewLabel_1.setBounds(0, 0, 767, 670);
		contentPane.add(lblNewLabel_1);
		
		btnContinuar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
						
				nuevousuario();
			
			}
			
		});
		btnVolver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Inicio volver=new Inicio();
				volver.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
			
		});

	}

	protected void nuevousuario() {
		
		// declaro variables para guardar las contraseñas; cadena de chars en strings
		 String username = textFieldUser.getText();
		    char[] passwordChars = passwordField.getPassword();
		    char[] confirmPasswordChars = passwordFieldConfirm.getPassword();
		    
		    // Convertir los arreglos de caracteres a cadenas
		    String password = new String(passwordChars);
		    String confirmPassword = new String(confirmPasswordChars);
		    boolean confirmar=false;
		 while(!confirmar) {   
		    // validar datos del nuevo usuario
		    if (!username.isBlank() && password.length() > 0 && confirmPassword.length() > 0) {
		    	
		        if (password.equals(confirmPassword)) {
		        	confirmar=true;
		        	Login newUser=new Login(null);
		        	newUser.setVisible(true);
					contentPane.setVisible(false);
					
		        	try {
						baseDatos.insertarUsuario(username, password);
						dispose();
					} catch (SQLException e) {
						e.printStackTrace();
					}
		 
		        } else {
		        	JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
		        	break;
		        }
		    } else {
		    	JOptionPane.showMessageDialog(null, "Campos incompletos, rellene todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
		    	break;
		    }
		 }
	}

	public JTextField getTextFieldUser() {
		return textFieldUser;
	}
}
