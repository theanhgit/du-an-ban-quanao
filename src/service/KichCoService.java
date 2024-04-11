/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.KichCoViewModel;

/**
 *
 * @author pc
 */
public interface KichCoService {
    
    List<KichCoViewModel> getAll();
    
    String getAdd(KichCoViewModel kc);
    
    String getUpdate(KichCoViewModel kc,int id);
    
    String getDelete(int id);
}
