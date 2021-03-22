package com.gz.fangcj;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

/**
 * @Description MAin
 * @Author Fangchenjiang
 * @Date 2021/3/22 17:04
 */
public class MainTest {
    public static void main(String[] args) {


        Workbook wb = null;
        try {
            //如果是xls，使用HSSFWorkbook；如果是xlsx，使用XSSFWorkbook
            wb = new HSSFWorkbook(new FileInputStream("F:\\opt\\leads-template.xls"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取第一个画布
        Sheet sheet = wb.getSheetAt(0);
        CellReference cellReference = new CellReference("A4");
        boolean flag = false;
        for (int i = cellReference.getRow(); i <= sheet.getLastRowNum();) {
            Row r = sheet.getRow(i);
            if(r == null){
                //如果是空行（即没有任何数据、格式），直接把它以下的数据往上移动
                sheet.shiftRows(i+1, sheet.getLastRowNum(),-1);
                continue;
            }
            flag = false;
            for(Cell c : r){
                if (c.getCellTypeEnum()!= CellType.BLANK){
                    flag = true;
                    break;
                }
            }
            if(flag){
                i++;
                continue;
            }else{//如果是空白行（即可能没有数据，但是有一定格式）
                if(i == sheet.getLastRowNum()){
                    //如果到了最后一行，直接将那一行remove掉
                    sheet.removeRow(r);
                }else{
                    //如果还没到最后一行，则数据往上移一行
                    sheet.shiftRows(i+1, sheet.getLastRowNum(),-1);
                }
            }
        }
        System.out.println("有效行数为:"+(sheet.getLastRowNum()+1));
    }
}
