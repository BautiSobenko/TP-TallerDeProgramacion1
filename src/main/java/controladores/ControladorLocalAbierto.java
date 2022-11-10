package controladores;

import enums.EstadoMesa;
import excepciones.MesaNoExistenteException;
import modelo.Comanda;
import modelo.Empresa;
import modelo.Mesa;
import modelo.Producto;
import negocio.GestionDeMesas;
import negocio.GestionDeMozos;
import negocio.GestionDeProductos;
import vistas.VistaAltaMesa;
import vistas.VistaLocalAbierto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;

public class ControladorLocalAbierto implements ActionListener {

    private static ControladorLocalAbierto controladorLocalAbierto = null;
    private static GestionDeMozos gestionDeMozos;
    private static GestionDeProductos gestionDeProductos;
    private static  GestionDeMesas gestionDeMesas;
    private static VistaLocalAbierto vistaLocalAbierto;

    private ControladorLocalAbierto() {
        this.vistaLocalAbierto = new VistaLocalAbierto();
        this.vistaLocalAbierto.setActionListener(this);
        this.gestionDeMesas = GestionDeMesas.get();
        this.gestionDeMozos = GestionDeMozos.get();
        this.gestionDeProductos = GestionDeProductos.get();
    }

    public static ControladorLocalAbierto getControladorLocalAbierto() {
        if (controladorLocalAbierto == null) {
            controladorLocalAbierto = new ControladorLocalAbierto();
        }

        //Carga de Combo Boxes
        Set<Mesa> mesas = gestionDeMesas.getMesas();
        JComboBox<Mesa> comboM = vistaLocalAbierto.getComboBoxAbrir();
        comboM.removeAllItems();
        for(Mesa mesa : mesas){
            comboM.addItem(mesa);
        }
        vistaLocalAbierto.setComboBoxAbrir(comboM);

       comboM = vistaLocalAbierto.getComboBoxCerrar();
       comboM.removeAllItems();
        for(Mesa mesa : mesas){
            comboM.addItem(mesa);
        }
        vistaLocalAbierto.setComboBoxCerrar(comboM);

       comboM = vistaLocalAbierto.getComboBoxMesa();
       comboM.removeAllItems();
        for(Mesa mesa : mesas){
            comboM.addItem(mesa);
        }
        vistaLocalAbierto.setComboBoxMesa(comboM);

        Set<Producto> productos = gestionDeProductos.getProductos();
        JComboBox<Producto> comboP = vistaLocalAbierto.getComboBoxProducto();
        comboP.removeAllItems();
        for(Producto prod : productos){
            comboP.addItem(prod);
        }
        vistaLocalAbierto.setComboBoxProducto(comboP);

        int[] intArr = {1,2,3,4,5};
        JComboBox<Integer> comboI = vistaLocalAbierto.getComboBoxCantidad();
        comboI.removeAllItems();
        for(int i : intArr) {
            comboI.addItem(i);
        }
        vistaLocalAbierto.setComboBoxCantidad(comboI);

        vistaLocalAbierto.limpia();

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
                    txt += "La mesa Nro"+ it.next().getNroMesa() + " tiene un  consumo promedio de " + gestionDeMesas.calculaConsumoPromedio(it.next().getNroMesa())+"\n";
                } catch (MesaNoExistenteException ex) {
                    throw new RuntimeException(ex);
                }
            }
            this.vistaLocalAbierto.success(txt);
        }
        else if(comando.equalsIgnoreCase("Mozo con menos ventas")){
            String msg = "El mozo con menos ventas es " + this.gestionDeMozos.mozoMinVentas();
            this.vistaLocalAbierto.success(msg);
        }
        else if(comando.equalsIgnoreCase("Mozo con mas Ventas")){
            String msg = "El mozo con mas ventas es " + this.gestionDeMozos.mozoMaxVentas();
            this.vistaLocalAbierto.success(msg);
        }
        else if(comando.equalsIgnoreCase("Cerrar Mesa")) {
            if (this.vistaLocalAbierto.getMesaApertura().getEstadoMesa() == EstadoMesa.LIBRE) {
                this.vistaLocalAbierto.failure("La mesa nunca fue abierta");
                this.vistaLocalAbierto.limpia();
                ControladorLocalAbierto con = ControladorLocalAbierto.getControladorLocalAbierto();
            } else {
                this.vistaLocalAbierto.getMesaCierre().setEstadoMesa(EstadoMesa.LIBRE);
                this.vistaLocalAbierto.success("Mesa cerrada con exito");
            }
        }
        else if(comando.equalsIgnoreCase("Cargar Pedido")){
                Producto prod = this.vistaLocalAbierto.getProductoElegido();
                Mesa mesa = this.vistaLocalAbierto.getMesaPedido();
                int cantidad= this.vistaLocalAbierto.getCantidad();
        }
        else if(comando.equalsIgnoreCase("Abrir Mesa")){
            if(this.vistaLocalAbierto.getMesaApertura().getEstadoMesa()==EstadoMesa.OCUPADA) {
                this.vistaLocalAbierto.failure("La mesa esta ocupada");
                this.vistaLocalAbierto.limpia();
                ControladorLocalAbierto con = ControladorLocalAbierto.getControladorLocalAbierto();
            }
            else {
                this.vistaLocalAbierto.getMesaApertura().setEstadoMesa(EstadoMesa.OCUPADA);
                this.vistaLocalAbierto.success("Mesa abierta con exito");
            }
        }
        else if(comando.equalsIgnoreCase("Cerrar Local")){
            this.vistaLocalAbierto.esconder();
            ControladorInicio controladorInicio = ControladorInicio.getControladorInicio(true);
        }

    }
}
