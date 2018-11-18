package com.FileIO.Service;

import org.apache.commons.fileupload.FileItem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理excel文件的业务类
 */
public class excelService {

    /**
     * 解析普通表单项
     */
    public String parseFormfield(FileItem fileItem) throws Exception{
        return fileItem.getString("UTF-8");
    }

    /**
     * 解析上传的excel文件
     */
    @SuppressWarnings("deprecation")
    public List<List<String>> parseExcel(FileItem fileItem) throws Exception{
        Workbook workbook = WorkbookFactory.create(fileItem.getInputStream());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<List<String>> excelData = new ArrayList<>();

        for(Row row : workbook.getSheet("Sheet1")) {
            List<String> rowData = new ArrayList<>();
            rowData.add(String.valueOf(row.getRowNum()));
            for(Cell cell : row) {
                // 获取每个单元格在excel表格中的位置：
//                CellReference cellRef = new CellReference(row.getRowNum(),cell.getColumnIndex());
//                System.out.print(cellRef.formatAsString());
//                System.out.print(" - ");

                switch (cell.getCellType()){
                    case Cell.CELL_TYPE_STRING:
                        String str = cell.getRichStringCellValue().toString();
                        rowData.add(str);
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellInternalDateFormatted(cell)) {
                            rowData.add(format.format(cell.getDateCellValue()));
                        } else {
                            String num = String.valueOf((int)cell.getNumericCellValue());
                            rowData.add(num);
                        }
                        break;
                    case Cell.CELL_TYPE_BLANK:
                        rowData.add(" ");
                        break;
                    default:
                        rowData.add(" ");
                }
            }
            excelData.add(rowData);
        }
        return excelData;
    }

    /**
     * 导出07版本excel
     */
    public Workbook exportExcel() {
        List<List<String>> content = this.getContent();
        // 创建一个07版本的excel:
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("我的excel");
        for (int i = 0; i < content.size(); i++) {
            Row row = sheet.createRow(i);
            List<String> rowData = content.get(i);
            for (int j = 0; j < rowData.size(); j++) {
                row.createCell(j).setCellValue(rowData.get(j));
            }
        }
        return workbook;
    }

    // 创建excel文件测试用数据：
    private List<List<String>> getContent(){
        List<List<String>> sheet = new ArrayList<>();
        List<String> row;
        row = new ArrayList<>();
        row.add("姓名");
        row.add("年龄");
        row.add("出生日期");
        sheet.add(row);

        row = new ArrayList<>();
        row.add("狗蛋");
        row.add("26");
        row.add("2000-02-06");
        sheet.add(row);

        row = new ArrayList<>();
        row.add("王小二");
        row.add("10");
        row.add("2015-10-01");
        sheet.add(row);

        row = new ArrayList<>();
        row.add("张麻子");
        row.add("40");
        row.add("1987-08-08");
        sheet.add(row);

        row = new ArrayList<>();
        row.add("张全蛋");
        row.add("30");
        row.add("1980-05-09");
        sheet.add(row);

        return sheet;
    }

    public static void main(String[] args) {
        System.out.println(new excelService().getContent());
    }
}
