/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import model.HDTableModel;
import model.HoaDonDomain;
import model.SanPhamChiTietModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.HDTableRepository;
import repository.HoaDonRepository;
import service.HDTableService;
import service.impl.HDTableSeriveImpl;
import viewmodel.HDTableVIewModel;
import viewmodel.SanPhamHDViewModel;
public class WriteExcel {
    public static final int COLUMN_INDEX_ID = 0;
    public static final int COLUMN_INDEX_MA = 1;
    public static final int COLUMN_INDEX_ID_NV = 2;
    public static final int COLUMN_INDEX_ID_KH = 3;
    public static final int COLUMN_INDEX_MAPGG = 4;
    public static final int COLUMN_INDEX_NGAY_TAO = 5;
    public static final int COLUMN_INDEX_NGAY_THANH_TOAN = 6;
    public static final int COLUMN_INDEX_TIEN_GIAM = 8;
    public static final int COLUMN_INDEX_TONG_TIEN = 7;
    public static final int COLUMN_INDEX_TIEN_KHACH_DUA = 10;
    public static final int COLUMN_INDEX_TIEN_THUA = 11;
    public static final int COLUMN_INDEX_TIEN_KHACH_PHAI_TRA = 9;
    public static final int COLUMN_INDEX_HINH_THUC_THANH_TOAN = 12;
    public static final int COLUMN_INDEX_MA_CHUYEN_KHOAN = 13;
    public static final int COLUMN_INDEX_TRANG_THAI = 14;
    public static final int COLUMN_INDEX_LOAISP = 0;
    public static final int COLUMN_INDEX_TENSP = 1;
    public static final int COLUMN_INDEX_KICHCO = 2;
    public static final int COLUMN_INDEX_SOLUONG = 3;
    public static final int COLUMN_INDEX_DONGIA = 4;
    private static CellStyle cellStyleFormatNumber = null; // lưu trữ 1 ô, màu sắc các thứ

