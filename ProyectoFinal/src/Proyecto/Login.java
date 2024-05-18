package Proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Login extends JFrame {
	BaseDatos bbdd = new BaseDatos();
	
	private Connection conn;
	
	private static final long serialVersionUID = 1L;
	private JPanel mipanel;
	private JTextField txtUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param user 
	 */
	public Login(String user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/Icono.jpg"));
		setTitle("GV");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aleja\\Downloads\\GAMEVERSE.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 693);
		mipanel = new JPanel();
		mipanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mipanel);
		mipanel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblUsuario.setBounds(92, 189, 103, 41);
		mipanel.add(lblUsuario);
		
		txtUsuario=new JTextField();
		txtUsuario.setToolTipText("Introduce el nombre del usuario");
		txtUsuario.setBounds(258, 197, 280, 34);
		mipanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setToolTipText("Introduce your password");
		lblContraseña.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblContraseña.setBounds(92, 262, 122, 41);
		mipanel.add(lblContraseña);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnContinuar.addActionListener( new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				accederApp();
				
				
			}
		});
		btnContinuar.setBounds(434, 367, 103, 28);
		mipanel.add(btnContinuar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio volver=new Inicio();
				volver.setVisible(true);
				dispose();
			}
		});
		btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnVolver.setBounds(258, 367, 103, 28);
		mipanel.add(btnVolver);
		
		JLabel lblInicioDeSesin = new JLabel("Inicio de sesión");
		lblInicioDeSesin.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblInicioDeSesin.setBounds(258, 52, 269, 95);
		mipanel.add(lblInicioDeSesin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(258, 262, 280, 34);
		mipanel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\aleja\\OneDrive\\Escritorio\\AYYYY.png"));
		lblNewLabel.setBounds(0, -21, 775, 687);
		mipanel.add(lblNewLabel);
	}

	private void accederApp() {
		
		String password=new String (passwordField.getPassword());		
		if(!(txtUsuario.getText().isBlank() || password.isBlank())) {
		
			BaseDatos bbdd=new BaseDatos();
			if((bbdd.loginBD(txtUsuario.getText(),password))){
							
				PaginaPrincipal v=new PaginaPrincipal(txtUsuario.getText());
				v.setVisible(true);
				dispose();
			}else{
				System.out.println("nanai");
			}			
		}			
	}	
}