package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

public class VistaAltaPromocionProducto extends JFrame implements MouseListener,KeyListener{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDesc;
	private JCheckBox chckbxLunes,chckbxMartes,chckbxMiercoles,chckbxJueves,chckbxViernes,chckbxSabado,chckbxDomingo;
	private JCheckBox chckbx2x1,chckbxDesc;
	private JButton btnFinalizar,btnVolver;

	JComboBox comboBox;

	private ButtonGroup tipoDesc;
	private String nombre;
	float porcentajeDesc=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaPromocionProducto frame = new VistaAltaPromocionProducto();
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
	public VistaAltaPromocionProducto() {
		setTitle("Promocion por Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de la Promocion:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 26, 189, 38);
		contentPane.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(220, 26, 221, 38);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Elija el producto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 100, 120, 26);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(220, 94, 221, 38);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Elija el/los dias:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 183, 120, 26);
		contentPane.add(lblNewLabel_2);
		
		chckbxLunes = new JCheckBox("Lunes");
		chckbxLunes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxLunes.setBounds(160, 168, 99, 23);
		contentPane.add(chckbxLunes);
		
		chckbxMartes = new JCheckBox("Martes");
		chckbxMartes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxMartes.setBounds(160, 213, 99, 23);
		contentPane.add(chckbxMartes);
		
		chckbxMiercoles = new JCheckBox("Miercoles");
		chckbxMiercoles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxMiercoles.setBounds(278, 168, 99, 23);
		contentPane.add(chckbxMiercoles);
		
		chckbxJueves = new JCheckBox("Jueves");
		chckbxJueves.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxJueves.setBounds(278, 213, 99, 23);
		contentPane.add(chckbxJueves);
		
		chckbxViernes = new JCheckBox("Viernes");
		chckbxViernes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxViernes.setBounds(391, 168, 99, 23);
		contentPane.add(chckbxViernes);
		
		chckbxSabado = new JCheckBox("Sabado");
		chckbxSabado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxSabado.setBounds(391, 213, 99, 23);
		contentPane.add(chckbxSabado);
		
		chckbxDomingo = new JCheckBox("Domingo");
		chckbxDomingo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxDomingo.setBounds(502, 183, 99, 23);
		contentPane.add(chckbxDomingo);
		
		chckbx2x1 = new JCheckBox("Aplica 2x1");
		chckbx2x1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbx2x1.setBounds(49, 282, 99, 23);
		contentPane.add(chckbx2x1);
		
		chckbxDesc = new JCheckBox("Aplica Descuento:");
		chckbxDesc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxDesc.setBounds(198, 284, 157, 23);
		contentPane.add(chckbxDesc);
		
		txtDesc = new JTextField();
		txtDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDesc.setColumns(10);
		txtDesc.setBounds(361, 279, 198, 26);
		contentPane.add(txtDesc);

