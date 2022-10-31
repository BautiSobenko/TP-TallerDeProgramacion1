package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class VistaAltaOperario {

	private JFrame frmAltaDeMozo;
	private JTextField textField;
	private JButton btnRegistrar;
	private JButton btnVolver;
	private JTextField textField_1;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JLabel lblContrasea;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaOperario window = new VistaAltaOperario();
					window.frmAltaDeMozo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaAltaOperario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAltaDeMozo = new JFrame();
		frmAltaDeMozo.setTitle("Alta de operario");
		frmAltaDeMozo.setBounds(100, 100, 450, 300);
		frmAltaDeMozo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAltaDeMozo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre completo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(39, 24, 110, 21);
		frmAltaDeMozo.getContentPane().add(lblNewLabel);
		
		JLabel lblFechaDeNacimiento = new JLabel("Nombre de usuario");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaDeNacimiento.setBounds(39, 68, 126, 20);
		frmAltaDeMozo.getContentPane().add(lblFechaDeNacimiento);
		
		JLabel lblNewLabel_1_1 = new JLabel("Estado");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(39, 149, 126, 32);
		frmAltaDeMozo.getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(200, 20, 184, 32);
		frmAltaDeMozo.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnRegistrar = new JButton("Aceptar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(274, 205, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnRegistrar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(39, 205, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnVolver);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(200, 64, 184, 32);
		frmAltaDeMozo.getContentPane().add(textField_1);
		
		rdbtnNewRadioButton = new JRadioButton("Activo");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(201, 154, 72, 23);
		frmAltaDeMozo.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("No Activo");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_1.setBounds(299, 154, 85, 23);
		frmAltaDeMozo.getContentPane().add(rdbtnNewRadioButton_1);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(39, 111, 126, 20);
		frmAltaDeMozo.getContentPane().add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 107, 184, 32);
		frmAltaDeMozo.getContentPane().add(passwordField);
	}
}
