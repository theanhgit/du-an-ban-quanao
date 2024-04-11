/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.print.PrinterException;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.Sides;
import javax.swing.JTextArea;



/**
 *
 * @author ledun
 */
public class Print {
    
   public static void printText(String noiDung){
       try {
           JTextArea txt=new JTextArea();
           txt.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
           PrintRequestAttributeSet prop=new HashPrintRequestAttributeSet();
           prop.add(MediaSizeName.ISO_A5);
           prop.add(new MediaPrintableArea(10   , 10, 128, 190, MediaPrintableArea.MM));
           prop.add(Sides.TWO_SIDED_LONG_EDGE);
           txt.setText(noiDung);
           txt.print(null, null, false, null, prop, true);
       } catch (PrinterException ex) {
           System.out.println("Lỗi máy in");
       }
   }
       
    
}
