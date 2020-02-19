package com.google.demoForIdea.common;


import java.io.*;

public class Xuliehua {
    	public static void main(String[] args) throws IOException, ClassNotFoundException {
		   /* User user = new User();
		    user.setUsername("汤彪");
		    byte[] bytes = toBytes(user);
		    System.out.println(bytes);
		    User user2 = (User) toObj(bytes);
		    System.out.println(user2.getUsername()+"反序列化");

		    toFile(user, "C:/Users/tangcomes/Desktop/console.txt");
		    User user4 = (User) fromFile("C:/Users/tangcomes/Desktop/console.txt");
		    System.out.println(user4.getUsername()+"我读");*/
/*
    			        
    			        String path ="C:/Users/tangcomes/Desktop/27console.txt";
		    String pathWrite ="C:/Users/tangcomes/Desktop/console.txt";
		    System.out.println( read(path));
		   writeFile(pathWrite,"汤彪");*/
}


		//写
	public static void writeFile(String fileName, String fileContent)
	{
		try
		{
			File f = new File(fileName);
			if (!f.exists())
			{
				f.createNewFile();
			}
			OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(f),"gbk");
			BufferedWriter writer=new BufferedWriter(write);
			writer.write(fileContent);
			writer.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}


    			        
//读
	private static String read(String fileName) throws FileNotFoundException {
		String fileContent = "";

		try
		{
			File f = new File(fileName);
		 if(f.isFile()&&f.exists())
		 {
		 	//做的操作是将字节流转换成字符流
		 	InputStreamReader read = null;
		 	//new FileInputStream(f)是创建输入流,此时读取的是文件的字节流，in.read()读取的是字节
		 read = new InputStreamReader(new FileInputStream(f),"gbk");
			// 创建一个reader的字符留缓冲区，将字符装载入缓冲区中
			 BufferedReader reader=new BufferedReader(read);
			 String line;
			 //用缓冲区的readLine(行的读取，返回值为String)读取文件
		while ((line = reader.readLine()) != null)
		 {
		fileContent += line;
		 }

			 read.close();
		 }
	} catch (Exception e)
	{
		e.printStackTrace();
	}
   return fileContent;


	 }
		//反序列化
    	  public static Serializable toObj(byte[] bytes) throws IOException, ClassNotFoundException {
    	        try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
    	            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
    	        ){ 
    	            Object o = objectInputStream.readObject();
    	            return (Serializable) o;
    	        }
    	    }
    	  //序列化
    			        
	        public static byte[] toBytes(Serializable obj) throws IOException {
	            try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
	            ){
	                objectOutputStream.writeObject(obj);
	                return byteArrayOutputStream.toByteArray();
	            }
	        }    	
	        //写文件
	        public static void toFile(Serializable obj, String filePath) throws IOException {
	            try(FileOutputStream fileOutputStream = new FileOutputStream(filePath);
	                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	            ){
	                objectOutputStream.writeObject(obj);
	            }
	        }
	        //读文件
	        public static Serializable fromFile(String filePath) throws IOException, ClassNotFoundException {
	            try(FileInputStream fileInputStream = new FileInputStream(filePath);
	                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	            ) {
	                return (Serializable) objectInputStream.readObject();
	            }
	        }
    				 
}

    	