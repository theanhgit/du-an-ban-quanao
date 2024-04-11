/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author pc
 */
public class KichCoModel {
    private int id;
    private String ma;
    
    private String kichCo;
//    private String rongVai;
//    private String eo;
//    private String dai;
//    private String canNang;
//    private String chieuCao;
//    private String loaiSanPham;

    public KichCoModel() {
    }

    public KichCoModel(int id, String ma, String kichCo) {
        this.id = id;
        this.ma = ma;
        this.kichCo = kichCo;
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

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

   

  
    
    public Object[] toRowData(){
        return new Object[]{ma,kichCo};
    }
}
