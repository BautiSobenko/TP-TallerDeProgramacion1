package vistas;

import modelo.Mesa;
import modelo.Producto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VistaLocalAbierto extends JFrame implements IGenerica,MouseListener {

	private JPanel contentPane;
	private JButton btnCerrarLocal,btnCerrarMesa,btnCargarPedido,btnAbrirMesa;
	private JComboBox comboBoxAbrir,comboBoxCantidad,comboBoxMesa,comboBoxProducto,comboBoxCerrar;
	private ActionListener actionListener;
	private JPanel panelEstadisticas;
	private JButton btnMaxVentas;
	private JButton btnMinVentas;
	private JButton btnConsumoPromedio;

	private Mesa mesaApertura,mesaCierre,mesaPedido;
	private Producto productoElegido;
	private int cantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaLocalAbierto frame = new VistaLocalAbierto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaLocalAbierto() {
		setTitle("Administracion Gastronomica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelGeneral = new JPanel();
		contentPane.add(panelGeneral, BorderLayout.CENTER);
		panelGeneral.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panelSup = new JPanel();
		panelGeneral.add(panelSup);
		panelSup.setLayout(null);
		
		comboBoxAbrir = new JComboBox();
		comboBoxAbrir.setToolTipText("Seleccione la mesa que desea abrir");
		comboBoxAbrir.setBounds(10, 29, 293, 48);
		comboBoxAbrir.addMouseListener(this);
		panelSup.add(comboBoxAbrir);
		comboBoxAbrir.addMouseListener(this);
		comboBoxAbrir.setSelectedItem(null);
		
		btnAbrirMesa = new JButton("Abrir Mesa");
		btnAbrirMesa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAbrirMesa.setBounds(502, 27, 132, 48);
		btnAbrirMesa.setEnabled(false);
		panelSup.add(btnAbrirMesa);
		
		JPanel panelCentral = new JPanel();
		panelGeneral.add(panelCentral);
		panelCentral.setLayout(null);
		
		comboBoxCantidad = new JComboBox();
		comboBoxCantidad.setToolTipText("Seleccione la cantidad del producto elegido");
		comboBoxCantidad.setBounds(313, 11, 111, 62);
		comboBoxCantidad.addMouseListener(this);
		panelCentral.add(comboBoxCantidad);
		comboBoxCantidad.addMouseListener(this);
		comboBoxCantidad.setSelectedItem(null);
		
		comboBoxMesa = new JComboBox();
		comboBoxMesa.setToolTipText("Seleccione la mesa que realizo el pedido");
		comboBoxMesa.setBounds(10, 11, 125, 62);
		comboBoxMesa.addMouseListener(this);
		panelCentral.add(comboBoxMesa);
		comboBoxMesa.addMouseListener(this);
		comboBoxMesa.setSelectedItem(null);

		
		comboBoxProducto = new JComboBox();
		comboBoxProducto.setToolTipText("Seleccione el producto a cargar");
		comboBoxProducto.setBounds(145, 11, 158, 62);
		comboBoxProducto.addMouseListener(this);
		panelCentral.add(comboBoxProducto);
		comboBoxProducto.addMouseListener(this);
		comboBoxProducto.setSelectedItem(null);
		
		btnCargarPedido = new JButton("Cargar Pedido");
		btnCargarPedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCargarPedido.setBounds(502, 18, 133, 45);
		btnCargarPedido.setEnabled(false);
		panelCentral.add(btnCargarPedido);
		
		JPanel panelInf = new JPanel();
		panelGeneral.add(panelInf);
		panelInf.setLayout(null);
		
		comboBoxCerrar = new JComboBox();
		comboBoxCerrar.setToolTipText("Seleccione la mesa que desea cerrar");
		comboBoxCerrar.setBounds(10, 29, 296, 48);
		comboBoxCerrar.addMouseListener(this);
		panelInf.add(comboBoxCerrar);
		comboBoxCerrar.addMouseListener(this);
		comboBoxCerrar.setSelectedItem(null);
		
		btnCerrarMesa = new JButton("Cerrar Mesa");
		btnCerrarMesa.setBounds(502, 27, 132, 48);
		btnCerrarMesa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCerrarMesa.setEnabled(false);
		panelInf.add(btnCerrarMesa);
		
		panelEstadisticas = new JPanel();
		panelGeneral.add(panelEstadisticas);
		panelEstadisticas.setLayout(null);
		
		btnMaxVentas = new JButton("Mozo con mas Ventas");
		btnMaxVentas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMaxVentas.setBounds(10, 11, 213, 79);
		panelEstadisticas.add(btnMaxVentas);
		
		btnMinVentas = new JButton("Mozo con menos ventas");
		btnMinVentas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinVentas.setBounds(251, 11, 199, 79);
		panelEstadisticas.add(btnMinVentas);
		
		btnConsumoPromedio = new JButton("Consumo promedio por mesa");
		btnConsumoPromedio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConsumoPromedio.setToolTipText("");
		btnConsumoPromedio.setBounds(475, 11, 234, 79);
		panelEstadisticas.add(btnConsumoPromedio);
		
		btnCerrarLocal = new JButton("Cerrar Local");
		btnCerrarLocal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnCerrarLocal, BorderLayout.SOUTH);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		this.actionListener = actionListener;
		this.btnAbrirMesa.addActionListener(actionListener);
		this.btnCargarPedido.addActionListener(actionListener);
		this.btnCerrarLocal.addActionListener(actionListener);
		this.btnCerrarMesa.addActionListener(actionListener);
		this.btnConsumoPromedio.addActionListener(actionListener);
		this.btnMaxVentas.addActionListener(actionListener);
		this.btnMinVentas.addActionListener(actionListener);
	}

	@Override
	public void mostrar() {
		this.setVisible(true);
	}

	@Override
	public void esconder() {
		this.setVisible(false);
		this.limpia();
	}

	@Override
	public void limpia() {
		this.btnAbrirMesa.setEnabled(false);
		this.btnCargarPedido.setEnabled(false);
		this.btnCerrarMesa.setEnabled(false);
		comboBoxAbrir.setSelectedItem(null);
		comboBoxMesa.setSelectedItem(null);
		comboBoxProducto.setSelectedItem(null);
		comboBoxCantidad.setSelectedItem(null);
		comboBoxCerrar.setSelectedItem(null);
	}

	@Override
	public void success(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Estadisticas", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void failure(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if(this.comboBoxAbrir.getSelectedItem()!=null) {
			this.mesaApertura = (Mesa) this.comboBoxAbrir.getSelectedItem();
			this.btnAbrirMesa.setEnabled(true);
		}
		if(this.comboBoxCantidad.getSelectedItem()!=null && this.comboBoxMesa.getSelectedItem()!=null && this.comboBoxProducto.getSelectedItem()!=null) {
			this.mesaPedido = (Mesa) this.comboBoxMesa.getSelectedItem();
			this.productoElegido = (Producto) this.comboBoxProducto.getSelectedItem();
			this.cantidad = (int) this.comboBoxCantidad.getSelectedItem();
			this.btnCargarPedido.setEnabled(true);
		}
		if(this.comboBoxCerrar.getSelectedItem()!=null) {
			this.mesaCierre = (Mesa) this.comboBoxCerrar.getSelectedItem();
			this.btnCerrarMesa.setEnabled(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public Mesa getMesaApertura() {
		return mesaApertura;
	}

	public void setMesaApertura(Mesa mesaApertura) {
		this.mesaApertura = mesaApertura;
	}

	public Mesa getMesaCierre() {
		return mesaCierre;
	}

	public void setMesaCierre(Mesa mesaCierre) {
		this.mesaCierre = mesaCierre;
	}

	public Mesa getMesaPedido() {
		return mesaPedido;
	}

	public void setMesaPedido(Mesa mesaPedido) {
		this.mesaPedido = mesaPedido;
	}

	public Producto getProductoElegido() {
		return productoElegido;
	}

	public void setProductoElegido(Producto productoElegido) {
		this.productoElegido = productoElegido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public JComboBox getComboBoxAbrir() {
		return comboBoxAbrir;
	}

	public void setComboBoxAbrir(JComboBox comboBoxAbrir) {
		this.comboBoxAbrir = comboBoxAbrir;
	}

	public JComboBox getComboBoxCantidad() {
		return comboBoxCantidad;
	}

	public void setComboBoxCantidad(JComboBox comboBoxCantidad) {
		this.comboBoxCantidad = comboBoxCantidad;
	}

	public JComboBox getComboBoxMesa() {
		return comboBoxMesa;
	}

	public void setComboBoxMesa(JComboBox comboBoxMesa) {
		this.comboBoxMesa = comboBoxMesa;
	}

	public JComboBox getComboBoxProducto() {
		return comboBoxProducto;
	}

	public void setComboBoxProducto(JComboBox comboBoxProducto) {
		this.comboBoxProducto = comboBoxProducto;
	}

	public JComboBox getComboBoxCerrar() {
		return comboBoxCerrar;
	}

	public void setComboBoxCerrar(JComboBox comboBoxCerrar) {
		this.comboBoxCerrar = comboBoxCerrar;
	}
}
