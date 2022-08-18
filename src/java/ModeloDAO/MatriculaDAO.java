/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.MatriculaVO;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBd;
import util.Crud;

/**
 *
 * @author Minguihobi
 */
public class MatriculaDAO extends ConexionBd implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String idMatr = "", idAlum = "", idUsua = "", regiMatr = "", fechMatr = "", estaMatr = "";

    public MatriculaDAO() {
    }

    public MatriculaDAO(MatriculaVO matVo) {

        super();
        try {

            conexion = this.obtenerConexion();

            idMatr = matVo.getIdMatr();
            idAlum = matVo.getIdAlum();
            idUsua = matVo.getIdUsua();
            regiMatr = matVo.getRegiMatr();
            fechMatr = matVo.getFechMatr();
            estaMatr = matVo.getEstaMatr();

        } catch (Exception e) {
            Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "insert into matricula (id_alum, id_usua, regis_matr, fech_matr, estado_matr) values(?,?,?,?,?)";

            puente = conexion.prepareStatement(sql);

            puente.setString(1, idAlum);
            puente.setString(2, idUsua);
            puente.setString(3, regiMatr);
            puente.setString(4, fechMatr);
            puente.setString(5, estaMatr);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.deneterConexion();
            } catch (SQLException e) {
                Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }

        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {

        try {
            sql = "update matricula set idAlum=?, idUsua=?, regiMatr=?, estaMatr=? where idMatr=?";

            puente = conexion.prepareStatement(sql);

            puente.setString(1, idAlum);
            puente.setString(2, idUsua);
            puente.setString(3, regiMatr);
            puente.setString(4, fechMatr);
            puente.setString(5, estaMatr);
            puente.setString(6, idMatr);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.deneterConexion();
            } catch (SQLException e) {
                Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }

        return operacion;

    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public MatriculaVO ConsultarMatricula(String regiMatr) {
        MatriculaVO matVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select * from matricula where regis_matr=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, regiMatr);
            while (mensajero.next()) {

                matVO = new MatriculaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6));
            }

        } catch (SQLException e) {
            Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.deneterConexion();
            } catch (SQLException e) {
                Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return matVO;
    }

    public ArrayList<MatriculaVO> listar() {

        ArrayList<MatriculaVO> listaMatr = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT matricula.ID_MATR, usuario.ID_USUA, alumno.ID_ALUM, matricula.REGIS_MATR, matricula.FECH_MATR, matricula.ESTADO_MATR FROM\n"
                    + "matricula INNER JOIN usuario on matricula.ID_USUA = usuario.ID_USUA \n"
                    + "JOIN alumno on matricula.ID_ALUM = alumno.ID_ALUM;";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                
                MatriculaVO matVO = new MatriculaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6));
                listaMatr.add(matVO);
            }
        } catch (SQLException e) {
            Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.deneterConexion();
            } catch (SQLException e) {
                Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        
        return listaMatr;
    }

}
