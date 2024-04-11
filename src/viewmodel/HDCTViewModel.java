/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author pc
 */
public class HDCTViewModel {
    
    private int id;
    private int idHD;
    private int idSPCT;
    private String kichCo;
    private int soLuong;
    private Float donGia;

    public HDCTViewModel() {
    }

    public HDCTViewModel(int id, int idHD, int idSPCT, String kichCo, int soLuong, Float donGia) {
        this.id = id;
        this.idHD = idHD;
        this.idSPCT = idSPCT;
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

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public int getIdSPCT() {
        return idSPCT;
    }

    public void setIdSPCT(int idSPCT) {
        this.idSPCT = idSPCT;
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

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }
    
    public Object[] toRowData(){
        return new Object[]{idHD,idSPCT,kichCo,soLuong,donGia};
    }
}
