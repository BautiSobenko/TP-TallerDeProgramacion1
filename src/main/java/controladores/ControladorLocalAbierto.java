package controladores;

import enums.EstadoMesa;
import excepciones.MesaNoExistenteException;
import modelo.Empresa;
import modelo.Mesa;
import negocio.GestionDeMesas;
import negocio.GestionDeMozos;
import vistas.VistaAltaMesa;
import vistas.VistaLocalAbierto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;

public class ControladorLocalAbierto implements ActionListener {

    private static ControladorLocalAbierto controladorLocalAbierto = null;
    private final GestionDeMozos gestionDeMozos;

    private final GestionDeMesas gestionDeMesas;
    private final VistaLocalAbierto vistaLocalAbierto;

    private ControladorLocalAbierto() {
        this.vistaLocalAbierto = new VistaLocalAbierto();
        this.vistaLocalAbierto.setActionListener(this);
        this.gestionDeMesas = GestionDeMesas.get();
        this.gestionDeMozos = GestionDeMozos.get();
    }

    public static ControladorLocalAbierto getControladorLocalAbierto() {
        if (controladorLocalAbierto == null) {
            controladorLocalAbierto = new ControladorLocalAbierto();
        }
        controladorLocalAbierto.vistaLocalAbierto.mostrar();

        return controladorLocalAbierto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if(comando.equalsIgnoreCase("Consumo promedio por mesa")){
            Set<Mesa> mesas = gestionDeMesas.getMesas();
            Iterator<Mesa> it = mesas.iterator();
            String txt ="";
            while (it.hasNext()){
                try {
                    txt+= "La mesa Nro"+ it.next().getNroMesa() + " tiene un  consumo promedio de " + gestionDeMesas.calculaConsumoPromedio(it.next().getNroMesa())+"\n";
                } catch (MesaNoExistenteException ex) {
                    throw new RuntimeException(ex);
                }
            }
            JOptionPane.showMessageDialog(null, txt, "Consumo promedio por mesa", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(comando.equalsIgnoreCase("Mozo con menos ventas")){
            this.vistaLocalAbierto.success("El moso con menos ventas es "+this.gestionDeMozos.mozoMinVentas());
        }
        else if(comando.equalsIgnoreCase("Mozo con mas Ventas")){
            this.vistaLocalAbierto.success("El moso con mas ventas es "+this.gestionDeMozos.mozoMaxVentas());
        }
        else if(comando.equalsIgnoreCase("Cerrar Mesa")){
            this.vistaLocalAbierto.getMesaCierre().setEstadoMesa(EstadoMesa.LIBRE);
        }
        else if(comando.equalsIgnoreCase("Cargar Pedido")){

        }
        else if(comando.equalsIgnoreCase("Abrir Mesa")){
            this.vistaLocalAbierto.getMesaApertura().setEstadoMesa(EstadoMesa.OCUPADA);
        }
        else if(comando.equalsIgnoreCase("Cerrar Local")){
            this.vistaLocalAbierto.esconder();
            ControladorInicio controladorInicio = ControladorInicio.getControladorInicio(true);
        }

    }
}
