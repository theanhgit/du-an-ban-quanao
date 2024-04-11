/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class NhanVienVM {
    private int id;
    private String ma;
    private String hoten;
    private int gioitinh;
    private String sdt;
    private String cccd;
    private LocalDate ngaysinh;
    private String diachi;
    private String email;
    private int chucvu;
    private String tendn;
    private String matkhau;
    private int trangthai;

    public NhanVienVM() {
    }

    public NhanVienVM(String ma, String hoten, int gioitinh, String sdt, String cccd, LocalDate ngaysinh, String diachi, String email, int chucvu, String tendn, String matkhau, int trangthai) {
        this.ma = ma;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.cccd = cccd;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.email = email;
        this.chucvu = chucvu;
        this.tendn = tendn;
        this.matkhau = matkhau;
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

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getChucvu() {
        return chucvu;
    }

    public void setChucvu(int chucvu) {
        this.chucvu = chucvu;
    }

    public String getTendn() {
        return tendn;
    }

    public void setTendn(String tendn) {
        this.tendn = tendn;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getgt() {
        if (gioitinh == 1) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }
    public String getcv() {
        if (chucvu == 1) {
            return "Nhân viên";
        } else {
            return "Quản lý";
        }
    }
    public String gettt() {
        if (trangthai == 1) {
            return "Làm việc";
        } else {
            return "Nghỉ việc";
        }
    }
}
