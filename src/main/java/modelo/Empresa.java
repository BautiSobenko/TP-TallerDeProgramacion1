package modelo;

import persistencia.IPersistencia;
import persistencia.PersistenciaXML;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Empresa {

    private static Empresa empresa = null;
    private String nombre;
    private Set<Mozo> mozos;
    private Set<Mesa> mesas;
    private Set<Producto> productos;
    private Set<Operario> operarios;
    //private Sueldo sueldo; ?

    private Operario usuarioLogueado;


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

    private void altaOperario(Operario operario){

    }
}
