/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.ThuongHieuViewModel;

/**
 *
 * @author pc
 */
public interface ThuongHieuService {
    
    List<ThuongHieuViewModel> getAll();
    
    String getAdd(ThuongHieuViewModel th);
    
    String getUpdate(ThuongHieuViewModel th,int id);
    
    String getDelet(int id);
}
