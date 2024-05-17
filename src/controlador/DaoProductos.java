
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.conexion;
import modelo.productos;

public class DaoProductos {

    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(productos c){
        String SQL="insert into productos (idproducto,nombre,stock,idCategoria,idproveedor,precioV) VALUES (?,?,?,?,?,?)";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, c.getIdProducto());
            ps.setString(2, c.getNomProd());
            ps.setInt(3, c.getStock());
            ps.setInt(4, c.getIdCategoria());
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

public List Listar(){
        List<productos> lista=new ArrayList<>();
        String SQL="select * from productos";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
                productos c=new productos();
                c.setIDProducto(rs.getInt(1));
                c.setNomProd(rs.getString(2));
                c.setStock(rs.getInt(3));
                c.setIdCategoria(rs.getInt(4));
                c.setIdproveedor(rs.getInt(5));
                c.setPrecioV(rs.getDouble(6));
                lista.add(c);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return lista;
    }
    

 public int numProducto(){
        int numero=0;
        String SQL="select max(idproducto) from productos";
         try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
            numero=rs.getInt(1);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return numero;
    }
}
