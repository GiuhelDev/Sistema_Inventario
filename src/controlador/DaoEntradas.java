/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.conexion;
import modelo.entradas;

public class DaoEntradas {
    
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(entradas c){
        String SQL="insert into entrada (idproducto,stock,fecha,idproveedor,precioE,precioV,total) VALUES (?,?,?,?,?,?,?)";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, c.getIdproducto());
            ps.setInt(2, c.getStock());
            ps.setDate(3, c.getFecha());
            ps.setInt(4, c.getIdproveedor());
            ps.setDouble(5, c.getPrecioE());
            ps.setDouble(6, c.getPrecioV());
            ps.setDouble(7, c.getTotal());
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

    public List Listar(){
        List<entradas> lista=new ArrayList<>();
        String SQL="select * from entrada";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
                entradas c=new entradas();
                c.setIdentrada(rs.getInt(1));
                c.setIdproducto(rs.getInt(2));
                c.setStock(rs.getInt(3));
                c.setFecha(rs.getDate(4));
                c.setIdproveedor(rs.getInt(5));
                c.setPrecioE(rs.getDouble(6));
                c.setPrecioV(rs.getDouble(7));
                c.setTotal(rs.getDouble(8));
                lista.add(c);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return lista;
    }


    public boolean editar(entradas c){
        String SQL="update entrada set idproducto=?,stock=?,fecha=?,idproveedor=?,precioE=?,precioV=?,total=? where identrada=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, c.getIdproducto());
            ps.setInt(2, c.getStock());
            ps.setDate(3, c.getFecha());
            ps.setInt(4, c.getIdproveedor());
            ps.setDouble(5, c.getPrecioE());
            ps.setDouble(6, c.getPrecioV());
            ps.setDouble(7, c.getTotal());
            ps.setInt(8, c.getIdentrada());
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

    public boolean eliminar(entradas c){
        String SQL="delete from entrada where identrada=?";
         try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, c.getIdentrada());
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

public boolean buscar(entradas c){
        String SQL="select * from entrada where identrada=?";
         try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, c.getIdentrada());
            rs=ps.executeQuery();
            if(rs.next()){
                c.setIdentrada(rs.getInt(1));
                c.setIdproducto(rs.getInt(2));
                c.setStock(rs.getInt(3));
                c.setFecha(rs.getDate(4));
                c.setIdproveedor(rs.getInt(5));
                c.setPrecioE(rs.getDouble(6));
                c.setPrecioV(rs.getDouble(7));
                c.setTotal(rs.getDouble(8));
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public int cantEntradas(){
        String SQL="SELECT COUNT(identrada) FROM entrada";
        int cant = 0;
         try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            if(rs.next()){
               cant=rs.getInt(1);
            }else{
               cant=0; 
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            
        }
        return cant;
    }

    public double TotalEntradas(int mes,int año){
        String SQL="Select sum(total) from entrada WHERE MONTH(fecha)="+mes+" and YEAR(fecha) = "+año;
        double total = 0;
         try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            if(rs.next()){
               total=rs.getDouble(1);
            }else{
               total=0; 
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            
        }
        return total;
    }
}
