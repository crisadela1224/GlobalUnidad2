/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.List;
import model.Login;

/**
 *
 * @author Maria Magdalena Cabrera Coronilla magdacc05@gmail.com
 */
public interface LoginDao {
    void insertarLogin(Login login);
    void eliminarLogin(int id);
    void modificarLogin(Login login);
    List<Login> desplegarLogins();
    Login elegirLogin(int id);
    
}
