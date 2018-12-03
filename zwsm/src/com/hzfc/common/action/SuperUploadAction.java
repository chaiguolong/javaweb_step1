package com.hzfc.common.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.hzfc.utils.ZipFileUtil;

@SuppressWarnings("serial")
public class SuperUploadAction extends SuperAction {

	private List<File> fileName;// 这里的"fileName"一定要与表单中的文件域名相同

	private List<String> fileNameContentType;// 格式同上"fileName"+ContentType

	private List<String> fileNameFileName;// 格式同上"fileName"+FileName

	private String fileRealName;// 文件名

	private String fileExt; // 文件扩展名

	private String savePath;// 文件上传后保存的路径

	private String removePath;// 需要移除的临时文件路径

	public static final String UPLOAD_TEMP_FOLDER = "upload/tempfile/";// 临时文件夹

	public static final int UPLOAD_SIZE_THRESHOLD = 1024 * 20;// 设置内存阀值，超过后写入临时文件:20KB
	
	// 前台每文件最大上传量:500K
    public static final int WEB_MAX_UPLOAD_FILE_SIZE = 1024 * 200;
    
    //允许支持上传
    public final static String UPLOAD_ALLOW_FILES = "jpg,jpeg,gif,png,pdf,swf,mp3,zip,doc,docx,xls,xlsx"; 
    
