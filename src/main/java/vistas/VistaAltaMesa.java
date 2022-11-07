package vistas;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VistaAltaMesa extends JFrame implements IGenerica, KeyListener{

	private JFrame frmAltaDeMozo;
	private JTextField txtNumeroMesa;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JTextField txtCantSillas;
	
	private String numeroMesa = null;
	private String cantSillas = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaMesa window = new VistaAltaMesa();
					window.frmAltaDeMozo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaAltaMesa() {
		initialize();
	}

	private void initialize() {
		frmAltaDeMozo = new JFrame();
		frmAltaDeMozo.setTitle("Nueva Mesa");
		frmAltaDeMozo.setBounds(100, 100, 450, 300);
		frmAltaDeMozo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAltaDeMozo.getContentPane().setLayout(null);
		
		JLabel lblNumeroMesa = new JLabel("Numero de mesa");
		lblNumeroMesa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroMesa.setBounds(39, 24, 110, 21);
		frmAltaDeMozo.getContentPane().add(lblNumeroMesa);
		
		JLabel lblCantSillas = new JLabel("Cantidad de sillas\r\n");
		lblCantSillas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantSillas.setBounds(41, 124, 126, 20);
		frmAltaDeMozo.getContentPane().add(lblCantSillas);
		
		txtNumeroMesa = new JTextField();
		txtNumeroMesa.setBounds(200, 20, 184, 32);
		frmAltaDeMozo.getContentPane().add(txtNumeroMesa);
		txtNumeroMesa.setColumns(10);
		txtNumeroMesa.addKeyListener(this);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.setBounds(274, 205, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(39, 205, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnVolver);
		
		txtCantSillas = new JTextField();
		txtCantSillas.setColumns(10);
		txtCantSillas.setBounds(200, 120, 184, 32);
		frmAltaDeMozo.getContentPane().add(txtCantSillas);
		txtCantSillas.addKeyListener(this);
		
		limpia();
		
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
		this.limpia();
	}

	@Override
	public void limpia() {
		this.btnAceptar.setEnabled(false);
		this.txtNumeroMesa.setText("");
		this.txtCantSillas.setText("");
	}

	@Override
	public void success(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	@Override
	public void failure(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
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
		this.numeroMesa = txtNumeroMesa.getText();
		this.cantSillas = txtCantSillas.getText();
		
		this.btnAceptar.setEnabled( this.numeroMesa.length() > 0 && this.cantSillas.length() > 0 );
	}

	public String getNumeroMesa() {
		return numeroMesa;
	}

	public String getCantSillas() {
		return cantSillas;
	}

}
