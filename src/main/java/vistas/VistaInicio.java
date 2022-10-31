package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaInicio {

	private JFrame frmInicioOperario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInicio window = new VistaInicio();
					window.frmInicioOperario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInicioOperario = new JFrame();
		frmInicioOperario.setTitle("Inicio Operario");
		frmInicioOperario.setBounds(100, 100, 532, 406);
		frmInicioOperario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelGral = new JPanel();
		frmInicioOperario.getContentPane().add(panelGral, BorderLayout.CENTER);
		panelGral.setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 0, 516, 303);
		panelGral.add(panel2);
		panel2.setLayout(null);
		
		JPanel panelGrid = new JPanel();
		panelGrid.setBounds(0, 0, 516, 303);
		panel2.add(panelGrid);
		panelGrid.setLayout(null);
		
		JPanel panelMo = new JPanel();
		panelMo.setBounds(0, 11, 253, 102);
		panelGrid.add(panelMo);
		panelMo.setLayout(null);
		
		JButton btnGestionMozos = new JButton("Gestionar Mozos");
		btnGestionMozos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestionMozos.setBounds(41, 11, 170, 80);
		panelMo.add(btnGestionMozos);
		
		JPanel panelMo_1 = new JPanel();
		panelMo_1.setBounds(263, 11, 253, 102);
		panelMo_1.setLayout(null);
		panelGrid.add(panelMo_1);
		
		JButton btnGestionOperarios = new JButton("Gestionar Operarios");
		btnGestionOperarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestionOperarios.setBounds(41, 11, 170, 80);
		panelMo_1.add(btnGestionOperarios);
		
		JPanel panelMo_2 = new JPanel();
		panelMo_2.setBounds(0, 112, 253, 102);
		panelMo_2.setLayout(null);
		panelGrid.add(panelMo_2);
		
		JButton btnGestionMesas = new JButton("Gestionar Mesas");
		btnGestionMesas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestionMesas.setBounds(41, 11, 170, 80);
		panelMo_2.add(btnGestionMesas);
		
		JPanel panelMo_3 = new JPanel();
		panelMo_3.setBounds(263, 112, 253, 102);
		panelMo_3.setLayout(null);
		panelGrid.add(panelMo_3);
		
		JButton btnGestionProductos = new JButton("Gestionar Productos");
		btnGestionProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestionProductos.setBounds(41, 11, 170, 80);
		panelMo_3.add(btnGestionProductos);
		
		JPanel panelMo_4 = new JPanel();
		panelMo_4.setBounds(0, 213, 516, 102);
		panelMo_4.setLayout(null);
		panelGrid.add(panelMo_4);
		
		JButton btnGestionPromos = new JButton("Gestionar Promociones");
		btnGestionPromos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGestionPromos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestionPromos.setBounds(169, 11, 173, 80);
		panelMo_4.add(btnGestionPromos);
		
		JPanel panelSur = new JPanel();
		panelSur.setBounds(0, 314, 516, 53);
		panelGral.add(panelSur);
		panelSur.setLayout(null);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(0, 11, 260, 42);
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSur.add(btnCerrarSesion);
		
		JButton btnApertura = new JButton("Abrir Local");
		btnApertura.setBounds(256, 11, 260, 42);
		btnApertura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSur.add(btnApertura);
	}
}
