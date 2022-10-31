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

public class VistaGestionPromociones {

	private JFrame frmGestionDeMozos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaGestionPromociones window = new VistaGestionPromociones();
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
	public VistaGestionPromociones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDeMozos = new JFrame();
		frmGestionDeMozos.setTitle("Gestion de promociones");
		frmGestionDeMozos.setBounds(100, 100, 450, 300);
		frmGestionDeMozos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDeMozos.getContentPane().setLayout(null);
		
		JLabel lblListaPromos = new JLabel("Listado de promociones");
		lblListaPromos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaPromos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaPromos.setBounds(65, 21, 145, 14);
		frmGestionDeMozos.getContentPane().add(lblListaPromos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 46, 221, 142);
		frmGestionDeMozos.getContentPane().add(scrollPane);
		
		JList listPromos = new JList();
		scrollPane.setViewportView(listPromos);
		
		JButton btnAltaPromo = new JButton("Alta Promocion");
		btnAltaPromo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltaPromo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAltaPromo.setBounds(276, 74, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnAltaPromo);
		
		JButton btnBajaPromo = new JButton("Baja Promocion");
		btnBajaPromo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBajaPromo.setBounds(276, 128, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnBajaPromo);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVolver.setBounds(22, 207, 89, 32);
		frmGestionDeMozos.getContentPane().add(btnVolver);
	}
}
