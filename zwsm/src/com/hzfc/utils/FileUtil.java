/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hzfc.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
/**
 *
 * @author IBM
 */
public class FileUtil {
    public static List<String> ss;
    public  static String CreateGUID()    {
      return  System.currentTimeMillis()+"";
    }
    public static String getName(String filename){
    	 int i = filename.indexOf('.');
         int leg = filename.length();
         return (i > 0 ? (i + 1) == leg ? " " : filename.substring(i-1, filename.length()) : " ").toLowerCase();
    }
    public static String getExtName(String filename) {
        int i = filename.indexOf('.');
        int leg = filename.length();
        return (i > 0 ? (i + 1) == leg ? " " : filename.substring(i, filename.length()) : " ").toLowerCase();
    }
    
    public static boolean  CreateDir(String dir) {
       File fp = new File(dir);  
        if (!fp.exists()) {  
            fp.mkdirs();
        }
        return true;
    }
    /*
     * 写入 FileManager.write("Hello, World!", "D:\\test.txt", "UTF-8");
       读取 System.out.println(FileManager.read("D:\\test.txt", "UTF-8"));
     */
     public static String FileRead(String fileName, String encoding) { 
        StringBuilder fileContent = new StringBuilder(); 
        try { 
            FileInputStream fis = new FileInputStream(fileName); 
            InputStreamReader isr = new InputStreamReader(fis, encoding); 
            BufferedReader br = new BufferedReader(isr); 
            String line = null; 
            while ((line = br.readLine()) != null) { 
                fileContent.append(line); 
                fileContent.append(System.getProperty("line.separator")); 
            } 
            br.close(); 
            isr.close(); 
            fis.close(); 
        } catch (Exception e) { 
        } 
        return fileContent.toString(); 
    } 
     public static void FileWrite(String fileContent, String fileName, String encoding) { 
        try { 
            FileOutputStream fos = new FileOutputStream(fileName); 
            OutputStreamWriter osw = new OutputStreamWriter(fos, encoding); 
            osw.write(fileContent); 
            osw.flush(); 
            osw.close(); 
            fos.close(); 
        } catch (Exception e) { 
        } 
    } 
     
 	/**
 	 * 文件复制
 	 * @param src
 	 * @param dst
 	 */
 	public static void copy(File src, File dst)  {
 		int BUFFER_SIZE = 16*1024;	
        try  {
           InputStream in = null ;
           OutputStream out = null ;
            try  {                
               in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
               out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
                byte[] buffer = new byte[BUFFER_SIZE];
                while(in.read(buffer) > 0 )  {
                   out.write(buffer);
               } 
            } finally  {
                if ( null != in)  {
                   in.close();
               } 
                 if ( null != out)  {
                   out.close();
               } 
           } 
        } catch (Exception e)  {
           e.printStackTrace();
       } 
   } 
}
