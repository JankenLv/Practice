package com.imooc.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理excel文件的工具类
 * 导入excel数据
 * 导出excel文件
 */
public class ExcelHandler {

    private ExcelHandler(){};

    /**
     * 导入course
     * @param fileItem
     */
    public static List<List<String>> getExcelData(FileItem fileItem) throws Exception{
        Workbook workbook = WorkbookFactory.create(fileItem.getInputStream());
        List<List<String>> excel = new ArrayList<>();

        for (Row row : workbook.getSheetAt(0)) {
            List<String> rowData = new ArrayList<>();

            for (int i=0; i<6; i++) {
                switch (row.getCell(i).getCellType()){
                    case Cell.CELL_TYPE_STRING:
                        rowData.add(row.getCell(i).getRichStringCellValue().toString());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellInternalDateFormatted(row.getCell(i))) {
                            rowData.add(row.getCell(i).getDateCellValue().toString());
                        } else {
                            rowData.add(String.valueOf(row.getCell(i).getNumericCellValue()));
                        }
                        break;
                    case Cell.CELL_TYPE_BLANK:
                        rowData.add(" ");
                        break;
                    default:
                        rowData.add(" ");
                        break;
                }
            }
            excel.add(rowData);
        }
        return excel;
    }

    // 导出excel格式的课表
    /*public static Workbook exportExcel(JSONArray result) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("sheet1");

        // 写excel表头：
        Row rowHeader = sheet.createRow(0);
        rowHeader.createCell(0).setCellValue("课程ID");
        rowHeader.createCell(1).setCellValue("课程名");
        rowHeader.createCell(2).setCellValue("方向");
        rowHeader.createCell(3).setCellValue("描述");
        rowHeader.createCell(4).setCellValue("时长(小时)");
        rowHeader.createCell(5).setCellValue("操作人");

        // 写excel数据：
        for (int i = 0; i < result.size(); i++) {
            Row row = sheet.createRow(i + 1);
            JSONObject jsonObject = result.getJSONObject(i);
            row.createCell(0).setCellValue(jsonObject.getString("id"));
            row.createCell(1).setCellValue(jsonObject.getString("courseName"));
            row.createCell(2).setCellValue(jsonObject.getString("courseType"));
            row.createCell(3).setCellValue(jsonObject.getString("description"));
            row.createCell(4).setCellValue(jsonObject.getString("courseTime"));
            row.createCell(5).setCellValue(jsonObject.getString("operator"));
        }

        return workbook;
    }*/
}
