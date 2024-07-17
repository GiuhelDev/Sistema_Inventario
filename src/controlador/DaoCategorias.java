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
import modelo.Categoria;
import modelo.conexion;

public class DaoCategorias {
    
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(Categoria c){
        String SQL="insert into categorias (catergoria) VALUES (?)";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, c.getNomCategoria());
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
        List<Categoria> lista=new ArrayList<>();
        String SQL="select * from categorias";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
                Categoria c=new Categoria();
                c.setIdCategoria(rs.getInt(1));
                c.setNomCategoria(rs.getString(2));
                lista.add(c);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return lista;
    }
    
    public boolean editar(Categoria c){
        String SQL="update categorias set catergoria=? where idCategoria=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, c.getNomCategoria());
            ps.setInt(2, c.getIdCategoria());
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
    
    public boolean eliminar(Categoria c){
        String SQL="delete from categorias where idCategoria=?";
         try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, c.getIdCategoria());
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
    
    public boolean buscar(Categoria c){
        String SQL="select * from categorias where idCategoria=?";
         try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, c.getIdCategoria());
            rs=ps.executeQuery();
            if(rs.next()){
                c.setIdCategoria(rs.getInt(1));
                c.setNomCategoria(rs.getString(2));
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public int cantCategorias(){
        String SQL="SELECT count(idCategoria) FROM categorias";
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
}
