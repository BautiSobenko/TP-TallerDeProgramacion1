package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VistaLogin extends JFrame implements KeyListener, ILogin {

	private JPanel contentPane;
	private JTextField usernameField;
	private JButton loginButton;
	private ActionListener actionListener;
	private String username;
	private String contrasena;
	private JPasswordField passwordField;

	public VistaLogin() {
		setTitle("Administracion Gastronomica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(0, 5, 505, 30);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		panelCentro.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 42, 505, 41);
		panelCentro.add(panel_1);

		usernameField = new JTextField();
		usernameField.setBounds(5, 0, 358, 25);
		usernameField.addKeyListener(this);
		panel_1.setLayout(null);
		panel_1.add(usernameField);
		usernameField.setColumns(20);

		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(0, 85, 505, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		panelCentro.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(20);
		passwordField.setBounds(5, 110, 357, 25);
		panelCentro.add(passwordField);

		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new BorderLayout(0, 0));

		loginButton = new JButton("Entrar");
		loginButton.setEnabled(false);
		loginButton.setActionCommand("LOGIN");
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelSur.add(loginButton);

		this.setVisible(true);
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		this.username = this.usernameField.getText();
		this.contrasena = new String(this.passwordField.getPassword());

		this.loginButton.setEnabled(username.length() > 0 && contrasena.length() > 0);
	}

	public void keyTyped(KeyEvent e) {
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public String getContrasena() {
		return this.contrasena;
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.loginButton.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	public void usuarioNoEncontrado() {
		JOptionPane.showMessageDialog(this, "Usuario no encontrado");
	}

	public void contrasenaIncorrecta() {
		JOptionPane.showMessageDialog(this, "Contrasena incorrecta");
	}

	@Override
	public void entrar() {
		// TODO Auto-generated method stub

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
	public void limpiaCampos() {
		this.usernameField.setText("");
		this.passwordField.setText("");
		this.username = null;
		this.contrasena = null;
	}
}
