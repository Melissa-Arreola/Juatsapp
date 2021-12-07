/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Mensaje;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;

/**
 * @author Melissa Arreola Pasos
 * @author Juan Diego Romero
 * @author Isaac Castelo Valenzuela
 */
public class MensajeDAO extends BaseDAO<Mensaje>{
    
    protected MongoCollection<Mensaje> getColeccion() throws DAOException {
        MongoCollection<Mensaje> coleccionMensajes = this.generarConexion().getCollection("mensajes", Mensaje.class);
        return coleccionMensajes;
    }

    @Override
    public Mensaje mensajeRecibido(Mensaje mensaje) throws DAOException {
        MongoCollection<Mensaje> coleccionMensajes = this.getColeccion();
        coleccionMensajes.find((Bson) mensaje);
        return (Mensaje) coleccionMensajes;
    }

    @Override
    public Mensaje mensaejEnviado(Mensaje mensaje) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    

}
