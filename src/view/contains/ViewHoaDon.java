/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.contains;


import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.HDTableModel;
import model.HoaDonDomain;
import service.HDTableService;
import service.IHoaDonCTService;
import service.IHoaDonService;
import service.impl.HDTableSeriveImpl;
import service.impl.HoaDonCTService;
import service.impl.HoaDonService;
import utility.WriteExcel;
import viewmodel.HDTableVIewModel;
import viewmodel.HoaDonView;
import viewmodel.SanPhamHDViewModel;
/**
 *
 * @author pc
 */
public class ViewHoaDon extends javax.swing.JPanel {

    private IHoaDonService iHoaDonService = new HoaDonService();
    
    private IHoaDonCTService iHoaDonCTService = new HoaDonCTService();
    
    private List<HoaDonView> hoaDonViews = new ArrayList<>();
    
    private List<HoaDonDomain> hoaDonDomains = new ArrayList<>();
    
    
    private List<SanPhamHDViewModel> chiTiet = null;
    
    private HoaDonDomain hoaDonDomain = null;
    
    //me
    private List<HDTableVIewModel> listHDTable=new ArrayList<>();
    
    private List<HDTableVIewModel> listChiTietHD=new ArrayList<>();
    HDTableVIewModel hdct=new HDTableVIewModel();
    
    private HDTableService serviceHDTable=new HDTableSeriveImpl();
    
    private HDTableVIewModel hdTable=new HDTableVIewModel();
    
    //me
    private DefaultTableModel dtmTable=new DefaultTableModel();
    
    /**
     * Creates new form ViewHoaDon
     */
    public ViewHoaDon() {
        initComponents();
        listHDTable=serviceHDTable.getAll();
        dtmTable=(DefaultTableModel) this.tblHoaDon.getModel();
        loadTable(iHoaDonService.getall());
        showDataTable(listHDTable);
        ClickRow();
    }
    //me
    private void showDataTable(List<HDTableVIewModel> listTable){
        dtmTable.setRowCount(0);
        for (HDTableVIewModel hDTableVIewModel : listTable) {
            dtmTable.addRow(hDTableVIewModel.toRowData());
        }
    }
    
    private HDTableVIewModel getHDTable(int index){
//        HDTableVIewModel hdTable=listHDTable.get(index);
//        return hdTable;
if (index >= 0 && index < listHDTable.size()) {
        HDTableVIewModel hdTable = listHDTable.get(index);
        return hdTable;
    } else {
        // Trả về giá trị mặc định hoặc thực hiện xử lý khác tùy thuộc vào yêu cầu của bạn.
        return null;
    }
    }
    //me
    
