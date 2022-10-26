package modelo;

import enums.EstadoMesa;
import enums.EstadoMozo;
import excepciones.*;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;

import java.io.IOException;
import java.util.*;

public class Empresa {

    private static Empresa empresa = null;

    private Operario admin;

    private String nombre;
    private Set<Mozo> mozos;
    private Set<Mesa> mesas;
    private Set<Producto> productos;
    private Set<Operario> operarios;
    private double sueldoBasico;

    private Operario usuarioLogueado;

    public static Empresa getEmpresa() {
        if (empresa == null) {
            empresa = new Empresa();
        }
        return empresa;
    }

    private Empresa() { //Terminar de tratar al admin y su logeo
        if(admin.getPassword() == "admin1234") {
            this.admin.setPassword("Hola");

        }
        cargarMesas();
        cargarMozos();
        cargarProductos();
        cargarOperarios();
    }

    public void addMozo(Mozo mozo) throws MozoExistenteException {

        boolean existeMozo = this.mozos.stream().anyMatch(m -> m.getId().equalsIgnoreCase(mozo.getId()) );
        if( !existeMozo )
            throw new MozoExistenteException();
        else
            this.mozos.add(mozo);

    }

    public void modMozo(Mozo mozo) throws MozoNoExistenteException {

        boolean existeMozo = this.mozos.stream().anyMatch(m -> m.getId().equalsIgnoreCase(mozo.getId()) );
        if( !existeMozo )
            throw new MozoNoExistenteException();
        else{
            this.mozos.remove(mozo);
            this.mozos.add(mozo);
        }
    }

    public void bajaMozo(Mozo mozo) throws MozoNoExistenteException {

        boolean existeMozo = this.mozos.stream().anyMatch(m -> m.getId().equalsIgnoreCase(mozo.getId()) );
        if( !existeMozo )
            throw new MozoNoExistenteException();
        else
            this.mozos.remove(mozo);

    }

    public void modEstadoMozo(Mozo mozo, EstadoMozo nuevoEstado) throws MozoNoExistenteException {

        boolean existeMozo = this.mozos.stream().anyMatch(m -> m.getId().equalsIgnoreCase(mozo.getId()) );
        if( !existeMozo )
            throw new MozoNoExistenteException();
        else
            mozo.setEstadoMozo(nuevoEstado);

    }

    public void asignarMozoMesa(Mozo mozo, Mesa mesa) throws MozoNoExistenteException, MesaNoExistenteException {

        boolean existeMozo = this.mozos.stream().anyMatch(m -> m.getId().equalsIgnoreCase(mozo.getId()) );
        boolean existeMesa;

        if( !existeMozo )
            throw new MozoNoExistenteException();
        else{
            existeMesa = this.mesas.stream().anyMatch(m -> m.getNroMesa() == mesa.getNroMesa());
            if( !existeMesa )
                throw new MesaNoExistenteException();
            else
                mesa.setMozoAsignado(mozo);
        }

    }

    public double cerrarMesa(Mesa mesa) throws MesaNoExistenteException, CierreMesaConEstadoLibreException {
        boolean existeMesa = this.mesas.stream().anyMatch(m -> m.getNroMesa() == mesa.getNroMesa());
        if( !existeMesa )
            throw new MesaNoExistenteException();
        else{
            if( mesa.getEstadoMesa() == EstadoMesa.LIBRE ){
                throw new CierreMesaConEstadoLibreException();
            }else{
                List<Pedido> pedidosMesa = mesa.getComanda().getPedidos();
                double totalMesa = pedidosMesa.stream()
                        .mapToDouble(p -> p.getProducto().getPrecio())
                        .sum();
                return totalMesa;

            }
        }
    }

    public void login(String username, String password){

    }

    private void cargarOperarios() {
        IPersistencia<Set<Operario>> persistencia = new PersistenciaXML();

        try { // Archivo XML "Operarios" -> Empresa
            persistencia.abrirInput("operarios.xml");
            this.operarios = persistencia.leer();
            if (operarios == null) {
                operarios = new HashSet<>();
                operarios.add(Operario.admin()); //cargar admin por default
                persistencia.escribir(operarios);
            }
            persistencia.cerrarInput();

        } catch (Exception err) {
            this.operarios = new HashSet<>();
            operarios.add(Operario.admin());
            try {
                persistencia.escribir(operarios);
            } catch (IOException ignored){}

        }
    }

    private void cargarProductos() {
        IPersistencia<Set<Producto>> persistencia = new PersistenciaXML();

        try { // Archivo XML "Productos" -> Empresa
            persistencia.abrirInput("productos.xml");
            this.productos = persistencia.leer();
            if (productos == null) {
                productos = new HashSet<>();
            }
            persistencia.cerrarInput();
        } catch (Exception err) {
            this.productos = new HashSet<>();
        }
    }

    private void cargarMesas() {
        IPersistencia<Set<Mesa>> persistencia = new PersistenciaXML();

        try { // Archivo XML "Mesas" -> Empresa
            persistencia.abrirInput("mesas.xml");
            this.mesas = persistencia.leer();
            if (mesas == null) {
                mesas = new HashSet<>();
            }
            persistencia.cerrarInput();
        } catch (Exception err) {
            this.mesas = new HashSet<>();
        }
    }

    private void cargarMozos() {
        IPersistencia<Set<Mozo>> persistencia = new PersistenciaXML();

        try { // Archivo XML "Mozos" -> Empresa
            persistencia.abrirInput("mozos.xml");
            this.mozos = persistencia.leer();
            if (mozos == null) {
                mozos = new HashSet<>();
            }
            persistencia.cerrarInput();
        } catch (Exception err) {
            this.mozos = new HashSet<>();
        }
    }

