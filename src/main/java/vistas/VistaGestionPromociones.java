package vistas;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import modelo.promociones.Promocion;

public class VistaGestionPromociones extends JFrame implements IVistaGestion, MouseListener{

	private JFrame frmGestionDePromociones;
	private JButton btnAltaPromo,btnBajaPromo,btnVolver;
	private JList<Promocion> listaPromos;
	private ActionListener actionListener;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaGestionPromociones window = new VistaGestionPromociones();
					window.frmGestionDePromociones.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaGestionPromociones() {
		initialize();
	}

	private void initialize() {
		frmGestionDePromociones = new JFrame();
		frmGestionDePromociones.setTitle("Gestion de promociones");
		frmGestionDePromociones.setBounds(100, 100, 450, 300);
		frmGestionDePromociones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDePromociones.getContentPane().setLayout(null);
		
		JLabel lblListaPromos = new JLabel("Listado de promociones");
		lblListaPromos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaPromos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaPromos.setBounds(65, 21, 145, 14);
		frmGestionDePromociones.getContentPane().add(lblListaPromos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 46, 221, 142);
		frmGestionDePromociones.getContentPane().add(scrollPane);
		
		listaPromos = new JList();
		scrollPane.setViewportView(listaPromos);
		listaPromos.addMouseListener(this);
		
		btnAltaPromo = new JButton("Alta Promocion");
		btnAltaPromo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltaPromo.addActionListener(actionListener);
		btnAltaPromo.setBounds(276, 74, 130, 32);
		frmGestionDePromociones.getContentPane().add(btnAltaPromo);
		
		btnBajaPromo = new JButton("Baja Promocion");
		btnBajaPromo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBajaPromo.setBounds(276, 128, 130, 32);
		frmGestionDePromociones.getContentPane().add(btnBajaPromo);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(22, 207, 89, 32);
		frmGestionDePromociones.getContentPane().add(btnVolver);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
		btnAltaPromo.addActionListener(actionListener);
		btnBajaPromo.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
	}

	@Override
	public void mostrar() {
		this.frmGestionDePromociones.setVisible(true);
	}

	@Override
	public void esconder() {
		this.frmGestionDePromociones.setVisible(false);
		this.limpia();
	}

	@Override
	public void limpia() {
		this.btnBajaPromo.setEnabled(false);
	}

	@Override
	public void success(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Resultado exitoso", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void failure(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(this.listaPromos.getSelectedValue()!=null)
			this.btnBajaPromo.setEnabled(true);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

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
	public void setModel(DefaultListModel<?> lista) {
		this.listaPromos.setModel((ListModel<Promocion>) lista);
	}

	@Override
	public Object getSeleccion() {
		return this.listaPromos.getSelectedValue();
	}
}