    public void loadTable(List<HoaDonView> list){
        hoaDonViews = list;
        int rowCount = tblHoaDon.getModel().getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) tblHoaDon.getModel()).removeRow(i);
        }
        for (HoaDonView p : list) {
            ((DefaultTableModel) tblHoaDon.getModel()).addRow(new Object[]{p.getMa(),
            p.getNgayTao(), p.getNgayThanhToan(), p.getTongTien(), p.getTienGiam(), p.getTongTien()-p.getTienGiam(), p.getTrangThai()});
        }
        tblHoaDon.setRowHeight(25);
        hoaDonDomains.clear();
        for (HoaDonView x: list){
          HoaDonDomain hoaDonDomain = new HoaDonDomain(x.getId(),x.getMa(),x.getIdNV(),x.getIdKH(),x.getMaPGG(),x.getNgayTao(),x.getNgayThanhToan(),x.getTienGiam(),x.getTongTien(),x.getTienKhachDua(),x.getTienThua(),x.getTienTraTruoc(),x.getHinhThucThanhToan(),x.getMaChuyenKhoan(),x.getTienChuyenKhoan());
          hoaDonDomain.setTrangThai(x.getTrangThai());
            
          hoaDonDomains.add(hoaDonDomain);
        }
    }
    
     public void loadTableCTHD(List<SanPhamHDViewModel> list){
        int rowCount = tblGioHang.getModel().getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) tblGioHang.getModel()).removeRow(i);
        }
        for (SanPhamHDViewModel p : list) {
            ((DefaultTableModel) tblGioHang.getModel()).addRow(new Object[]{p.getTenSp(), p.getKichCo(),p.getSoLuong(), p.getDonGia()});
        }
        tblGioHang.setRowHeight(25);
    }
    
    public void ClickRow() {
        tblHoaDon.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
                    int id=0;
                    String maHD=null;
                    String ma = table.getValueAt(table.getSelectedRow(), 0).toString();
                    for (HoaDonView hoaDonView : hoaDonViews) {
                        if(hoaDonView.getMa().trim().equals(ma)){
                            id=hoaDonView.getId();
                            maHD=hoaDonView.getMa();
                        }
                    }
                    HoaDonView x = iHoaDonService.findById(maHD);
                    hoaDonDomain = new HoaDonDomain(x.getId(),x.getMa(),x.getIdNV(),x.getIdKH(),x.getMaPGG(),x.getNgayTao(),x.getNgayThanhToan(),x.getTienGiam(),x.getTongTien(),x.getTienKhachDua(),x.getTienThua(),x.getTienTraTruoc(),x.getHinhThucThanhToan(),x.getMaChuyenKhoan(),x.getTienChuyenKhoan());
                    hoaDonDomain.setTrangThai(x.getTrangThai());
                    System.out.println(id);
                    loadTableCTHD(iHoaDonCTService.getByHdId(Integer.valueOf(id)));
                    chiTiet = iHoaDonCTService.getByHdId(Integer.valueOf(id));
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplPhieuDoi = new javax.swing.JPanel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        xemHoaDonChiTiet = new javax.swing.JMenuItem();
        jdlChiTietHoaDon = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jlbTenNV = new javax.swing.JLabel();
        jlbMaHD = new javax.swing.JLabel();
        jlbTenKH = new javax.swing.JLabel();
        jlbMaPGG = new javax.swing.JLabel();
        jlbTienGiam = new javax.swing.JLabel();
        jlbHTTT = new javax.swing.JLabel();
        jlbTongTien = new javax.swing.JLabel();
        jlbNgayTT = new javax.swing.JLabel();
        jlbNgayTao = new javax.swing.JLabel();
        jlbMaCK = new javax.swing.JLabel();
        jlbTienThua = new javax.swing.JLabel();
        jlbTienKPT = new javax.swing.JLabel();
        jlbTienKD = new javax.swing.JLabel();
        jlbTrangThai = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ngayTao = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        starlDate = new com.toedter.calendar.JDateChooser();
        endDate = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        javax.swing.GroupLayout jplPhieuDoiLayout = new javax.swing.GroupLayout(jplPhieuDoi);
        jplPhieuDoi.setLayout(jplPhieuDoiLayout);
        jplPhieuDoiLayout.setHorizontalGroup(
            jplPhieuDoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );
        jplPhieuDoiLayout.setVerticalGroup(
            jplPhieuDoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
        );

        xemHoaDonChiTiet.setText("Xem chi tiết hóa đơn");
        xemHoaDonChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemHoaDonChiTietActionPerformed(evt);
            }
        });
        jPopupMenu1.add(xemHoaDonChiTiet);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Hình thức TT: ");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Tiền khách phải trả :");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Trạng thái hóa đơn :");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Ngày tạo :");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Ngày thanh toán :");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Tổng tiền :");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Tiền giảm :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Mã :");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Mã chuyển khoản :");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Tên NV :");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Tiền khách đưa :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Tên KH :");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Tiền thừa :");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("MaPGG :");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 51));
        jLabel27.setText("Hóa đơn");

        jlbTenNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTenNV.setText("TenNV");

        jlbMaHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbMaHD.setText("Ma");

        jlbTenKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTenKH.setText("TenKH");

        jlbMaPGG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbMaPGG.setText("MaPGG");

        jlbTienGiam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTienGiam.setText("TienGiam");

        jlbHTTT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbHTTT.setText("HTTT");

        jlbTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTongTien.setText("TongTien");

        jlbNgayTT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbNgayTT.setText("NgayTT");

        jlbNgayTao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbNgayTao.setText("NgayTao");

        jlbMaCK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbMaCK.setText("MaCK");

        jlbTienThua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTienThua.setText("TienThua");

        jlbTienKPT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTienKPT.setText("TienKPT");

        jlbTienKD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTienKD.setText("TienKD");

        jlbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTrangThai.setText("TrangTHD");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlbMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlbTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlbTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlbMaPGG, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)))
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlbNgayTT, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlbTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jlbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(jlbMaCK, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbTienKPT, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbTrangThai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbTienKD, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel18)
                    .addComponent(jlbMaHD)
                    .addComponent(jLabel13)
                    .addComponent(jlbNgayTao)
                    .addComponent(jlbTienKPT))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel25)
                    .addComponent(jLabel14)
                    .addComponent(jlbTenNV)
                    .addComponent(jlbNgayTT)
                    .addComponent(jlbTienKD))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel22)
                    .addComponent(jLabel26)
                    .addComponent(jlbTenKH)
                    .addComponent(jlbTongTien)
                    .addComponent(jlbTienThua))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel23)
                    .addComponent(jLabel19)
                    .addComponent(jlbMaPGG)
                    .addComponent(jlbTienGiam)
                    .addComponent(jlbTrangThai))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel24)
                    .addComponent(jlbHTTT)
                    .addComponent(jlbMaCK))
                .addGap(150, 150, 150))
        );

        javax.swing.GroupLayout jdlChiTietHoaDonLayout = new javax.swing.GroupLayout(jdlChiTietHoaDon.getContentPane());
        jdlChiTietHoaDon.getContentPane().setLayout(jdlChiTietHoaDonLayout);
        jdlChiTietHoaDonLayout.setHorizontalGroup(
            jdlChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdlChiTietHoaDonLayout.setVerticalGroup(
            jdlChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Sản phẩm trong hóa đơn");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        tblHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Ngày tạo", "Ngày TT", "Tổng tiền", "Tiền giảm", "Khách phải trả", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Lọc và tìm kiếm hóa đơn");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mã :");

        txt_ma.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_ma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_maMouseEntered(evt);
            }
        });
        txt_ma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Lọc theo ngày :");

        ngayTao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ngayTao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày tạo", "Ngày thanh toán" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Từ :");

        starlDate.setBackground(new java.awt.Color(255, 255, 255));
        starlDate.setDateFormatString("yyyy-MM-dd");

        endDate.setBackground(new java.awt.Color(255, 255, 255));
        endDate.setDateFormatString("yyyy-MM-dd");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Đến :");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search (1).png"))); // NOI18N
        jButton2.setText("Lọc");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 0, 0));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Hoàn tác");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ma)))
                .addGap(79, 79, 79)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(starlDate, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(starlDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Danh sách hóa đơn");

        tblGioHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Loại sản phẩm", "Kích cỡ ", "Số lượng ", "Đơn giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-microsoft-excel-30.png"))); // NOI18N
        jButton4.setText(" Lưu danh sách hóa đơn");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-microsoft-excel-30.png"))); // NOI18N
        jButton11.setText("Lưu danh sách sản phẩm trong HĐ");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("Chức năng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      //     ngayTao.get
        String txtma = txt_ma.getText();
        if(!txtma.equals("")){
            try {
                
                List<HoaDonView> list = new ArrayList<>();
//                List<HDTableVIewModel> listSearch=new ArrayList<>();
                list.add(iHoaDonService.findById(txtma));
//                for (HDTableVIewModel hDTableModel : listHDTable) {
//                    if(hDTableModel.getMa().trim().equals(txt_ma.getText())){
//                        listSearch.add(hDTableModel);
//                    }
//                }
//                showDataTable(listSearch);
                
                loadTable(list);
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(new JFrame(), "Mã hóa đơn phải là kiểu số", "Dialog", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            String nt = (String) ngayTao.getSelectedItem();
            Date start = Date.valueOf("1900-01-01");
            Date end = Date.valueOf("2500-01-01");
            if(starlDate.getDate() != null && endDate.getDate() != null){
                start = new Date(starlDate.getDate().getTime());
                end = new Date(endDate.getDate().getTime());
            }
            if(nt.equals("Ngày tạo")){
                loadTable(iHoaDonService.searchByDate(start, end, 0));
            }
            else if(nt.equals("Ngày thanh toán")){
                loadTable(iHoaDonService.searchByDate(start, end, 1));
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (hoaDonDomains.size() == 0) 
        {
            JOptionPane.showMessageDialog(new JFrame(), "Không có hóa đơn nào!", "Dialog", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Lưu file");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xlsx");
        chooser.setFileFilter(filter);

        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
                String duongDan = chooser.getSelectedFile().toString();

                try {
                    WriteExcel.writeExcel(listHDTable, duongDan + "/listHD.xlsx");
                    JOptionPane.showMessageDialog(new JFrame(), "Lưu file thành công!", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    e.printStackTrace(); // In ra chi tiết lỗi
                    JOptionPane.showMessageDialog(new JFrame(), "Lưu file thất bại!", "Dialog", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace(); // In ra chi tiết lỗi
                JOptionPane.showMessageDialog(new JFrame(), "Đã có lỗi xảy ra!", "Dialog", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
//        loadTable(iHoaDonService.getall());
        listHDTable=serviceHDTable.getAll();
        showDataTable(listHDTable);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int index=tblHoaDon.getSelectedRow();
        hdTable=getHDTable(index);
        if(hdTable == null){
            JOptionPane.showMessageDialog(new JFrame(), "Hãy chọn 1 đơn hàng!", "Dialog", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("lưu file");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
                String duongDan = chooser.getSelectedFile().toString();
                try {
                    WriteExcel.writeChiTietExcel(hdTable, chiTiet, duongDan+"/listCTHD.xlsx");
                    JOptionPane.showMessageDialog(new JFrame(), "Lưu file thành công!", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(new JFrame(), "Lưu file thất bại!", "Dialog", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Đã có lỗi xảy ra!", "Dialog", JOptionPane.WARNING_MESSAGE);
            }

        }     
    }//GEN-LAST:event_jButton11ActionPerformed

    private void txt_maMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_maMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maMouseEntered

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int index=tblHoaDon.getSelectedRow();
        hdct=listHDTable.get(index);
        if (SwingUtilities.isRightMouseButton(evt)) {
            int row = tblHoaDon.rowAtPoint(evt.getPoint());
            if (row >= 0 && row < listHDTable.size()) {
                tblHoaDon.setRowSelectionInterval(row, row);
                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void xemHoaDonChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemHoaDonChiTietActionPerformed
        jdlChiTietHoaDon.setSize(772, 350);
        jdlChiTietHoaDon.setResizable(false);
        jdlChiTietHoaDon.setLocationRelativeTo(null);
        jdlChiTietHoaDon.setVisible(true);
        jlbMaHD.setText(hdct.getMa());
        jlbTenNV.setText(hdct.getTenNhanVien());
        jlbTenKH.setText(hdct.getTenKhachHang());
        jlbMaPGG.setText(hdct.getMaPGG());
        jlbHTTT.setText(hdct.getHinhThucThanhToan()==0?"Chuyển khoản":"Tiền mặt");
        jlbNgayTao.setText(String.valueOf(hdct.getNgayTao()));
        jlbNgayTT.setText(String.valueOf(hdct.getNgayThanhToan()));
        jlbTongTien.setText(String.valueOf(hdct.getTongTien()));
        jlbTienGiam.setText(String.valueOf(hdct.getTienGiam()));
        jlbMaCK.setText(hdct.getMaChuyenKhoan());
        jlbTienKPT.setText(String.valueOf(hdct.getTienKhachPhaiTra()));
        jlbTienKD.setText(String.valueOf(hdct.getTienKhachDua()));
        jlbTienThua.setText(String.valueOf(hdct.getTienThua()));
        jlbTrangThai.setText(hdct.getTrangThai().equals("1")?"Đã thanh toán":"Chưa thanh toán");
    }//GEN-LAST:event_xemHoaDonChiTietActionPerformed

    private void txt_maActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JDialog jdlChiTietHoaDon;
    private javax.swing.JLabel jlbHTTT;
    private javax.swing.JLabel jlbMaCK;
    private javax.swing.JLabel jlbMaHD;
    private javax.swing.JLabel jlbMaPGG;
    private javax.swing.JLabel jlbNgayTT;
    private javax.swing.JLabel jlbNgayTao;
    private javax.swing.JLabel jlbTenKH;
    private javax.swing.JLabel jlbTenNV;
    private javax.swing.JLabel jlbTienGiam;
    private javax.swing.JLabel jlbTienKD;
    private javax.swing.JLabel jlbTienKPT;
    private javax.swing.JLabel jlbTienThua;
    private javax.swing.JLabel jlbTongTien;
    private javax.swing.JLabel jlbTrangThai;
    private javax.swing.JPanel jplPhieuDoi;
    private javax.swing.JComboBox<String> ngayTao;
    private com.toedter.calendar.JDateChooser starlDate;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JMenuItem xemHoaDonChiTiet;
    // End of variables declaration//GEN-END:variables
}
