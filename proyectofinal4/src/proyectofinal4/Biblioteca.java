package proyectofinal4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import java.awt.Color;

public class Biblioteca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Biblioteca frame = new Biblioteca();
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
	public Biblioteca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Juegos que te pueden gustar");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(14, 122, 356, 31);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Juegos recomendados");
		btnNewButton.setBounds(23, 198, 139, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblBienvenido = new JLabel("Bienvenido x");
		lblBienvenido.setForeground(new Color(0, 0, 0));
		lblBienvenido.setBackground(Color.GREEN);
		lblBienvenido.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblBienvenido.setBounds(0, 0, 301, 65);
		lblBienvenido.setBackground(null);
		
			
			contentPane.add(lblBienvenido);
		
		JButton btnVerBiblioteca_1 = new JButton("Ver biblioteca");
		btnVerBiblioteca_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnVerBiblioteca_1.setBounds(159, 199, 103, 31);
		contentPane.add(btnVerBiblioteca_1);
		
		JMenu mnNewMenu_1 = new JMenu("Buscar juegos");
		mnNewMenu_1.setBounds(262, 199, 139, 28);
		contentPane.add(mnNewMenu_1);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnVolver.setBounds(642, 199, 103, 28);
		contentPane.add(btnVolver);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(10, 230, 735, 416);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("./img/paginaprincipal2.jpg"));
		lblNewLabel_2.setBounds(-11, 0, 766, 668);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(31, 230, 45, 13);
		contentPane.add(lblNewLabel);
		
		btnVolver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Login volver=new Login();
				volver.setVisible(true);
				contentPane.setVisible(false);
			}
			
		});
	}
}
