package proyectofinal4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUser;
	private JPasswordField passwordField;
	private JLabel lblImagen;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 579);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Account name");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(SystemColor.text);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(23, 202, 162, 35);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(SystemColor.text);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(23, 302, 141, 41);
		contentPane.add(lblPassword);
		
		textFieldUser = new JTextField();
		textFieldUser.setForeground(SystemColor.textHighlightText);
		textFieldUser.setBackground(new Color(42, 42, 42));
		textFieldUser.setToolTipText("Introduce nombre del usuario");
		textFieldUser.setBounds(195, 206, 350, 35);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(SystemColor.textHighlightText);
		passwordField.setBackground(new Color(42, 42, 42));
		passwordField.setBounds(195, 301, 350, 35);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO LO QUE PONGAMOS AQUI SE EJECUTA CON EL BOTON
				accederAPP();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(190, 395, 162, 27);
		contentPane.add(btnLogin);
		
		lblImagen = new JLabel("New label");
		lblImagen.setIcon(new ImageIcon("C:\\Users\\dani\\Documents\\programacionhtmlcss\\Captura.PNG"));
		lblImagen.setBounds(99, 33, 406, 110);
		contentPane.add(lblImagen);
	}

	private void accederAPP() {
		
		String password = new String (passwordField.getPassword()) ;
		if(!(textFieldUser.getText().isBlank() || password.isBlank() )) {
			
		}
	}
}