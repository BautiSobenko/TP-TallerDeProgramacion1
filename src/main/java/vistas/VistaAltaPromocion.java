package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class VistaAltaPromocion {

	private JFrame frmAltaDeMozo;
	private JTextField txtNombrePromocion;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JLabel lblFormaDePago;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public VistaAltaPromocion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAltaDeMozo = new JFrame();
		frmAltaDeMozo.setTitle("Promocion temporal");
		frmAltaDeMozo.setBounds(100, 100, 450, 300);
		frmAltaDeMozo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAltaDeMozo.getContentPane().setLayout(null);
		
		JLabel lblNombrePromoción = new JLabel("Nombre promocion");
		lblNombrePromoción.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombrePromoción.setBounds(23, 15, 126, 21);
		frmAltaDeMozo.getContentPane().add(lblNombrePromoción);
		
		txtNombrePromocion = new JTextField();
		txtNombrePromocion.setBounds(197, 11, 192, 32);
		frmAltaDeMozo.getContentPane().add(txtNombrePromocion);
		txtNombrePromocion.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		
		JCheckBox chckbxEfectivo = new JCheckBox("Efectivo");
		chckbxEfectivo.setBounds(197, 56, 72, 23);
		frmAltaDeMozo.getContentPane().add(chckbxEfectivo);
		
		JCheckBox chckbxTarjeta = new JCheckBox("Tarjeta");
		chckbxTarjeta.setBounds(197, 82, 72, 23);
		frmAltaDeMozo.getContentPane().add(chckbxTarjeta);
		
		JCheckBox chckbxMercadoPago = new JCheckBox("Mercado Pago");
		chckbxMercadoPago.setBounds(300, 56, 97, 23);
		frmAltaDeMozo.getContentPane().add(chckbxMercadoPago);
		
		JCheckBox chckbxCuentaDNI = new JCheckBox("Cuenta DNI");
		chckbxCuentaDNI.setBounds(300, 82, 97, 23);
		frmAltaDeMozo.getContentPane().add(chckbxCuentaDNI);
		
		JLabel lblFormaDePago_1 = new JLabel("Dias Promo");
		lblFormaDePago_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFormaDePago_1.setBounds(23, 111, 97, 24);
		frmAltaDeMozo.getContentPane().add(lblFormaDePago_1);
		
		JCheckBox chckbxLunes = new JCheckBox("Lunes");
		chckbxLunes.setBounds(117, 111, 60, 23);
		frmAltaDeMozo.getContentPane().add(chckbxLunes);
		
		JCheckBox chckbxJueves = new JCheckBox("Jueves");
		chckbxJueves.setBounds(117, 137, 60, 23);
		frmAltaDeMozo.getContentPane().add(chckbxJueves);
		
		JCheckBox chckbxMartes = new JCheckBox("Martes");
		chckbxMartes.setBounds(197, 111, 60, 23);
		frmAltaDeMozo.getContentPane().add(chckbxMartes);
		
		JCheckBox chckbxViernes = new JCheckBox("Viernes");
		chckbxViernes.setBounds(197, 137, 60, 23);
		frmAltaDeMozo.getContentPane().add(chckbxViernes);
		
		JCheckBox chckbxMiercoles = new JCheckBox("Miercoles");
		chckbxMiercoles.setBounds(272, 111, 72, 23);
		frmAltaDeMozo.getContentPane().add(chckbxMiercoles);
		
		JCheckBox chckbxSabado = new JCheckBox("Sabado");
		chckbxSabado.setBounds(272, 137, 61, 23);
		frmAltaDeMozo.getContentPane().add(chckbxSabado);
		
		JCheckBox chckbxDomingo = new JCheckBox("Domingo");
		chckbxDomingo.setBounds(347, 123, 67, 23);
		frmAltaDeMozo.getContentPane().add(chckbxDomingo);
		
		JCheckBox chckbxPromoActiva = new JCheckBox("");
		chckbxPromoActiva.setBounds(74, 180, 27, 23);
		frmAltaDeMozo.getContentPane().add(chckbxPromoActiva);
		
		JLabel lblFormaDePago_1_1 = new JLabel("Activa");
		lblFormaDePago_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFormaDePago_1_1.setBounds(23, 180, 45, 21);
		frmAltaDeMozo.getContentPane().add(lblFormaDePago_1_1);
		
		JCheckBox chckbxPromoAcumulable = new JCheckBox("");
		chckbxPromoAcumulable.setBounds(218, 180, 27, 23);
		frmAltaDeMozo.getContentPane().add(chckbxPromoAcumulable);
		
		JLabel lblFormaDePago_1_1_1 = new JLabel("Acumulable");
		lblFormaDePago_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFormaDePago_1_1_1.setBounds(140, 180, 72, 21);
		frmAltaDeMozo.getContentPane().add(lblFormaDePago_1_1_1);
	}
}
