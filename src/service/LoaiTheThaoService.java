/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.LoaiTheThaoViewModel;

/**
 *
 * @author pc
 */
public interface LoaiTheThaoService {
    
    List<LoaiTheThaoViewModel> getAll();
    
    String getAdd(LoaiTheThaoViewModel ltt);
    
    String getUpdate(LoaiTheThaoViewModel ltt,int id);
    
    String getDelete(int id);
}
