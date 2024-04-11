/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import viewmodel.HoaDonCTView;
import viewmodel.SanPhamHDViewModel;

/**
 *
 * @author Tus
 */
public interface IHoaDonCTService {
    List<HoaDonCTView> getAll();
    boolean add(HoaDonCTView hd);
    boolean update(int id, HoaDonCTView hd);
    boolean delete(int id);
    List<SanPhamHDViewModel> getByHdId(int idHd);
}