    public void uploadFile() {// 上传至临时文件夹

		File dir = new File(getWebRootDir() + UPLOAD_TEMP_FOLDER);

		if (!dir.exists()) { // 判断文件夹是否生成
			dir.mkdirs();
		}

		try {

			for (int i = 0; i < fileName.size(); i++) {

				FileInputStream in = new FileInputStream(fileName.get(i));// 取得输入流
				
				long now = System.currentTimeMillis();

				fileRealName = fileNameFileName.get(i);

				fileExt = fileRealName
						.substring(fileRealName.lastIndexOf(".") + 1);

				savePath = UPLOAD_TEMP_FOLDER + String.valueOf(now)
						+ (int) Math.random() * 1000 + "." + fileExt;// 临时存放路径

				File saveFile = new File(getWebRootDir() + savePath);

				if (!saveFile.exists()) { // 创建文件
					saveFile.createNewFile();
				}

				FileOutputStream out = new FileOutputStream(saveFile);// 定义输出流

				byte[] buffers = new byte[UPLOAD_SIZE_THRESHOLD];// 设置缓冲大小
				int len = 0;
				while ((len = in.read(buffers)) != -1) {
					out.write(buffers, 0, len);
				}

				in.close();
				out.close();// 关闭输入，输出流
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		this.renderHtml("{'flag':true,'path':'" + savePath + "','ext':'"
				+ fileExt + "','name':'" + fileRealName + "'}");
	}

	public void upload() {// 上传至临时文件夹

		File dir = new File(getWebRootDir() + UPLOAD_TEMP_FOLDER);

		if (!dir.exists()) { // 判断文件夹是否生成
			dir.mkdirs();
		}

		try {

			for (int i = 0; i < fileName.size(); i++) {

				FileInputStream in = new FileInputStream(fileName.get(i));// 取得输入流
				
				long now = System.currentTimeMillis();

				fileRealName = fileNameFileName.get(i);

				fileExt = fileRealName
						.substring(fileRealName.lastIndexOf(".") + 1);

				savePath = UPLOAD_TEMP_FOLDER + String.valueOf(now)
						+ (int) Math.random() * 1000 + "=." + fileExt;// 临时存放路径

				File saveFile = new File(getWebRootDir() + savePath);

				if (!saveFile.exists()) { // 创建文件
					saveFile.createNewFile();
				}

				FileOutputStream out = new FileOutputStream(saveFile);// 定义输出流

				byte[] buffers = new byte[UPLOAD_SIZE_THRESHOLD];// 设置缓冲大小
				int len = 0;
				while ((len = in.read(buffers)) != -1) {
					out.write(buffers, 0, len);
				}

				in.close();
				out.close();// 关闭输入，输出流
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		this.renderHtml("{'flag':true,'path':'" + savePath + "','ext':'"
				+ fileExt + "','name':'" + fileRealName + "'}");
	}
	
	public void webup() {// 上传至临时文件夹

		File dir = new File(getWebRootDir() + UPLOAD_TEMP_FOLDER);

		if (!dir.exists()) { // 判断文件夹是否生成
			dir.mkdirs();
		}

		try {

			for (int i = 0; i < fileName.size(); i++) {

				FileInputStream in = new FileInputStream(fileName.get(i));// 取得输入流
				
				if(in.available() > WEB_MAX_UPLOAD_FILE_SIZE){//上传文件过大
					this.renderHtml("{'flag':false,'msg':'上传文件不能超长200K'}");
				}
				else {
					
					long now = System.currentTimeMillis();
					
					fileRealName = fileNameFileName.get(i);
					
					fileExt = fileRealName
					.substring(fileRealName.lastIndexOf(".") + 1);
					
					savePath = UPLOAD_TEMP_FOLDER + String.valueOf(now)
					+ (int) Math.random() * 1000 + "=." + fileExt;// 临时存放路径
					
					File saveFile = new File(getWebRootDir() + savePath);
					
					if (!saveFile.exists()) { // 创建文件
						saveFile.createNewFile();
					}
					
					FileOutputStream out = new FileOutputStream(saveFile);// 定义输出流
					
					byte[] buffers = new byte[UPLOAD_SIZE_THRESHOLD];// 设置缓冲大小
					int len = 0;
					while ((len = in.read(buffers)) != -1) {
						out.write(buffers, 0, len);
					}
					
					in.close();
					out.close();// 关闭输入，输出流
					this.renderHtml("{'flag':true,'path':'" + savePath + "','ext':'"
							+ fileExt + "','name':'" + fileRealName + "'}");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}


	public void remove() {// 从临时文件夹中删除

		if (StringUtils.isNotBlank(removePath)) {
			
			File delFile = new File(getWebRootDir() + removePath);
			if (delFile.exists()) {
				delFile.delete();
			}

			this.renderHtml("{'flag':true}");
		} else {
			this.renderHtml("{'flag':false}");
		}
	}
	
	public void removeMore() {// 从临时文件夹中删除多个文件

		if (StringUtils.isNotBlank(removePath)) {
			String [] path = removePath.split(",");
			for(int i = 0; i < path.length && StringUtils.isNotBlank(path[i]); i ++){
				File delFile = new File(getWebRootDir() + path[i]);
				if (delFile.exists()) {
					delFile.delete();
				}
			}

			this.renderHtml("{'flag':true}");
		} else {
			this.renderHtml("{'flag':false}");
		}
	}
	
	public void removeDir() {//删除目录下的所有文件

		if (StringUtils.isNotBlank(removePath)) {
			String [] path = removePath.split(",");
			for(int i = 0; i < path.length && StringUtils.isNotBlank(path[i]); i ++){
				ZipFileUtil.delFolder(getWebRootDir() + path[i]);
			}

			this.renderHtml("{'flag':true}");
		} else {
			this.renderHtml("{'flag':false}");
		}
	}
	
	//允许上传的文件格式
	public boolean checkFilesNotAllow(String ext){
		ext = ext.toLowerCase().trim();
		if(UPLOAD_ALLOW_FILES.indexOf(ext) >= 0){
			return false;
		}
		else {
			return true;
		}
	}


	public List<File> getFileName() {
		return fileName;
	}

	public void setFileName(List<File> fileName) {
		this.fileName = fileName;
	}

	public List<String> getFileNameContentType() {
		return fileNameContentType;
	}

	public void setFileNameContentType(List<String> fileNameContentType) {
		this.fileNameContentType = fileNameContentType;
	}

	public List<String> getFileNameFileName() {
		return fileNameFileName;
	}

	public void setFileNameFileName(List<String> fileNameFileName) {
		this.fileNameFileName = fileNameFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public String getRemovePath() {
		return removePath;
	}

	public void setRemovePath(String removePath) {
		this.removePath = removePath;
	}

	public String getFileRealName() {
		return fileRealName;
	}

	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}

}
