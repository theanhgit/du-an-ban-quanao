/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repository.PhieuGiamGiaVMRepo;
import utility.JDBCHelper;
import viewmodel.PhieuGiamGiaVM;

/**
 *
 * @author User
 */
public class PhieuGiamGiaVMService {

    private final PhieuGiamGiaVMRepo phieuGiamGiaVMRepo;

    public PhieuGiamGiaVMService() {
        this.phieuGiamGiaVMRepo = new PhieuGiamGiaVMRepo();
    }

    public List<PhieuGiamGiaVM> getAllPGGVM() {
        return phieuGiamGiaVMRepo.getAllPGGVM();
    }

    public Integer addPGGVM(PhieuGiamGiaVM pggvm) {
        return phieuGiamGiaVMRepo.addPGGVM(pggvm);
    }

    public Integer updatePGGVM(PhieuGiamGiaVM pggct) {
        return phieuGiamGiaVMRepo.updatePGGVM(pggct);
    }
    
    public Integer voHieuHoaPGGVM(PhieuGiamGiaVM pggvm) {
        return phieuGiamGiaVMRepo.voHieuHoaPGGVM(pggvm);
    }
    
    public Integer voHieuHoaPGGVMHetHan() {
        return phieuGiamGiaVMRepo.voHieuHoaPGGVMHetHan();
    }
    public Integer deletePGGVM(int PhieuGiamGiaVM_ID) {
        return phieuGiamGiaVMRepo.deletePGGVM(PhieuGiamGiaVM_ID);
    }

    public List<PhieuGiamGiaVM> getByMa(String ma) {
        return phieuGiamGiaVMRepo.getByMa(ma);
    }

    public List<PhieuGiamGiaVM> getByTen(String ten) {
        return phieuGiamGiaVMRepo.getByTen(ten);
    }

    public List<PhieuGiamGiaVM> getSapDienRa() {
        return phieuGiamGiaVMRepo.getSapDienRa();
    }

    public List<PhieuGiamGiaVM> getDangDienRa() {
        return phieuGiamGiaVMRepo.getDangDienRa();
    }

    public List<PhieuGiamGiaVM> getDaKetThuc() {
        return phieuGiamGiaVMRepo.getDaKetThuc();
    }
}
