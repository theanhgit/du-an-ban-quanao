/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.GioHangModel;
import model.HDCTModel;
import repository.HDCTRepository;
import service.HDCTService;
import viewmodel.GioHangViewModel;
import viewmodel.HDCTViewModel;

/**
 *
 * @author pc
 */
public class HDCTVServiceIMpl implements HDCTService{

    HDCTRepository hdctRepo=new HDCTRepository();
    
    @Override
    public List<HDCTViewModel> getAll() {
        List<HDCTModel> list=hdctRepo.getAll();
        List<HDCTViewModel> listAl=new ArrayList<>();
        for (HDCTModel hdct : list) {
            listAl.add(new HDCTViewModel(hdct.getId(),hdct.getIdHD(),hdct.getIdSPCT(),hdct.getKichCo(),hdct.getSoLuong(),hdct.getDonGia()));
        }
        return listAl;
    }

    @Override
    public String getAdd(HDCTViewModel hdct) {
        HDCTModel hd=new HDCTModel(hdct.getId(),hdct.getIdHD(),hdct.getIdSPCT(),hdct.getKichCo(),hdct.getSoLuong(),hdct.getDonGia());
        boolean them=hdctRepo.getAdd(hd);
        if(them){
            return "Thanh cong";
        }else {
            return "That bai";
        }
    }

    @Override
    public String getUpdate(HDCTViewModel hdct, int id) {
        HDCTModel hd=new HDCTModel(hdct.getId(),hdct.getIdHD(),hdct.getIdSPCT(),hdct.getKichCo(),hdct.getSoLuong(),hdct.getDonGia());
        boolean them=hdctRepo.getUpdate(hd,id);
        if(them){
            return "Thanh cong";
        }else {
            return "That bai";
        }
    }

    @Override
    public String getDelete(int id) {
        boolean them=hdctRepo.getDelete(id);
        if(them){
            return "Thanh cong";
        }else {
            return "That bai";
        }
    }

    @Override
    public List<GioHangViewModel> getGioHang() {
        List<GioHangModel> list=hdctRepo.getAllTable();
        List<GioHangViewModel> listAll=new ArrayList<>();
        for (GioHangModel gioHang : list) {
            listAll.add(new GioHangViewModel(gioHang.getId(),gioHang.getMaHD(),gioHang.getTenSp(),gioHang.getKichCo(),gioHang.getSoLuong(),gioHang.getDonGia()));
            
        }
        return listAll;
    }

    @Override
    public String getUpdateSoLuong(int id, int soLuong,Float donGia) {
        boolean sua= hdctRepo.getUpdateSoLuong(id, soLuong,donGia);
        if(sua){
            return "Thanh cong";
        }else {
            return "That bai";
        }
    }
    
}
