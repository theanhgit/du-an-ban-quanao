/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.ArrayList;
import model.NhanVien;
import repository.NhanVienRepository;
import service.NhanVienService;
import viewmodel.QLNhanVien;

/**
 *
 * @author adm
 */
public class NhanVienServiceImpl implements NhanVienService{

    NhanVienRepository repository;
    
    public NhanVienServiceImpl(){
        this.repository = new NhanVienRepository();
    }
    @Override
    public ArrayList<QLNhanVien> getList() {
       return repository.getListFromDB();
    }

    @Override
    public Boolean Them(NhanVien nhanVien) {
        return repository.Them(nhanVien);
    }

    @Override
    public Boolean Xoa(int id) {
        return repository.Xoa(id);
    }

    @Override
    public Boolean Sua(int id, NhanVien nhanVien) {
        return repository.Sua(id, nhanVien);
    }

    @Override
    public ArrayList<QLNhanVien> TimKiem(String name) {
        return repository.TimKiemTheoMa(name);
    }
    
}
