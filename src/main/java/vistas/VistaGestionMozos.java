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

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public VistaGestionMozos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDeMozos = new JFrame();
		frmGestionDeMozos.setTitle("Gestion de Mozos");
		frmGestionDeMozos.setBounds(100, 100, 450, 300);
		frmGestionDeMozos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDeMozos.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listado de mozos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(83, 21, 111, 14);
		frmGestionDeMozos.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 46, 221, 142);
		frmGestionDeMozos.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("Alta Mozo");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(276, 46, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Baja Mozo");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(276, 101, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modificar Mozo");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(276, 156, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Volver");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(26, 211, 89, 32);
		frmGestionDeMozos.getContentPane().add(btnNewButton_3);
	}
}
