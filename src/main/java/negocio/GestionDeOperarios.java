package negocio;

import excepciones.MozoNoExistenteException;
import excepciones.OperarioExistenteException;
import excepciones.OperarioNoExistenteException;
import excepciones.PermisoDenegadoException;
import modelo.Empresa;
import modelo.Mozo;
import modelo.Operario;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class GestionDeOperarios {

    private final Empresa empresa;
    private static GestionDeOperarios gestionDeOperarios = null;

    private GestionDeOperarios() {
        this.empresa = Empresa.getEmpresa();
    }

    public static GestionDeOperarios get() {
        if( gestionDeOperarios == null )
            gestionDeOperarios = new GestionDeOperarios();
        return gestionDeOperarios;
    }

    public void persistirOperarios(){
        IPersistencia<Set<Operario>> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("operarios.xml");
            persistencia.escribir(this.empresa.getOperarios());
            persistencia.cerrarOutput();
        } catch (IOException e) {

        }
    }

    public void altaOperario(Operario operario) throws OperarioExistenteException, PermisoDenegadoException {
        if (this.empresa.getUsuarioLogueado().getUsername().equals("admin")){
            Set<Operario> operarios = this.empresa.getOperarios();

            Iterator<Operario> it = operarios.iterator();
            boolean encontreOperario = false;
            Operario op;

            while(it.hasNext() && !encontreOperario) {
                op = it.next();
                if(op.getNombreCompleto().equals(operario.getNombreCompleto())){
                    encontreOperario = true;
                }
            }
            if(!encontreOperario){
                operarios.add(operario);
                this.empresa.setOperarios(operarios);
                persistirOperarios();
            } else
                throw new OperarioExistenteException();
        }else
            throw new PermisoDenegadoException();
    }


    public void modificarOperario(Operario operario) throws OperarioNoExistenteException, PermisoDenegadoException {
        if (this.empresa.getUsuarioLogueado().getUsername().equals("admin")){
            Set<Operario> operarios = this.empresa.getOperarios();
            Iterator<Operario> it = operarios.iterator();

            boolean encontreOperario = false;
            Operario op = null;

            while(it.hasNext() && !encontreOperario) {
                op = it.next();
                if(op.getNombreCompleto().equals(operario.getNombreCompleto())){
                    encontreOperario = true;
                }
            }
            if(encontreOperario) {
                operarios.remove(op);
                operarios.add(operario);
                this.empresa.setOperarios(operarios);
                persistirOperarios();
            }else
                throw new OperarioNoExistenteException();
        }else
            throw new PermisoDenegadoException();
    }

    public void bajaOperario(String nombre) throws OperarioNoExistenteException, PermisoDenegadoException {
        if (this.empresa.getUsuarioLogueado().getUsername().equals("admin")){
            Set<Operario> operarios = this.empresa.getOperarios();
            Iterator<Operario> it = operarios.iterator();

            boolean encontreOperario = false;
            Operario op = null;

            while(it.hasNext() && !encontreOperario) {
                op = it.next();
                if(op.getNombreCompleto().equals(nombre)){
                    encontreOperario = true;
                }
            }
            if(encontreOperario){
                operarios.remove(op);
                this.empresa.setOperarios(operarios);
                persistirOperarios();
            }else
                throw new OperarioNoExistenteException();
        }else
            throw new PermisoDenegadoException();
    }

    public Set<Operario> getOperarios(){
        return this.empresa.getOperarios();
    }

}
