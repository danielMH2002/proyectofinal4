package Proyecto;

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
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/Icono.jpg"));
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
		btnInicioSesion.setBounds(290, 234, 122, 37);
		contentPane.add(btnInicioSesion);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCrearCuenta.setBounds(290, 375, 122, 37);
		contentPane.add(btnCrearCuenta);
		
		JLabel lblNewLabel_1 = new JLabel("O");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(337, 295, 58, 56);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("GameVerse Studio");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(261, 24, 258, 46);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\aleja\\OneDrive\\Escritorio\\ad.png"));
		lblNewLabel.setBounds(0, -13, 766, 685);
		contentPane.add(lblNewLabel);
		btnCrearCuenta.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				CrearUsuario newUser=new CrearUsuario();
				newUser.setVisible(true);
				contentPane.setVisible(false);
			}
			
		});
		btnInicioSesion.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				Login usuario=new Login(null);
				usuario.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			
			}
			
		});
		
		
		
	}
}
