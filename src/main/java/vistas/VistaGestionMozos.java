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

public class VistaGestionMozos {

	private JFrame frmGestionDeMozos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaGestionMozos window = new VistaGestionMozos();
					window.frmGestionDeMozos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaGestionMozos() {
		initialize();
	}

	private void initialize() {
		frmGestionDeMozos = new JFrame();
		frmGestionDeMozos.setTitle("Gestion de Mozos");
		frmGestionDeMozos.setBounds(100, 100, 450, 300);
		frmGestionDeMozos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDeMozos.getContentPane().setLayout(null);
		
		JLabel lblListadoMozos = new JLabel("Listado de mozos");
		lblListadoMozos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoMozos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListadoMozos.setBounds(83, 21, 111, 14);
		frmGestionDeMozos.getContentPane().add(lblListadoMozos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 46, 221, 142);
		frmGestionDeMozos.getContentPane().add(scrollPane);
		
		JList listMozos = new JList();
		scrollPane.setViewportView(listMozos);
		
		JButton btnAltaMozo = new JButton("Alta Mozo");
		btnAltaMozo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltaMozo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAltaMozo.setBounds(276, 46, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnAltaMozo);
		
		JButton btnBajaMozo = new JButton("Baja Mozo");
		btnBajaMozo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBajaMozo.setBounds(276, 101, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnBajaMozo);
		
		JButton btnModificarMozo = new JButton("Modificar Mozo");
		btnModificarMozo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarMozo.setBounds(276, 156, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnModificarMozo);
		
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
