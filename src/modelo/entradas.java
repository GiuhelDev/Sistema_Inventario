/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

public class entradas {
    
   int identrada										;
   int idproducto;
   int stock;
   Date fecha;
   int idproveedor;
   double precioE;
   double precioV;
   double total;

    public entradas() {
    }

    public entradas(int identrada, int idproducto, int stock, Date fecha, int idproveedor, double precioE, double precioV, double total) {
        this.identrada = identrada;
        this.idproducto = idproducto;
        this.stock = stock;
        this.fecha = fecha;
        this.idproveedor = idproveedor;
        this.precioE = precioE;
        this.precioV = precioV;
        this.total = total;
    }

   

    public int getIdentrada() {
        return identrada;
    }

    public void setIdentrada(int identrada) {
        this.identrada = identrada;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

   

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

 

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public double getPrecioE() {
        return precioE;
    }

    public void setPrecioE(double precioE) {
        this.precioE = precioE;
    }

    public double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(double precioV) {
        this.precioV = precioV;
    }

    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
   
}
