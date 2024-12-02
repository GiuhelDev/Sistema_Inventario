/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class auditoria {
    int idauditoria;
    String tabla;
    String accion;
    int idUsuario;

    public auditoria() {
    }

    public auditoria(int idauditoria, String tabla, String accion, int idUsuario) {
        this.idauditoria = idauditoria;
        this.tabla = tabla;
        this.accion = accion;
        this.idUsuario = idUsuario;
    }

    public int getIdauditoria() {
        return idauditoria;
    }

    public void setIdauditoria(int idauditoria) {
        this.idauditoria = idauditoria;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
