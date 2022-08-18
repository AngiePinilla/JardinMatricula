<%-- 
    Document   : ActualizarMat
    Created on : 18-ago-2022, 6:16:13
    Author     : yoang
--%>

<%@page import="ModeloVO.MatriculaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Matricula</title>
    </head>
    <body>
        <h1>Actualizar Matricula</h1>
        
        <%
        MatriculaVO matVO = (MatriculaVO)request.getAttribute("datosconsultados");
        if(matVO !=null){
        %>
        
        <form method="post" action="Matricula">
            <table>
                <tr>
                    <th>
                        <h5>Id</h5>
                        <input type="text" name="textMatr" value="<%= matVO.getIdMatr() %>"><br>
                        
                        <h5>Alumno</h5>
                        <input type="text" name="textAlum" value="<%= matVO.getIdAlum() %>"><br>
                        
                        <h5>Director</h5>
                        <input type="text" name="textUsua" value="<%= matVO.getIdUsua() %>"><br>
                        
                        <h5>Registro</h5>
                        <input type="text" name="textregiMatr" value="<%= matVO.getRegiMatr() %>"><br>
                        
                        <h5>fecha</h5>
                        <input type="datetime-local" name="textfechMatr" value="<%= matVO.getFechMatr() %>"><br>
                        
                        <h5>Estado</h5>
                        <input type="text" name="textestaMatr" value="<%= matVO.getEstaMatr() %>"><br>
                    </th>
                </tr>
            </table>
                    <button>Actualizar</button><br>
                    <input type="hidden" value="2" name="opcion">
            
        </form>
        <% } %>
        
        <%
            if (request.getAttribute("mensajeError") != null) { %>
        ${mensajeError}
        <%} else {%>
        ${mensajeExito}        
        <%}%>
    </body>
</html>
