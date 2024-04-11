/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import service.IHoaDonCTService;
import java.util.ArrayList;
import java.util.List;
import model.HoaDonCTDomain;
import repository.HoaDonCTRepository;
import viewmodel.HoaDonCTView;
import viewmodel.SanPhamHDViewModel;

/**
 *
 * @author Tus
 */
public class HoaDonCTService implements IHoaDonCTService {

    private HoaDonCTRepository rs = new HoaDonCTRepository();

    @Override
    public List<HoaDonCTView> getAll() {
        List<HoaDonCTView> hdc = new ArrayList<>();
        List<HoaDonCTDomain> list = this.rs.getall();
        for (HoaDonCTDomain x : list) {
            HoaDonCTView hoaDonCTView = new HoaDonCTView(x.getId(), x.getIdHD(), x.getIdSPCT(), x.getSoluong(), x.getDonGia());
            hdc.add(hoaDonCTView);
        }
        return hdc;
    }

    @Override
    public boolean add(HoaDonCTView hd) {
        HoaDonCTDomain domain = new HoaDonCTDomain(hd.getId(), hd.getIdHD(), hd.getIdSPCT(), hd.getSoluong(), hd.getDonGia());
        return this.rs.add(domain);
    }

    @Override
    public boolean update(int id, HoaDonCTView hd) {
        HoaDonCTDomain domain = new HoaDonCTDomain(hd.getId(), hd.getIdHD(), hd.getIdSPCT(), hd.getSoluong(), hd.getDonGia());
        return this.rs.update(id, domain);
    }

    @Override
    public boolean delete(int id) {
        return this.rs.delete(id);
    }

    @Override
    public List<SanPhamHDViewModel> getByHdId(int idHd) {
        return rs.getByHdId(idHd);
    }

}
