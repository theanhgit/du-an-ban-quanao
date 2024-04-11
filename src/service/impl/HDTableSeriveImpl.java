/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.HDTableModel;
import repository.HDTableRepository;
import service.HDTableService;
import viewmodel.HDTableVIewModel;

/**
 *
 * @author pc
 */
public class HDTableSeriveImpl implements HDTableService{

    HDTableRepository HDRepo=new HDTableRepository();
    
    @Override
    public List<HDTableVIewModel> getAll() {
        List<HDTableModel> getAll=HDRepo.getAll();
        List<HDTableVIewModel> getTable=new ArrayList<>();
        for (HDTableModel hd : getAll) {
            getTable.add(new HDTableVIewModel(hd.getId(),hd.getMa(),hd.getTenNhanVien(), hd.getTenKhachHang(),hd.getMaPGG(),hd.getNgayTao(),hd.getNgayThanhToan(),hd.getTienGiam(),hd.getTongTien(),hd.getTienKhachDua(),hd.getTienThua(),hd.getTienKhachPhaiTra(),hd.getHinhThucThanhToan(),hd.getMaChuyenKhoan(),hd.getTrangThai()));
        }
        return getTable;
    }
    
}
