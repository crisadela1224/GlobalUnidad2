/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoginDao;
import dao.LoginDaoImp;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Login;

/**
 *
 * @author user
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final String LISTA_LOGINS= 
            "/listarLogins.jsp";
    private static final String AGREGAR_O_CAMBIAR = 
            "/logins.jsp";
    private LoginDao dao;
    
    public LoginController(){
        dao = new LoginDaoImp();
    }
    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("eliminar")){
            forward = LISTA_LOGINS;
            int id = Integer.parseInt(
                    request.getParameter("id"));
            dao.eliminarLogin(id);
            request.setAttribute("logins", dao.desplegarLogins());
        }else if(action.equalsIgnoreCase("modificar")){
            forward= AGREGAR_O_CAMBIAR;
            int id = Integer.parseInt(
                    request.getParameter("id"));
            Login login=  dao.elegirLogin(id);
            request.setAttribute("login", login);
            
            
            
        }else if(action.equalsIgnoreCase("insertar")){
            forward= AGREGAR_O_CAMBIAR;
        }else{
            forward=LISTA_LOGINS;
            request.setAttribute("logins", dao.desplegarLogins());
        }
        RequestDispatcher view =
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Login login = new Login();
      String id = (request.getParameter("id").trim());
      login.setUserName(request.getParameter("userName").trim());
      login.setType(request.getParameter("type").trim());
      
      
      
      if(id==null || id.isEmpty()){
          dao.insertarLogin(login);
          
      }else{
          login.setId(Integer.parseInt(id));
//          repository.setKey(Integer.parseInt(userKey));
          dao.modificarLogin(login);
          
      }
      RequestDispatcher view = request.getRequestDispatcher(LISTA_LOGINS);
      request.setAttribute("logins", dao.desplegarLogins());
      view.forward(request, response);
    }


   
    }

