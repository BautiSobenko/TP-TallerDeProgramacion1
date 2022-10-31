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
	private JTextField txtNombre;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JTextField txtFechaNacimiento;
	private JTextField txtCantHijos;

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
		frmAltaDeMozo.setTitle("Nuevo Mozo");
		frmAltaDeMozo.setBounds(100, 100, 450, 300);
		frmAltaDeMozo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAltaDeMozo.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre completo");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(39, 24, 110, 21);
		frmAltaDeMozo.getContentPane().add(lblNombre);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaDeNacimiento.setBounds(39, 83, 126, 20);
		frmAltaDeMozo.getContentPane().add(lblFechaDeNacimiento);
		
		JLabel lblCantHijos = new JLabel("Cantidad de Hijos");
		lblCantHijos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantHijos.setBounds(39, 138, 126, 32);
		frmAltaDeMozo.getContentPane().add(lblCantHijos);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(200, 20, 184, 32);
		frmAltaDeMozo.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.setBounds(274, 218, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(39, 218, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnVolver);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(200, 80, 184, 32);
		frmAltaDeMozo.getContentPane().add(txtFechaNacimiento);
		
		txtCantHijos = new JTextField();
		txtCantHijos.setColumns(10);
		txtCantHijos.setBounds(200, 140, 184, 32);
		frmAltaDeMozo.getContentPane().add(txtCantHijos);
	}
}
