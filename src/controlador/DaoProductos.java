
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
        String SQL="insert into productos (idproducto,nombre,stock,idCategoria,precioV) VALUES (?,?,?,?,?)";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, c.getIdproducto());
            ps.setString(2, c.getNomProd());
            ps.setInt(3, c.getStock());
            ps.setInt(4, c.getIdCategoria());
            ps.setDouble(5, c.getPrecioV());
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
                c.setIdproducto(rs.getInt(1));
                c.setNomProd(rs.getString(2));
                c.setStock(rs.getInt(3));
                c.setIdCategoria(rs.getInt(4));
                c.setPrecioV(rs.getDouble(5));
                lista.add(c);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return lista;
    }

   
    public boolean buscar(productos c){
        String SQL="select * from productos where idproducto=?";
         try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, c.getIdproducto());
            rs=ps.executeQuery();
            if(rs.next()){
                c.setIdproducto(rs.getInt(1));
                c.setNomProd(rs.getString(2));
                c.setStock(rs.getInt(3));
                c.setIdCategoria(rs.getInt(4));
                c.setPrecioV(rs.getDouble(5));
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(productos c){
        String SQL="update productos set nombre=?,stock=?,idCategoria=?,precioV=? where idproducto=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, c.getNomProd());
            ps.setInt(2, c.getStock());
            ps.setInt(3, c.getIdCategoria());
            ps.setDouble(4, c.getPrecioV());
            ps.setDouble(5, c.getIdproducto());
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

    public boolean editarPrecioV(productos c){
        String SQL="update productos set precioV=? where idproducto=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setDouble(1, c.getPrecioV());
            ps.setDouble(2, c.getIdproducto());
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

    public boolean sumarStock(int idproducto,int cant){
            String SQL="UPDATE productos set stock=stock+"+cant+" WHERE idproducto="+idproducto;
            try{
                con=cn.conectar();
                ps=con.prepareStatement(SQL);
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

    public boolean restarStock(int idp,int cant){
        String SQL="UPDATE productos set stock=stock-"+cant+" WHERE idproducto="+idp;
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
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

    public boolean eliminar(productos c){
        String SQL="delete from productos where idproducto=?";
         try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, c.getIdproducto());
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

    public List ProdFrecuentes(){
        List<productos> lista=new ArrayList<>();
        String SQL="SELECT sum(ds.cantidad)as cant,p.nombre from detallesalida ds INNER JOIN\n" +
                    "productos p on ds.idproducto=p.idproducto group by ds.idproducto order by cant DESC  limit 3";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
                productos c=new productos();
                c.setCantF(rs.getInt(1));
                c.setNomProd(rs.getString(2));
                lista.add(c);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return lista;
    }
}
