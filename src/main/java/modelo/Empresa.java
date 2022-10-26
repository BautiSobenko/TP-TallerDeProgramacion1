package modelo;

import Exceptions.*;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class Empresa {

    private static Empresa empresa = null;
    private String nombre;
    private Set<Mozo> mozos;
    private Set<Mesa> mesas;
    private Set<Producto> productos;
    private Set<Operario> operarios;
    //private Sueldo sueldo; ?

    private Operario usuarioLogueado;

    private double sueldoBasico =


    public static Empresa getEmpresa() {
        if (empresa == null) {
            empresa = new Empresa();
        }
        return empresa;
    }

    private Empresa() {
        cargarMesas();
        cargarMozos();
        cargarProductos();
        cargarOperarios();
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

    private void altaOperario(Operario operario) throws operarioExistenteException {
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
            throw new operarioExistenteException();
    }

    private void modificarOperario(Operario operario) throws operarioNoExistenteException {

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
            throw new operarioNoExistenteException();
    }

    private void bajaOperario(String nombre) throws operarioNoExistenteException {

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
            throw new operarioNoExistenteException();
    }

    private void altaProducto(Producto producto) throws productoExistenteException {
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
            throw new productoExistenteException();
    }

    private void modificaProducto(Producto producto) throws productoNoExistenteException {
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
            throw new productoNoExistenteException();
    }

    private void bajaProducto(String id) throws productoNoExistenteException {
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
            throw new productoNoExistenteException();
    }

    private void altaMesa(Mesa mesa) throws mesaExistenteException {
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
            throw new mesaExistenteException();
    }

    private void modificaMesa(Mesa mesa) throws mesaNoExistenteException {
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
            throw new mesaNoExistenteException();
    }

    private void bajaMesa(int nroMesa) throws mesaNoExistenteException {
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
            throw new mesaNoExistenteException();
    }

    private Mozo mayorVolumenVentaMozo(){
        Iterator<Mozo> it = mozos.iterator();
        Mozo m, mayor;
        double max = 0;

        while(it.hasNext()){
            m = it.next();
            if(m.getVentas()>max){
                mayor = m;
                max = m.getVentas();
            }
        }
        return mayor;
    }

    private Mozo menorVolumenVentaMozo(){
        Iterator<Mozo> it = mozos.iterator();
        Mozo m, menor;
        double min = 9999999;

        while(it.hasNext()){
            m = it.next();
            if(m.getVentas()<min){
                menor = m;
                min = m.getVentas();
            }
        }
        return menor;
    }

    private float consumoPromedioMesa(int nroMesa) throws mesaNoExistenteException{
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
            return m.getVentas / m.getCantCierres();
        else
            throw new mesaNoExistenteException();

    }

    private double calculaSueldo(String id) throws MozoNoExistenteException{

        Iterator<Mozo> it = mozos.iterator();
        boolean sale = false;
        Mozo mo;

        while(it.hasNext() && !sale) {
            mo = it.next();
            if(mo.getId() == id){
                sale = true;
            }
        }
        if(sale)
            return this.sueldoBasico * (1 + 0.05 * mo.getCantidadHijos());
        else
            throw new MozoNoExistenteException();
    }
}
