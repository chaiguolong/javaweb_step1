package com.hzfc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hzfc.utils.ImageUtils;
import com.hzfc.utils.ScaleImage;

public class FileOperUtils {

	/**
	 * 移动图片
	 * 
	 * @param oldPath
	 * @param newPath
	 */
	public void copyfile(String oldPath, String newPath) {
		try {
			File moveFile = new File(oldPath);
			if (moveFile.exists()) {

				File dir = new File(newPath.substring(0, newPath.lastIndexOf("/")));

				if (!dir.exists()) { // 判断文件夹是否生成
					dir.mkdirs();
				}

				// 生成新文件
				File newFile = new File(newPath);

				// 是否存在
				if (!newFile.exists()) {
					newFile.createNewFile();
				}

				// 取得输入流
				InputStream in = new FileInputStream(oldPath);

				// 指定输出流文件
				FileOutputStream out = new FileOutputStream(newFile);

				int c;
				// 设置缓冲大小
				byte buffer[] = new byte[1024 * 1024 * 2];
				while ((c = in.read(buffer)) != -1) {
					for (int t = 0; t < c; t++)
						out.write(buffer[t]);
				}

				// 关闭输入，输出流
				in.close();
				out.close();

				// 删除文件
				moveFile.delete();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 从EXCEL中读取数据，单列，从第二行开始读取
	public List<String> poiLoadXls(String excelpath) {
		List<String> returnList = new ArrayList<String>();
		try {
			// 从表单中获取文件
			File file = new File(excelpath);

			if (file.exists()) {

				// 取得输入流
				InputStream in = new FileInputStream(file);

				HSSFWorkbook workBook = new HSSFWorkbook(in);

				// 获取第一个sheet页
				HSSFSheet workSheet = workBook.getSheetAt(0);

				int size = workSheet.getLastRowNum();

				for (int j = 0; j <= size && size != 0; j++) {
					HSSFRow row = workSheet.getRow(j);
					HSSFCell cell = row.getCell(0);

					if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						break;
					} else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
						returnList.add(cell.getRichStringCellValue().toString());
					} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
						int text = (int) cell.getNumericCellValue();
						returnList.add(String.valueOf(text));
					} else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
						returnList.add(String.valueOf(cell.getBooleanCellValue()));
					} else if (cell.getCellType() == HSSFCell.CELL_TYPE_ERROR) {
						break;
					}
				}
			}

		} catch (Exception e) {
			return null;
		}
		return returnList;
	}

	public List<String> poiLoadXlsx(String excelpath) {
		List<String> returnList = new ArrayList<String>();
		try {
			// 从表单中获取文件
			File file = new File(excelpath);
			if (file.exists()) {

				// 取得输入流
				InputStream in = new FileInputStream(file);

				XSSFWorkbook workBook = new XSSFWorkbook(in);

				// 获取第一个sheet页
				XSSFSheet workSheet = workBook.getSheetAt(0);

				int size = workSheet.getLastRowNum();

				for (int j = 0; j <= size && size != 0; j++) {
					XSSFRow row = workSheet.getRow(j);
					XSSFCell cell = row.getCell(0);

					if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
						break;
					} else if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
						returnList.add(cell.getRichStringCellValue().toString());
					} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
						int text = (int) cell.getNumericCellValue();
						returnList.add(String.valueOf(text));
					} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
						returnList.add(String.valueOf(cell.getBooleanCellValue()));
					} else if (cell.getCellType() == XSSFCell.CELL_TYPE_ERROR) {
						break;
					}
				}
			}

		} catch (Exception e) {
			return null;
		}
		return returnList;
	}


	/**
	 * 复制文件不删除旧文件
	 * 
	 * @param oldPath
	 * @param newPath
	 */
	public void copyTofile(String oldPath, String newPath) {
		try {
			File moveFile = new File(oldPath);
			if (moveFile.exists()) {

				File dir = new File(newPath.substring(0, newPath.lastIndexOf("/")));

				if (!dir.exists()) { // 判断文件夹是否生成
					dir.mkdirs();
				}

				// 生成新文件
				File newFile = new File(newPath);

				// 是否存在
				if (!newFile.exists()) {
					newFile.createNewFile();
				}

				// 取得输入流
				InputStream in = new FileInputStream(oldPath);

				// 指定输出流文件
				FileOutputStream out = new FileOutputStream(newFile);

				int c;
				// 设置缓冲大小
				byte buffer[] = new byte[1024 * 1024 * 2];
				while ((c = in.read(buffer)) != -1) {
					for (int t = 0; t < c; t++)
						out.write(buffer[t]);
				}

				// 关闭输入，输出流
				in.close();
				out.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成多比例缩略图
	 * 
	 * @param realpath
	 *            源图片路径
	 * @param standard
	 *            生成的尺寸比例多个用逗号分开
	 * @param isWaterMark
	 *            是否有水印
	 */
	public void doScaleImages(String realpath, String standard, boolean isWaterMark) {

		String ext = realpath.substring(realpath.lastIndexOf(".") + 1);

		if (isWaterMark) {// 生成水印
			// 原图尾部加I，不加水印
			String yl = realpath.substring(0, realpath.lastIndexOf(".")) + "_I." + ext;
			copyTofile(TablesNameConstants.WEB_ROOT_PATH + realpath, TablesNameConstants.WEB_ROOT_PATH + yl);
			// 给图片加上水印
			ImageUtils.pressImage(TablesNameConstants.WEB_ROOT_PATH + "upload/logo.png", TablesNameConstants.WEB_ROOT_PATH + realpath, 0, 0);
		}
		String imageType = "JPEG";
		if (ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("jpeg")) {
			imageType = "JPEG";
		} else if (ext.equalsIgnoreCase("gif")) {
			imageType = "GIF";
		} else if (ext.equalsIgnoreCase("png")) {
			imageType = "PNG";
		}
		String[] str = standard.split(",");

		int w = 0;
		int h = 0;
		String savepath = realpath.substring(0, realpath.lastIndexOf("."));
		File fromFile = new File(TablesNameConstants.WEB_ROOT_PATH + realpath);
		ScaleImage si = new ScaleImage();
		for (int i = 0; i < str.length && StringUtils.isNotBlank(str[i]); i++) {
			String[] tg = str[i].split("\\*");
			w = Integer.valueOf(tg[0]);
			h = Integer.valueOf(tg[1]);
			try {
				File saveFile = new File(TablesNameConstants.WEB_ROOT_PATH + savepath.replaceAll("=", "_" + w + "x" + h) + "." + ext);
				if (!saveFile.exists()) { // 创建文件
					saveFile.createNewFile();
				}
				si.saveImageScale(fromFile, saveFile, w, h, imageType);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除文件，并且将匹配的文件都删除
	 * @param removePath
	 * @return
	 */
	public boolean remove(String removePath) {
		if (StringUtils.isNotBlank(removePath)) {
			String dir = TablesNameConstants.WEB_ROOT_PATH + removePath.substring(0, removePath.lastIndexOf("/"));
			List<String> resultList = new ArrayList<String>();  
			findFiles(dir, removePath.substring(removePath.lastIndexOf("/")+1), resultList);
			if(resultList.size() > 0){
				for (int i = 0; i < resultList.size(); i++) {   
					File delFile = new File( dir + "//" + resultList.get(i));
					if (delFile.exists()) {
						delFile.delete();
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 递归查找文件
	 * 
	 * @param baseDirName
	 *            查找的文件夹路径
	 * @param targetFileName
	 *            需要查找的文件名
	 * @param fileList
	 *            查找到的文件集合
	 */
	@SuppressWarnings("unchecked")
	public void findFiles(String baseDirName, String targetFileName, List fileList) {
		/**
		 * 算法简述： 从某个给定的需查找的文件夹出发，搜索该文件夹的所有子文件夹及文件，
		 * 若为文件，则进行匹配，匹配成功则加入结果集，若为子文件夹，则进队列。 队列不空，重复上述操作，队列为空，程序结束，返回结果。
		 */
		String tempName = null;
		// 判断目录是否存在
		File baseDir = new File(baseDirName);
		if (!baseDir.exists() || !baseDir.isDirectory()) {
			//System.out.println("文件查找失败：" + baseDirName + "不是一个目录！");
		} else {
			String[] filelist = baseDir.list();
			for (int i = 0; i < filelist.length; i++) {
				File readfile = new File(baseDirName + "\\" + filelist[i]);
				// System.out.println(readfile.getName());
				if (!readfile.isDirectory()) {
					tempName = readfile.getName();
					if (wildcardMatch(targetFileName, tempName)) {
						// 匹配成功，将文件名添加到结果集
						fileList.add(readfile.getName());
					}
				} else if (readfile.isDirectory()) {
					findFiles(baseDirName + "\\" + filelist[i], targetFileName, fileList);
				}
			}
		}
	}

	/**
	 * 通配符匹配
	 * 
	 * @param pattern
	 *            通配符模式
	 * @param str
	 *            待匹配的字符串
	 * @return 匹配成功则返回true，否则返回false
	 */
	private boolean wildcardMatch(String pattern, String str) {
		int patternLength = pattern.length();
		int strLength = str.length();
		int strIndex = 0;
		char ch;
		for (int patternIndex = 0; patternIndex < patternLength; patternIndex++) {
			ch = pattern.charAt(patternIndex);
			if (ch == '=') {
				// 通配符等号=表示可以匹配任意多个字符
				while (strIndex < strLength) {
					if (wildcardMatch(pattern.substring(patternIndex + 1), str.substring(strIndex))) {
						return true;
					}
					strIndex++;
				}
			} else if (ch == '?') {
				// 通配符问号?表示匹配任意一个字符
				strIndex++;
				if (strIndex > strLength) {
					// 表示str中已经没有字符匹配?了。
					return false;
				}
			} else {
				if ((strIndex >= strLength) || (ch != str.charAt(strIndex))) {
					return false;
				}
				strIndex++;
			}
		}
		return (strIndex == strLength);
	}

}
