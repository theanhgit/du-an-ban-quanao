/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utility.JDBCHelper;
import viewmodel.PhieuGiamGiaVM;

/**
 *
 * @author User
 */
public class PhieuGiamGiaVMRepo {

    private List<PhieuGiamGiaVM> getPhieuGiamGiaFromResultSet(ResultSet rs) {
        List<PhieuGiamGiaVM> lst = new ArrayList<>();
        try {
            while (rs.next()) {
                String ma = rs.getString(2);
                String ten = rs.getString(3);
//            LocalDate ngaybatdau = rs.getTimestamp(4).toLocalDateTime().toLocalDate();
//            LocalDate ngayketthuc = rs.getTimestamp(5).toLocalDateTime().toLocalDate();
// Kiểm tra và chuyển đổi ngaybatdau
                LocalDate ngaybatdau = null;
                LocalDate ngayketthuc = null;

                // Kiểm tra và chuyển đổi ngaybatdau
                java.sql.Date ngaybatdauDate = rs.getDate(4);
                if (ngaybatdauDate != null) {
                    ngaybatdau = ngaybatdauDate.toLocalDate();
                }

                // Kiểm tra và chuyển đổi ngayketthuc
                java.sql.Date ngayketthucDate = rs.getDate(5);
                if (ngayketthucDate != null) {
                    ngayketthuc = ngayketthucDate.toLocalDate();
                }

                int luotsudung = rs.getInt(6);
                String dieukhoan = rs.getString(7);
                long giatri = rs.getLong(8);
                int trangthai = rs.getInt(9);
                lst.add(new PhieuGiamGiaVM(ma, ten, ngaybatdau, ngayketthuc, luotsudung, dieukhoan, giatri, trangthai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<PhieuGiamGiaVM> getAllPGGVM() {
        String sql = "Select*from PHIEU_GIAM_GIA_CHI_TIET";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        return getPhieuGiamGiaFromResultSet(rs);
    }

    public Integer addPGGVM(PhieuGiamGiaVM pggvm) {
        String sql = "insert into PHIEU_GIAM_GIA_CHI_TIET values(?,?,?,?,?,?,?,?)";
        Integer row = JDBCHelper.excuteUpdate(sql, pggvm.getMa(), pggvm.getTen(), pggvm.getNgaybatdau(), pggvm.getNgayketthuc(), pggvm.getLuotsudung(), pggvm.getDieukhoan(), pggvm.getGiatri(), pggvm.getTrangthai());
        return row;
    }

    public Integer updatePGGVM(PhieuGiamGiaVM pggvm) {
        String sql = "update PHIEU_GIAM_GIA_CHI_TIET set  ma = ? , ten = ?, ngaybatdau = ?, ngayketthuc = ?, luotsudung = ?, dieukhoan = ?, giatri = ?, trangthai = ? where ma = ?";
        Integer row = JDBCHelper.excuteUpdate(sql, pggvm.getMa(), pggvm.getTen(), pggvm.getNgaybatdau(), pggvm.getNgayketthuc(), pggvm.getLuotsudung(), pggvm.getDieukhoan(), pggvm.getGiatri(), pggvm.getTrangthai(), pggvm.getMa());
        return row;
    }

    public Integer voHieuHoaPGGVM(PhieuGiamGiaVM pggvm) {
        String sql = "update PHIEU_GIAM_GIA_CHI_TIET set  trangthai = ? where ma = ?";
        Integer row = JDBCHelper.excuteUpdate(sql, pggvm.getTrangthai(), pggvm.getMa());
        return row;
    }

    public Integer voHieuHoaPGGVMHetHan() {
        String sql = "update PHIEU_GIAM_GIA_CHI_TIET set  trangthai = 0 where ngayketthuc< getDate() ";
        Integer row = JDBCHelper.excuteUpdate(sql);
        return row;
    }

    public Integer deletePGGVM(int PhieuGiamGiaVM_ID) {
        String sql = "delete PHIEU_GIAM_GIA_CHI_TIET where ID = ?";
        Integer row = JDBCHelper.excuteUpdate(sql, PhieuGiamGiaVM_ID);
        return row;
    }

    public List<PhieuGiamGiaVM> getByMa(String ma1) {
        String sql = " select*from PHIEU_GIAM_GIA_CHI_TIET "
                + "where ma like '%" + ma1 + "%'";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        return getPhieuGiamGiaFromResultSet(rs);
    }

    public List<PhieuGiamGiaVM> getByTen(String ten1) {
        String sql = " SELECT * FROM PHIEU_GIAM_GIA_CHI_TIET\n"
                + "WHERE TEN COLLATE Latin1_General_CI_AI LIKE N'%" + ten1 + "%'";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        return getPhieuGiamGiaFromResultSet(rs);
    }

    public List<PhieuGiamGiaVM> getSapDienRa() {
        String sql = "SELECT * FROM PHIEU_GIAM_GIA_CHI_TIET\n"
                + "WHERE GETDATE() < NGAYBATDAU;";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        return getPhieuGiamGiaFromResultSet(rs);
    }

    public List<PhieuGiamGiaVM> getDangDienRa() {
        String sql = " SELECT *\n"
                + "FROM PHIEU_GIAM_GIA_CHI_TIET\n"
                + "WHERE CONVERT(DATE, GETDATE()) BETWEEN CONVERT(DATE, ngayBatDau) AND CONVERT(DATE, ngayKetThuc);";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        return getPhieuGiamGiaFromResultSet(rs);
    }

    public List<PhieuGiamGiaVM> getDaKetThuc() {
        String sql = "SELECT *\n"
                + "FROM PHIEU_GIAM_GIA_CHI_TIET\n"
                + "WHERE CONVERT(DATE, GETDATE()) > CONVERT(DATE, NGAYKETTHUC);";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        return getPhieuGiamGiaFromResultSet(rs);
    }
}
