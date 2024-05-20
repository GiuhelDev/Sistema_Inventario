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
        String SQL="insert into entrada (idproducto,stock,idCategoria,fecha,idproveedor,precioE,precioV,total) VALUES (?,?,?,?,?,?,?,?)";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, c.getIdproducto());
            ps.setInt(2, c.getStock());
            ps.setInt(3, c.getIdCategoria());
            ps.setDate(4, c.getFecha());
            ps.setInt(5, c.getIdproveedor());
            ps.setDouble(6, c.getPrecioE());
            ps.setDouble(7, c.getPrecioV());
            ps.setDouble(8, c.getTotal());
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
                c.setIdCategoria(rs.getInt(4));
                c.setFecha(rs.getDate(5));
                c.setIdproveedor(rs.getInt(6));
                c.setPrecioE(rs.getDouble(7));
                c.setPrecioV(rs.getDouble(8));
                c.setTotal(rs.getDouble(9));
                lista.add(c);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return lista;
    }


    public boolean editar(entradas c){
        String SQL="update entrada set idproducto=?,stock=?,idCategoria=?,fecha=?,idproveedor=?,precioE=?,precioV=?,total=? where identrada=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, c.getIdproducto());
            ps.setInt(2, c.getStock());
            ps.setInt(3, c.getIdCategoria());
            ps.setDate(4, c.getFecha());
            ps.setInt(5, c.getIdproveedor());
            ps.setDouble(6, c.getPrecioE());
            ps.setDouble(7, c.getPrecioV());
            ps.setDouble(8, c.getTotal());
            ps.setInt(9, c.getIdentrada());
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
                c.setIdCategoria(rs.getInt(4));
                c.setFecha(rs.getDate(5));
                c.setIdproveedor(rs.getInt(6));
                c.setPrecioE(rs.getDouble(7));
                c.setPrecioV(rs.getDouble(8));
                c.setTotal(rs.getDouble(9));
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
