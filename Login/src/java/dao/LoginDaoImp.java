/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;




import model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Util;

/**
 *
 * @author user
 */
public class LoginDaoImp implements LoginDao {
    private Connection connection;
    
    public LoginDaoImp(){
        connection = Util.getConnection();
    
}

    @Override
    public void insertarLogin(Login login) {
try{
            String query = "INSERT INTO logins (user_name,type)"
                    +" VALUES(?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,login.getUserName());
            ps.setString(2,login.getType());
          
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        } 
    }

    @Override
    public void eliminarLogin(int id) {
try{
            String query = "DELETE FROM logins WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void modificarLogin(Login login) {
try{
            String query = "UPDATE logins SET user_name =? "
                    + ", type =?"
                   
                    +" WHERE   id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,login.getUserName());
            ps.setString(2,login.getType());
              ps.setInt(3, login.getId());
            
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Login> desplegarLogins() {
     List<Login> logins = new ArrayList<Login>();
        try{
        Statement statement = connection.createStatement();
         ResultSet rs= statement.executeQuery("SELECT * FROM logins");
         while(rs.next()){
             Login login = new Login(
                     rs.getInt("id"),
                     rs.getString("user_name"),
                     rs.getString("type"));
             
             logins.add(login);
             
         
         }
         rs.close();
         statement.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
return logins;
    }
    

    @Override
    public Login elegirLogin(int id) {
   Login login = null;
        
        try{
            String query = "SELECT * FROM logins WHERE id= ?";
            PreparedStatement statement =
                    connection.prepareStatement(query);
            statement.setInt(1, id);
             ResultSet rs= statement.executeQuery();
         if(rs.next()){
             
               login= new Login(
                rs.getInt("id"),
                        rs.getString("user_name"),
                        rs.getString("type"));
         }
         rs.close();
         statement.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
return login;
    }
    
    }
    
   
