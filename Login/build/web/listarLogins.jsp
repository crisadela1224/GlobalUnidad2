<%-- 
    Document   : ListarUsuario
    Created on : 22/09/2016, 02:24:08 PM
    Author     : user 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Repositorys</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>User Name</th>
                    <th>Type</th>
                  
                    
                    
                </tr>
            <tbody>
                <c:forEach var="login" items="${logins}">
                    <tr>
                        <td>${login.id}</td>
                        <td>${login.userName}</td>
                        <td>${login.type}</td>
                        
                        <td><a href="LoginController?action=modificar&id=${login.id}">Modificar</a></td>
                         <td><a href="LoginController?action=eliminar&id=${login.id}">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
            
            
        </table>
        <p>
            <a href="LoginController?action=insertar">Nuevo Login</a>
        </p>
    </body>
</html>
