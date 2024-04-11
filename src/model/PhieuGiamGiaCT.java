/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author User
 */
public class PhieuGiamGiaCT {

    private String ID;
    private String ID_PGG;
    private String MA;
    private Date NGAYBATDAU;
    private Date NGAYKETTHUC;
    private String LUOTSUDUNG;
    private String DIEUKHOAN;
    private String GIATRI;
    private String TRANGTHAI;

    public PhieuGiamGiaCT() {
    }

    public PhieuGiamGiaCT(String ID, String ID_PGG, String MA, Date NGAYBATDAU, Date NGAYKETTHUC, String LUOTSUDUNG, String DIEUKHOAN, String GIATRI, String TRANGTHAI) {
        this.ID = ID;
        this.ID_PGG = ID_PGG;
        this.MA = MA;
        this.NGAYBATDAU = NGAYBATDAU;
        this.NGAYKETTHUC = NGAYKETTHUC;
        this.LUOTSUDUNG = LUOTSUDUNG;
        this.DIEUKHOAN = DIEUKHOAN;
        this.GIATRI = GIATRI;
        this.TRANGTHAI = TRANGTHAI;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID_PGG() {
        return ID_PGG;
    }

    public void setID_PGG(String ID_PGG) {
        this.ID_PGG = ID_PGG;
    }

    public String getMA() {
        return MA;
    }

    public void setMA(String MA) {
        this.MA = MA;
    }

    public Date getNGAYBATDAU() {
        return NGAYBATDAU;
    }

    public void setNGAYBATDAU(Date NGAYBATDAU) {
        this.NGAYBATDAU = NGAYBATDAU;
    }

    public Date getNGAYKETTHUC() {
        return NGAYKETTHUC;
    }

    public void setNGAYKETTHUC(Date NGAYKETTHUC) {
        this.NGAYKETTHUC = NGAYKETTHUC;
    }

    public String getLUOTSUDUNG() {
        return LUOTSUDUNG;
    }

    public void setLUOTSUDUNG(String LUOTSUDUNG) {
        this.LUOTSUDUNG = LUOTSUDUNG;
    }

    public String getDIEUKHOAN() {
        return DIEUKHOAN;
    }

    public void setDIEUKHOAN(String DIEUKHOAN) {
        this.DIEUKHOAN = DIEUKHOAN;
    }

    public String getGIATRI() {
        return GIATRI;
    }

    public void setGIATRI(String GIATRI) {
        this.GIATRI = GIATRI;
    }

    public String getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(String TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

}
