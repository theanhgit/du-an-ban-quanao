/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author pc
 */
public class DanhSachSP {
    
    private String ma;
    
    private String loaiSP;
    
    private String mauSac;
    
    private String kichCo;
    
    private int soLuong;
    
    private int giaNhap;

    public DanhSachSP() {
    }

    public DanhSachSP(String ma, String loaiSP, String mauSac, String kichCo, int soLuong, int giaNhap) {
        this.ma = ma;
        this.loaiSP = loaiSP;
        this.mauSac = mauSac;
        this.kichCo = kichCo;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
    }

    

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    @Override
    public String toString() {
        return "DanhSachSP{" + "ma=" + ma + ", loaiSP=" + loaiSP + ", mauSac=" + mauSac + ", kichCo=" + kichCo + ", soLuong=" + soLuong + ", giaNhap=" + giaNhap + '}';
    }

    
    public Object[] toRowData(){
        return new Object[]{ma,loaiSP,mauSac,kichCo,soLuong,giaNhap};
    }
}
