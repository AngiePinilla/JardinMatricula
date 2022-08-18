/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBd;

/**
 *
 * @author Minguihobi
 */
public class UsuarioDAO extends ConexionBd {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String idUsua = "", nomUsua = "", contrUsua = "", estaUsua = "";

    public UsuarioDAO(UsuarioVO usuVO) {
        
        super();

        try {
            conexion = this.obtenerConexion();

            idUsua = usuVO.getIdUsua();
            nomUsua = usuVO.getNomUsua();
            contrUsua = usuVO.getContrUsua();
            estaUsua = usuVO.getEstaUsua();

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

}
