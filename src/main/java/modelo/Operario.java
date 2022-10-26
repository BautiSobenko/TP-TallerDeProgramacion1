package modelo;

import enums.EstadoMozo;
import exceptions.CierreMesaConEstadoLibreException;
import exceptions.MesaNoExistenteException;
import exceptions.MozoExistenteException;
import exceptions.MozoNoExistenteException;

import java.util.Iterator;

public class Operario {

    private String nombreCompleto;
    private String username;
    private String password;
    private Boolean activo;

    public Operario(String nombreCompleto, String username, String password) {
        this.nombreCompleto = nombreCompleto;
        this.username = username;
        this.password = password;
        this.activo = true;
    }

    public static Operario admin() {
        return new Operario("admin", "admin", "admin1234");
    }


    public void altaMozo(Mozo mozo) throws MozoExistenteException {

        try {

            Empresa.getEmpresa().addMozo(mozo);

        }catch(MozoExistenteException exc){
            throw exc;
        }

    }

    public void modificarMozo(Mozo mozo) throws MozoNoExistenteException {

        try {

            Empresa.getEmpresa().modMozo(mozo);

        }catch(MozoNoExistenteException exc){
            throw exc;
        }

    }

    public void bajaMozo(Mozo mozo) throws MozoNoExistenteException {

        try {

            Empresa.getEmpresa().modMozo(mozo);

        }catch(MozoNoExistenteException exc){
            throw exc;
        }

    }

    public void modEstadoMozo(Mozo mozo, EstadoMozo nuevoEstado) throws MozoNoExistenteException {

        try {

            Empresa.getEmpresa().modEstadoMozo(mozo, nuevoEstado);

        } catch (MozoNoExistenteException exc) {
            throw exc;
        }

    }

    public void cierreMesa(Mesa mesa) throws MesaNoExistenteException, CierreMesaConEstadoLibreException {

        try {

            Empresa.getEmpresa().cerrarMesa(mesa);

        }catch (MesaNoExistenteException exc) {
            throw exc;
        } catch (CierreMesaConEstadoLibreException exc) {
            throw exc;
        }

    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }



}
