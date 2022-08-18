/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.MatriculaDAO;
import ModeloVO.MatriculaVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yoang
 */
@WebServlet(name = "MatriculaControlador", urlPatterns = {"/Matricula"})

public class MatriculaControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String idMatr = request.getParameter("textMatr");
        String idAlum = request.getParameter("textAlum");
        String idUsua = request.getParameter("textUsua");
        String regiMatr = request.getParameter("textregiMatr");
        String fechMatr = request.getParameter("textfechMatr");
        String estaMatr = request.getParameter("textestaMatr");

        String datos = request.getParameter("datos");

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        MatriculaVO matVO = new MatriculaVO(idMatr, idAlum, idUsua, regiMatr, fechMatr, estaMatr);

        MatriculaDAO matDAO = new MatriculaDAO(matVO);

        switch (opcion) {
            //Agregar Registro
            case 1:
                if (matDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "La matricula se registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "La matricula NO se registro correctamente");
                }
                request.getRequestDispatcher("RegistrarMatricula.jsp").forward(request, response);
                break;
             //Actualizar
            case 2:
                if (matDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "la matricula se actualizo correctamente");
                    
                } else {
                    request.setAttribute("mensajeError", "la matricula NO se actualizo correctamente");
                }
                request.getRequestDispatcher("ActualizarMat.jsp").forward(request, response);
                
            break;
            //Eliminar
            case 3:
                
            break;
            //Consultar
            case 4:
            matVO = matDAO.ConsultarMatricula(regiMatr);
                if (matVO != null) {
                    request.setAttribute("datosConsultados", matVO);
                    request.getRequestDispatcher("ConsultarMat.jsp").forward(request, response);
                }else{
                    request.setAttribute("mensajeError", "la matricula no se pudo encontrar");
                    request.getRequestDispatcher("ConsultarMat.jsp").forward(request, response);
                
                }
            break;
                
        
        }
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
