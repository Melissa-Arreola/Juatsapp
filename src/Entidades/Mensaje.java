/* 
 *  Mensaje.java
 * 
 *  Creada el 27 de Noviembre del 2021 7:50PM
 */

package Entidades;

/**
 * @author Melissa Arreola Pasos
 * @author Juan Diego Romero
 * @author Isaac Castelo Valenzuela
 */
public class Mensaje {

    private String mensajeEnviado;
    private String mensajeRecibido;

    public Mensaje() {
    }

    public Mensaje(String mensajeEnviado, String mensajeRecibido) {
        this.mensajeEnviado = mensajeEnviado;
        this.mensajeRecibido = mensajeRecibido;
    }

    public String getMensajeEnviado() {
        return mensajeEnviado;
    }

    public void setMensajeEnviado(String mensajeEnviado) {
        this.mensajeEnviado = mensajeEnviado;
    }

    public String getMensajeRecibido() {
        return mensajeRecibido;
    }

    public void setMensajeRecibido(String mensajeRecibido) {
        this.mensajeRecibido = mensajeRecibido;
    }
    
    
    
    
}
