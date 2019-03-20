//package com.example.java.fileio;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class DeSerialize {

	public static HashMap<Integer, String> getMap(){
		
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "Hey");
		return map;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//HashMap<Integer, String> map = null;
		try {
			FileInputStream fin = new FileInputStream("D:\\sederial\\output.txt");
			if(fin.read()==-1)
				System.out.println("Empty file");
			
			ObjectInputStream in = new ObjectInputStream(fin);
			
			HashMap<Integer, String> map = (HashMap<Integer, String>)in.readObject();
			if(map.isEmpty())
				System.out.println("Empty map");
			
			in.close();
			fin.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
//		for(Map.Entry<Integer, String> hm : map.entrySet()) {
//			System.out.println(hm.getKey()+" "+hm.getValue());
//		}
		HashMap<Integer, String> map = getMap();
		if(map.isEmpty())
			System.out.println("Last Empty map");
	}
}