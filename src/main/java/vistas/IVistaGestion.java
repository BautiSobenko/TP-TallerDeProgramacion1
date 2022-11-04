package vistas;

import modelo.Operario;

import javax.swing.*;

public interface IVistaGestion extends IGenerica{
	
	public void setModel(DefaultListModel<Operario> lista);

	public Object getSeleccion();

}
