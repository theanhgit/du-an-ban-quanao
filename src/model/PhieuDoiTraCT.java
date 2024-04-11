/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class PhieuDoiTraCT {

    private String ID;
    private String ID_PIEU_DOI_TRA;
    private String ID_SPCT;
    private String GIASP;
    private String TRANGTHAI;
    private String LIDOA;

    public PhieuDoiTraCT() {
    }

    public PhieuDoiTraCT(String ID, String ID_PIEU_DOI_TRA, String ID_SPCT, String GIASP, String TRANGTHAI, String LIDOA) {
        this.ID = ID;
        this.ID_PIEU_DOI_TRA = ID_PIEU_DOI_TRA;
        this.ID_SPCT = ID_SPCT;
        this.GIASP = GIASP;
        this.TRANGTHAI = TRANGTHAI;
        this.LIDOA = LIDOA;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID_PIEU_DOI_TRA() {
        return ID_PIEU_DOI_TRA;
    }

    public void setID_PIEU_DOI_TRA(String ID_PIEU_DOI_TRA) {
        this.ID_PIEU_DOI_TRA = ID_PIEU_DOI_TRA;
    }

    public String getID_SPCT() {
        return ID_SPCT;
    }

    public void setID_SPCT(String ID_SPCT) {
        this.ID_SPCT = ID_SPCT;
    }

    public String getGIASP() {
        return GIASP;
    }

    public void setGIASP(String GIASP) {
        this.GIASP = GIASP;
    }

    public String getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(String TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public String getLIDOA() {
        return LIDOA;
    }

    public void setLIDOA(String LIDOA) {
        this.LIDOA = LIDOA;
    }

}
