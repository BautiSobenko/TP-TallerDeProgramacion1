package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import javax.swing.SwingConstants;
import modelo.Mesa;

public class VistaGestionMesas extends JFrame implements IGenerica, MouseListener{

	private JFrame frmGestionDeMozos;
	private JButton btnAltaMesa;
	private JButton btnModificarMesa;
	private JButton btnBajaMesa;
	private JButton btnAsignarMozo;
	private JButton btnAceptar;
	private JButton btnVolver;
	
	private DefaultListModel<Mesa> mesas;
	private JList<Mesa> listMesas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaGestionMesas window = new VistaGestionMesas();
					window.frmGestionDeMozos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VistaGestionMesas() {
		initialize();
	}

	private void initialize() {
		frmGestionDeMozos = new JFrame();
		frmGestionDeMozos.setTitle("Gestion de Mesas");
		frmGestionDeMozos.setBounds(100, 100, 450, 300);
		frmGestionDeMozos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDeMozos.getContentPane().setLayout(null);
		
		JLabel lblListadoMesas = new JLabel("Listado de mesas");
		lblListadoMesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoMesas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListadoMesas.setBounds(83, 21, 111, 14);
		frmGestionDeMozos.getContentPane().add(lblListadoMesas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 46, 221, 142);
		frmGestionDeMozos.getContentPane().add(scrollPane);
		
		listMesas = new JList();
		scrollPane.setViewportView(listMesas);
		listMesas.addMouseListener(this);
		
		btnAltaMesa = new JButton("Alta Mesa");
		btnAltaMesa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnAltaMesa.setBounds(276, 46, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnAltaMesa);
		
		btnBajaMesa = new JButton("Baja Mesa");
		btnBajaMesa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBajaMesa.setBounds(276, 101, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnBajaMesa);
		
		btnModificarMesa = new JButton("Modificar Mesa");
		btnModificarMesa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarMesa.setBounds(276, 156, 130, 32);
		frmGestionDeMozos.getContentPane().add(btnModificarMesa);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnVolver.setBounds(26, 211, 89, 32);
		frmGestionDeMozos.getContentPane().add(btnVolver);
		
		btnAsignarMozo = new JButton("Asignar Mozo");
		btnAsignarMozo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAsignarMozo.setBounds(276, 211, 130, 30);
		frmGestionDeMozos.getContentPane().add(btnAsignarMozo);
		
		limpia();
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnAceptar.addActionListener(actionListener);
		this.btnAltaMesa.addActionListener(actionListener);
		this.btnAsignarMozo.addActionListener(actionListener);
		this.btnBajaMesa.addActionListener(actionListener);
		this.btnModificarMesa.addActionListener(actionListener);
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
	
	public void setModel(DefaultListModel<Mesa> model) {
		this.listMesas.setModel(model);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if( this.listMesas.getSelectedValue() != null ) {
			this.btnBajaMesa.setEnabled(true);
			this.btnModificarMesa.setEnabled(true);
			this.btnAsignarMozo.setEnabled(true);
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

	@Override
	public void limpia() {
		this.btnBajaMesa.setEnabled(false);
		this.btnModificarMesa.setEnabled(false);
		this.btnAsignarMozo.setEnabled(false);
	}

}
