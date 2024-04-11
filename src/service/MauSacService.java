/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.MauSacViewModel;

/**
 *
 * @author pc
 */
public interface MauSacService {
   
    List<MauSacViewModel> getAll();
    
    String getAdd(MauSacViewModel ms);
    
    String getUpdate(MauSacViewModel ms,int id);
    
    String getDelete(int id);
}
