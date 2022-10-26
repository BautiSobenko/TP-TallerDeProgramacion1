package modelo;

import enums.EstadoMozo;

import java.util.Date;
import java.util.UUID;

public class Mozo {

    private String nombreCompleto;
    private Date fechaNacimiento;
    private int cantidadHijos;
    private EstadoMozo estadoMozo;
    private String id;

    private double ventas;

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    public Mozo(String nombreCompleto, Date fechaNacimiento, int cantidadHijos) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.cantidadHijos = cantidadHijos;
        this.estadoMozo = EstadoMozo.ACTIVO;
        this.id = UUID.randomUUID().toString();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCantidadHijos() {
        return cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }

    public EstadoMozo getEstadoMozo() {
        return estadoMozo;
    }

    public void setEstadoMozo(EstadoMozo estadoMozo) {
        this.estadoMozo = estadoMozo;
    }

    public String getId() {
        return id;
    }
}
