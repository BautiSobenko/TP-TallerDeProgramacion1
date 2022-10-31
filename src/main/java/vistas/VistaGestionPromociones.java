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

import modelo.Producto;

public class VistaGestionPromociones extends JFrame implements IGenerica, MouseListener{

	private JFrame frmGestionDeMozos;
	private JButton btnAltaPromo,btnBajaPromo,btnVolver;
	private JList<Producto> listaPromos;
	private ActionListener actionListener;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaGestionPromociones window = new VistaGestionPromociones();
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
	public VistaGestionPromociones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDeMozos = new JFrame();
		frmGestionDeMozos.setTitle("Gestion de promociones");
		frmGestionDeMozos.setBounds(100, 100, 450, 300);
		frmGestionDeMozos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDeMozos.getContentPane().setLayout(null);
		
		JLabel lblListaPromos = new JLabel("Listado de promociones");
		lblListaPromos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaPromos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaPromos.setBounds(65, 21, 145, 14);
		frmGestionDeMozos.getContentPane().add(lblListaPromos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 46, 221, 142);
		frmGestionDeMozos.getContentPane().add(scrollPane);
		
		listaPromos = new JList();
		scrollPane.setViewportView(listaPromos);
		listaPromos.addMouseListener(this);
		
		btnAltaPromo = new JButton("Alta Promocion");
		btnAltaPromo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltaPromo.addActionListener(actionListener);
		btnAltaPromo.setBounds(276, 74, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnAltaPromo);
		
		btnBajaPromo = new JButton("Baja Promocion");
		btnBajaPromo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBajaPromo.setBounds(276, 128, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnBajaPromo);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(22, 207, 89, 32);
		frmGestionDeMozos.getContentPane().add(btnVolver);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		this.actionListener = actionListener;
		btnAltaPromo.addActionListener(actionListener);
		btnBajaPromo.addActionListener(actionListener);
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
		this.btnBajaPromo.setEnabled(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
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
}
