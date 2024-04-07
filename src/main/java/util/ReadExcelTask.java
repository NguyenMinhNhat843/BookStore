/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author Asus
 */
//public class ReadExcelTask implements Callable<List<List<String>>> {
//    private String filePath;
//
//    public ReadExcelTask(String filePath) {
//        this.filePath = filePath;
//    }
//
//    @Override
//    public List<List<String>> call() throws IOException {
//        List<List<String>> data = new ArrayList<>();
//
//        try (FileInputStream fis = new FileInputStream(filePath);
//             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//            XSSFSheet sheet = workbook.getSheetAt(0);
//
//            Iterator<Row> rowIterator = sheet.iterator();
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//
//                Iterator<Cell> cellIterator = row.iterator();
//                List<String> rowData = new ArrayList<>();
//                while (cellIterator.hasNext()) {
//                    Cell cell = cellIterator.next();
//
//                    String cellValue = "";
//                    switch (cell.getCellType()) {
//                        case STRING:
//                            cellValue = cell.getStringCellValue();
//                            break;
//                        case NUMERIC:
//                            cellValue = String.valueOf(cell.getNumericCellValue());
//                            break;
//                        case BOOLEAN:
//                            cellValue = String.valueOf(cell.getBooleanCellValue());
//                            break;
//                    }
//
//                    rowData.add(cellValue);
//                }
//
//                data.add(rowData);
//            }
//        }
//
//        return data;
//    }
//}
