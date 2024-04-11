/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.BangTichDiem;
import viewmodel.QLBangTichDiem;

/**
 *
 * @author adm
 */
public interface BangTichDiemService {
    
    public ArrayList<QLBangTichDiem> getList();
    
    public  Boolean Them(BangTichDiem bangTichDiem);
    
    public Boolean Xoa(int id);
    
    public Boolean Sua(int id, BangTichDiem bangTichDiem);
    
    public ArrayList<QLBangTichDiem> TimKiem(int idKH);
    
    public Boolean getUpdateBangDiem(int id, QLBangTichDiem bangTichDiem);
}
