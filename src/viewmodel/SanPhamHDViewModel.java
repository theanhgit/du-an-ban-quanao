package viewmodel;

public class SanPhamHDViewModel {
    
    private int id;

    private String loaiSanPham;
    
    private String tenSp;
    
    private String kichCo;
    
    private int soLuong;
    
    private int donGia;

    public SanPhamHDViewModel() {
    }

    public SanPhamHDViewModel(int id, String loaiSanPham, String tenSp, String kichCo, int soLuong, int donGia) {
        this.id = id;
        this.loaiSanPham = loaiSanPham;
        this.tenSp = tenSp;
        this.kichCo = kichCo;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
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

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "SanPhamHDViewModel{" + "id=" + id + ", loaiSanPham=" + loaiSanPham + ", tenSp=" + tenSp + ", kichCo=" + kichCo + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }
    
    
}