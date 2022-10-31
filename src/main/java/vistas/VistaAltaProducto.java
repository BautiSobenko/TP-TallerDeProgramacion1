package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaAltaProducto {

	private JFrame frmAltaDeMozo;
	private JTextField txtNombre;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JTextField txtPrecioCosto;
	private JTextField txtPrecioVenta;
	private JTextField txtStockInicial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaProducto window = new VistaAltaProducto();
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
	public VistaAltaProducto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAltaDeMozo = new JFrame();
		frmAltaDeMozo.setTitle("Nuevo Producto");
		frmAltaDeMozo.setBounds(100, 100, 450, 300);
		frmAltaDeMozo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAltaDeMozo.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre producto");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(39, 24, 110, 21);
		frmAltaDeMozo.getContentPane().add(lblNombre);
		
		JLabel lblPrecioCosto = new JLabel("Precio Costo");
		lblPrecioCosto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecioCosto.setBounds(39, 66, 126, 20);
		frmAltaDeMozo.getContentPane().add(lblPrecioCosto);
		
		JLabel lblPrecioVenta = new JLabel("Precio Venta");
		lblPrecioVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecioVenta.setBounds(39, 106, 126, 32);
		frmAltaDeMozo.getContentPane().add(lblPrecioVenta);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(200, 20, 184, 32);
		frmAltaDeMozo.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.setBounds(274, 218, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(39, 218, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnVolver);
		
		txtPrecioCosto = new JTextField();
		txtPrecioCosto.setColumns(10);
		txtPrecioCosto.setBounds(200, 63, 184, 32);
		frmAltaDeMozo.getContentPane().add(txtPrecioCosto);
		
		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setColumns(10);
		txtPrecioVenta.setBounds(200, 108, 184, 32);
		frmAltaDeMozo.getContentPane().add(txtPrecioVenta);
		
		JLabel lblStockInicial = new JLabel("Stock Inicial");
		lblStockInicial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStockInicial.setBounds(39, 153, 126, 32);
		frmAltaDeMozo.getContentPane().add(lblStockInicial);
		
		txtStockInicial = new JTextField();
		txtStockInicial.setColumns(10);
		txtStockInicial.setBounds(200, 155, 184, 32);
		frmAltaDeMozo.getContentPane().add(txtStockInicial);
	}
}
