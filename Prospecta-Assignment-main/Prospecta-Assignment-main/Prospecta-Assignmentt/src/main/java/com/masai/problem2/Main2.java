package com.masai.problem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Main2 {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("csv.txt");
		
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		
//		System.out.println(line);
		
		String[] str = line.split(",");
		
		System.out.println(Arrays.toString(str));
		
		HashMap<String,String> hm = new HashMap<>();
		
		for(int i=0;i<str.length;i++) {
			
			String[] entry = str[i].split(": ");
			
			hm.put(entry[0], entry[1]);
			
			
		}
		System.out.println(hm);
		
		Set<String> set = hm.keySet();
		
		for(String key : set) {
			
			String value = hm.get(key);
			
			try {
				
				Integer ans = Integer.parseInt(value);
				System.out.println(ans);
				
			} catch (Exception e) {
				
				System.out.println("formula");
				String newValue = value.substring(1);
				
				System.out.println(newValue);
				
//				String[] arr = newValue.split("+");
				
				int ans = 0;
				
//				for(int i=0;i<arr.length;i++) {
//					ans += Integer.parseInt(hm.get(i));
//				}
				
				System.out.println(ans);
				
			}
			
			
			
			
		}
		
		
		
		
	}
	
	
}
