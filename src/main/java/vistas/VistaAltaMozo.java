package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaAltaMozo {

	private JFrame frmAltaDeMozo;
	private JTextField textField;
	private JButton btnRegistrar;
	private JButton btnVolver;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaMozo window = new VistaAltaMozo();
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
	public VistaAltaMozo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAltaDeMozo = new JFrame();
		frmAltaDeMozo.setTitle("Alta de mozo");
		frmAltaDeMozo.setBounds(100, 100, 450, 300);
		frmAltaDeMozo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAltaDeMozo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre completo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(39, 24, 110, 21);
		frmAltaDeMozo.getContentPane().add(lblNewLabel);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaDeNacimiento.setBounds(39, 83, 126, 20);
		frmAltaDeMozo.getContentPane().add(lblFechaDeNacimiento);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cantidad de Hijos");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(39, 138, 126, 32);
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
		btnRegistrar.setBounds(274, 218, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnRegistrar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(39, 218, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnVolver);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(200, 80, 184, 32);
		frmAltaDeMozo.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(200, 140, 184, 32);
		frmAltaDeMozo.getContentPane().add(textField_2);
	}
}
