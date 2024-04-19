
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
        String SQL="insert into salidas (idEntrada,cantidad,idCliente,fecha,subtotal,igv,total) VALUES (?,?,?,?,?,?,?)";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, c.getIdEntrada());
            ps.setInt(2, c.getCantidad());
            ps.setInt(3, c.getIdCliente());
            ps.setDate(4, c.getFecha());
            ps.setDouble(5, c.getSubtotal());
            ps.setDouble(6, c.getIgv());
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
}
