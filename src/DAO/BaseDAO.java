/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entidades.Mensaje;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Melissa
 */
public abstract class BaseDAO<T>{
    
    //Hay que poner los datos del host y puerto
    private static final String HOST = "";
    private static final String PUERTO = "";
    private final String DATA_BASE = "juatsapp";
     
     protected MongoDatabase generarConexion() throws DAOException {
        try{
            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
            CodecRegistry codecRegistry = fromRegistries( MongoClientSettings.getDefaultCodecRegistry(),pojoCodecRegistry);

            ConnectionString cadenaConexion = new ConnectionString(String.format("mongodb://%s/%s", HOST, PUERTO));

            MongoClientSettings configuracionesConexion = MongoClientSettings.builder()
                .applyConnectionString(cadenaConexion)
                .codecRegistry(codecRegistry)
                .build();

            MongoClient clienteBD = MongoClients.create(configuracionesConexion);
            MongoDatabase baseDatos = clienteBD.getDatabase(DATA_BASE);
            return baseDatos;
            
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }        
    }
     
    //Metodos abstractos
    public abstract Mensaje mensajeRecibido(Mensaje mensaje) throws DAOException;
    public abstract Mensaje mensaejEnviado(Mensaje mensaje) throws DAOException;
    
}
