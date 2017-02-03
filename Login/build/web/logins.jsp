<%-- 
    Document   : Usuario
    Created on : 22/09/2016, 02:24:34 PM
    Author     : user 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logins</title>
    </head>
    <body>
        <form action="LoginController" method="post">
            <fieldset>
                <legend>Formulario de Logins</legend>
                <div>
                 <label>Id:</label>
                <input type="text" name="id"
                       value="${login.id}"
                       readonly="readonly"
                       placeholder="id"
                       />
                </div>
                       
                       <div>
                <label>User Name:</label>
                <input type="text" name="userName"
                                value="${login.userName}"
                       placeholder="User Name"
                       />
                
                       </div>
                       
                       <div>
                 <label>Type:</label>
                <input type="text" name="type"
                       value="${login.type}"
                       placeholder="Type"
                       />
                
                       </div>
                       
                       
                       
                  
                           <input type="submit" value="Guardar" />
                           
                       
            </fieldset>
            
        </form>
    </body>
</html>
