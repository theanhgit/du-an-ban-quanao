/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.Date;
import java.util.List;
import model.HoaDonDomain;

public interface HoaDonRepo {
    List<HoaDonDomain> getall();
    boolean add(HoaDonDomain hd);
    boolean update(int id, HoaDonDomain hd);
    boolean delete(int  hd);
    HoaDonDomain findByMa(String ma);
    List<HoaDonDomain> searchByDate(Date start, Date end, int type);
}
