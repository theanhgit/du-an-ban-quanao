/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

/**
 *
 * @author adm
 */
public class QLTaiKhoan {
    private int id , idNV;
    private String  taiKhoan, matKhau;

    public QLTaiKhoan() {
    }

    public QLTaiKhoan(int id, int idNV, String taiKhoan, String matKhau) {
        this.id = id;
        this.idNV = idNV;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
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

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    
   
}
