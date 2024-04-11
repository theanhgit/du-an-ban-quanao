package model;

import java.sql.Date;

public class HoaDonDomain {
    private int id;
    private String ma;
    private int idNV;
    private int idKH;
    private String maPGG;
    private Date ngayTao;
    private Date ngayThanhToan;
    private int tienGiam;
    private int tongTien;
    private int tienKhachDua;
    private int tienThua;
    private int tienTraTruoc;
    private int HinhThucThanhToan;
    private String maChuyenKhoan;
    private int tienChuyenKhoan;
    private String trangThai;

    public HoaDonDomain() {
    }

    public HoaDonDomain(int id, String ma, int idNV, int idKH, String maPGG, Date ngayTao, Date ngayThanhToan, int tienGiam, int tongTien, int tienKhachDua, int tienThua, int tienTraTruoc, int HinhThucThanhToan, String maChuyenKhoan, int tienChuyenKhoan, String trangThai) {
        this.id = id;
        this.ma = ma;
        this.idNV = idNV;
        this.idKH = idKH;
        this.maPGG = maPGG;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tienGiam = tienGiam;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.tienThua = tienThua;
        this.tienTraTruoc = tienTraTruoc;
        this.HinhThucThanhToan = HinhThucThanhToan;
        this.maChuyenKhoan = maChuyenKhoan;
        this.tienChuyenKhoan = tienChuyenKhoan;
        this.trangThai = trangThai;
    }

    
    public HoaDonDomain(String ma, int idNV, int idKH, String maPGG, Date ngayTao, Date ngayThanhToan, int tienGiam, int tongTien, int tienKhachDua, int tienThua, int tienTraTruoc, int HinhThucThanhToan, String maChuyenKhoan, int tienChuyenKhoan) {
        this.idNV = idNV;
        this.idKH = idKH;
        this.maPGG = maPGG;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tienGiam = tienGiam;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.tienThua = tienThua;
        this.tienTraTruoc = tienTraTruoc;
        this.HinhThucThanhToan = HinhThucThanhToan;
        this.maChuyenKhoan = maChuyenKhoan;
        this.tienChuyenKhoan = tienChuyenKhoan;
        this.ma = ma;
    }

    public HoaDonDomain(int id,String ma , int idNV, int idKH, String maPGG, Date ngayTao, Date ngayThanhToan, int tienGiam, int tongTien, int tienKhachDua, int tienThua, int tienTraTruoc, int HinhThucThanhToan, String maChuyenKhoan, int tienChuyenKhoan) {
        this.id = id;
        this.ma =ma;
        this.idNV = idNV;
        this.idKH = idKH;
        this.maPGG = maPGG;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tienGiam = tienGiam;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.tienThua = tienThua;
        this.tienTraTruoc = tienTraTruoc;
        this.HinhThucThanhToan = HinhThucThanhToan;
        this.maChuyenKhoan = maChuyenKhoan;
        this.tienChuyenKhoan = tienChuyenKhoan;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public String getMaPGG() {
        return maPGG;
    }

    public void setMaPGG(String maPGG) {
        this.maPGG = maPGG;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getTienGiam() {
        return tienGiam;
    }

    public void setTienGiam(int tienGiam) {
        this.tienGiam = tienGiam;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(int tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public int getTienThua() {
        return tienThua;
    }

    public void setTienThua(int tienThua) {
        this.tienThua = tienThua;
    }

    public int getTienTraTruoc() {
        return tienTraTruoc;
    }

    public void setTienTraTruoc(int tienTraTruoc) {
        this.tienTraTruoc = tienTraTruoc;
    }

    public int getHinhThucThanhToan() {
        return HinhThucThanhToan;
    }

    public void setHinhThucThanhToan(int HinhThucThanhToan) {
        this.HinhThucThanhToan = HinhThucThanhToan;
    }

    public String getMaChuyenKhoan() {
        return maChuyenKhoan;
    }

    public void setMaChuyenKhoan(String maChuyenKhoan) {
        this.maChuyenKhoan = maChuyenKhoan;
    }

    public int getTienChuyenKhoan() {
        return tienChuyenKhoan;
    }

    public void setTienChuyenKhoan(int tienChuyenKhoan) {
        this.tienChuyenKhoan = tienChuyenKhoan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    
    @Override
    public String toString() {
        return "HoaDonDomain{" + "id=" + id + ", ma=" + ma + ", idNV=" + idNV + ", idKH=" + idKH + ", maPGG=" + maPGG + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", tienGiam=" + tienGiam + ", tongTien=" + tongTien + ", tienKhachDua=" + tienKhachDua + ", tienThua=" + tienThua + ", tienTraTruoc=" + tienTraTruoc + ", HinhThucThanhToan=" + HinhThucThanhToan + ", maChuyenKhoan=" + maChuyenKhoan + ", tienChuyenKhoan=" + tienChuyenKhoan + ", trang thai: "+trangThai+'}';
    }

   
}
