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

public class VistaAltaMesa {

	private JFrame frmAltaDeMozo;
	private JTextField txtNumeroMesa;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JTextField txtCantSillas;
	private JRadioButton rdbtnMesaLibre;
	private JRadioButton rdbtnMesaOcupada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaMesa window = new VistaAltaMesa();
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
	public VistaAltaMesa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAltaDeMozo = new JFrame();
		frmAltaDeMozo.setTitle("Nueva Mesa");
		frmAltaDeMozo.setBounds(100, 100, 450, 300);
		frmAltaDeMozo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAltaDeMozo.getContentPane().setLayout(null);
		
		JLabel lblNumeroMesa = new JLabel("Numero de mesa");
		lblNumeroMesa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroMesa.setBounds(39, 24, 110, 21);
		frmAltaDeMozo.getContentPane().add(lblNumeroMesa);
		
		JLabel lblCantSillas = new JLabel("Cantidad de sillas\r\n");
		lblCantSillas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantSillas.setBounds(39, 83, 126, 20);
		frmAltaDeMozo.getContentPane().add(lblCantSillas);
		
		JLabel lblEstadoMesa = new JLabel("Estado");
		lblEstadoMesa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstadoMesa.setBounds(39, 138, 126, 32);
		frmAltaDeMozo.getContentPane().add(lblEstadoMesa);
		
		txtNumeroMesa = new JTextField();
		txtNumeroMesa.setBounds(200, 20, 184, 32);
		frmAltaDeMozo.getContentPane().add(txtNumeroMesa);
		txtNumeroMesa.setColumns(10);
		
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
		
		txtCantSillas = new JTextField();
		txtCantSillas.setColumns(10);
		txtCantSillas.setBounds(200, 80, 184, 32);
		frmAltaDeMozo.getContentPane().add(txtCantSillas);
		
		rdbtnMesaLibre = new JRadioButton("Libre");
		rdbtnMesaLibre.setSelected(true);
		rdbtnMesaLibre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMesaLibre.setBounds(200, 143, 72, 23);
		frmAltaDeMozo.getContentPane().add(rdbtnMesaLibre);
		
		rdbtnMesaOcupada = new JRadioButton("Ocupada");
		rdbtnMesaOcupada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMesaOcupada.setBounds(303, 143, 81, 23);
		frmAltaDeMozo.getContentPane().add(rdbtnMesaOcupada);
	}
}
