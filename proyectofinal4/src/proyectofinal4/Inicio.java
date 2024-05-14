package proyectofinal4;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aleja\\Downloads\\GAMEVERSE.png"));
		setTitle("GV");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 693);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInicioSesion = new JButton("Inicio sesion");
		btnInicioSesion.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnInicioSesion.setBounds(439, 231, 122, 37);
		contentPane.add(btnInicioSesion);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCrearCuenta.setBounds(166, 231, 122, 37);
		contentPane.add(btnCrearCuenta);
		btnCrearCuenta.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				CrearUsuario newUser=new CrearUsuario();
				newUser.setVisible(true);
				contentPane.setVisible(false);
			}
			
		});
		btnInicioSesion.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				Login usuario=new Login();
				usuario.setVisible(true);
				contentPane.setVisible(false);
			}
			
		});
		
		
		
	}
}
