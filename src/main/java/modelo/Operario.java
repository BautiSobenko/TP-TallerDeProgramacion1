package modelo;

import dto.MozoDTO;
import enums.EstadoMozo;
import excepciones.*;
import negocio.GestionDeMozos;
import negocio.GestionDeMesas;

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


    public void altaMozo(MozoDTO mozo) throws MozoExistenteException, PermisoDenegadoException {

        GestionDeMozos.get().altaMozo(mozo);

    }

    public void modificarMozo(MozoDTO mozo) throws MozoNoExistenteException, PermisoDenegadoException {

        GestionDeMozos.get().modificarMozo(mozo);

    }

    public void bajaMozo(Mozo mozo) throws MozoNoExistenteException, PermisoDenegadoException {

        GestionDeMozos.get().bajaMozo(mozo);

    }

    public void modEstadoMozo(Mozo mozo, EstadoMozo nuevoEstado) throws MozoNoExistenteException {

        GestionDeMozos.get().modEstadoMozo(mozo, nuevoEstado);

    }

    public double cierreMesa(Mesa mesa) throws MesaNoExistenteException, CierreMesaConEstadoLibreException {

        return GestionDeMesas.get().cerrarMesa(mesa);

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

    public boolean validaContrasena(String contrasena) throws ContrasenaIncorrectaException {
        boolean ingreso = false;
        if (contrasena.equals(this.password))
            ingreso = true;
        else {
            throw new ContrasenaIncorrectaException(contrasena, "contrasena incorrecta");
        }
        return ingreso;
    }



}
