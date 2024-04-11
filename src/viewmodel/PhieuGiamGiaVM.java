/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author User
 */
public class PhieuGiamGiaVM {
    private int id;
    private String ma;
    private String ten;
    private LocalDate ngaybatdau;
    private LocalDate ngayketthuc;
    private int luotsudung;
    private String dieukhoan;
    private long giatri;
    private int trangthai;

    public PhieuGiamGiaVM() {
    }

    public PhieuGiamGiaVM(String ma, String ten, LocalDate ngaybatdau, LocalDate ngayketthuc, int luotsudung, String dieukhoan, long giatri, int trangthai) {
        this.ma = ma;
        this.ten = ten;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.luotsudung = luotsudung;
        this.dieukhoan = dieukhoan;
        this.giatri = giatri;
        this.trangthai = trangthai;
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

    public LocalDate getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(LocalDate ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public LocalDate getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(LocalDate ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public int getLuotsudung() {
        return luotsudung;
    }

    public void setLuotsudung(int luotsudung) {
        this.luotsudung = luotsudung;
    }

    public String getDieukhoan() {
        return dieukhoan;
    }

    public void setDieukhoan(String dieukhoan) {
        this.dieukhoan = dieukhoan;
    }

    public long getGiatri() {
        return giatri;
    }

    public void setGiatri(long giatri) {
        this.giatri = giatri;
    }

    public int getTrangthai() {
//        return trangthai.equalsIgnoreCase("1")? "Đang hoạt động" : "Ngừng hoạt động";
return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
     

     public String getNgay() {
        if (trangthai == 1) {
            return "Đang hoạt động";
        } else {
            return "Ngừng hoạt động";
        
    }
}
}
