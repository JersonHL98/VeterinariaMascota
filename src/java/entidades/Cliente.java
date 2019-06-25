package entidades;
// Generated 24/06/2019 10:14:04 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private int idCliente1;
     private String nombre;
     private String apellido;
     private Date fechaNacimiento;
     private String direccion;
     private String telefono;
     private String email;
     private Set mascotaporclientes = new HashSet(0);

    public Cliente() {
    }

	
    public Cliente(int idCliente1, String nombre, String apellido, Date fechaNacimiento, String direccion, String telefono, String email) {
        this.idCliente1 = idCliente1;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
    public Cliente(int idCliente1, String nombre, String apellido, Date fechaNacimiento, String direccion, String telefono, String email, Set mascotaporclientes) {
       this.idCliente1 = idCliente1;
       this.nombre = nombre;
       this.apellido = apellido;
       this.fechaNacimiento = fechaNacimiento;
       this.direccion = direccion;
       this.telefono = telefono;
       this.email = email;
       this.mascotaporclientes = mascotaporclientes;
    }
   
    public int getIdCliente1() {
        return this.idCliente1;
    }
    
    public void setIdCliente1(int idCliente1) {
        this.idCliente1 = idCliente1;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set getMascotaporclientes() {
        return this.mascotaporclientes;
    }
    
    public void setMascotaporclientes(Set mascotaporclientes) {
        this.mascotaporclientes = mascotaporclientes;
    }




}