		tipoDesc.add(chckbxDesc);
		tipoDesc.add(chckbx2x1);
		chckbxDesc.addMouseListener(this);
		chckbx2x1.addMouseListener(this);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVolver.setBounds(10, 337, 107, 33);
		contentPane.add(btnVolver);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFinalizar.setBounds(490, 337, 107, 33);
		contentPane.add(btnFinalizar);
	}

	public void setActionListener(ActionListener actionListener){
		btnFinalizar.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
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
		// TODO Auto-generated method stub
		this.nombre = this.txtNombre.getText();
		if (chckbx2x1.isSelected()) {
			this.btnFinalizar.setEnabled(
					this.comboBox.getSelectedItem() != null
							&&
							(this.chckbxLunes.isSelected() ||
									this.chckbxMartes.isSelected() ||
									this.chckbxMiercoles.isSelected() ||
									this.chckbxJueves.isSelected() ||
									this.chckbxViernes.isSelected() ||
									this.chckbxSabado.isSelected() ||
									this.chckbxDomingo.isSelected())
							&& this.nombre.length() > 0);
		} else if (chckbxDesc.isSelected()) {
			try {
				this.porcentajeDesc = Float.parseFloat(this.txtDesc.getText());
				this.btnFinalizar.setEnabled(
						this.comboBox.getSelectedItem() != null
								&&
								(this.chckbxLunes.isSelected() ||
										this.chckbxMartes.isSelected() ||
										this.chckbxMiercoles.isSelected() ||
										this.chckbxJueves.isSelected() ||
										this.chckbxViernes.isSelected() ||
										this.chckbxSabado.isSelected() ||
										this.chckbxDomingo.isSelected())
								&& this.nombre.length() > 0
								&& this.porcentajeDesc > 0);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Ingreso de manera erronea el descuento", "Error", JOptionPane.ERROR_MESSAGE);
				this.txtDesc.setText("");
			}
		}
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
			this.nombre = this.txtNombre.getText();
			if (chckbx2x1.isSelected()) {
				this.btnFinalizar.setEnabled(
						this.comboBox.getSelectedItem() != null
								&&
								(this.chckbxLunes.isSelected() ||
										this.chckbxMartes.isSelected() ||
										this.chckbxMiercoles.isSelected() ||
										this.chckbxJueves.isSelected() ||
										this.chckbxViernes.isSelected() ||
										this.chckbxSabado.isSelected() ||
										this.chckbxDomingo.isSelected())
								&& this.nombre.length() > 0);
			} else if (chckbxDesc.isSelected()) {
				try {
					this.porcentajeDesc = Float.parseFloat(this.txtDesc.getText());
					this.btnFinalizar.setEnabled(
							this.comboBox.getSelectedItem() != null
									&&
									(this.chckbxLunes.isSelected() ||
											this.chckbxMartes.isSelected() ||
											this.chckbxMiercoles.isSelected() ||
											this.chckbxJueves.isSelected() ||
											this.chckbxViernes.isSelected() ||
											this.chckbxSabado.isSelected() ||
											this.chckbxDomingo.isSelected())
									&& this.nombre.length() > 0
									&& this.porcentajeDesc > 0);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Ingreso de manera erronea el descuento", "Error", JOptionPane.ERROR_MESSAGE);
					this.txtDesc.setText("");
				}
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
	
	public void mostrar() {
		this.setVisible(true);
	}
	
	public void esconder() {
		this.setVisible(false);
		limpiaCampos();
	}
	
	public void limpiaCampos() {
		this.txtNombre.setText("");
		this.txtDesc.setText("");
		chckbx2x1.setSelected(false);
		chckbxDesc.setSelected(false);
		chckbxLunes.setSelected(false);
		chckbxMartes.setSelected(false);
		chckbxMiercoles.setSelected(false);
		chckbxJueves.setSelected(false);
		chckbxViernes.setSelected(false);
		chckbxSabado.setSelected(false);
		chckbxDomingo.setSelected(false);
	}
	
	public void success(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Resultado exitoso", JOptionPane.INFORMATION_MESSAGE);
	}

	public void failure(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public JCheckBox getChckbxLunes() {
		return chckbxLunes;
	}

	public void setChckbxLunes(JCheckBox chckbxLunes) {
		this.chckbxLunes = chckbxLunes;
	}

	public JCheckBox getChckbxMartes() {
		return chckbxMartes;
	}

	public void setChckbxMartes(JCheckBox chckbxMartes) {
		this.chckbxMartes = chckbxMartes;
	}

	public JCheckBox getChckbxMiercoles() {
		return chckbxMiercoles;
	}

	public void setChckbxMiercoles(JCheckBox chckbxMiercoles) {
		this.chckbxMiercoles = chckbxMiercoles;
	}

	public JCheckBox getChckbxJueves() {
		return chckbxJueves;
	}

	public void setChckbxJueves(JCheckBox chckbxJueves) {
		this.chckbxJueves = chckbxJueves;
	}

	public JCheckBox getChckbxViernes() {
		return chckbxViernes;
	}

	public void setChckbxViernes(JCheckBox chckbxViernes) {
		this.chckbxViernes = chckbxViernes;
	}

	public JCheckBox getChckbxSabado() {
		return chckbxSabado;
	}

	public void setChckbxSabado(JCheckBox chckbxSabado) {
		this.chckbxSabado = chckbxSabado;
	}

	public JCheckBox getChckbxDomingo() {
		return chckbxDomingo;
	}

	public void setChckbxDomingo(JCheckBox chckbxDomingo) {
		this.chckbxDomingo = chckbxDomingo;
	}

	public JCheckBox getChckbx2x1() {
		return chckbx2x1;
	}

	public void setChckbx2x1(JCheckBox chckbx2x1) {
		this.chckbx2x1 = chckbx2x1;
	}

	public JCheckBox getChckbxDesc() {
		return chckbxDesc;
	}

	public void setChckbxDesc(JCheckBox chckbxDesc) {
		this.chckbxDesc = chckbxDesc;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public ButtonGroup getTipoDesc() {
		return tipoDesc;
	}

	public void setTipoDesc(ButtonGroup tipoDesc) {
		this.tipoDesc = tipoDesc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPorcentajeDesc() {
		return porcentajeDesc;
	}

	public void setPorcentajeDesc(float porcentajeDesc) {
		this.porcentajeDesc = porcentajeDesc;
	}
}
