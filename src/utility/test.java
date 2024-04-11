/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import util.Print;

/**
 *
 * @author admin
 */
public class test {
    public static void main(String[] args) {
        String tenKH = "Nguyễn Văn A";
        String tenNV = "Thu ngân B";
        String maHD= "HD01";
        double tongTien = 50000;
        double tienGiam= 10000;
        double tienPhaiTra = tongTien-tienGiam;
        double tienKhachDua = 100000;
        double tienThua=tienKhachDua-tienPhaiTra;
        
        LocalDateTime gioHienTai = LocalDateTime.now();
        // Định dạng ngày giờ theo một định dạng cụ thể
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = gioHienTai.format(formatter);

        
        
        String receipt = String.format("""
                                                                QUẦN ÁO THỂ THAO NAM-G7
                        
                                                        Địa chỉ: TT.Tây Đằng-H.Ba Vì-TP.Hà Nội
                                                        SĐT: 0388198352           
                                              ------------------------------------------------------------------------
                                                                   HÓA ĐƠN THANH TOÁN
                                                Khách hàng:                                %s
                                                Thu ngân:                                  %s
                                                Mã hóa đơn:                                %s
                                                Ngày:                                      %s
                                              -------------------------------------------------------------------------
                                                Mặt hàng             SL        Đơn giá        Thành tiền
                                       """
                                                
                                       +
                                            """
                                        
                                                      
                        
                        
                        
                                              --------------------------------------------------------------------------
                                                Tổng tiền:                                  %.2f
                                                Giảm:                                       %.2f
                                                Tiền phải trả:                              %.2f
                                                Tiền khách đưa:                             %.2f
                                                Tiền thừa:                                  %.2f
                                              --------------------------------------------------------------------------
                        
                                                                    G7 Xin cảm ơn quý khách!
                                                      
                        
                        """,tenKH, tenNV,maHD, date, tongTien, tienGiam,tienPhaiTra, tienKhachDua, tienThua);
         Print.printText(receipt);
    }
}
