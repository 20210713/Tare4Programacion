//Jorge Miguel Paulino Luciano, 2021-0713
package com.mycompany.tarea4;

public class Usuario {
    public String nombre;
    public String apellido;
    public String usuario;
    public String telefono;
    public String email;
    public String contraseña;
    
    public Usuario(){
        this.nombre = "";
        this.apellido = "";
        this.contraseña = "";
        this.usuario = "";
        this.telefono = "";
        this.email = "";
    }
    
    public Usuario (String nombre, String apellido, String usuario, String telefono, String email, String contraseña){
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.usuario = usuario;
        this.telefono = telefono;
        this.email = email;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
