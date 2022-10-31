package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import modelo.Operario;
import modelo.Producto;

public class VistaGestionProductos extends JFrame implements IGenerica,MouseListener{

	private JFrame frmGestionDeMozos;
	private JButton btnAltaProducto,btnBajaProducto,btnModificarProducto,btnVolver;
	private JList<Producto> listaProductos;
	private ActionListener actionListener;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public VistaGestionProductos() {
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
		
		JLabel lblListadoProductos = new JLabel("Listado de productos");
		lblListadoProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListadoProductos.setBounds(70, 11, 130, 25);
		frmGestionDeMozos.getContentPane().add(lblListadoProductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 46, 221, 142);
		frmGestionDeMozos.getContentPane().add(scrollPane);
		
		listaProductos = new JList();
		scrollPane.setViewportView(listaProductos);
		listaProductos.addMouseListener(this);
		
		btnAltaProducto = new JButton("Alta Producto");
		btnAltaProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltaProducto.setBounds(270, 46, 147, 32);
		frmGestionDeMozos.getContentPane().add(btnAltaProducto);
		
		btnBajaProducto = new JButton("Baja Producto");
		btnBajaProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBajaProducto.setBounds(270, 101, 147, 32);
		btnBajaProducto.setEnabled(false);
		frmGestionDeMozos.getContentPane().add(btnBajaProducto);
		
		btnModificarProducto = new JButton("Modificar Producto");
		btnModificarProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarProducto.setBounds(270, 156, 147, 32);
		btnModificarProducto.setEnabled(false);
		frmGestionDeMozos.getContentPane().add(btnModificarProducto);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(26, 211, 89, 32);
		frmGestionDeMozos.getContentPane().add(btnVolver);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		this.actionListener = actionListener;
		btnAltaProducto.addActionListener(actionListener);
		btnModificarProducto.addActionListener(actionListener);
		btnBajaProducto.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}

	@Override
	public void esconder() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		this.limpia();
	}

	@Override
	public void limpia() {
		// TODO Auto-generated method stub
		this.btnBajaProducto.setEnabled(false);
		this.btnModificarProducto.setEnabled(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(this.listaProductos.getSelectedValue()!=null) {
			this.btnBajaProducto.setEnabled(true);
			this.btnModificarProducto.setEnabled(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
