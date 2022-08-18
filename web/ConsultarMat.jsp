<%-- 
    Document   : ConsultarMat
    Created on : 10-ago-2022, 21:44:58
    Author     : yoang
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.MatriculaDAO"%>
<%@page import="ModeloVO.MatriculaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Matricula</title>
    </head>
    <body>
        <a href="Index.jsp">Volver</a>
        <h1>Matriculas registradas</h1>
        <form method="post" action="Matricula">
            <table>
                <tr>
                    <th>
                        <h5>Buscar por Matricula:</h5>
                        <div>
                            <input type="text" name="textregiMatr">
                            <button>Buscar</button>
                            <input type="hidden" value="4" name="opcion">
                        </div>
                    </th>
                </tr>
            </table>
            
        </form>
        
        <%            if (request.getAttribute("mensajeError") != null) { %>
            ${mensajeError}

            <%} else {%>
            ${mensajeExito}        
            <%}%>
        
            <br>
            
            <form method="post" action="Matricula">
                
                <table>
                    <tr>
                        <th>Id</th>
                        <th>Director</th>
                        <th>Alumno</th>
                        <th>Registro</th>
                        <th>Fecha</th>
                        <th>Estado</th>
                    </tr>
                    <% 
                    MatriculaVO matVO = new MatriculaVO();
                    MatriculaDAO matDAO = new MatriculaDAO();
                    ArrayList<MatriculaVO> listaMatr = matDAO.listar();
                    for (int i = 0; i < listaMatr.size(); i++) {
                            matVO = listaMatr.get(i);
                                  
                        
                    
                    %>
                    <tr>
                        <td><%= matVO.getIdMatr() %></td>
                        <td><%= matVO.getIdUsua() %></td>
                        <td><%= matVO.getIdAlum() %></td>
                        <td><%= matVO.getRegiMatr() %></td>
                        <td><%= matVO.getFechMatr() %></td>
                        <td><%= matVO.getEstaMatr() %></td>

                    </tr>
                    <% }%>
                </table>
                
            </form>
    </body>
</html>
