/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import com.toedter.calendar.JDateChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Uhelper {
    
    
    public static boolean checkRong(JTextField f, String msg) {
        if (f.getText().equals("")) {
            JOptionPane.showMessageDialog(f, msg);
            return true;
        }
        return false;
    }

    public static boolean checkRongChoNgay(JDateChooser dateChooser, String msg) {
        if (dateChooser.getDate() == null) {
            JOptionPane.showMessageDialog(dateChooser, msg);
            return true;
        }
        return false;
    }

    public static boolean checkKhongAm(JTextField f, String msg) {
        try {
            int number = Integer.parseInt(f.getText());
            if (number < 0) {
                JOptionPane.showMessageDialog(f, msg);
                return true;
            }
            return false;
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(f, "Vui lòng nhập một số nguyên hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return true;
        }
    }
    
    
}
