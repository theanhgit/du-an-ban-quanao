/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PhieuGiamGia;
import utility.JDBCHelper;

/**
 *
 * @author User
 */
public class PhieuGiamGiaRepo {
     public List<PhieuGiamGia> getAllPGG() {
        List<PhieuGiamGia> lst = new ArrayList<>();
        String sql = "Select*from Phieu_Giam_Gia";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                lst.add(new PhieuGiamGia(id, ma, ten));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public Integer addPGG(PhieuGiamGia pgg) {
        String sql = "insert into Phieu_Giam_Gia values(?,?)";
        Integer row = JDBCHelper.excuteUpdate(sql, pgg.getMa(), pgg.getTen());
        return row;
    }

    public Integer updatePGG(PhieuGiamGia pgg) {
        String sql = "update Phieu_Giam_Gia set  MA = ? , TEN = ? where ID = ?";
        Integer row = JDBCHelper.excuteUpdate(sql,  pgg.getMa(), pgg.getTen(),pgg.getId());
        return row;
    }

    public Integer deletePGG(String PhieuGiamGiaID) {
        String sql = "delete Phieu_Giam_Gia where ID = ?";
        Integer row = JDBCHelper.excuteUpdate(sql, PhieuGiamGiaID);
        return row;
    }
}
