/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import repository.NhanVienRepository;
import repository.NhanVienVMRepository;
import viewmodel.NhanVienVM;

/**
 *
 * @author User
 */
public class NhanVienVMService {
    
    private final NhanVienVMRepository nhanVienVMRepository;
    
    public NhanVienVMService() {
        this.nhanVienVMRepository = new NhanVienVMRepository();
    }
    
    public List<NhanVienVM> getAllNVVM() {
        return nhanVienVMRepository.getAllNVVM();
    }
    public List<NhanVienVM> getAllNVByTrangThai() {
        return nhanVienVMRepository.getAllNVByTrangThai();
    }

    public Integer addNhanVienVM(NhanVienVM nvvm) {
        return nhanVienVMRepository.addNhanVienVM(nvvm);
    }
    public Integer updateNhanVienVM(NhanVienVM nvvm) {
        return nhanVienVMRepository.updateNhanVienVM(nvvm);
    }

    public List<NhanVienVM> timKiemByTen(String tennv) {
        return nhanVienVMRepository.timKiemByTen(tennv);
    }

    public Integer voHieuHoaNhanVienVM(NhanVienVM nvvm) {
        return nhanVienVMRepository.voHieuHoaNhanVienVM(nvvm);
    }
    
    public List<NhanVienVM> locChucVu(int chucvu) {
        return nhanVienVMRepository.locChucVu(chucvu);
    }

    public List<NhanVienVM> locTrangThai(int trangThai) {
        return nhanVienVMRepository.locTrangThai(trangThai);
    }
      public List<NhanVienVM> locNhanVien(int chucVu, int trangThai) {
          return nhanVienVMRepository.locNhanVien(chucVu, trangThai);
      }
}
