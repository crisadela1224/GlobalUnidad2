/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class Login {
    private int id;
    private String  userName;
    private String type;
    
   


    public Login(int id, String userName, String type ) {
        this.id= id;
        this.userName = userName;
        this.type=type ;
       
   
       
    }
    
    public Login(){
        this(0, "", "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Login{" + "id=" + id + ", userName=" + userName + ", type=" + type + '}';
    }


    

    
}
