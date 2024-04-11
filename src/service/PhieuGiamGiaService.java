/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PhieuGiamGia;
import repository.PhieuGiamGiaRepo;
import utility.JDBCHelper;

/**
 *
 * @author User
 */
public class PhieuGiamGiaService {
    private final PhieuGiamGiaRepo phieuGiamGiaRepo;

    public PhieuGiamGiaService() {
        this.phieuGiamGiaRepo = new PhieuGiamGiaRepo();
    }
     public List<PhieuGiamGia> getAllPGG() {
       return phieuGiamGiaRepo.getAllPGG();
    }

    public Integer addPGG(PhieuGiamGia pgg) {
     return phieuGiamGiaRepo.addPGG(pgg);
    }

    public Integer updatePGG(PhieuGiamGia pgg) {
        return phieuGiamGiaRepo.updatePGG(pgg);
    }

    public Integer deletePGG(String PhieuGiamGiaID) {
        return phieuGiamGiaRepo.deletePGG(PhieuGiamGiaID);
    }

    
}
