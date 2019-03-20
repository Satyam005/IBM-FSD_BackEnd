package com.example.java.fileio;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class SerializeEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "Goku");
		map.put(2, "Satyam");
		map.put(3, "Vegeta");
		map.put(4, "Stark");
		
		try {
			FileOutputStream fout = new FileOutputStream("D:\\sederial\\output.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			
			out.writeObject(map);
			out.close();
			fout.close();
			
			System.out.printf("Serialized data is saved");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}