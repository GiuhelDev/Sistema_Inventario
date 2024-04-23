/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class detalleSalida {
    
int idDetalle;
int idSalida;
int idEntrada;
int cantidad;
double importe;

    public detalleSalida() {
    }

    public detalleSalida(int idDetalle, int idSalida, int idEntrada, int cantidad, double importe) {
        this.idDetalle = idDetalle;
        this.idSalida = idSalida;
        this.idEntrada = idEntrada;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }


}
