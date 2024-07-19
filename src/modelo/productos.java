/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class productos {
    
   int idproducto										;
   String nomProd;
   int stock;
   int idCategoria;
   double precioV;
   int cantF;

    public productos() {
    }

    public productos(int idproducto, String nomProd, int stock, int idCategoria, double precioV, int cantF) {
        this.idproducto = idproducto;
        this.nomProd = nomProd;
        this.stock = stock;
        this.idCategoria = idCategoria;
        this.precioV = precioV;
        this.cantF = cantF;
    }

    
    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
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

    public double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(double precioV) {
        this.precioV = precioV;
    }

    public int getCantF() {
        return cantF;
    }

    public void setCantF(int cantF) {
        this.cantF = cantF;
    }

   
}
