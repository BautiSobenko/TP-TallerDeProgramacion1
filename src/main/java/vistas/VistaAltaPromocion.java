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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JCheckBox;

public class VistaAltaPromocion extends JFrame implements IGenerica, KeyListener, MouseListener{

	private JFrame frmAltaDeMozo;
	private JTextField txtNombrePromocion;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JLabel lblFormaDePago;
	private JCheckBox chckbxEfectivo;
	private JCheckBox chckbxTarjeta;
	private JCheckBox chckbxMercadoPago;
	private JCheckBox chckbxCuentaDNI;
	private JCheckBox chckbxLunes;
	private JCheckBox chckbxMartes;
	private JCheckBox chckbxMiercoles;
	private JCheckBox chckbxJueves;
	private JCheckBox chckbxViernes;
	private JCheckBox chckbxSabado;
	private JCheckBox chckbxDomingo;
	private JCheckBox chckbxPromoActiva;
	private JCheckBox chckbxPromoAcumulable;
	
	private String nombre = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaPromocion window = new VistaAltaPromocion();
					window.frmAltaDeMozo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaAltaPromocion() {
		initialize();
	}

	private void initialize() {
		frmAltaDeMozo = new JFrame();
		frmAltaDeMozo.setTitle("Promocion temporal");
		frmAltaDeMozo.setBounds(100, 100, 450, 300);
		frmAltaDeMozo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAltaDeMozo.getContentPane().setLayout(null);
		
		JLabel lblNombrePromocion = new JLabel("Nombre promocion");
		lblNombrePromocion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombrePromocion.setBounds(23, 15, 126, 21);
		frmAltaDeMozo.getContentPane().add(lblNombrePromocion);
		
		txtNombrePromocion = new JTextField();
		txtNombrePromocion.setBounds(197, 11, 192, 32);
		frmAltaDeMozo.getContentPane().add(txtNombrePromocion);
		txtNombrePromocion.setColumns(10);
		txtNombrePromocion.addKeyListener(this);
		
		btnAceptar = new JButton("Aceptar");

		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.setBounds(304, 218, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(23, 218, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnVolver);
		
		lblFormaDePago = new JLabel("Formas de pago");
		lblFormaDePago.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFormaDePago.setBounds(23, 56, 126, 21);
		frmAltaDeMozo.getContentPane().add(lblFormaDePago);
		
		chckbxEfectivo = new JCheckBox("Efectivo");
		chckbxEfectivo.setBounds(197, 56, 72, 23);
		chckbxEfectivo.addMouseListener(this);
		frmAltaDeMozo.getContentPane().add(chckbxEfectivo);
		
		chckbxTarjeta = new JCheckBox("Tarjeta");
		chckbxTarjeta.setBounds(197, 82, 72, 23);
		chckbxTarjeta.addMouseListener(this);
		frmAltaDeMozo.getContentPane().add(chckbxTarjeta);
		
		chckbxMercadoPago = new JCheckBox("Mercado Pago");
		chckbxMercadoPago.setBounds(300, 56, 97, 23);
		chckbxMercadoPago.addMouseListener(this);
		frmAltaDeMozo.getContentPane().add(chckbxMercadoPago);
		
		chckbxCuentaDNI = new JCheckBox("Cuenta DNI");
		chckbxCuentaDNI.setBounds(300, 82, 97, 23);
		chckbxCuentaDNI.addMouseListener(this);
		frmAltaDeMozo.getContentPane().add(chckbxCuentaDNI);
		
		JLabel lblFormaDePago_1 = new JLabel("Dias Promo");
		lblFormaDePago_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFormaDePago_1.setBounds(23, 111, 97, 24);
		frmAltaDeMozo.getContentPane().add(lblFormaDePago_1);
		
		chckbxLunes = new JCheckBox("Lunes");
		chckbxLunes.setBounds(117, 111, 60, 23);
		chckbxLunes.addMouseListener(this);
		frmAltaDeMozo.getContentPane().add(chckbxLunes);
		
		chckbxJueves = new JCheckBox("Jueves");
		chckbxJueves.setBounds(117, 137, 60, 23);
		chckbxJueves.addMouseListener(this);
		frmAltaDeMozo.getContentPane().add(chckbxJueves);
		
		chckbxMartes = new JCheckBox("Martes");
		chckbxMartes.setBounds(197, 111, 60, 23);
		chckbxMartes.addMouseListener(this);
		frmAltaDeMozo.getContentPane().add(chckbxMartes);
		
		chckbxViernes = new JCheckBox("Viernes");
		chckbxViernes.setBounds(197, 137, 60, 23);
		chckbxViernes.addMouseListener(this);
		frmAltaDeMozo.getContentPane().add(chckbxViernes);
		
		chckbxMiercoles = new JCheckBox("Miercoles");
		chckbxMiercoles.setBounds(272, 111, 72, 23);
		chckbxMiercoles.addMouseListener(this);
		frmAltaDeMozo.getContentPane().add(chckbxMiercoles);
		
		chckbxSabado = new JCheckBox("Sabado");
		chckbxSabado.setBounds(272, 137, 61, 23);
		chckbxSabado.addMouseListener(this);
		frmAltaDeMozo.getContentPane().add(chckbxSabado);
		
		chckbxDomingo = new JCheckBox("Domingo");
		chckbxDomingo.setBounds(347, 123, 67, 23);
		chckbxDomingo.addMouseListener(this);
		frmAltaDeMozo.getContentPane().add(chckbxDomingo);
		
		chckbxPromoActiva = new JCheckBox("");
		chckbxPromoActiva.setBounds(74, 180, 27, 23);
		frmAltaDeMozo.getContentPane().add(chckbxPromoActiva);
		
		JLabel lblFormaDePago_1_1 = new JLabel("Activa");
		lblFormaDePago_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFormaDePago_1_1.setBounds(23, 180, 45, 21);
		frmAltaDeMozo.getContentPane().add(lblFormaDePago_1_1);
		
		chckbxPromoAcumulable = new JCheckBox("");
		chckbxPromoAcumulable.setBounds(218, 180, 27, 23);
		frmAltaDeMozo.getContentPane().add(chckbxPromoAcumulable);
		
		JLabel lblFormaDePago_1_1_1 = new JLabel("Acumulable");
		lblFormaDePago_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFormaDePago_1_1_1.setBounds(140, 180, 72, 21);
		frmAltaDeMozo.getContentPane().add(lblFormaDePago_1_1_1);
		
		limpia();
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
		this.btnAceptar.setEnabled(( this.chckbxEfectivo.isSelected()    ||
									 this.chckbxTarjeta.isSelected()     ||
									 this.chckbxMercadoPago.isSelected() ||
									 this.chckbxCuentaDNI.isSelected() )
									 &&
								   ( this.chckbxLunes.isSelected()       || 
									 this.chckbxMartes.isSelected()      || 
									 this.chckbxMiercoles.isSelected()   || 
									 this.chckbxJueves.isSelected()      || 
									 this.chckbxViernes.isSelected()     || 
									 this.chckbxSabado.isSelected()      || 
									 this.chckbxDomingo.isSelected() )
									 && 
									 this.nombre.length() > 0 );
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.nombre = this.txtNombrePromocion.getText();
		
		this.btnAceptar.setEnabled(( this.chckbxEfectivo.isSelected()    ||
									 this.chckbxTarjeta.isSelected()     ||
									 this.chckbxMercadoPago.isSelected() ||
									 this.chckbxCuentaDNI.isSelected() )
									 &&
								   ( this.chckbxLunes.isSelected()       || 
									 this.chckbxMartes.isSelected()      || 
									 this.chckbxMiercoles.isSelected()   || 
									 this.chckbxJueves.isSelected()      || 
									 this.chckbxViernes.isSelected()     || 
									 this.chckbxSabado.isSelected()      || 
									 this.chckbxDomingo.isSelected() )
									 && 
									 this.nombre.length() > 0 );
		
		
		
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnAceptar.addActionListener(actionListener);	
		this.btnVolver.addActionListener(actionListener);
		
		this.chckbxEfectivo.addActionListener(actionListener);
		this.chckbxTarjeta.addActionListener(actionListener);
		this.chckbxMercadoPago.addActionListener(actionListener);
		this.chckbxCuentaDNI.addActionListener(actionListener);
		
		this.chckbxLunes.addActionListener(actionListener);
		this.chckbxMartes.addActionListener(actionListener);
		this.chckbxMiercoles.addActionListener(actionListener);
		this.chckbxJueves.addActionListener(actionListener);
		this.chckbxViernes.addActionListener(actionListener);
		this.chckbxSabado.addActionListener(actionListener);
		this.chckbxDomingo.addActionListener(actionListener);
		
		this.chckbxPromoActiva.addActionListener(actionListener);
		this.chckbxPromoAcumulable.addActionListener(actionListener);
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
		this.txtNombrePromocion.setText("");
		this.btnAceptar.setEnabled(false);
		
		this.chckbxEfectivo.setSelected(false);
		this.chckbxTarjeta.setSelected(false);
		this.chckbxMercadoPago.setSelected(false);
		this.chckbxCuentaDNI.setSelected(false);
		
		this.chckbxLunes.setSelected(false);
		this.chckbxMartes.setSelected(false);
		this.chckbxMiercoles.setSelected(false);
		this.chckbxJueves.setSelected(false);
		this.chckbxViernes.setSelected(false);
		this.chckbxSabado.setSelected(false);
		this.chckbxDomingo.setSelected(false);
		
		this.chckbxPromoActiva.setSelected(false);
		this.chckbxPromoAcumulable.setSelected(false);
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
}
