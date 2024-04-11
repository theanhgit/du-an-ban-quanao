/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.ThuongHieuModel;
import repository.ThuongHieuRepository;
import service.ThuongHieuService;
import viewmodel.ThuongHieuViewModel;

/**
 *
 * @author pc
 */
public class ThuongHieuServiceImpl implements ThuongHieuService{

    ThuongHieuRepository thRepo=new ThuongHieuRepository();
    @Override
    public List<ThuongHieuViewModel> getAll() {
    List<ThuongHieuModel> listAll = thRepo.getAll();
        List<ThuongHieuViewModel> listTable = new ArrayList<>();
        for (ThuongHieuModel th : listAll) {
            listTable.add(new ThuongHieuViewModel(th.getId(), th.getMa(), th.getTen()));
        }
        return listTable;
    }

    @Override
    public String getAdd(ThuongHieuViewModel th) {
        ThuongHieuModel thmd=new ThuongHieuModel(th.getId(), th.getMa(), th.getTen());
        boolean them=thRepo.getAdd(thmd);
        if(them){
            return"Them thanh cong";
        }else{
            return "Them that bai";
        }
    }

    @Override
    public String getUpdate(ThuongHieuViewModel th, int id) {
        ThuongHieuModel thmd=new ThuongHieuModel(th.getId(), th.getMa(), th.getTen());
        boolean sua=thRepo.getUpdate(thmd,id);
        if(sua){
            return"Sua thanh cong";
        }else{
            return "Sua that bai";
        }
    }

    @Override
    public String getDelet(int id) {
        boolean xoa=thRepo.getDelete(id);
        if(xoa){
            return"Xoa thanh cong";
        }else{
            return "Xoa that bai";
        }
    }
    
}
