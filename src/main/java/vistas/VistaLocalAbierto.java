package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VistaLocalAbierto extends JFrame implements IGenerica,MouseListener {

	private JPanel contentPane;
	private JButton btnCerrarLocal,btnCerrarMesa,btnCargarPedido,btnAbrirMesa;
	private JComboBox comboBoxAbrir,comboBoxCantidad,comboBoxMesa,comboBoxProducto,comboBoxCerrar;
	private ActionListener actionListener;

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
		setBounds(100, 100, 554, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelGeneral = new JPanel();
		contentPane.add(panelGeneral, BorderLayout.CENTER);
		panelGeneral.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panelSup = new JPanel();
		panelGeneral.add(panelSup);
		panelSup.setLayout(null);
		
		comboBoxAbrir = new JComboBox();
		comboBoxAbrir.setToolTipText("Seleccione la mesa que desea abrir");
		comboBoxAbrir.setBounds(10, 29, 227, 48);
		comboBoxAbrir.addMouseListener(this);
		panelSup.add(comboBoxAbrir);
		
		btnAbrirMesa = new JButton("Abrir Mesa");
		btnAbrirMesa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAbrirMesa.setBounds(368, 27, 132, 48);
		btnAbrirMesa.setEnabled(false);
		panelSup.add(btnAbrirMesa);
		
		JPanel panelCentral = new JPanel();
		panelGeneral.add(panelCentral);
		panelCentral.setLayout(null);
		
		comboBoxCantidad = new JComboBox();
		comboBoxCantidad.setToolTipText("Seleccione la cantidad del producto elegido");
		comboBoxCantidad.setBounds(259, 11, 81, 62);
		comboBoxCantidad.addMouseListener(this);
		panelCentral.add(comboBoxCantidad);
		
		comboBoxMesa = new JComboBox();
		comboBoxMesa.setToolTipText("Seleccione la mesa que realizo el pedido");
		comboBoxMesa.setBounds(10, 11, 96, 62);
		comboBoxMesa.addMouseListener(this);
		panelCentral.add(comboBoxMesa);
		
		comboBoxProducto = new JComboBox();
		comboBoxProducto.setToolTipText("Seleccione el producto a cargar");
		comboBoxProducto.setBounds(116, 11, 133, 62);
		comboBoxProducto.addMouseListener(this);
		panelCentral.add(comboBoxProducto);
		
		btnCargarPedido = new JButton("Cargar Pedido");
		btnCargarPedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCargarPedido.setBounds(369, 20, 133, 45);
		btnCargarPedido.setEnabled(false);
		panelCentral.add(btnCargarPedido);
		
		JPanel panelInf = new JPanel();
		panelGeneral.add(panelInf);
		panelInf.setLayout(null);
		
		comboBoxCerrar = new JComboBox();
		comboBoxCerrar.setToolTipText("Seleccione la mesa que desea cerrar");
		comboBoxCerrar.setBounds(10, 29, 227, 48);
		comboBoxCerrar.addMouseListener(this);
		panelInf.add(comboBoxCerrar);
		
		btnCerrarMesa = new JButton("Cerrar Mesa");
		btnCerrarMesa.setBounds(368, 27, 132, 48);
		btnCerrarMesa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCerrarMesa.setEnabled(false);
		panelInf.add(btnCerrarMesa);
		
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
		this.btnAbrirMesa.setEnabled(false);
		this.btnCargarPedido.setEnabled(false);
		this.btnCerrarMesa.setEnabled(false);
	}

	@Override
	public void success(String msg) {

	}

	@Override
	public void failure(String msg) {

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
		if(this.comboBoxAbrir.getSelectedItem()!=null)
			this.btnAbrirMesa.setEnabled(true);
		if(this.comboBoxCantidad.getSelectedItem()!=null && this.comboBoxMesa.getSelectedItem()!=null && this.comboBoxProducto.getSelectedItem()!=null)
			this.btnCargarPedido.setEnabled(true);
		if(this.comboBoxCerrar.getSelectedItem()!=null)
			this.btnCerrarMesa.setEnabled(true);
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
