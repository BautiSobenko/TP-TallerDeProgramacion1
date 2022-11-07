package vistas;

import modelo.Mesa;
import modelo.Operario;

import javax.swing.*;

public interface IVistaGestion<E> extends IGenerica{
	
	public void setModel(DefaultListModel<E> lista);

	public Object getSeleccion();

}
