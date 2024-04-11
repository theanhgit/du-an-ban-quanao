/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author pc
 */
public class SanPhamModel {
    private int id;
    private String ma;
    private String ten;
    private String loaiSanPham;
    private int  soLuong;

    public SanPhamModel() {
    }

    public SanPhamModel(int id, String ma, String ten, String loaiSanPham, int soLuong) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.loaiSanPham = loaiSanPham;
        this.soLuong = soLuong;
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

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    
    
    
    public Object[] toRowData(){
        return new Object[]{ma,ten,loaiSanPham,soLuong};
    }
}
