
package modelo;

public class proveedor {
    
   int idProveedor;
   String nombre;
   String apellido;
   String documento;
   String Rsocial;
   String direccion;
   String telefono;
   String correo;

    public proveedor() {
    }

    public proveedor(int idProveedor, String nombre, String apellido, String documento, String Rsocial, String direccion, String telefono, String correo) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.Rsocial = Rsocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getRsocial() {
        return Rsocial;
    }

    public void setRsocial(String Rsocial) {
        this.Rsocial = Rsocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


}
