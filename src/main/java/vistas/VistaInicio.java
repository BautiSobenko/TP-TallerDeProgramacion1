package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;

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
		frmInicioOperario.setBounds(100, 100, 450, 300);
		frmInicioOperario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelGral = new JPanel();
		frmInicioOperario.getContentPane().add(panelGral, BorderLayout.CENTER);
		panelGral.setLayout(new BorderLayout(0, 0));
		
		JPanel panel2 = new JPanel();
		panelGral.add(panel2, BorderLayout.CENTER);
		panel2.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGrid = new JPanel();
		panel2.add(panelGrid, BorderLayout.CENTER);
		panelGrid.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panelMo = new JPanel();
		panelGrid.add(panelMo);
		
		JButton btnMozos = new JButton("Gestionar Mozos");
		panelMo.add(btnMozos);
		
		JPanel panelMe = new JPanel();
		panelGrid.add(panelMe);
		
		JButton btnMesas = new JButton("Gestionar Mesas");
		panelMe.add(btnMesas);
		
		JPanel panelOp = new JPanel();
		panelGrid.add(panelOp);
		
		JButton btnOperarios = new JButton("Gestionar Operarios");
		panelOp.add(btnOperarios);
		
		JPanel panelProd = new JPanel();
		panelGrid.add(panelProd);
		
		JButton btnProductos = new JButton("Gestionar Productos");
		panelProd.add(btnProductos);
		
		JPanel panelPromo = new JPanel();
		panel2.add(panelPromo, BorderLayout.SOUTH);
		
		JButton btnPromociones = new JButton("Gestionar Promociones");
		panelPromo.add(btnPromociones);
		
		JPanel panelSur = new JPanel();
		panelGral.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnSalir = new JButton("Salir");
		panelSur.add(btnSalir);
		
		JButton btnApertuta = new JButton("Abrir Local");
		panelSur.add(btnApertuta);
	}

}
