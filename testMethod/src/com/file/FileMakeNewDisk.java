package com.file;

import java.io.File;

public class FileMakeNewDisk {
	
	//尝试新建目录
	public void createNewDisk() throws Exception{
		String pathname = "D:\\documentTest";
		File file = new File(pathname + File.separator + "hello.txt");
		File file_path = new File(pathname);
		try {
			//System.out.println(file_path.exists());//文件夹是否存�?
			//System.out.println(file_path.isDirectory()); 是否是文件夹
			if(file_path.exists()){
				System.out.println("文件夹已存在");
			}else{
				file_path.mkdir();
			}
			if(file.exists()){
				System.out.print("文件已存�?");
			}else{
				file.createNewFile();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(">>文件夹执行错�?");
			file_path.delete();
		}
		
	}
}
