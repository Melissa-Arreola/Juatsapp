/* 
 *  Usuario.java
 * 
 *  Creada el 27 de Noviembre del 2021 7:50PM
 */

package Entidades;

/**
 * @author Melissa Arreola Pasos
 * @author Juan Diego Romero
 * @author Isaac Castelo Valenzuela
 */
public class Usuario {

    private String nombre;
    private String contrasenia;
    private Long edad;

    public Usuario() {
    }

    public Usuario(String nombre, String contrasenia, Long edad) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.edad = edad;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Long getEdad() {
        return edad;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
    }
    
    
}
