package com.google.demoForIdea.common;

import org.apache.commons.net.ftp.*;

import java.io.*;
import java.net.MalformedURLException;

public class FtpUtils {
  /*// ftp服务器地址
    public String hostname = "xxx";
    // ftp登录账号
    public String username = "ftpuser";
    // ftp登录密码
    public String password = "tq123456";*/

//    // ftp服务器地址
//    public String hostname = "xxx";
//    // ftp登录账号
//    public String username = "ftpuser";
//    // ftp登录密码
//    public String password = "tq123456";

	// ftp服务器地址
	public String hostname = "192.168.93.130";
	// ftp登录账号
	public String username = "tangcomes";
	// ftp登录密码
	public String password = "biao632613";

	// ftp服务器端口号默认为21
	public Integer port = 21;

	public FTPClient ftpClient = null;

	/**
	 * 初始化ftp服务器
	 */
	public void initFtpClient() {
		ftpClient = new FTPClient();
		ftpClient.setControlEncoding("utf-8");
		try {
			System.out.println("connecting...ftp服务器:" + this.hostname + ":" + this.port);
			ftpClient.connect(hostname, port); // 连接ftp服务器
			ftpClient.login(username, password); // 登录ftp服务器
			int replyCode = ftpClient.getReplyCode(); // 是否成功登录服务器
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("connect failed...ftp服务器:" + this.hostname + ":" + this.port);
			}else{
				System.out.println("connect successfu...ftp服务器:" + this.hostname + ":" + this.port);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 上传文件
	 *
	 * @param pathname
	 *            ftp服务保存地址
	 * @param fileName
	 *            上传到ftp的文件名
	 * @param originfilename
	 *            待上传文件的名称（绝对地址） *
	 * @return
	 */
	public boolean uploadFile(String pathname, String fileName, String originfilename) {
		InputStream inputStream = null;
		try {
			System.out.println("开始上传文件");
			inputStream = new FileInputStream(new File(originfilename));
			initFtpClient();
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

			ftpClient.setControlEncoding("UTF-8");

			CreateDirecroty(pathname);
			ftpClient.makeDirectory(pathname);
			ftpClient.changeWorkingDirectory(pathname);

			// 每次数据连接之前，ftp client告诉ftp server开通一个端口来传输数据
			ftpClient.enterLocalPassiveMode();

			ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);

			// 观察是否真的上传成功
			boolean storeFlag = ftpClient.storeFile(fileName, inputStream);
//            boolean storeFlag = ftpClient.storeFile(new String(fileName.getBytes("UTF-8"), "ISO-8859-1"), inputStream);
			System.err.println("storeFlag==" + storeFlag);
			inputStream.close();
			ftpClient.logout();
			System.out.println("上传文件成功");
		} catch (Exception e) {
			System.out.println("上传文件失败");
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	/**
	 * 上传文件
	 *
	 * @param pathname
	 *            ftp服务保存地址
	 * @param fileName
	 *            上传到ftp的文件名
	 * @param inputStream
	 *            输入文件流
	 * @return
	 */
	public boolean uploadFile(String pathname, String fileName, InputStream inputStream) {
		try {
			System.out.println("开始上传文件");
			initFtpClient();
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			CreateDirecroty(pathname);
			ftpClient.makeDirectory(pathname);
			ftpClient.changeWorkingDirectory(pathname);
			ftpClient.storeFile(fileName, inputStream);
			inputStream.close();
			ftpClient.logout();
			System.out.println("上传文件成功");
		} catch (Exception e) {
			System.out.println("上传文件失败");
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	// 改变目录路径
	public boolean changeWorkingDirectory(String directory) {
		boolean flag = true;
		try {
			flag = ftpClient.changeWorkingDirectory(directory);
			if (flag) {
				System.out.println("进入文件夹" + directory + " 成功！");

			} else {
				System.out.println("进入文件夹" + directory + " 失败！开始创建文件夹");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return flag;
	}

	// 创建多层目录文件，如果有ftp服务器已存在该文件，则不创建，如果无，则创建
	public boolean CreateDirecroty(String remote) throws IOException {
		boolean success = true;
		String directory = remote + "/";
		// 如果远程目录不存在，则递归创建远程服务器目录
		if (!directory.equalsIgnoreCase("/") && !changeWorkingDirectory(new String(directory))) {
			int start = 0;
			int end = 0;
			if (directory.startsWith("/")) {
				start = 1;
			} else {
				start = 0;
			}
			end = directory.indexOf("/", start);
			String path = "";
			String paths = "";
			while (true) {
				String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
				path = path + "/" + subDirectory;
				if (!existFile(path)) {
					if (makeDirectory(subDirectory)) {
						changeWorkingDirectory(subDirectory);
					} else {
						System.out.println("创建目录[" + subDirectory + "]失败");
						changeWorkingDirectory(subDirectory);
					}
				} else {
					changeWorkingDirectory(subDirectory);
				}

				paths = paths + "/" + subDirectory;
				start = end + 1;
				end = directory.indexOf("/", start);
				// 检查所有目录是否创建完毕
				if (end <= start) {
					break;
				}
			}
		}
		return success;
	}

	// 判断ftp服务器文件是否存在
	public boolean existFile(String path) throws IOException {
		boolean flag = false;
		FTPFile[] ftpFileArr = ftpClient.listFiles(path);
		if (ftpFileArr.length > 0) {
			flag = true;
		}
		return flag;
	}

	// 创建目录
	public boolean makeDirectory(String dir) {
		boolean flag = true;
		try {
			flag = ftpClient.makeDirectory(dir);
			if (flag) {
				System.out.println("创建文件夹" + dir + " 成功！");

			} else {
				System.out.println("创建文件夹" + dir + " 失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * * 下载文件 *
	 *
	 * @param pathname
	 *            FTP服务器文件目录 *
	 * @param filename
	 *            文件名称 *
	 * @param localpath
	 *            下载后的文件路径 *
	 * @return
	 */
	public boolean downloadFile(String pathname, String filename, String localpath) {
		boolean flag = false;
		OutputStream os = null;
		try {
			System.out.println("开始下载文件");
			initFtpClient();


			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);//传输的时候以二进制传输
			ftpClient.enterLocalPassiveMode();
//            ftpClient.setRemoteVerificationEnabled(false);

//            ftpClient.configure(new FTPClientConfig("com.zznode.tnms.ra.c11n.nj.resource.ftp.UnixFTPEntryParser"));
			//由于apache不支持中文语言环境，通过定制类解析中文日期类型
			ftpClient.configure(new FTPClientConfig("com.zznode.tnms.ra.c11n.nj.resource.ftp.UnixFTPEntryParser"));

			// 切换FTP目录
			boolean changeFlag = ftpClient.changeWorkingDirectory(pathname);
			System.err.println("changeFlag==" + changeFlag);


			// 查看有哪些文件夹 以确定切换的ftp路径正确
			String[] a = ftpClient.listNames();
			System.err.println(a[0]);


			FTPFile[] ftpFiles = ftpClient.listFiles();
			for (FTPFile file : ftpFiles) {
				if (filename.equalsIgnoreCase(file.getName())) {
					File localFile = new File(localpath + "/" + file.getName());
					os = new FileOutputStream(localFile);
					ftpClient.retrieveFile(file.getName(), os);
					os.close();
				}
			}
			ftpClient.logout();
			flag = true;
			System.out.println("下载文件成功");
		} catch (Exception e) {
			System.out.println("下载文件失败");
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	/**
	 * * 删除文件 *
	 *
	 * @param pathname
	 *            FTP服务器保存目录 *
	 * @param filename
	 *            要删除的文件名称 *
	 * @return
	 */
	public boolean deleteFile(String pathname, String filename) {
		boolean flag = false;
		try {
			System.out.println("开始删除文件");
			initFtpClient();
			// 切换FTP目录
			ftpClient.changeWorkingDirectory(pathname);
			ftpClient.dele(filename);
			ftpClient.logout();
			flag = true;
			System.out.println("删除文件成功");
		} catch (Exception e) {
			System.out.println("删除文件失败");
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		FtpUtils ftp = new FtpUtils();
		// 文件路径写为用户建立时 指定的目录
//         ftp.uploadFile("/var/ftp/pub", "resp.txt", "E:\\data\\resp.txt");
     //   ftp.uploadFile("tangcomes", "WhatsNew.txt", "E:\\WhatsNew.txt");
    //   ftp.downloadFile("tangcomes", "test.txt", "E://");
		//ftp.downloadFile("", "test.txt", "E://");
//        ftp.deleteFile("/var/ftp/pub", "resp.txt");

     //  ftp.deleteFile("tangcomes", "test.txt");
		System.out.println("ok");
	}
}
