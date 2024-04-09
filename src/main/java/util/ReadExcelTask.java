/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.CellType.BOOLEAN;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author Asus
 */
public class ReadExcelTask implements Callable<List<Object[]>>{
    private XSSFSheet sheet = null;
    private int startRow = 0;
    private int endRow = 0;
    private Object[] headers;
    private List<Object[]> data;
    
    public ReadExcelTask(XSSFSheet sheet, int startRow, int endRow) {
        this.sheet = sheet;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    public Object[] getHeaders() {
        return headers;
    }
    
    public List<Object[]> getData() {
        return data;
    }

    public List<Object[]> call() throws Exception {
        data = new ArrayList<>();
        Row headerRow = sheet.getRow(0);
        headers = new Object[headerRow.getPhysicalNumberOfCells()];
        for(int i = 0; i < headerRow.getPhysicalNumberOfCells(); ++i) {
            headers[i] = headerRow.getCell(i).getStringCellValue();
        }
        
        for(int i = startRow; i < endRow; ++i ) {
            if (i == 0) continue;
            Row row = sheet.getRow(i);
            if(row != null) {
                Object[] rowdata = new Object[row.getPhysicalNumberOfCells()];
                for(int j = 0; j < row.getPhysicalNumberOfCells(); ++j) {
                    Cell cell = row.getCell(j);
//                    System.out.println(cell.toString());
//                    rowdata[j] = cell.toString();
                    switch (cell.getCellType()) {
                        case STRING:
                            rowdata[j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            rowdata[j] = cell.getNumericCellValue();
                            break;
                        case BOOLEAN:
                            rowdata[j] = cell.getBooleanCellValue();
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
                data.add(rowdata);
            }
        }
        return data;
    }
}
