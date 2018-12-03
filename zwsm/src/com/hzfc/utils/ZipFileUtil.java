package com.hzfc.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

/**
 * FileUtil 文件操作类
 * 
 * @author sunjun
 * @version v2.0
 */
public class ZipFileUtil {

 /**
  * 创建目录
  * 
  * @param absolutePath
  *            目录绝对路径
  * @throws IOException
  */
 public static void createDirectory(String absolutePath) throws IOException {
  File file = new File(absolutePath);
  if (!file.exists())
   file.mkdirs(); // 创建不存在在但必须有的目录
 }

 /**
  * 在指定目录创建年月日目录,返回"/年/月/日"时间目录字符串
  * 
  * @param file
  *            指定目录
  * @return "/年/月/日"时间目录字符串
  * @throws IOException
  */
 public static String createDirectoryByDate(File file) throws IOException {
  SimpleDateFormat f = new SimpleDateFormat("/yyyy/MM/dd");
  String path = f.format(new Date());
  createDirectory(file.getAbsolutePath() + f.format(new Date()));
  return path;
 }

 /**
  * 删除文件或目录
  * 
  * @param file
  *            文件或目录
  * @throws FileNotFoundException
  */
 public static void deleteFile(File file) throws FileNotFoundException {
  if (!(file.exists() && file.canRead() && file.canWrite()))
   return;
  if ((file.isDirectory() && file.listFiles().length == 0)
    || !file.isDirectory()) {
   file.delete();
   return;
  }
  for (File f : file.listFiles())
   deleteFile(f);
  deleteFile(file);
 }

 /**
  * 删除文件或目录列表
  * 
  * @param file
  *            文件或目录
  * @throws FileNotFoundException
  */
 public static void deleteFile(List fileList, ServletContext context)
   throws FileNotFoundException {
  if (fileList.isEmpty())
   return;
  Map map = null;
  Set keys = null;
  String key = null;
  String value = null;
  for (int i = 0; i < fileList.size(); i++) {
   map = (Map) fileList.get(i);
   keys = map.keySet();
   for (Iterator iter = keys.iterator(); iter.hasNext();) {
    key = (String) iter.next();
    value = (String) map.get(key);
    if (!(value == null || value.equals("")))
     deleteFile(new File(context.getRealPath(value)));
   }
  }
 }

 /**
  * 得到文件后缀名
  * 
  * @param fileName
  *            文件名
  * @return 后缀名
  */
 public static String getFileSuffixName(File file) {
  if (file.isDirectory())
   return "";
  String fileName = file.getName();
  if (fileName.indexOf(".") > 0)
   return fileName.substring(fileName.lastIndexOf("."));
  return "";
 }

 /**
  * 检查文件后缀名是否符合要求
  * 
  * @param suffixName
  *            后缀名
  * @param suffixListStr
  *            后缀名限制字符串(以|为分隔符)
  * @return boolean
  */
 public static boolean checkFileSuffix(String suffixName,
   String suffixListStr) {
  for (String s : suffixListStr.split("\\|"))
   if (suffixName.equalsIgnoreCase(s))
    return true;
  return false;
 }

 /**
  * 将给定的内容输出到指定的文件
  * 
  * @param content
  *            内容
  * @param file
  *            文件
  * @throws IOException
  */
 public static void writeStringToFile(String content, File file)
   throws IOException {
  FileUtils.writeStringToFile(file, content);
 }

 /**
  * 读取文件的内容
  * 
  * @param file
  *            文件
  * @return 文件内容
  * @throws Exception
  */
 public static String readFileToString(File file) throws Exception {
  return FileUtils.readFileToString(file);
 }

 /**
  * 下载文件
  * 
  * @param input
  *            下载输入流对象
  * @param response
  *            HttpServletResponse对象
  * @param filename
  *            下载提示文件名
  * @throws Exception
  */
 public static void downLoad(InputStream input,
   HttpServletResponse response, String filename) throws Exception {
  // 指定默认的contentType，为弹出下载框
  String contentType = "application/x-download";
  downLoad(input, response, filename, contentType);
 }

