package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VistaGestionMesas implements IGenerica{

	private JFrame frmGestionDeMozos;
	JButton btnAltaMesa;
	JButton btnModificarMesa;
	JButton btnBajaMesa;
	JButton btnAsignarMozo;
	JButton btnAceptar;
	JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaGestionMesas window = new VistaGestionMesas();
					window.frmGestionDeMozos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaGestionMesas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDeMozos = new JFrame();
		frmGestionDeMozos.setTitle("Gestion de Mesas");
		frmGestionDeMozos.setBounds(100, 100, 450, 300);
		frmGestionDeMozos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDeMozos.getContentPane().setLayout(null);
		
		JLabel lblListadoMesas = new JLabel("Listado de mesas");
		lblListadoMesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoMesas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListadoMesas.setBounds(83, 21, 111, 14);
		frmGestionDeMozos.getContentPane().add(lblListadoMesas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 46, 221, 142);
		frmGestionDeMozos.getContentPane().add(scrollPane);
		
		JList listMesas = new JList();
		scrollPane.setViewportView(listMesas);
		
		btnAltaMesa = new JButton("Alta Mesa");
		btnAltaMesa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnAltaMesa.setBounds(276, 46, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnAltaMesa);
		
		btnBajaMesa = new JButton("Baja Mesa");
		btnBajaMesa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBajaMesa.setBounds(276, 101, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnBajaMesa);
		
		btnModificarMesa = new JButton("Modificar Mesa");
		btnModificarMesa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarMesa.setBounds(276, 156, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnModificarMesa);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnVolver.setBounds(26, 211, 89, 32);
		frmGestionDeMozos.getContentPane().add(btnVolver);
		
		btnAsignarMozo = new JButton("Asignar Mozo");
		btnAsignarMozo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAsignarMozo.setBounds(276, 211, 130, 30);
		frmGestionDeMozos.getContentPane().add(btnAsignarMozo);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		
		
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void esconder() {
		// TODO Auto-generated method stub
		
	}
}
