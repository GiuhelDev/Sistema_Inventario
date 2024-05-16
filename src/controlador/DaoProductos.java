/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.conexion;
import modelo.productos;

public class DaoProductos {

    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(productos c){
        String SQL="insert into productos (nombre,stock,idCategoria,fecha,idproveedor,precioV) VALUES (?,?,?,?,?,?)";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, c.getNomProd());
            ps.setInt(2, c.getStock());
            ps.setInt(3, c.getIdCategoria());
            ps.setDate(4, c.getFecha());
            ps.setInt(5, c.getIdproveedor());
            ps.setDouble(6, c.getPrecioV());
            int n=ps.executeUpdate();
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
}