    private void altaOperario(Operario operario) throws OperarioExistenteException {
        Iterator<Operario> it = operarios.iterator();
        boolean sale = false;
        Operario op;

        while(it.hasNext() && !sale) {
            op = it.next();
            if(op.getNombreCompleto() == operario.getNombreCompleto()){
                sale = true;
            }
        }
        if(!sale)
            this.operarios.add(operario);
        else
            throw new OperarioExistenteException();
    }

    private void modificarOperario(Operario operario) throws OperarioNoExistenteException {

        Iterator<Operario> it = operarios.iterator();
        boolean sale = false;
        Operario op;

        while(it.hasNext() && !sale) {
            op = it.next();
            if(op.getNombreCompleto() == operario.getNombreCompleto()){
                sale = true;
            }
        }
        if(sale) {
            it.remove();
            operarios.add(operario);
        }
        else
            throw new OperarioNoExistenteException();
    }

    private void bajaOperario(String nombre) throws OperarioNoExistenteException {

        Iterator<Operario> it = operarios.iterator();
        boolean sale = false;
        Operario op;

        while(it.hasNext() && !sale) {
            op = it.next();
            if(op.getNombreCompleto() == nombre){
                sale = true;
            }
        }
        if(sale)
            it.remove();
        else
            throw new OperarioNoExistenteException();
    }

    private void altaProducto(Producto producto) throws ProductoExistenteException {
        Iterator<Producto> it = productos.iterator();
        boolean sale = false;
        Producto prod;

        while(it.hasNext() && !sale) {
            prod = it.next();
            if(prod.getId() == producto.getId()){
                sale = true;
            }
        }
        if(!sale)
            this.productos.add(producto);
        else
            throw new ProductoExistenteException();
    }

    private void modificaProducto(Producto producto) throws ProductoNoExistenteException {
        Iterator<Producto> it = productos.iterator();
        boolean sale = false;
        Producto prod;

        while(it.hasNext() && !sale) {
            prod = it.next();
            if(prod.getId() == producto.getId()){
                sale = true;
            }
        }
        if(sale) {
            it.remove();
            this.productos.add(producto);
        }
        else
            throw new ProductoNoExistenteException();
    }

    private void bajaProducto(String id) throws ProductoNoExistenteException {
        Iterator<Producto> it = productos.iterator();
        boolean sale = false;
        Producto prod;

        while(it.hasNext() && !sale) {
            prod = it.next();
            if(prod.getId() == id){
                sale = true;
            }
        }
        if(sale)
            it.remove();
        else
            throw new ProductoNoExistenteException();
    }

    private void altaMesa(Mesa mesa) throws MesaExistenteException {
        Iterator<Mesa> it = mesas.iterator();
        boolean sale = false;
        Mesa m;

        while(it.hasNext() && !sale) {
            m = it.next();
            if(m.getNroMesa() == mesa.getNroMesa()){
                sale = true;
            }
        }
        if(!sale)
            this.mesas.add(mesa);
        else
            throw new MesaExistenteException();
    }

    private void modificaMesa(Mesa mesa) throws MesaNoExistenteException {
        Iterator<Mesa> it = mesas.iterator();
        boolean sale = false;
        Mesa m;

        while(it.hasNext() && !sale) {
            m = it.next();
            if(m.getNroMesa() == mesa.getNroMesa()){
                sale = true;
            }
        }
        if(sale) {
            it.remove();
            this.mesas.add(mesa);
        }
        else
            throw new MesaNoExistenteException();
    }

    private void bajaMesa(int nroMesa) throws MesaNoExistenteException {
        Iterator<Mesa> it = mesas.iterator();
        boolean sale = false;
        Mesa m;

        while(it.hasNext() && !sale) {
            m = it.next();
            if(m.getNroMesa() == nroMesa){
                sale = true;
            }
        }
        if(sale)
            it.remove();
        else
            throw new MesaNoExistenteException();
    }

    private Mozo mayorVolumenVentaMozo(){
        Iterator<Mozo> it = mozos.iterator();
        Mozo mozo=null, mayor=null;
        double max = 0;

        while(it.hasNext()){
            mozo = it.next();
            if(mozo.getVentas()>max){
                mayor = mozo;
                max = mozo.getVentas();
            }
        }
        return mayor;
    }

    private Mozo menorVolumenVentaMozo(){
        Iterator<Mozo> it = mozos.iterator();
        Mozo mozo=null, menor=null;
        double min = 9999999;

        while(it.hasNext()){
            mozo = it.next();
            if(mozo.getVentas()<min){
                menor = mozo;
                min = mozo.getVentas();
            }
        }
        return menor;
    }

    private double consumoPromedioMesa(int nroMesa) throws MesaNoExistenteException{
        Iterator<Mesa> it = mesas.iterator();
        boolean sale = false;
        Mesa mesa=null;

        while(it.hasNext() && !sale) {
            mesa = it.next();
            if(mesa.getNroMesa() == nroMesa){
                sale = true;
            }
        }
        if(sale)
            return mesa.getVentas() / mesa.getCantCuentasCerradas();
        else
            throw new MesaNoExistenteException();

    }

    private double calculaSueldo(String id) throws MozoNoExistenteException{

        Iterator<Mozo> it = mozos.iterator();
        boolean sale = false;
        Mozo mozo=null;

        while(it.hasNext() && !sale) {
            mozo = it.next();
            if(mozo.getId() == id){
                sale = true;
            }
        }
        if(sale)
            return this.sueldoBasico * (1 + 0.05 * mozo.getCantidadHijos());
        else
            throw new MozoNoExistenteException();
    }
}
