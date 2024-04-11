/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.SanPhamModel;
import repository.SanPhamRepository;
import service.SanPhamService;
import viewmodel.SanPhamThongKe;
import viewmodel.SanPhamViewModel;

/**
 *
 * @author pc
 */
public class SanPhamServiceImpl implements SanPhamService{
     SanPhamRepository spRpo=new SanPhamRepository();
    
    @Override
    public List<SanPhamViewModel> getAll() {
        List<SanPhamModel> listAll=spRpo.getAll();
        List<SanPhamViewModel> listTable=new ArrayList<>();
        for (SanPhamModel sp : listAll) {
            listTable.add(new SanPhamViewModel(sp.getId(),sp.getMa(),sp.getTen(),sp.getLoaiSanPham(),sp.getSoLuong()));
        }
        return listTable;
    }

    @Override
    public String getAdd(SanPhamViewModel sp) {
        SanPhamModel sanPham=new SanPhamModel(sp.getId(),sp.getMa(),sp.getTen(),sp.getLoaiSanPham(),sp.getSoLuong());
        boolean them=spRpo.getAdd(sanPham);
        if(them){
            return "Them thanh cong";
        }else{
            return "Them that bat";
        }
    }

    @Override
    public String getUpdate(SanPhamViewModel sp, int id) {
        SanPhamModel sanPham=new SanPhamModel(sp.getId(),sp.getMa(),sp.getTen(),sp.getLoaiSanPham(),sp.getSoLuong());
        boolean sua=spRpo.getUpdate(sanPham,id);
        if(sua){
            return "Sua thanh cong";
        }else{
            return "Sua that bat";
        }
    }

    @Override
    public String getDelete(int id) {
        boolean xoa=spRpo.getDelete(id);
        if(xoa){
            return "Xoa thanh cong";
        }else{
            return "Xoa that bat";
        }
    }
    
     @Override
    public Integer tongSp(Object id, int type) {
        return spRpo.tongSp(id, type);
    }

    @Override
    public Integer tongSpDaBan(String ma, Date start, Date end, int type) {
        return spRpo.tongSpDaBan(ma, start, end, type);
    }

    @Override
    public List<SanPhamThongKe> sanPhamThongKe(String ma, Date start, Date end, int type) {
        return spRpo.sanPhamThongKe(ma, start, end, type);
    }

    @Override
    public Integer tinhDoanhThu(Date start, Date end) {
        return spRpo.tinhDoanhThu(start, end);
    }

    @Override
    public Integer tinhDoanhThu1(Date date) {
        return spRpo.tinhDoanhThu1(date);
    }

    @Override
    public Integer tinhDoanhThu2(int month) {
        return spRpo.tinhDoanhThu2(month);
    }

    @Override
    public List<SanPhamThongKe> sanPhamThongKeTC() {
        return spRpo.sanPhamThongKeTC();

    }

    @Override
    public Integer tongSpTC() {
        return spRpo.tongSpTC();

    }

    @Override
    public Integer tongSpDaBanTC() {
        return spRpo.tongSpDaBanTC();

    }

}
