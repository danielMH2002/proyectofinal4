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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import java.awt.Color;

public class PaginaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaPrincipal frame = new PaginaPrincipal();
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
	public PaginaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido x");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblNewLabel.setBounds(10, 10, 297, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnVerBiblioteca_1 = new JButton("Ver biblioteca");
		btnVerBiblioteca_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnVerBiblioteca_1.setBounds(164, 67, 103, 28);
		contentPane.add(btnVerBiblioteca_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 250, 735, 416);
		contentPane.add(lblNewLabel_2);
		
		JMenu mnNewMenu = new JMenu("Recomendados");
		mnNewMenu.setBackground(new Color(128, 0, 0));
		mnNewMenu.setBounds(10, 67, 144, 28);
		contentPane.add(mnNewMenu);
		
		JLabel lblNewLabel_1 = new JLabel("Juegos que te pueden gustar");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 189, 238, 31);
		contentPane.add(lblNewLabel_1);
		
		JMenu mnNewMenu_1 = new JMenu("Buscar juegos");
		mnNewMenu_1.setBounds(252, 67, 139, 28);
		contentPane.add(mnNewMenu_1);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnVolver.setBounds(642, 67, 103, 28);
		contentPane.add(btnVolver);
		
		btnVolver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Login volver=new Login();
				volver.setVisible(true);
				contentPane.setVisible(false);
			}
			
		});
	}
}
