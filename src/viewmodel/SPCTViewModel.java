/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author pc
 */
public class SPCTViewModel {
    private int id;
    private String ma;
    private String maVach;
    private String moTa;
    private int soLuong;
    private String loaiSanPham;
    private String thuongHieu;
    private String loaiTheThao;
    private String kichCo;
    private String mauSac;
    private String chatLieu;
    private float giaNhap;
    private float giaBan;
    private boolean trangThai;

    public SPCTViewModel() {
    }

    public SPCTViewModel(int id, String ma, String maVach, String moTa, int soLuong, String loaiSanPham, String thuongHieu, String loaiTheThao, String kichCo, String mauSac, String chatLieu, float giaNhap, float giaBan, boolean trangThai) {
        this.id = id;
        this.ma = ma;
        this.maVach = maVach;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.loaiSanPham = loaiSanPham;
        this.thuongHieu = thuongHieu;
        this.loaiTheThao = loaiTheThao;
        this.kichCo = kichCo;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
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

    public String getMaVach() {
        return maVach;
    }

    public void setMaVach(String maVach) {
        this.maVach = maVach;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }


    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getLoaiTheThao() {
        return loaiTheThao;
    }

    public void setLoaiTheThao(String loaiTheThao) {
        this.loaiTheThao = loaiTheThao;
    }

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan=giaNhap*150/100;
    }

    public void setGiaBan(float giaNhap) {
        this.giaBan = giaNhap*(150/100);
    }

    public boolean isTrangThai() {
        return soLuong!=0;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    public Object[] toRowData(){
        return new Object[]{ma,maVach,moTa,soLuong,loaiSanPham,thuongHieu,loaiTheThao,kichCo,mauSac,chatLieu,giaNhap,getGiaBan(),soLuong!=0?"Còn Hàng":"Hết Hàng"};
    }
    
    public Object[] toRowDataBanHang(){
        return new Object[]{ma,loaiSanPham,thuongHieu,loaiTheThao,mauSac,kichCo,soLuong,getGiaBan()};
    }
}
