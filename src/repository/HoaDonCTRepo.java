/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import model.HoaDonCTDomain;
import viewmodel.SanPhamHDViewModel;

/**
 *
 * @author Tus
 */
public interface HoaDonCTRepo {
    List<HoaDonCTDomain> getall();
    boolean add(HoaDonCTDomain ht);
    boolean update(int id, HoaDonCTDomain ht);
    boolean delete(int id);
    List<SanPhamHDViewModel> getByHdId(int idHd);
}
