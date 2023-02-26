package com.masai.problem2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		// here I am create createing my file...
		File file = new File("csv.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileWriter fw = new FileWriter("csv.txt");
		
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("A1: 5, A2: 7, A3: 9, B1: 3, B2: 8, B3: =4+5, C1: =5+A1, C2: =A2+B2, C3: =C2+B3");
		
		bw.flush();
		bw.close();
		
		System.out.println("Done...");
		
		
		
	}
	

}
