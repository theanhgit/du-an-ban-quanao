/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Date;
import java.util.List;
import viewmodel.HDTableVIewModel;
import viewmodel.HoaDonView;

/**
 *
 * @author Tus
 */
public interface IHoaDonService {
    List<HoaDonView> getall();
    boolean add(HoaDonView hd);
    boolean update(int id, HoaDonView hd);
    boolean delete(int id_hd);
    HoaDonView findById(String ma);
    List<HoaDonView> searchByDate(Date start, Date end, int type);
    List<HDTableVIewModel> getAllTable();
}
