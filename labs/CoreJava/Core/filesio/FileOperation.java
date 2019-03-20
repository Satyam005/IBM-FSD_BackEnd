//package com.example.java.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TreeMap;

public class FileOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File inputFile = new File("D:\\sederial\\output.txt");
			System.out.println(inputFile.length());
			FileInputStream fin = new FileInputStream(inputFile);
			//FileOutputStream fout = new FileOutputStream("C:\\Users\\DusayantaPrasad\\Desktop\\output.txt");
			int i = 0;
//			while((i = fin.read())!=-1) {
//				
//				fout.write(i);
//				System.out.print((char)i);
//			}
			if(fin.read()!=-1)
				System.out.println("Not empty");
			else
				System.out.println("empty");
			
			TreeMap<Integer, String> treemap = new TreeMap<>();
			
			if(treemap.isEmpty())
				System.out.println("treemap is empty");
			
			fin.close();
			//fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
