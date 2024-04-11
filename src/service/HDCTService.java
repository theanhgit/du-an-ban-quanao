/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.GioHangViewModel;
import viewmodel.HDCTViewModel;

/**
 *
 * @author pc
 */
public interface HDCTService {
   
    List<HDCTViewModel> getAll();
    
    String getAdd(HDCTViewModel hdct);
    
    String getUpdate(HDCTViewModel hdct,int id);
    
    String getDelete(int id);
    
    List<GioHangViewModel> getGioHang();
    
    String getUpdateSoLuong(int id,int soLuong,Float donGia);
    
}
