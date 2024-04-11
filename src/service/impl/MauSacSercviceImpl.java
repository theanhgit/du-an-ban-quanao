/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.MauSacModel;
import repository.MauSacRepository;
import service.MauSacService;
import viewmodel.MauSacViewModel;

/**
 *
 * @author pc
 */
public class MauSacSercviceImpl implements MauSacService{

    MauSacRepository msRepo=new MauSacRepository();
    @Override
    public List<MauSacViewModel> getAll() {
        List<MauSacModel> listAll=msRepo.getAll();
        List<MauSacViewModel> listTable=new ArrayList<>();
        for (MauSacModel ms : listAll) {
            listTable.add(new MauSacViewModel(ms.getId(),ms.getMa(),ms.getTen()));
        }
        return listTable;
    }

    @Override
    public String getAdd(MauSacViewModel ms) {
        MauSacModel msmd=new MauSacModel(ms.getId(),ms.getMa(),ms.getTen());
        boolean them=msRepo.getAdd(msmd);
        if(them){
            return"Them thanh cong";
        }else {
            return "Them that bai";
        }
    }

    @Override
    public String getUpdate(MauSacViewModel ms, int id) {
        MauSacModel msmd=new MauSacModel(ms.getId(),ms.getMa(),ms.getTen());
        boolean sua=msRepo.getUpdate(msmd,id);
        if(sua){
            return"Sua thanh cong";
        }else {
            return "Sua that bai";
        }
    }

    @Override
    public String getDelete(int id) {
        boolean xoa=msRepo.getDelete(id);
        if(xoa){
            return"xoa thanh cong";
        }else {
            return "xoa that bai";
        }
    }
    
}
