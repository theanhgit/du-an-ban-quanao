/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.sql.Date;
import java.util.List;
import viewmodel.SanPhamThongKe;
import viewmodel.SanPhamViewModel;

/**
 *
 * @author pc
 */
public interface SanPhamService {
    
    List<SanPhamViewModel> getAll();
    
    String getAdd(SanPhamViewModel sp);
    
    String getUpdate(SanPhamViewModel sp, int id);
    
    String getDelete(int id);
    
    Integer tongSp(Object id, int type);

    Integer tongSpTC();

    Integer tongSpDaBan(String ma, Date start, Date end, int type);

    Integer tongSpDaBanTC();

    List<SanPhamThongKe> sanPhamThongKe(String id, Date start, Date end, int type);

    List<SanPhamThongKe> sanPhamThongKeTC();

    Integer tinhDoanhThu(Date start, Date end);

    Integer tinhDoanhThu1(Date date);

    Integer tinhDoanhThu2(int month);
}
