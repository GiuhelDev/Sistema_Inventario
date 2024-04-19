
package modelo;
import java.sql.Date;

public class salidas {

int idSalida;
int idEntrada;
int cantidad;
int idCliente;
Date fecha;
double subtotal;
double igv;
double total;

    public salidas() {
    }

    public salidas(int idSalida, int idEntrada, int cantidad, int idCliente, Date feca, double dubtotal, double igv, double total) {
        this.idSalida = idSalida;
        this.idEntrada = idEntrada;
        this.cantidad = cantidad;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.subtotal = dubtotal;
        this.igv = igv;
        this.total = total;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double dubtotal) {
        this.subtotal = dubtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}
