/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.conexion;
import modelo.usuarios;


public class DaoUsuario {
    
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public usuarios login(String usuario,String pass){
        usuarios us=new usuarios();
        String sql="SELECT * FROM usuarios WHERE usuario='"+usuario+"' and pass=aes_encrypt('"+pass+"','clave')";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
        while(rs.next()){
            us.setIdusuario(rs.getInt(1));
            us.setNombre(rs.getString(2));
            us.setApellido(rs.getString(3));
            us.setDocumento(rs.getString(4));
            us.setDireccion(rs.getString(5));
            us.setTelefono(rs.getString(6));
            us.setCorreo(rs.getString(7));
            us.setTipoUsuario(rs.getString(8));
            us.setUsaurio(rs.getString(9));
            us.setPassword(rs.getString(10));
        }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
        return us;
    }

    public boolean insertar(String nombre,String apellido,String documento,String direccion,String telefono,String correo,
                            String tipouser,String user,String pass){
        String SQL="insert into usuarios (nombre,apellido,documento,direccion,telefono,correo,tipoUsuario,usuario,pass) "
                + "VALUES ('"+nombre+"','"+apellido+"','"+documento+"','"+direccion+"','"+telefono+"','"+correo+"','"+tipouser+"'"
                + ",'"+user+"',aes_encrypt('"+pass+"','clave'))";
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

    public List Listar(){
        List<usuarios> lista=new ArrayList<>();
        String SQL="select * from usuarios";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
                usuarios c=new usuarios();
                c.setIdusuario(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDocumento(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setCorreo(rs.getString(7));
                c.setTipoUsuario(rs.getString(8));
                c.setUsaurio(rs.getString(9));
                c.setPassword(rs.getString(10));
                lista.add(c);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return lista;
    }
}
