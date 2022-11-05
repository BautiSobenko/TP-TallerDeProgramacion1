package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VistaAltaProducto extends JFrame implements IGenerica, KeyListener {

	private JFrame frmAltaDeMozo;
	private JTextField txtNombre;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JTextField txtPrecioCosto;
	private JTextField txtPrecioVenta;
	private JTextField txtStockInicial;
	
	private String nombre;
	private String precioCosto;
	private String precioVenta;
	private String stockInicial;

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

	public VistaAltaProducto() {
		initialize();
	}

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
		txtNombre.addKeyListener(this);
		
		btnAceptar = new JButton("Aceptar");
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
		txtPrecioCosto.addKeyListener(this);
		frmAltaDeMozo.getContentPane().add(txtPrecioCosto);
		
		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setColumns(10);
		txtPrecioVenta.setBounds(200, 108, 184, 32);
		txtPrecioVenta.addKeyListener(this);
		frmAltaDeMozo.getContentPane().add(txtPrecioVenta);
		
		JLabel lblStockInicial = new JLabel("Stock Inicial");
		lblStockInicial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStockInicial.setBounds(39, 153, 126, 32);
		frmAltaDeMozo.getContentPane().add(lblStockInicial);
		
		txtStockInicial = new JTextField();
		txtStockInicial.setColumns(10);
		txtStockInicial.setBounds(200, 155, 184, 32);
		txtStockInicial.addKeyListener(this);
		frmAltaDeMozo.getContentPane().add(txtStockInicial);
		
		limpia();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.nombre = this.txtNombre.getText();
		this.precioCosto = this.txtPrecioCosto.getText();
		this.precioVenta = this.txtPrecioVenta.getText();
		this.stockInicial = this.txtStockInicial.getText();
		
		if( nombre.length() > 0 &&
			precioCosto.length() > 0 &&
			precioVenta.length() > 0 &&
			stockInicial.length() > 0) {
			
			this.btnAceptar.setEnabled(true);
			
		}
		
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnAceptar.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
	}

	@Override
	public void mostrar() {
		this.setVisible(true);
		
	}

	@Override
	public void esconder() {
		this.setVisible(false);
		
	}

	@Override
	public void limpia() {
		this.btnAceptar.setEnabled(false);
		this.txtNombre.setText("");
		this.txtPrecioCosto.setText("");
		this.txtPrecioVenta.setText("");
		this.txtStockInicial.setText("");
	}

	@Override
	public void success(String msg) {

	}

	@Override
	public void failure(String msg) {

	}

	public String getNombre() {
		return nombre;
	}

	public String getPrecioCosto() {
		return precioCosto;
	}

	public String getPrecioVenta() {
		return precioVenta;
	}

	public String getStockInicial() {
		return stockInicial;
	}
}
