package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class VistaAltaOperario extends JFrame implements IGenerica, KeyListener, MouseListener{

	private JFrame frmAltaDeMozo;
	private JTextField txtNombre;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JTextField txtNombreUsuario;
	private JRadioButton rdbtnOperarioNoActivo;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private ButtonGroup grupoEstado;
	
	private String nombre = null;
	private String username = null;
	private String password = null;
	private String estado = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaOperario window = new VistaAltaOperario();
					window.frmAltaDeMozo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaAltaOperario() {
		initialize();
	}

	private void initialize() {
		frmAltaDeMozo = new JFrame();
		frmAltaDeMozo.setTitle("Nuevo Operario");
		frmAltaDeMozo.setBounds(100, 100, 450, 300);
		frmAltaDeMozo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAltaDeMozo.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre completo");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(39, 24, 110, 21);
		frmAltaDeMozo.getContentPane().add(lblNombre);
		
		JLabel lblNombreUsuario = new JLabel("Nombre de usuario");
		lblNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreUsuario.setBounds(39, 68, 126, 20);
		frmAltaDeMozo.getContentPane().add(lblNombreUsuario);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstado.setBounds(39, 149, 126, 32);
		frmAltaDeMozo.getContentPane().add(lblEstado);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(200, 20, 184, 32);
		frmAltaDeMozo.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.addKeyListener(this);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.setBounds(274, 205, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(39, 205, 110, 32);
		frmAltaDeMozo.getContentPane().add(btnVolver);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBounds(200, 64, 184, 32);
		txtNombreUsuario.addKeyListener(this);
		frmAltaDeMozo.getContentPane().add(txtNombreUsuario);
		
		this.grupoEstado = new ButtonGroup();
		
		JRadioButton rdbtnOperarioActivo = new JRadioButton("Activo");
		rdbtnOperarioActivo.setSelected(true);
		rdbtnOperarioActivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnOperarioActivo.setBounds(201, 154, 72, 23);
		grupoEstado.add(rdbtnOperarioActivo);
		frmAltaDeMozo.getContentPane().add(rdbtnOperarioActivo);
		
		rdbtnOperarioNoActivo = new JRadioButton("No Activo");
		rdbtnOperarioNoActivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnOperarioNoActivo.setBounds(299, 154, 85, 23);
		grupoEstado.add(rdbtnOperarioNoActivo);
		frmAltaDeMozo.getContentPane().add(rdbtnOperarioNoActivo);
		
		lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(39, 111, 126, 20);
		frmAltaDeMozo.getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(200, 107, 184, 32);
		txtPassword.addKeyListener(this);
		frmAltaDeMozo.getContentPane().add(txtPassword);
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.estado = this.grupoEstado.getSelection().getActionCommand();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.nombre = this.txtNombre.getText();
		this.username = this.txtNombreUsuario.getText();
		this.password = new String(this.txtPassword.getPassword());
		
		if( nombre.length() > 0 && 
			username.length() > 0 && 
			password.length() > 0) {
			
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
	}

	public String getNombre() {
		return nombre;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEstado() {
		return estado;
	}
}
