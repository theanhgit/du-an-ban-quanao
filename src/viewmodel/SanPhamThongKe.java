package viewmodel;

public class SanPhamThongKe {

    private String maSp;
    
    private String loaiSp;
    
    private String kichCo;
    
    private int soLuongBan;
    
    private int giaBan;
    
    private int doanhThu;

    public SanPhamThongKe() {
    }

    public SanPhamThongKe(String maSp, String loaiSp, String kichCo, int soLuongBan, int giaBan, int doanhThu) {
        this.maSp = maSp;
        this.loaiSp = loaiSp;
        this.kichCo = kichCo;
        this.soLuongBan = soLuongBan;
        this.giaBan = giaBan;
        this.doanhThu = doanhThu;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getLoaiSp() {
        return loaiSp;
    }

    public void setLoaiSp(String loaiSp) {
        this.loaiSp = loaiSp;
    }

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(int doanhThu) {
        this.doanhThu = doanhThu;
    }
    
    
}