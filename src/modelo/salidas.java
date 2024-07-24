
package modelo;
import java.sql.Date;

public class salidas {

int idSalida;
String numSalida;
int idCliente;
Date fecha;
double subtotal;
double igv;
double total;
String estado;


    public salidas() {
    }

    public salidas(int idSalida, String numSalida, int idCliente, Date fecha, double subtotal, double igv, double total,String estado) {
        this.idSalida = idSalida;
        this.numSalida = numSalida;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.estado=estado;
    }

    public String getNumSalida() {
        return numSalida;
    }

    public void setNumSalida(String numSalida) {
        this.numSalida = numSalida;
    }

    
    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
