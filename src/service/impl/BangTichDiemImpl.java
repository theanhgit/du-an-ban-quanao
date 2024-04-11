/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.ArrayList;
import model.BangTichDiem;
import repository.BangTichDiemRepository;
import service.BangTichDiemService;
import viewmodel.QLBangTichDiem;

/**
 *
 * @author adm
 */
public class BangTichDiemImpl implements BangTichDiemService{

    BangTichDiemRepository repository;
    
    public BangTichDiemImpl(){
        this.repository = new BangTichDiemRepository();
    }
    @Override
    public ArrayList<QLBangTichDiem> getList() {
        return repository.getListFromDB();
    }

    @Override
    public Boolean Them(BangTichDiem bangTichDiem) {
        return repository.Them(bangTichDiem);
    }

    @Override
    public Boolean Xoa(int id) {
        return repository.Xoa(id);
    }

    @Override
    public Boolean Sua(int id, BangTichDiem bangTichDiem) {
       return repository.Sua(id, bangTichDiem);
    }

    @Override
    public ArrayList<QLBangTichDiem> TimKiem(int idKH) {
        return repository.TimTheoIDKH(idKH);
    }

    @Override
    public Boolean getUpdateBangDiem(int id, QLBangTichDiem bangTichDiem) {
        return repository.updateBangDIem(id, bangTichDiem);
    }

    
}