 /**
  * 下载文件
  * 
  * @param input
  *            下载输入流对象
  * @param response
  *            HttpServletResponse对象
  * @param fileName
  *            下载提示文件名
  * @param contentType
  *            下载的ContentType
  * @throws Exception
  */
 public static void downLoad(InputStream input,
   HttpServletResponse response, String fileName, String contentType)
   throws Exception {
  if (contentType == null || "".equals(contentType))
   contentType = "application/x-download";
  response.setContentType("application/" + contentType);
  response.addHeader("Content-Disposition", "attachment;filename="
    + URLEncoder.encode(fileName, "UTF-8"));
  // 定义输出流对象
  OutputStream output = null;
  try {
   output = response.getOutputStream();
   byte[] buffer = new byte[1024 * 8];
   int readLen = 0;
   while ((readLen = input.read(buffer)) != -1)
    output.write(buffer, 0, readLen);
  } catch (Exception e) {
   e.printStackTrace();
  } finally {
   try {
    // 关闭流
    try {
     // 关闭输入流
     if (input != null)
      input.close();
    } catch (java.io.IOException e) {
     e.printStackTrace();
    }
    if (output != null) {
     output.flush();
     output.close();
    }
   } catch (java.io.IOException e) {
    e.printStackTrace();
   }
  }
 }

 /**
  * 根据指定的文件绝对路径得到文件大小字符串
  * 
  * @param file
  *            文件
  * @return 文件大小字符串
  */
 public static String getFileSize(File file) {
  if (file.isDirectory())
   return "-";
  double size = file.length();
  if (size >= 0 && size < 1024)
   return file.length() + "Byte";
  if (size >= 1024 && size < 1024 * 1024)
   return formatNumber(size / 1024, 2, 2) + "KB";
  return formatNumber(size / 1024 * 1024, 2, 2) + "MB";
 }

 /**
  * 得到数字格式化后的字符串
  * 
  * @param number
  *            Number类型
  * @param minFractionDigits
  *            小数最小位数
  * @param maxFractionDigits
  *            小数最大位数
  * @return String 格式化后的字符串
  */
 private static String formatNumber(Number number, int minFractionDigits,
   int maxFractionDigits) {
  NumberFormat format = NumberFormat.getInstance();
  format.setMinimumFractionDigits(minFractionDigits);
  format.setMaximumFractionDigits(maxFractionDigits);
  return format.format(number);
 }

 /**
  * 加载属性文件(.properties)
  * 
  * @param file
  *            文件
  * @return Properties 对象
  * @throws IOException
  */
 public static Properties loadProperties(File file) throws IOException {
  Properties prop = new Properties();
  InputStream input = null;
  try {
   if (file.exists() && file.canRead()) {
    input = new FileInputStream(file);
    prop.load(input);
   }
  } catch (Exception ex) {
   ex.printStackTrace();
  } finally {
   if (input != null)
    input.close();
  }
  return prop;
 }

 /**
  * 将Properties的内容保存到.properties文件中
  * 
  * @param prop
  *            Properties对象
  * @param file
  *            properties文件
  * @throws IOException
  */
 public static void storePropertie(Properties prop, File file)
   throws IOException {
  if (!file.exists())
   file.createNewFile();
  OutputStream output = null;
  try {
   output = new FileOutputStream(file);
   prop.store(output, file.getName());
  } catch (Exception ex) {
   ex.printStackTrace();
  } finally {
   if (output != null) {
    output.flush();
    output.close();
   }
  }
 }

 /**
  * 得到指定的http url的HTML,保存到指定路径
  * 
  * @param file
  *            保存文件
  * @param httpurl
  *            http url
  * @throws IOException
  */
 public static void writeToFileByURL(File file, String httpurl)
   throws IOException {
  writeStringToFile(getStringByHTTPURL(httpurl), file);
 }

 /**
  * 得到给定 网址的html内容
  * 
  * @param 网址
  * @return 结果HTML
  */
 public static String getStringByHTTPURL(String httpurl) {
  StringBuilder sb = new StringBuilder();
  HttpURLConnection con = null;
  URL url = null;
  BufferedReader reader = null;
  try {
   url = new URL(httpurl);
   con = (HttpURLConnection) url.openConnection();
   // 可设置编码
   reader = new BufferedReader(new InputStreamReader(con
     .getInputStream()));
   String line = null;
   while ((line = reader.readLine()) != null)
    sb.append(line);
  } catch (Exception e) {
   e.printStackTrace();
  } finally {
   // 关闭连接和流
   if (reader != null) {
    try {
     reader.close();
    } catch (IOException e) {
     e.printStackTrace();
    }
   }
   if (con != null)
    con.disconnect();
  }
  return sb.toString();
 }

//删除文件夹
	// param folderPath 文件夹完整绝对路径

	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 删除指定文件夹下所有文件
	// param path 文件夹完整绝对路径
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}
	
}