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
import java.awt.Font;
import javax.swing.SwingConstants;
import modelo.Mozo;

public class VistaGestionMozos extends JFrame implements IGenerica, MouseListener{

	private JFrame frmGestionDeMozos;
	private JButton btnVolver,btnModificarMozo,btnBajaMozo,btnAltaMozo;
	private JList<Mozo> listaMozos;
	private ActionListener actionListener;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaGestionMozos window = new VistaGestionMozos();
					window.frmGestionDeMozos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaGestionMozos() {
		initialize();
	}

	private void initialize() {
		frmGestionDeMozos = new JFrame();
		frmGestionDeMozos.setTitle("Gestion de Mozos");
		frmGestionDeMozos.setBounds(100, 100, 450, 300);
		frmGestionDeMozos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDeMozos.getContentPane().setLayout(null);
		
		JLabel lblListadoMozos = new JLabel("Listado de mozos");
		lblListadoMozos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoMozos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListadoMozos.setBounds(83, 21, 111, 14);
		frmGestionDeMozos.getContentPane().add(lblListadoMozos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 46, 221, 142);
		frmGestionDeMozos.getContentPane().add(scrollPane);
		
		listaMozos = new JList();
		scrollPane.setViewportView(listaMozos);
		listaMozos.addMouseListener(this);
		
		btnAltaMozo = new JButton("Alta Mozo");
		btnAltaMozo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltaMozo.setBounds(276, 46, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnAltaMozo);
		
		btnBajaMozo = new JButton("Baja Mozo");
		btnBajaMozo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBajaMozo.setBounds(276, 101, 130, 32);
		btnBajaMozo.setEnabled(false);
		frmGestionDeMozos.getContentPane().add(btnBajaMozo);
		
		btnModificarMozo = new JButton("Modificar Mozo");
		btnModificarMozo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarMozo.setBounds(276, 156, 130, 32);
		btnModificarMozo.setEnabled(false);
		frmGestionDeMozos.getContentPane().add(btnModificarMozo);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(26, 211, 89, 32);
		frmGestionDeMozos.getContentPane().add(btnVolver);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		this.actionListener = actionListener;
		btnAltaMozo.addActionListener(actionListener);
		btnModificarMozo.addActionListener(actionListener);
		btnBajaMozo.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
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
		this.btnBajaMozo.setEnabled(false);
		this.btnModificarMozo.setEnabled(false);
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
		if(this.listaMozos.getSelectedValue()!=null) {
			this.btnBajaMozo.setEnabled(true);
			this.btnModificarMozo.setEnabled(true);
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
