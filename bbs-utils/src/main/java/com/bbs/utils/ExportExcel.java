package com.bbs.utils;
 
import java.io.BufferedOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbs.domain.Data;

/** 
 * @author 
 * @Email   
 * @date   
 * @version 1.0   
 */
public class ExportExcel<T> {
	public void exportExcel(String[] headers,List<Data> dataset, String fileName,HttpServletResponse response) {
		// 声明一个工作薄
		// 生成一个表格
		XSSFWorkbook workbook =new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(fileName);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 20);
		// 产生表格标题行
		XSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			XSSFCell cell = row.createCell(i);
			XSSFRichTextString text = new XSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		try {
	     int size=dataset.size();
	     int index=0;
	     for(int i=0;i<size;i++)
	     {
	    	 index++;
	    	 row = sheet.createRow(index);
	    	 Data t=dataset.get(i);
	    	 Field[] fields = t.getClass().getDeclaredFields();
	    	for(short j=0;j<headers.length;j++)// 去掉一个序列化 则显示减一
	    	{
	    		XSSFCell cell = row.createCell(j);

	    			Field field = fields[j+1];// 设置为j+1 避免序列化TId这个数据的影响
		    		String fieldName = field.getName();
		    		String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
		    		Class test=t.getClass();
	                Method getMethod = test.getMethod(getMethodName, new Class[] {});
	            	Object value = getMethod.invoke(t, new Object[] {});
	            	// 判断值的类型后进行强制类型转换
					String textValue = null;
					// 其它数据类型都当作字符串简单处理
					if(value != null && value != ""){
						textValue = value.toString();
					}
					if (textValue != null) {
						XSSFRichTextString richString = new XSSFRichTextString(textValue);
						cell.setCellValue(richString);
					}
	    		}
           }
	     getExportedFile(workbook, fileName,response); 
		} 
	     catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 
	 * 方法说明: 指定路径下生成EXCEL文件
	 * @return
	 */
	public void getExportedFile(XSSFWorkbook workbook, String name,HttpServletResponse response) throws Exception {
		BufferedOutputStream fos = null;
		try {
			String fileName = name + ".xlsx";
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
			fos = new BufferedOutputStream(response.getOutputStream());
			workbook.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}
 
}
