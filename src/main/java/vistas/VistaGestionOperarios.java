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

public class VistaGestionOperarios {

	private JFrame frmGestionDeMozos;
	private JButton btnAltaOperario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaGestionOperarios window = new VistaGestionOperarios();
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
	public VistaGestionOperarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDeMozos = new JFrame();
		frmGestionDeMozos.setTitle("Gestion de Operarios");
		frmGestionDeMozos.setBounds(100, 100, 450, 300);
		frmGestionDeMozos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDeMozos.getContentPane().setLayout(null);
		
		JLabel lblListaOperarios = new JLabel("Listado de operarios");
		lblListaOperarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaOperarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaOperarios.setBounds(72, 21, 130, 14);
		frmGestionDeMozos.getContentPane().add(lblListaOperarios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 46, 221, 142);
		frmGestionDeMozos.getContentPane().add(scrollPane);
		
		JList listOperarios = new JList();
		scrollPane.setViewportView(listOperarios);
		
		btnAltaOperario = new JButton("Alta Operario");
		btnAltaOperario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltaOperario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAltaOperario.setBounds(276, 46, 141, 32);
		frmGestionDeMozos.getContentPane().add(btnAltaOperario);
		
		JButton btnBajaOperario = new JButton("Baja Operario");
		btnBajaOperario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBajaOperario.setBounds(276, 101, 141, 32);
		frmGestionDeMozos.getContentPane().add(btnBajaOperario);
		
		JButton btnModificarOperario = new JButton("Modificar Operario");
		btnModificarOperario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarOperario.setBounds(276, 156, 141, 32);
		frmGestionDeMozos.getContentPane().add(btnModificarOperario);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVolver.setBounds(26, 211, 89, 32);
		frmGestionDeMozos.getContentPane().add(btnVolver);
	}
}
