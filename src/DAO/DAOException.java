/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author eduar
 */
class DAOException extends Exception {
    
    public DAOException(String string) {
        super(string);
    }

    public DAOException() {
    }

    public DAOException(Throwable thrwbl) {
        super(thrwbl);
    }

    public DAOException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

}
