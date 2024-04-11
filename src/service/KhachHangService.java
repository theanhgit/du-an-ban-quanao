/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.KhachHang;
import viewmodel.QLKhachHang;

/**
 *
 * @author adm
 */
public interface KhachHangService {

    public ArrayList<QLKhachHang> getList();

    public Boolean Them(KhachHang khachHang);

    public Boolean Xoa(int id);

    public Boolean Sua(int id, KhachHang khachHang);

    public ArrayList<QLKhachHang> TimKiem(String name);

    void khachHangTaoHD(int id);

    void khachHangThanhToanHD(int id);

}
