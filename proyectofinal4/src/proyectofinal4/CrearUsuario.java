package Proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class CrearUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		textField = new JTextField();
		textField.setToolTipText("Introduce el nombre del usuario");
		textField.setColumns(10);
		textField.setBounds(232, 184, 280, 34);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Introduce el nombre del usuario");
		textField_1.setColumns(10);
		textField_1.setBounds(232, 268, 280, 34);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Introduce el nombre del usuario");
		textField_2.setColumns(10);
		textField_2.setBounds(232, 354, 280, 34);
		contentPane.add(textField_2);
		
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
		btnContinuar.setBounds(409, 468, 103, 28);
		contentPane.add(btnContinuar);
		
		btnContinuar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				PaginaPrincipal newUser=new PaginaPrincipal();
				newUser.setVisible(true);
				contentPane.setVisible(false);
			}
			
		});
		btnVolver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Inicio volver=new Inicio();
				volver.setVisible(true);
				contentPane.setVisible(false);
			}
			
		});

	}

}
