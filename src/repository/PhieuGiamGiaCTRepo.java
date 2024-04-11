/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import utility.DBConnect;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.PGGModel;
import model.PhieuGiamGiaCT;
import utility.JDBCHelper;

/**
 *
 * @author User
 */
public class PhieuGiamGiaCTRepo {

    public List<PhieuGiamGiaCT> getAllPGGCT() {
        List<PhieuGiamGiaCT> lst = new ArrayList<>();
        String sql = "Select*from PHIEU_GIAM_GIA_CHI_TIET";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String ID = rs.getString(1);
                String ID_PGG = rs.getString(2);
                String MA = rs.getString(3);
                Date NGAYBATDAU = rs.getTimestamp(4);
                Date NGAYKETTHUC = rs.getTimestamp(5);
                String LUOTSUDUNG = rs.getString(6);
                String DIEUKHOAN = rs.getString(7);
                String GIATRI = rs.getString(8);
                String TRANGTHAI = rs.getString(9);
                lst.add(new PhieuGiamGiaCT(ID, ID_PGG, MA, NGAYBATDAU, NGAYKETTHUC, LUOTSUDUNG, DIEUKHOAN, GIATRI, TRANGTHAI));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public Integer addPGGCT(PhieuGiamGiaCT pggct) {
        String sql = "insert into PHIEU_GIAM_GIA_CHI_TIET values(?,?,?,?,?,?,?,?)";
        Integer row = JDBCHelper.excuteUpdate(sql, pggct.getID_PGG(), pggct.getMA(), pggct.getNGAYBATDAU(), pggct.getNGAYKETTHUC(), pggct.getLUOTSUDUNG(), pggct.getDIEUKHOAN(), pggct.getGIATRI(), pggct.getTRANGTHAI());
        return row;
    }

    public Integer updatePGGCT(PhieuGiamGiaCT pggct) {
        String sql = "update PHIEU_GIAM_GIA_CHI_TIET set  ID_PGG = ? , MA = ?, NGAYBATDAU = ?, NGAYKETTHUC = ?, LUOTSUDUNG = ?, DIEUKHOAN = ?, GIATRI = ?, TRANGTHAI = ? where ID = ?";
        Integer row = JDBCHelper.excuteUpdate(sql, pggct.getID_PGG(), pggct.getMA(), pggct.getNGAYBATDAU(), pggct.getNGAYKETTHUC(), pggct.getLUOTSUDUNG(), pggct.getDIEUKHOAN(), pggct.getGIATRI(), pggct.getTRANGTHAI(), pggct.getID());
        return row;
    }

    public Integer deletePGGCT(String PhieuGiamGiaCT_ID) {
        String sql = "delete PHIEU_GIAM_GIA_CHI_TIET where ID = ?";
        Integer row = JDBCHelper.excuteUpdate(sql, PhieuGiamGiaCT_ID);
        return row;
    }

    public List<PhieuGiamGiaCT> getByMa(String ma) {
        List<PhieuGiamGiaCT> lst = new ArrayList<>();
        String sql = " select*from PHIEU_GIAM_GIA_CHI_TIET "
                + "where ma like '%" + ma + "%'";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String ID = rs.getString(1);
                String ID_PGG = rs.getString(2);
                String MA = rs.getString(3);
                Date NGAYBATDAU = rs.getTimestamp(4);
                Date NGAYKETTHUC = rs.getTimestamp(5);
                String LUOTSUDUNG = rs.getString(6);
                String DIEUKHOAN = rs.getString(7);
                String GIATRI = rs.getString(8);
                String TRANGTHAI = rs.getString(9);
                lst.add(new PhieuGiamGiaCT(ID, ID_PGG, MA, NGAYBATDAU, NGAYKETTHUC, LUOTSUDUNG, DIEUKHOAN, GIATRI, TRANGTHAI));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<PhieuGiamGiaCT> getByGiaTri(String giaTri) {
        List<PhieuGiamGiaCT> lst = new ArrayList<>();
        String sql = " select*from PHIEU_GIAM_GIA_CHI_TIET "
                + "where GIATRI like '%" + giaTri + "%'";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String ID = rs.getString(1);
                String ID_PGG = rs.getString(2);
                String MA = rs.getString(3);
                Date NGAYBATDAU = rs.getTimestamp(4);
                Date NGAYKETTHUC = rs.getTimestamp(5);
                String LUOTSUDUNG = rs.getString(6);
                String DIEUKHOAN = rs.getString(7);
                String GIATRI = rs.getString(8);
                String TRANGTHAI = rs.getString(9);
                lst.add(new PhieuGiamGiaCT(ID, ID_PGG, MA, NGAYBATDAU, NGAYKETTHUC, LUOTSUDUNG, DIEUKHOAN, GIATRI, TRANGTHAI));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<PGGModel> getLayMaGGHD() {
        List<PGGModel> listPGG = new ArrayList<>();
        String qery = """
                    SELECT [ID]
                          ,[MA]
                          ,[TEN]
                          ,[NGAYBATDAU]
                          ,[NGAYKETTHUC]
                          ,[LUOTSUDUNG]
                          ,[DIEUKHOAN]
                          ,[GIATRI]
                          ,[TRANGTHAI]
                      FROM [dbo].[PHIEU_GIAM_GIA_CHI_TIET]
                    WHERE GETDATE() Between [NGAYBATDAU] and [NGAYKETTHUC]
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {

            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                PGGModel pgg = new PGGModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
                listPGG.add(pgg);
            }
            return listPGG;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }

    public boolean getUpdateSoLuongPGGKhiTT(int id) {
        int check = 0;
        String qery = """
                    UPDATE [dbo].[PHIEU_GIAM_GIA_CHI_TIET]
                       SET [LUOTSUDUNG] = [LUOTSUDUNG]-1
                          
                     WHERE ID=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, id);
            check=pr.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check>0;
    }

//    public static void main(String[] args) {
//       List<PhieuGiamGiaCT> pggctList = getAllPGGCT();
//        
//        // In thông tin từ danh sách PhieuGiamGiaCT
//        for (PhieuGiamGiaCT pggct : pggctList) {
//            System.out.println(pggct.getID());
//            System.out.println(pggct.getID_PGG());
//            System.out.println(pggct.getMA());
//            System.out.println(pggct.getNGAYBATDAU());
//            System.out.println(pggct.getNGAYKETTHUC());
//            System.out.println(pggct.getLUOTSUDUNG());
//            System.out.println(pggct.getDIEUKHOAN());
//            System.out.println(pggct.getGIATRI());
//            System.out.println(pggct.getTRANGTHAI());
//            System.out.println("--------------------------");
//        }
//    }
}
