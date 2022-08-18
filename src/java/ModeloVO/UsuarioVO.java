/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Minguihobi
 */
public class UsuarioVO {

    private String idUsua, nomUsua, contrUsua, estaUsua;

    public UsuarioVO(String idUsua, String nomUsua, String contrUsua, String estaUsua) {
        this.idUsua = idUsua;
        this.nomUsua = nomUsua;
        this.contrUsua = contrUsua;
        this.estaUsua = estaUsua;
    }

    public String getIdUsua() {
        return idUsua;
    }

    public void setIdUsua(String idUsua) {
        this.idUsua = idUsua;
    }

    public String getNomUsua() {
        return nomUsua;
    }

    public void setNomUsua(String nomUsua) {
        this.nomUsua = nomUsua;
    }

    public String getContrUsua() {
        return contrUsua;
    }

    public void setContrUsua(String contrUsua) {
        this.contrUsua = contrUsua;
    }

    public String getEstaUsua() {
        return estaUsua;
    }

    public void setEstaUsua(String estaUsua) {
        this.estaUsua = estaUsua;
    }

}
