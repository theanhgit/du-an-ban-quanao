/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author pc
 */
public class PGGModel {

    private int id;

    private String ma;

    private String ten;

    private Date ngayBatDau;

    private Date ngayKetThuc;

    private int luotSuDung;

    private String dieuKhoan;

    private int giaTri;

    private int trangThai;

    public PGGModel() {
    }

    public PGGModel(int id, String ma, String ten, Date ngayBatDau, Date ngayKetThuc, int luotSuDung, String dieuKhoan, int giaTri, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.luotSuDung = luotSuDung;
        this.dieuKhoan = dieuKhoan;
        this.giaTri = giaTri;
        this.trangThai = trangThai;
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getLuotSuDung() {
        return luotSuDung;
    }

    public void setLuotSuDung(int luotSuDung) {
        this.luotSuDung = luotSuDung;
    }

    public String getDieuKhoan() {
        return dieuKhoan;
    }

    public void setDieuKhoan(String dieuKhoan) {
        this.dieuKhoan = dieuKhoan;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

    

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
