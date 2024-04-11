/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.HDViewModel;

/**
 *
 * @author pc
 */
public interface HDService {
    
    List<HDViewModel> getAll();
    
    String getAdd(HDViewModel hd);
    
    String getUpdate(HDViewModel hd,int id);
    
    String getDelete(int id);
    
    String getThanhToan(HDViewModel hd,int id);
    
}
