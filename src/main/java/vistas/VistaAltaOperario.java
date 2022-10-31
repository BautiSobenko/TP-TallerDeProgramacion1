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
	private JTextField txtNombre;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JTextField txtNombreUsuario;
	private JRadioButton rdbtnOperarioActivo;
	private JRadioButton rdbtnOperarioNoActivo;
	private JLabel lblPassword;
	private JPasswordField txtPassword;

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
		frmAltaDeMozo.setTitle("Nuevo Operario");
		frmAltaDeMozo.setBounds(100, 100, 450, 300);
		frmAltaDeMozo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAltaDeMozo.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre completo");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(39, 24, 110, 21);
		frmAltaDeMozo.getContentPane().add(lblNombre);
		
		JLabel lblNombreUsuario = new JLabel("Nombre de usuario");
		lblNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreUsuario.setBounds(39, 68, 126, 20);
		frmAltaDeMozo.getContentPane().add(lblNombreUsuario);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstado.setBounds(39, 149, 126, 32);
		frmAltaDeMozo.getContentPane().add(lblEstado);
		
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
		btnAceptar.setBounds(274, 205, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(39, 205, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnVolver);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBounds(200, 64, 184, 32);
		frmAltaDeMozo.getContentPane().add(txtNombreUsuario);
		
		rdbtnOperarioActivo = new JRadioButton("Activo");
		rdbtnOperarioActivo.setSelected(true);
		rdbtnOperarioActivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnOperarioActivo.setBounds(201, 154, 72, 23);
		frmAltaDeMozo.getContentPane().add(rdbtnOperarioActivo);
		
		rdbtnOperarioNoActivo = new JRadioButton("No Activo");
		rdbtnOperarioNoActivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnOperarioNoActivo.setBounds(299, 154, 85, 23);
		frmAltaDeMozo.getContentPane().add(rdbtnOperarioNoActivo);
		
		lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(39, 111, 126, 20);
		frmAltaDeMozo.getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(200, 107, 184, 32);
		frmAltaDeMozo.getContentPane().add(txtPassword);
	}
}
