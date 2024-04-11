/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.TaiKhoan;
import viewmodel.QLTaiKhoan;

/**
 *
 * @author adm
 */
public interface TaiKhoanService {
    
    public ArrayList<QLTaiKhoan> getList();
    
    public Boolean Them(TaiKhoan taiKhoan);
    
    public Boolean Xoa(int id);
    
    public Boolean Sua(int id, TaiKhoan taiKhoan);
    
    public ArrayList<QLTaiKhoan> TimKiem(int idNV);
}
