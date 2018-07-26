package com.tool.util;

import org.apache.poi.ss.usermodel.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/7/25.
 */
public class ExcelUtil {

    /** 
    * @Description: 解析文件流返回listMap集合
    * @Param: [in] 
    * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>> 
    * @Author: chenshuai 
    * @Date: 2018/7/25 
    */ 
    public static List<Map<String,Object>> getBean(InputStream in){
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        //默认只读取第一个页签，第一行为key，第二行为对应key含义，第二行之后为数据行
        try {
            //创建读取对象
            Workbook workbook = WorkbookFactory.create(in);
            Sheet sheet = workbook.getSheetAt(0);
            //设置列id
            List<String> keyList = new ArrayList<String>();
            Row keyRow =  sheet.getRow(0);
            for(int i= 0;i<keyRow.getPhysicalNumberOfCells();i++){
                keyList.add(getCellValue(keyRow.getCell(i)) == null ? "":getCellValue(keyRow.getCell(i)) .toString());
            }
            //设置表格数据
            for (int i = sheet.getFirstRowNum()+2;i< sheet.getPhysicalNumberOfRows();i++) {
                Map<String,Object> resultMap = new HashMap<String, Object>();
                for (int j= 0; j<keyList.size(); j++) {
                    Cell ce = sheet.getRow(i).getCell(j);
                    Object value = getCellValue(ce);
                    resultMap.put(keyList.get(j),value);
                }
                list.add(resultMap);
            }
        }catch (Exception e){
            return list;
        }



        return list;
    }

    private static Object getCellValue(Cell cell) {
        Object value = null;
        switch (cell.getCellTypeEnum()) {
            case _NONE:
                break;
            case STRING:
                value = cell.getStringCellValue();
                break;
            case NUMERIC:
                value = cell.getNumericCellValue();
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case BLANK:
                break;
            default:
                value = cell.toString();
        }
        return value;
    }

}
