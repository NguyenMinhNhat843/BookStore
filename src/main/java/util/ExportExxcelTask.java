/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Asus
 */
public class ExportExxcelTask implements Callable<Boolean>{
    private final DefaultTableModel model;
    private final int startRow;
    private final int endRow;
    private final File folder;

    public ExportExxcelTask(DefaultTableModel model, int startRow, int endRow, File folder) {
        this.model = model;
        this.startRow = startRow;
        this.endRow = endRow;
        this.folder = folder;
    }

    public Boolean call() throws Exception {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Data");
            
            // Xuat tieu de cot
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < model.getColumnCount(); i++) {
                headerRow.createCell(i).setCellValue(model.getColumnName(i));
            }
            
            // Xuat du lieu tu JTable
            for (int i = startRow; i < endRow; ++i) {
                if(i == 0) continue;
                Row row = sheet.createRow(i);
                for (int j = 0; j < model.getColumnCount(); ++j) {
                    Object value = model.getValueAt(i, j);
                    if (value != null) {
                        row.createCell(j).setCellValue(value.toString());
//                        if (value instanceof String) {
//                            row.createCell(j).setCellValue((String) value);
//                        } else if (value instanceof Double) {
//                            row.createCell(j).setCellValue((Double) value);
//                        } else if (value instanceof Integer) {
//                            row.createCell(j).setCellValue((Integer) value);
//                        } else if (value instanceof Boolean) {
//                            row.createCell(j).setCellValue((Boolean) value);
//                        }
                    }
                }
            }
            
            // Lưu workbook ra file Excel
            File outputFile = new File(folder, "export_sanpham.xlsx");
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                workbook.write(fos);
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
