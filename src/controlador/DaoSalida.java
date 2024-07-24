
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.conexion;
import modelo.salidas;

public class DaoSalida {
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(salidas c){
        String SQL="insert into salidas (numSalida,idCliente,fecha,subtotal,igv,total) VALUES (?,?,?,?,?,?)";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, c.getNumSalida());
            ps.setInt(2, c.getIdCliente());
            ps.setDate(3, c.getFecha());
            ps.setDouble(4, c.getSubtotal());
            ps.setDouble(5, c.getIgv());
            ps.setDouble(6, c.getTotal());
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

    public String numSalida(){
        String numero="";
        String SQL="select max(idSalida) from salidas";
         try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
            numero=rs.getString(1);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return numero;
    }


 public List Listar(){
        List<salidas> lista=new ArrayList<>();
        String SQL="select * from salidas";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
                salidas c=new salidas();
                c.setIdSalida(rs.getInt(1));
                c.setNumSalida(rs.getString(2));
                c.setIdCliente(rs.getInt(3));
                c.setFecha(rs.getDate(4));
                c.setSubtotal(rs.getInt(5));
                c.setIgv(rs.getDouble(6));
                c.setTotal(rs.getDouble(7));
                c.setEstado(rs.getString(8));
                lista.add(c);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return lista;
    }
    
    public List ListarPorFecha(String fec1,String fec2){
        List<salidas> lista=new ArrayList<>();
        String SQL="SELECT * from salidas WHERE fecha BETWEEN '"+fec1+"' AND '"+fec2+"'";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
                salidas c=new salidas();
                c.setIdSalida(rs.getInt(1));
                c.setNumSalida(rs.getString(2));
                c.setIdCliente(rs.getInt(3));
                c.setFecha(rs.getDate(4));
                c.setSubtotal(rs.getInt(5));
                c.setIgv(rs.getDouble(6));
                c.setTotal(rs.getDouble(7));
                c.setEstado(rs.getString(8));
                lista.add(c);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return lista;
    }
    
    public boolean anularSalida(salidas c){
        String SQL="update salidas set estado=? where idSalida=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, c.getEstado());
            ps.setInt(2, c.getIdSalida());
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

    public int cantSalidas(){
        String SQL="SELECT COUNT(idSalida) FROM salidas";
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

    public double TotalSalidas(int mes,int año){
        String SQL="Select sum(total) from salidas WHERE MONTH(fecha)="+mes+" and YEAR(fecha) = "+año;
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
