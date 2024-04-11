/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.ArrayList;
import model.TaiKhoan;
import repository.TaiKhoanRepository;
import service.TaiKhoanService;
import viewmodel.QLTaiKhoan;

/**
 *
 * @author adm
 */
public class TaiKhoanServiceImpl implements TaiKhoanService{

    TaiKhoanRepository repository;
    
    public TaiKhoanServiceImpl(){
        this.repository = new TaiKhoanRepository();
    }
    @Override
    public ArrayList<QLTaiKhoan> getList() {
        return repository.getListFromDB();
    }

    @Override
    public Boolean Them(TaiKhoan taiKhoan) {
        return repository.Them(taiKhoan);
    }

    @Override
    public Boolean Xoa(int id) {
       return repository.Xoa(id);
    }

    @Override
    public Boolean Sua(int id, TaiKhoan taiKhoan) {
        return repository.Sua(id, taiKhoan);
    }

   
    @Override
    public ArrayList<QLTaiKhoan> TimKiem(int idNV) {
        return repository.TimKiem(idNV);
    }
    
}
