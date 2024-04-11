/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author User
 */
public class PhieuDoiTra {
    private String ID;
    private String ID_HD;
    private Date NGAYDT;
    private String TRONGTIEN;

    public PhieuDoiTra() {
    }

    public PhieuDoiTra(String ID, String ID_HD, Date NGAYDT, String TRONGTIEN) {
        this.ID = ID;
        this.ID_HD = ID_HD;
        this.NGAYDT = NGAYDT;
        this.TRONGTIEN = TRONGTIEN;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID_HD() {
        return ID_HD;
    }

    public void setID_HD(String ID_HD) {
        this.ID_HD = ID_HD;
    }

    public Date getNGAYDT() {
        return NGAYDT;
    }

    public void setNGAYDT(Date NGAYDT) {
        this.NGAYDT = NGAYDT;
    }

    public String getTRONGTIEN() {
        return TRONGTIEN;
    }

    public void setTRONGTIEN(String TRONGTIEN) {
        this.TRONGTIEN = TRONGTIEN;
    }
    
}
