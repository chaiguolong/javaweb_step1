package com.hzfc.utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;

public class PioExcelWorker {
	
	/**
	 * 用于导出Excel
	 * frankLin
	 */
	private static short HEAD_START_ROW = 2;
	
	private static short DATA_START_ROW = 3;
	
	private static int MAX_ROW = 65000;
	
	public static PioExcelWorker getInstance(){
		return new PioExcelWorker();
	}
	
	//构造方法
	private PioExcelWorker(){
		workBook =  new HSSFWorkbook();
		defaultHeadFont = workBook.createFont();
		initDefaultHeadCellFont();
		defaultHeadStyle = workBook.createCellStyle();
		initDefaultHeadCellStyle();
	}
	
	//导出工厂
	public void exportFactory(String title, int colsize, List headerNameList, List headerCodeList, List dataList, boolean isSetNull, int rowL) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		createTableTitle(title, colsize);
		createTableHeader(headerNameList);
		createTableDate(headerCodeList, dataList, isSetNull, rowL);
	}
	
	//创建工作本
	private HSSFWorkbook workBook;
	
	//创建表
	private HSSFSheet workSheet ;
	
	//表格样式
	private static HSSFCellStyle defaultHeadStyle; 
	
	//字体样式
	private static HSSFFont  defaultHeadFont; 
	
	//设置头部
	private void initDefaultHeadCellStyle(){
		defaultHeadStyle.setAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中
		defaultHeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // /水平居中
		defaultHeadStyle.setFont(defaultHeadFont); // 将字体格式加入到单元格风格当中
		defaultHeadStyle.setWrapText(true);//
	}
	
	//设置头部字体
	private void initDefaultHeadCellFont(){
		defaultHeadFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		defaultHeadFont.setColor(HSSFFont.SS_NONE); // 设置单元格字体的颜色.
		defaultHeadFont.setFontHeight((short) 200); // 设置字体大小
		defaultHeadFont.setFontName("Courier New"); // 设置单元格字体
	}
	
	//设置导出title
	public void createTableTitle(String title,int colsize){
		workSheet = workBook.createSheet(title);
		
		HSSFRow row = workSheet.createRow( (short) 0);
		workSheet.addMergedRegion(new Region(0, (short) 0, 1, (short)(colsize-1)));
		HSSFCell cell = row.createCell( (short) 0);//然后可以能这个格内的数据进行写入操作
		
		HSSFRichTextString text = new HSSFRichTextString(title);		
		cell.setCellValue(text);
		
		HSSFCellStyle titleStyle = workBook.createCellStyle();
		
		HSSFFont titleFont = workBook.createFont();
		titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		titleFont.setColor(HSSFFont.SS_NONE); // 设置单元格字体的颜色.
		titleFont.setFontHeight((short) 400); // 设置字体大小
		titleFont.setFontName("Courier New"); // 设置单元格字体
		
		titleStyle.setAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // /水平居中
		titleStyle.setFont(titleFont); // 将字体格式加入到单元格风格当中
		titleStyle.setWrapText(true);//
		
		cell.setCellStyle(titleStyle);
	}
	
	//创建导出列标题
	public void createTableHeader(List headerNameList){
		HSSFRow headerRow = workSheet.createRow(HEAD_START_ROW);
		for(int i = 0; i < headerNameList.size(); i++){
			String cellTitle = (String) headerNameList.get(i);
			HSSFCell headerCell = headerRow.createCell((short) i);
			workSheet.setColumnWidth((short)i, (short)5000);
			headerCell.setCellStyle(defaultHeadStyle);
			HSSFRichTextString text = new HSSFRichTextString(cellTitle);
			headerCell.setCellValue(text);
		}
	}
	
	//加载数据到excel
	public void createTableDate(List headerCodeList, List dataList, boolean isSetNull, int rowL) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		HSSFRow excelRow;
		HSSFCell dataCell;
		HSSFRichTextString text;
		short startRowNum = DATA_START_ROW;
		for(int i = 0; i<dataList.size() && i < MAX_ROW; i++){	
			Map obj = PropertyUtils.describe(dataList.get(i));
			excelRow = workSheet.createRow(startRowNum);
			for(int j = 0; j < headerCodeList.size(); j++){
				dataCell = excelRow.createCell((short)j);
				if(obj.get(headerCodeList.get(j)) instanceof Integer){
					int it = (Integer) obj.get(headerCodeList.get(j));
					text = new HSSFRichTextString(String.valueOf(it));
				}
				else {
					text = new HSSFRichTextString(String.valueOf(obj.get(headerCodeList.get(j))));
				}
				//过滤null
				if("".equals(text.getString()) || text.getString() == null ||"null".equals(text.getString())){
					text = new HSSFRichTextString("");
				}
				dataCell.setCellValue(text);
			}
			
			//上下两行数据相同，则清空单元格
			if(isSetNull && startRowNum != DATA_START_ROW){
				HSSFRow upExcelRow;
				String upValue = "";
				String thisValue = "";
				//向上找
				for(int k = startRowNum-1 ; k >= DATA_START_ROW ; k --){
					upExcelRow = workSheet.getRow(k);
					upValue = upExcelRow.getCell(0).getRichStringCellValue().getString();
					if(StringUtils.isNotBlank(upValue)){
						break;
					}
				}
				thisValue = excelRow.getCell(0).getRichStringCellValue().getString();//本行
				if(thisValue.equals(upValue)){ //判断上下2行是否相同
					for(int j = 0; j < rowL; j++){
						excelRow.getCell(j).setCellValue(new HSSFRichTextString(""));
					}
				}
			}
			
			startRowNum ++ ;
		}
	}
	
	//输出数据
	public void expordExcel(HttpServletResponse response) throws IOException{
		workSheet.setGridsPrinted(true);
		HSSFFooter footer = workSheet.getFooter();
        footer.setRight("Page " + HSSFFooter.page() + " of " +
        HSSFFooter.numPages());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        response.setHeader("Content-Disposition", "attachment; filename=" + df.format(new Date(System.currentTimeMillis()).getTime()) + ".xls"); // 以上输出文件元信息
        response.setContentType("application/vnd.ms-excel");
        workBook.write(response.getOutputStream());
	}


}
