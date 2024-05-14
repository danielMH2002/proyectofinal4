package proyectofinal4;

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
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mipanel;
	private JTextField txtUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("CV");
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
		
		txtUsuario = new JTextField();
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
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Biblioteca newUser=new Biblioteca();
				newUser.setVisible(true);
				mipanel.setVisible(false);
			}
		});
		btnContinuar.setBounds(434, 367, 103, 28);
		mipanel.add(btnContinuar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio volver=new Inicio();
				volver.setVisible(true);
				mipanel.setVisible(false);
			}
		});
		btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnVolver.setBounds(258, 367, 103, 28);
		mipanel.add(btnVolver);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Recuerdame");
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(258, 328, 122, 21);
		mipanel.add(chckbxNewCheckBox);
		
		JLabel lblInicioDeSesin = new JLabel("Inicio de sesión");
		lblInicioDeSesin.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblInicioDeSesin.setBounds(258, 52, 269, 95);
		mipanel.add(lblInicioDeSesin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(258, 262, 280, 34);
		mipanel.add(passwordField);
	}
}
