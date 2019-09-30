package cn.itheima.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadManyAction2 extends ActionSupport{
	private File[] upload;
	private String[] uploadContentType;
	private String[] uploadFileName;
	

	public File[] getUpload() {
		return upload;
	}


	public void setUpload(File[] upload) {
		this.upload = upload;
	}


	public String[] getUploadContentType() {
		return uploadContentType;
	}


	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}


	public String[] getUploadFileName() {
		return uploadFileName;
	}


	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}


	public void uploadFile(){
		String path=ServletActionContext.getServletContext().getRealPath("/upload");
		try {
		for(int i = 0;i<upload.length;i++){
		File dest=new File(path,uploadFileName[i]);
		
			FileUtils.copyFile(upload[i], dest);
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
