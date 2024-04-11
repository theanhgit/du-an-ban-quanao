/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.HDModel;
import repository.HDRepository;
import service.HDService;
import viewmodel.HDViewModel;

/**
 *
 * @author pc
 */
public class HDServiceImpl implements HDService{

    HDRepository hdRepo=new HDRepository();
    
    @Override
    public List<HDViewModel> getAll() {
        List<HDModel> list=hdRepo.getAll();
        List<HDViewModel> listAll=new ArrayList<>();
        for (HDModel hd : list) {
            listAll.add(new HDViewModel(hd.getId(),hd.getMa(),hd.getIdNV(),hd.getIdKH(),hd.getMaPGG(),hd.getNgayTao(),hd.getNgayThanhToan(),hd.getTienGiam(),hd.getTongTien(),hd.getTienKhachDua(),hd.getTienThua(),hd.getTienKhachPhaiTra(),hd.getHinhThucThanhToan(),hd.getMaChuyenKhoan(),hd.getTrangThai()));
            
        }
        return listAll;
    }

    @Override
    public String getAdd(HDViewModel hd) {
        HDModel hdAdd=new HDModel(hd.getId(),hd.getMa(),hd.getIdNV(),hd.getIdKH(),hd.getMaPGG(),hd.getNgayTao(),hd.getNgayThanhToan(),hd.getTienGiam(),hd.getTongTien(),hd.getTienKhachDua(),hd.getTienThua(),hd.getTienKhachPhaiTra(),hd.getHinhThucThanhToan(),hd.getMaChuyenKhoan(),hd.getTrangThai());
        boolean add=hdRepo.getAdd(hdAdd);
        if(add){
            return "Thanh cong";
        }else {
            return"That bai";
        }
    }

    @Override
    public String getUpdate(HDViewModel hd, int id) {
        HDModel hdAdd=new HDModel(hd.getId(),hd.getMa(),hd.getIdNV(),hd.getIdKH(),hd.getMaPGG(),hd.getNgayTao(),hd.getNgayThanhToan(),hd.getTienGiam(),hd.getTongTien(),hd.getTienKhachDua(),hd.getTienThua(),hd.getTienKhachPhaiTra(),hd.getHinhThucThanhToan(),hd.getMaChuyenKhoan(),hd.getTrangThai());
        boolean add=hdRepo.getUpdate(hdAdd,id);
        if(add){
            return "Thanh cong";
        }else {
            return"That bai";
        }
    }

    @Override
    public String getDelete(int id) {
        boolean add=hdRepo.getDelete(id);
        if(add){
            return "Thanh cong";
        }else {
            return"That bai";
        }
    }

    @Override
    public String getThanhToan(HDViewModel hd, int id) {
        HDModel hdAdd=new HDModel(hd.getId(),hd.getMa(),hd.getIdNV(),hd.getIdKH(),hd.getMaPGG(),hd.getNgayTao(),hd.getNgayThanhToan(),hd.getTienGiam(),hd.getTongTien(),hd.getTienKhachDua(),hd.getTienThua(),hd.getTienKhachPhaiTra(),hd.getHinhThucThanhToan(),hd.getMaChuyenKhoan(),hd.getTrangThai());
        boolean thanhToan=hdRepo.getThanhToan(hdAdd,id);
        if(thanhToan){
            return "Thanh toán thành công";
        }else {
            return"That bai";
        }
    }
    
}
