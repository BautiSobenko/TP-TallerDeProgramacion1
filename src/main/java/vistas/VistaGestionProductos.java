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

public class VistaGestionProductos {

	private JFrame frmGestionDeMozos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaGestionProductos window = new VistaGestionProductos();
					window.frmGestionDeMozos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaGestionProductos() {
		initialize();
	}

	private void initialize() {
		frmGestionDeMozos = new JFrame();
		frmGestionDeMozos.setTitle("Gestion de Mozos");
		frmGestionDeMozos.setBounds(100, 100, 450, 300);
		frmGestionDeMozos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDeMozos.getContentPane().setLayout(null);
		
		JLabel lblListadoProductos = new JLabel("Listado de productos");
		lblListadoProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListadoProductos.setBounds(70, 11, 130, 25);
		frmGestionDeMozos.getContentPane().add(lblListadoProductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 46, 221, 142);
		frmGestionDeMozos.getContentPane().add(scrollPane);
		
		JList listProductos = new JList();
		scrollPane.setViewportView(listProductos);
		
		JButton btnAltaProducto = new JButton("Alta Producto");
		btnAltaProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltaProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAltaProducto.setBounds(270, 46, 147, 32);
		frmGestionDeMozos.getContentPane().add(btnAltaProducto);
		
		JButton btnBajaProducto = new JButton("Baja Producto");
		btnBajaProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBajaProducto.setBounds(270, 101, 147, 32);
		frmGestionDeMozos.getContentPane().add(btnBajaProducto);
		
		JButton btnModificarProducto = new JButton("Modificar Producto");
		btnModificarProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarProducto.setBounds(270, 156, 147, 32);
		frmGestionDeMozos.getContentPane().add(btnModificarProducto);
		
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
