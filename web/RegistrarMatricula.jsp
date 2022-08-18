<%-- 
    Document   : RegistrarMatricula
    Created on : 09-ago-2022, 22:43:26
    Author     : yoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="Index.jsp">Volver</a>
        <br>
        <h1>Nueva Matricula</h1>
        <form action="Matricula" method="POST">
            <table>
                <tr>
                    <td>
                        
                        <h5>Alumno</h5>
                        <input type="number" name="textAlum">
                        <br>
                        <h5>Director</h5>
                        <input type="number" name="textUsua">
                        <br>
                        <h5>Registro</h5>
                        <input type="text" name="textregiMatr">
                        <br>
                        <h5>Fecha</h5>
                        <input type="datetime-local" name="textfechMatr">
                        <br>
                        <h5>Estado </h5>
                        <input type="number" name="textestaMatr">
                        <br>
                        
                        
                    </td>
                </tr>
            </table>
            <button>Registar</button>
                <input type="hidden" value="1" name="opcion">
        </form>
        <br>


            <%
                if (request.getAttribute("mensajeError") != null) { %>
            ${mensajeError}

            <%} else {%>
            ${mensajeExito}        
            <%}%><br>
    </body> 
</html>
