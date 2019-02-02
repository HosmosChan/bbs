package com.bbs.utils;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelRead {
	public static final String DATA_TYPE_NULL= "null";
	public static final String DATA_TYPE_BOOLEAN= "boolean";
	public static final String DATA_TYPE_STRING= "string";
	public static final String DATA_TYPE_DATE= "date";
	public static final String DATA_TYPE_NUMBER= "number";
	public static final String DATA_TYPE_ERROR= "error";//该类型不可以转换为图表
	
	//返回数据
	private static String getContent1(Cell cell) {
		// TODO Auto-generated method stub
    	String content=null;
    	switch (cell.getCellType()) {
        case 3://空值
        	content=""; break;
        case 4://boolean值
        	content= Boolean.toString(cell.getBooleanCellValue());
            break;
        // 数值
        case 0://数字
            if (DateUtil.isCellDateFormatted(cell)) {
                SimpleDateFormat sdf = null;
                if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                        .getBuiltinFormat("h:mm")) {
                    sdf = new SimpleDateFormat("HH:mm");
                } else {// 日期
                    sdf = new SimpleDateFormat("yyyy-MM-dd");
                }
                Date date = cell.getDateCellValue();
                content=sdf.format(date);
            } else {
                cell.setCellType(Cell.CELL_TYPE_STRING);
                String temp = cell.getStringCellValue();
                // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                if (temp.indexOf(".") > -1) {
                	content= String.valueOf(new Double(temp)).trim();
                } else {
                	content= temp.trim();
                }
            }
            break;
        case 1://字符串
        	content= cell.getStringCellValue().trim();
            break;
        case 5://错误信息
        	content= "";
            break;
        case 2://公式
            cell.setCellType(Cell.CELL_TYPE_STRING);
            String temp = cell.getStringCellValue();
            // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
            if (temp.indexOf(".") > -1) {
                temp = String.valueOf(new Double(temp))
                        .trim();
                Double cny = Double.parseDouble(temp);//6.2041
                DecimalFormat df = new DecimalFormat("0.00");
                content= df.format(cny);
            } else {
            	content= temp.trim();
            }
            break;
        default:
        	content= "";
        	System.err.println("类型未知");
            break;
    }

		return content;
	} 
	//返回数据类型
	private static String getContentType(Cell cell) {
		// TODO Auto-generated method stub
    	String content=null;
    	switch (cell.getCellType()) {
        case 3://空值
        	content=DATA_TYPE_NULL; break;
        case 4://boolean值
        	content=DATA_TYPE_BOOLEAN;
            break;
        // 数值
        case 0://数字
            if (DateUtil.isCellDateFormatted(cell)) {
                SimpleDateFormat sdf = null;
                if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                        .getBuiltinFormat("h:mm")) {
                    sdf = new SimpleDateFormat("HH:mm");
                } else {// 日期
                    sdf = new SimpleDateFormat("yyyy/MM/dd");
                }
                Date date = cell.getDateCellValue();
                content=DATA_TYPE_DATE;
            } else {
                cell.setCellType(Cell.CELL_TYPE_STRING);
                String temp = cell.getStringCellValue();
                // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                if (temp.indexOf(".") > -1) {
                	content=DATA_TYPE_NUMBER;
                } else {
                	content=DATA_TYPE_NUMBER;
                }
            }
            break;
        case 1://字符串
        	content=DATA_TYPE_NUMBER;
        	String str=cell.getStringCellValue().trim();
        	for (int i=0;i<str.length();i++){   
        	    if (!Character.isDigit(str.charAt(i))){ 
        	    	content=DATA_TYPE_STRING;
        			   } 
        	  }
            break;
        case 5://错误信息
        	content=DATA_TYPE_ERROR;
            break;
        case 2://公式
            cell.setCellType(Cell.CELL_TYPE_STRING);
            String temp = cell.getStringCellValue();
            // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
            if (temp.indexOf(".") > -1) {
                temp = String.valueOf(new Double(temp))
                        .trim();
                Double cny = Double.parseDouble(temp);//6.2041
                DecimalFormat df = new DecimalFormat("0.00");
                content=DATA_TYPE_ERROR;
            } else {
            	content=DATA_TYPE_ERROR;
            }
            break;
        default:
        	content=DATA_TYPE_ERROR;
            break;
    }

		return content;
	}  
    
	public static String[][] getXlsx2(String fileName,int[] id) {
		 XSSFWorkbook wb = null;
        try {
        	File excelFile = new File(fileName); //替换你文档地址
           
            wb = new XSSFWorkbook(new FileInputStream(excelFile));
        } catch (IOException e){
        	System.err.println("文件不存在");
            e.printStackTrace();
        }
        for (int x = 0; x < wb.getNumberOfSheets();x++) {
            XSSFSheet sheet = wb.getSheetAt(x);
            int columnNum = 0;
            int rowNum=0;
            if (sheet.getRow(0) != null) {
                columnNum = sheet.getRow(0).getLastCellNum()
                        - sheet.getRow(0).getFirstCellNum();
                rowNum = sheet.getLastRowNum()- sheet.getFirstRowNum();
            }
            if(null!=id)
            {
            	columnNum=id.length;
            }
           	 String[][] singleRow = new String[rowNum+2][columnNum];   //需要加2 加上首行和数据类型行 \
                 if (columnNum > 0) {
                       int m=0;
                     for (Row row : sheet) {//从第一行开始
                     	for (int i = 0; i <columnNum; i++) {//从第一列开始
                         	Cell cell = row.getCell(i,MissingCellPolicy.CREATE_NULL_AS_BLANK);
                         		singleRow[rowNum+1][i]=getContentType(cell);
                         		singleRow[m][i]=getContent1(cell);	
                         	}
                         m++;
                     }
                  }
                 return singleRow;
        }
		return null;
		}


}
