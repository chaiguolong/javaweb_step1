package com.hzfc.common.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.hzfc.utils.DateUtil;
import com.hzfc.utils.FileOperUtils;
import com.hzfc.utils.FileUtil;
import com.hzfc.utils.ImageUtils;
import com.hzfc.utils.ZipUtil;

@SuppressWarnings("serial")
public class CkEditorUploadAction extends SuperUploadAction {

	public static final String UPLOAD_CKEDITOR_FOLDER = "upload/ckeditor/";
	public static final String UPLOAD_BASE_FOLDER = "upload/";
	public final static String UPLOADREALPATH = "/upload/";
	public final static String UPLOADSWF = "*.swf";
    public final static String UPLOADMP3 = "*.mp3";
    public final static String UPLOADPIC = "*.jpg*.jpeg*.gif*.png";
	private File UpFiles;
	private String UpFilesFileName;
	private String UpFilesContentType;
	private ServletContext servletContext;
	private String UpFilesType = "pic";
	private long UpFilesSize = 0;
	private String UpFilesShowPic = "";
	private int UpFilesCount = 1;
	private String UpFilesName = "";
	private String addflag = "";
	private String type = "";

	public File getUpFiles() {
		return UpFiles;
	}

	public void setUpFiles(File upFiles) {
		UpFiles = upFiles;
	}

	public String getUpFilesFileName() {
		return UpFilesFileName;
	}

	public void setUpFilesFileName(String upFilesFileName) {
		UpFilesFileName = upFilesFileName;
	}

	public String getUpFilesContentType() {
		return UpFilesContentType;
	}

	public void setUpFilesContentType(String upFilesContentType) {
		UpFilesContentType = upFilesContentType;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public String getUpFilesType() {
		return UpFilesType;
	}

	public void setUpFilesType(String upFilesType) {
		UpFilesType = upFilesType;
	}

	public long getUpFilesSize() {
		return UpFilesSize;
	}

	public void setUpFilesSize(long upFilesSize) {
		UpFilesSize = upFilesSize;
	}

	public String getUpFilesShowPic() {
		return UpFilesShowPic;
	}

	public void setUpFilesShowPic(String upFilesShowPic) {
		UpFilesShowPic = upFilesShowPic;
	}

	public int getUpFilesCount() {
		return UpFilesCount;
	}

	public void setUpFilesCount(int upFilesCount) {
		UpFilesCount = upFilesCount;
	}

	public String getUpFilesName() {
		return UpFilesName;
	}

	public void setUpFilesName(String upFilesName) {
		UpFilesName = upFilesName;
	}

	public String getAddflag() {
		return addflag;
	}

	public void setAddflag(String addflag) {
		this.addflag = addflag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void ckupload() {
		try {
			for (int i = 0; i < getFileName().size(); i++) {
				FileInputStream in = new FileInputStream(getFileName().get(i));// 取得输入流
				long now = System.currentTimeMillis();
				setFileRealName(getFileNameFileName().get(i));
				setFileExt(getFileRealName().substring(
						getFileRealName().lastIndexOf(".") + 1));
				
				String data = DateUtil.getNowDateSplit("") + "/";
				//相对系统根目录的路径
				String path = UPLOAD_CKEDITOR_FOLDER
				+ takeDeepPath(getUpFilesType(), getFileExt()) + data;
				File dir = new File(getWebRootDir() + path);
				if (!dir.exists()) { // 判断文件夹是否生成
					dir.mkdirs();
				}
				String filename = String.valueOf(now)
				+ (int) Math.random() * 1000 + "." + getFileExt();
				
				//过滤非法文件
				if(checkFilesNotAllow(getFileExt())){
					this.renderHtml("{'flag':false,'path':'','ext':'"
							+ getFileExt() + "','name':'" + getFileRealName() + "'}");
					in.close();
					return ;
				}
				
				setSavePath(path + filename);// 临时存放路径
				File saveFile = new File(getWebRootDir() + getSavePath());
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
				if ("pic".equals(getUpFilesType()) && "true".equals(addflag)) {
					ImageUtils.pressImage(getWebRootDir() + UPLOAD_BASE_FOLDER
							+ "logo.png", getWebRootDir() + getSavePath(), 0, 0);
				}
				String width = (String) getParameterValue("width");
				String height = (String) getParameterValue("height");
				if (!"".equals(width) && !"".equals(height)) {
					FileOperUtils fou = new FileOperUtils();
					fou.doScaleImages(getSavePath(), width + "*" + height,
							false);
				}
				else if(!"".equals(width)) {
					FileOperUtils fou = new FileOperUtils();
					fou.doScaleImages(getSavePath(), width + "*" + width,
							false);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.renderHtml("{'flag':true,'path':'" + getSavePath() + "','ext':'"
				+ getFileExt() + "','name':'" + getFileRealName() + "'}");
	}
	
	/**
	 * 根据上传类型来获得相应路径
	 * 
	 * @param type
	 * @return
	 */
	public String takeDeepPath(String type,String extname) {
		String path = "";
		if ("pic".equals(getUpFilesType())) {
			path = "ospic/";
		} else if ("swf".equals(getUpFilesType())) {
			path = "osswf/";
		} else if ("zip".equals(getUpFilesType())) {
			path = "oszip/";
		} else {
			if (UPLOADMP3.indexOf(extname) >= 0) {// mp3上传
				path = "radio/";
			} else {
				path = "file/";
			}
		}
		return path;
	}
	
	public void Copy(File oldfile, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			// File oldfile = new File(oldPath);
			if (oldfile.exists()) {
				InputStream inStream = new FileInputStream(oldfile);
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					// System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			// System.out.println("error  ");
			e.printStackTrace();
		}
	}
}