    private HDTableService service=new HDTableSeriveImpl();
    private List<HDTableVIewModel> listHD=new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
         List<HDTableVIewModel> listHD=new HDTableSeriveImpl().getAll();
         String excelFilePath = "T:\\JAVA\\DuAn1"
                 + "bifone/tesExcel/listHD.xlsx";
        writeExcel(listHD, excelFilePath);
    }

    public static void writeExcel(List<HDTableVIewModel> list, String excelFilePath) throws IOException {
        Workbook workbook = getWorkbook(excelFilePath); 

        Sheet sheet = workbook.createSheet("ds hoa don"); 
        int rowIndex = 0;
        // Write header
        writeHeader(sheet, rowIndex);
        // Write data
        rowIndex++;
        for (HDTableVIewModel hd : list) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeHD(hd, row);
            rowIndex++;
        }
        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
        // Create file excel
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
    }
    
    
    public static void writeChiTietExcel(HDTableVIewModel hoaDon,List<SanPhamHDViewModel> chiTiet, String excelFilePath) throws IOException {
        Workbook workbook = getWorkbook(excelFilePath); 

        Sheet sheet = workbook.createSheet("chi tiết hoa don"); 
        int rowIndex = 0;
        
        writeHeader(sheet, rowIndex);
        rowIndex++;
        Row row = sheet.createRow(rowIndex);
        writeHD(hoaDon, row);
        
        rowIndex++;
        sheet.createRow(rowIndex);
        rowIndex++;
        sheet.createRow(rowIndex);
        
        rowIndex++;
        writeChiTietHeader(sheet, rowIndex);
       
        
        // Write data
        for(SanPhamHDViewModel sp : chiTiet){
            rowIndex++;
            Row rows = sheet.createRow(rowIndex);
            // Write data on row
            writeChiTietHD(sp, rows);
        }
       
        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
        // Create file excel
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
    }


   

    // Create workbook
    private static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    // Write header with format
    private static void writeHeader(Sheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);
        // Create row
        Row row = sheet.createRow(rowIndex);
        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Id");

        cell = row.createCell(COLUMN_INDEX_MA);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ma");

        cell = row.createCell(COLUMN_INDEX_ID_NV);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("ID_NV");

        cell = row.createCell(COLUMN_INDEX_ID_KH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("ID KH");

        cell = row.createCell(COLUMN_INDEX_MAPGG);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ma PGGG");
        
//        cell = row.createCell(COLUMN_INDEX_NGAY_TAO);
//        cell.setCellStyle(cellStyle);
//        cell.setCellValue("Ngày tạo");
//        
//        cell = row.createCell(COLUMN_INDEX_NGAY_THANH_TOAN);
//        cell.setCellStyle(cellStyle);
//        cell.setCellValue("Ngày thanh toán");

        // Cột Ngày tạo
    cell = row.createCell(COLUMN_INDEX_NGAY_TAO);
    cell.setCellStyle(getDateCellStyle(sheet.getWorkbook()));
    cell.setCellValue("Ngày tạo");

    // Cột Ngày thanh toán
    cell = row.createCell(COLUMN_INDEX_NGAY_THANH_TOAN);
    cell.setCellStyle(getDateCellStyle(sheet.getWorkbook()));
    cell.setCellValue("Ngày thanh toán");
        
        cell = row.createCell(COLUMN_INDEX_TIEN_GIAM);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tiền giảm");
        
        cell = row.createCell(COLUMN_INDEX_TONG_TIEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tổng tiền");
        
        cell = row.createCell(COLUMN_INDEX_TIEN_KHACH_DUA);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tiền khách đưa");
        
        cell = row.createCell(COLUMN_INDEX_TIEN_THUA);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tiền thừa");
        
        cell = row.createCell(COLUMN_INDEX_TIEN_KHACH_PHAI_TRA);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tiền phải trả");
        
        cell = row.createCell(COLUMN_INDEX_HINH_THUC_THANH_TOAN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("HTTT");
        
        cell = row.createCell(COLUMN_INDEX_MA_CHUYEN_KHOAN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Mã CK");
        
        cell = row.createCell(COLUMN_INDEX_TRANG_THAI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Trạng thái");
        
    }
    private static CellStyle getDateCellStyle(Workbook workbook) {
    CellStyle cellStyle = workbook.createCellStyle();
    CreationHelper createHelper = workbook.getCreationHelper();
    cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));
    return cellStyle;
}
    
    private static void writeChiTietHeader(Sheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);
        // Create row
        Row row = sheet.createRow(rowIndex);
        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_ID);
        
        cell = row.createCell(COLUMN_INDEX_LOAISP);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Loại sản phẩm");
        
        cell = row.createCell(COLUMN_INDEX_TENSP);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tên sản phẩm");
        
        cell = row.createCell(COLUMN_INDEX_KICHCO);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Kích cỡ");
        
        cell = row.createCell(COLUMN_INDEX_SOLUONG);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số lượng");
        
         cell = row.createCell(COLUMN_INDEX_DONGIA);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Đơn giá");
    }

    // Write data
    private static void writeHD(HDTableVIewModel hd, Row row) {
        if (cellStyleFormatNumber == null) {
            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
          
            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }

        Cell cell = row.createCell(COLUMN_INDEX_ID);
        
        cell.setCellValue(hd.getId());

        cell = row.createCell(COLUMN_INDEX_MA);
        cell.setCellValue(hd.getMa());

        cell = row.createCell(COLUMN_INDEX_ID_NV);
        cell.setCellValue(hd.getTenNhanVien());

        cell = row.createCell(COLUMN_INDEX_ID_KH);
        cell.setCellValue(hd.getTenKhachHang());

        cell = row.createCell(COLUMN_INDEX_MAPGG);
        cell.setCellValue(hd.getMaPGG());
        
         cell = row.createCell(COLUMN_INDEX_NGAY_TAO);
        cell.setCellValue(hd.getNgayTao());
        
        cell = row.createCell(COLUMN_INDEX_NGAY_THANH_TOAN);
        cell.setCellValue(hd.getNgayThanhToan());
        
        cell = row.createCell(COLUMN_INDEX_TIEN_GIAM);
        cell.setCellValue(hd.getTienGiam());
        
        cell = row.createCell(COLUMN_INDEX_TONG_TIEN);
        cell.setCellValue(hd.getTongTien());
        
        cell = row.createCell(COLUMN_INDEX_TIEN_KHACH_DUA);
        cell.setCellValue(hd.getTienKhachDua());
        
        cell = row.createCell(COLUMN_INDEX_TIEN_THUA);
        cell.setCellValue(hd.getTienThua());
        
        cell = row.createCell(COLUMN_INDEX_TIEN_KHACH_PHAI_TRA);
        cell.setCellValue(hd.getTienKhachPhaiTra());
        
        cell = row.createCell(COLUMN_INDEX_HINH_THUC_THANH_TOAN);
        cell.setCellValue(hd.getHinhThucThanhToan()==1?"Tiền mặt":"Chuyển khoản");
        
        cell = row.createCell(COLUMN_INDEX_MA_CHUYEN_KHOAN);
        cell.setCellValue(hd.getMaChuyenKhoan());
        
        cell = row.createCell(COLUMN_INDEX_TRANG_THAI);
        cell.setCellValue(hd.getTrangThai().equals("0")?"Chưa thanh toán":"Đã thanh toán");
    }
    
    private static void writeChiTietHD(SanPhamHDViewModel sanPham, Row row) {
        if (cellStyleFormatNumber == null) {
            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
      
        Cell cell = row.createCell(COLUMN_INDEX_LOAISP);
        cell.setCellValue(sanPham.getLoaiSanPham());
        
        cell = row.createCell(COLUMN_INDEX_TENSP);
        cell.setCellValue(sanPham.getTenSp());
        
        cell = row.createCell(COLUMN_INDEX_KICHCO);
        cell.setCellValue(sanPham.getKichCo());
        
        cell = row.createCell(COLUMN_INDEX_SOLUONG);
        cell.setCellValue(sanPham.getSoLuong());
        
        cell = row.createCell(COLUMN_INDEX_DONGIA);
        cell.setCellValue(sanPham.getDonGia());
    }


    // Create CellStyle for header
    private static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        // Chuyển đổi màu RGB sang dạng short
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

   

    // Auto resize column width
    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    // Create output file
    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try ( OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }
}
