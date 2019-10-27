package com.qixin.ssh.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.qixin.common.HttpClient;
import com.qixin.common.PropertiesUtil;
import com.qixin.ssh.model.FileEntity;
import com.qixin.ssh.model.Files;
import com.qixin.ssh.services.FileService;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



@Controller
public class FileController {		
	ObjectMapper objectMapper = new ObjectMapper();
	Gson gson = new Gson();
	private FileService fileService;	
	public FileService getFileService() {
		return fileService;
	}
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	public void init(){
		System.out.println("最新");
	}	

	//文件上传
	 @RequestMapping(value = "testUpload")
	    @ResponseBody
	    public String testUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") CommonsMultipartFile file) throws JsonProcessingException {
		 Map result = new HashMap();
			try {
				// fastDfs上传
				String fileName = file.getOriginalFilename();
				//后缀名字
				String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
				File tempFile = new File(System.getProperty("user.dir")
						+ File.separator + "fileHome" + File.separator + fileName);
				
			
				if (!tempFile.getParentFile().exists()) {
					tempFile.getParentFile().mkdirs();
				}
				if (tempFile.exists()) {
					tempFile.delete();
				}
				file.transferTo(tempFile);
				//字节数
				System.out.println(tempFile.length()+"?");
				String fdfsUploadResultss = HttpClient.httpFileUpload(
						PropertiesUtil.readProperty("fileServer")
								+ "/uploadFile.htm", tempFile); //如果是本地就写当前方法，groupName，saveName也拿不到
				HashMap<String, String> fdfsUploadResults = gson.fromJson(
						fdfsUploadResultss, HashMap.class);
				String groupName = fdfsUploadResults.get("groupName");
				String saveName = fdfsUploadResults.get("saveName");
				Files files = new Files();
				files.setFileName(fileName);
				files.setGroupName(groupName);
				files.setSaveName(saveName);
				if (tempFile.exists()) {
					tempFile.delete();
				}
				Files saveFiles = fileService.saveFiles(files);
				
				FileEntity fe = new FileEntity();
				fe.setFileId(saveFiles.getFileId());
				fe.setName(fileName);
				if ("docx".equals(extName) || "doc".equals(extName)
						|| "pdf".equals(extName) || "jpg".equals(extName)
						|| "jpeg".equals(extName) || "gif".equals(extName)) {
					fe.setLookPath("pvwatch/look.htm?fileId=" + saveFiles.getFileId());
				}
				fe.setDownloadPath("pvwatch/downloadFile.htm?fileId="
						+ saveFiles.getFileId());
			
				result.put("data", fe);
				result.put("msg", "文件上传成功");
			} catch (Exception e) {
				result.put("data", null);
				result.put("msg", "文件上传失败");
				e.printStackTrace();
			}
			return objectMapper.writeValueAsString(result);
	 }
	 //文件下载
	 @RequestMapping("downloadFile.htm")
		public void downloadFile(String fileId, HttpServletResponse response)
				throws IOException, KeyManagementException,
				NoSuchAlgorithmException {
			Files downFiles = fileService.downFiles(fileId);
			try {
				if (downFiles != null) {
					//服务器上得
					String filePath = System.getProperty("user.dir")
							+ File.separator + "fileHome" + File.separator
							+ downFiles.getGroupName() + File.separator
							+ downFiles.getSaveName();
					
					
					
					File file = new File(filePath);
					if (!file.getParentFile().exists()) {
						file.getParentFile().mkdirs();
					}
					if (!file.exists()) {
						//服务器上的
						byte[] buffer = HttpClient.doGet(PropertiesUtil
								.readProperty("fileServer")
								+ "/downloadFile.htm?groupName="
								+ downFiles.getGroupName()
								+ "&saveName="
								+ downFiles.getSaveName());
						
						if (buffer == null) {
							response.setContentType("text/html;charset=UTF-8");
							PrintWriter out = response.getWriter();
							out.print("文件暂时不能下载");
							out.flush();
							out.close();
							return;
						}
						FileUtils.writeByteArrayToFile(file, buffer);
					}
					ServletOutputStream outputStream = response.getOutputStream();
					String fileName = downFiles.getFileName();
					fileName = new String(fileName.getBytes(), "ISO-8859-1");
					response.setHeader("Content-Disposition",
							"attachment;filename=" + fileName);
					FileInputStream inputStream = new FileInputStream(file);
					int temp = 0;
					byte[] bt = new byte[1024];
					while ((temp = inputStream.read(bt, 0, bt.length)) != -1) {
						outputStream.write(bt, 0, temp);
					}
					outputStream.flush();
					outputStream.close();
					inputStream.close();
				} else {
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.print("文件不存在");
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("文件暂时不能下载");
				out.flush();
				out.close();
				e.printStackTrace();
			}
		}
	 
	 /**
		 * 预览
		 * 
		 * @throws IOException
		 * @throws NoSuchAlgorithmException
		 * @throws KeyManagementException
		 */
		@RequestMapping("look.htm")
		public void look(String fileId, HttpServletResponse response)
				throws IOException, KeyManagementException,
				NoSuchAlgorithmException {
			if (fileId == null || "".equals(fileId)) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("fileId不能为空");
				out.flush();
				out.close();
				return;
			}
			  Files downFiles = fileService.downFiles(fileId);
			if (downFiles != null) {
				try {
					 //后缀
					String extName = downFiles.getFileName().substring(downFiles.getFileName().lastIndexOf(".") + 1);
					if (!"pdf".equalsIgnoreCase(extName) 
							&& !"jpg".equalsIgnoreCase(extName)&& !"jpeg".equalsIgnoreCase(extName) && !"gif".equalsIgnoreCase(extName)&&!"png".equalsIgnoreCase(extName)
							&& !"txt".equalsIgnoreCase(extName) && !"xml".equalsIgnoreCase(extName)
							&& !"xlsx".equalsIgnoreCase(extName)&&!"docx".equalsIgnoreCase(extName) && !"doc".equalsIgnoreCase(extName)) {
						response.setContentType("text/html;charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.print("文件暂不支持预览");
						out.flush();
						out.close();
						return;
					}
					response.setContentType("text/html;charset=UTF-8");
					String sourceFilePath = System.getProperty("user.dir")
							+ File.separator + "fileHome" + File.separator
							+ downFiles.getGroupName() + File.separator
							+ downFiles.getSaveName();
					String targetFilePath = sourceFilePath;
					File sourceFile = new File(sourceFilePath);
					if (!sourceFile.getParentFile().exists()) {
						sourceFile.getParentFile().mkdirs();
					}
					byte[] buffer = null;
					if (!sourceFile.exists()) {
						response.setContentType("text/html;charset=UTF-8");
						buffer = HttpClient.doGet(PropertiesUtil
								.readProperty("fileServer")
								+ "/downloadFile.htm?groupName="
								+ downFiles.getGroupName()
								+ "&saveName="
								+ downFiles.getSaveName());
						FileUtils.writeByteArrayToFile(sourceFile, buffer);
					}
					if ("docx".equals(extName) || "doc".equals(extName)
							|| "xlsx".equals(extName)) {
						response.setContentType("text/html;charset=UTF-8");
						String pdfFilePath = sourceFilePath.substring(0,
								sourceFilePath.lastIndexOf(".") + 1) + "pdf";
						targetFilePath = pdfFilePath;
						File pdfFile = new File(pdfFilePath);
						if (!pdfFile.exists()) {
							String httpUrl = PropertiesUtil
									.readProperty("fileServer")
									+ "/convertFile.htm";
							Map<String, Object> params = new HashMap<String, Object>();
							params.put("file", sourceFile);
							params.put("fileType", "pdf");
							buffer = HttpClient.doPost(httpUrl, null, params,
									"multipart/form-Data");
							// 删除文件服务器上临时文件
							byte[] deleteFileByte = HttpClient
									.doGet(PropertiesUtil
											.readProperty("fileServer")
											+ "/deleteFile.htm");
							if (deleteFileByte != null) {
								String deleteFileResult = new String(deleteFileByte);
								System.out.println(deleteFileResult);
							}
						} else {
							response.setContentType("text/html;charset=UTF-8");
							FileInputStream inputStream = new FileInputStream(
									pdfFile);
							buffer = IOUtils.toByteArray(inputStream);
							inputStream.close();
						}
					} else {
						response.setContentType("text/html;charset=UTF-8");
						FileInputStream inputStream = new FileInputStream(
								sourceFile);
						buffer = IOUtils.toByteArray(inputStream);
						inputStream.close();
					}
					if (buffer == null) {
						response.setContentType("text/html;charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.print("连接文件服务器失败，请稍后重试！");
						out.flush();
						out.close();
						return;
					}
					File targetFile = new File(targetFilePath);
					if (!targetFile.exists()) {
						response.setContentType("text/html;charset=UTF-8");
						FileUtils.writeByteArrayToFile(targetFile, buffer);
					}
					response.setContentType("text/html;charset=UTF-8");
					ServletOutputStream outputStream = response.getOutputStream();
					response.setHeader("Content-disposition", "filename="
							+ downFiles.getFileName());
					FileInputStream inputStream = new FileInputStream(targetFile);
					int temp = 0;
					byte[] bt = new byte[1024];
					while ((temp = inputStream.read(bt, 0, bt.length)) != -1) {
						outputStream.write(bt, 0, temp);
					}
					outputStream.flush();
					outputStream.close();
					inputStream.close();
				} catch (IOException e) {
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.print("文件暂不支持预览");
					out.flush();
					out.close();
					e.printStackTrace();
				}
			} else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("文件不存在");
				out.flush();
				out.close();
			}
		}
}
