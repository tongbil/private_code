package com.google.demoForIdea.common;


import java.io.*;

public class Xuliehua {
    	public static void main(String[] args) throws IOException, ClassNotFoundException {

    			        
    			        String path ="C:/Users/tangcomes/Desktop/27console.txt";
		    System.out.println( read(path));
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
		 	InputStreamReader read = null;
		 read = new InputStreamReader(new FileInputStream(f),"gbk");
			 BufferedReader reader=new BufferedReader(read);
			 String line;
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

    	