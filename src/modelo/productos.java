/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

public class productos {
    
   int idproducto										;
   String nomProd;
   int stock;
   int idCategoria;
   int idproveedor;
   double precioV;

    public productos() {
    }

    public productos(int idproducto, String nomProd, int stock, int idCategoria, int idproveedor, double precioV) {
        this.idproducto = idproducto;
        this.nomProd = nomProd;
        this.stock = stock;
        this.idCategoria = idCategoria;
        this.idproveedor = idproveedor;
        this.precioV = precioV;
    }

    public int getIdProducto() {
        return idproducto;
    }

    public void setIDProducto(int identrada) {
        this.idproducto = identrada;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

   
    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(double precioV) {
        this.precioV = precioV;
    }

   
}
