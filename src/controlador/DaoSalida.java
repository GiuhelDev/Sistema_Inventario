
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    
}
