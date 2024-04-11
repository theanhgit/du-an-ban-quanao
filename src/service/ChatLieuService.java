/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.ChatLieuViewModel;

/**
 *
 * @author pc
 */
public interface ChatLieuService {
    
    List<ChatLieuViewModel> getAll();
    
    String getAdd(ChatLieuViewModel cl);
    
    String getUpdate(ChatLieuViewModel cl,int id);
    
    String getDelete(int id);
}
