import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class BitMap {

	static Map<String,ArrayList<Integer>> map_EmpID=new HashMap<String,ArrayList<Integer>>();
	static Map<String,ArrayList<Integer>> map_Dept=new HashMap<String,ArrayList<Integer>>();
	static Map<String,ArrayList<Integer>> map_Gender=new HashMap<String,ArrayList<Integer>>();
	static ArrayList<String> duplicateEmpID=new ArrayList<>();
	public static void createBitmap(File inFile,String attributes){
		Config.COUNT_TUPLES=0;
		int startIndex=0,endIndex=0;
		if(attributes.equalsIgnoreCase("EmpID")) {
			startIndex=0;
			endIndex=8;
		}else if(attributes.equalsIgnoreCase("Dept")) {
			startIndex=44;
			endIndex=47;
		}else if(attributes.equalsIgnoreCase("Gender")) {
			startIndex=43;
			endIndex=44;
		}

		BufferedReader reader=null;
		try{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), "UTF-8"));
			String tuple;
			int index=0;
			while ((tuple = reader.readLine())!=null) {

				if(map_EmpID.containsKey(tuple.substring(0,8)))
					map_EmpID.get(tuple.substring(0,8)).add(index);
				else {
					ArrayList<Integer> temp=new ArrayList<Integer>();
					temp.add(index);
					map_EmpID.put(tuple.substring(0,8), temp);
				}
				if(map_Dept.containsKey(tuple.substring(44,47)))
					map_Dept.get(tuple.substring(44,47)).add(index);
				else {
					ArrayList<Integer> temp=new ArrayList<Integer>();
					temp.add(index);
					map_Dept.put(tuple.substring(44,47), temp);
				}	
				if(map_Gender.containsKey(tuple.substring(43,44)))
					map_Gender.get(tuple.substring(43,44)).add(index);
				else {
					ArrayList<Integer> temp=new ArrayList<Integer>();
					temp.add(index);
					map_Gender.put(tuple.substring(43,44), temp);
				}
				index++;
				Config.COUNT_TUPLES++;
				//reader.close();
			}	
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		} 
		
	}



	public static void outputBitmapToFile(Map<String,ArrayList<Integer>> map,String filePath) throws IOException {
		Config.COUNT_bitmap=0;
		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
		BufferedWriter writerToCompressFile = new BufferedWriter(new FileWriter("compressed_"+filePath));
		for(Map.Entry<String, ArrayList<Integer>> element:map.entrySet()) {
			StringBuffer temp = new StringBuffer("");
			ArrayList<Integer> currentList = element.getValue();
			int s = currentList.size();
			int tuple_num  = 0;
			for (int i = 0; i < s; i++) {
				int num = currentList.get(i);
				while (tuple_num < num) {
					temp.append("0");
					tuple_num++;
				}
				temp.append("1");
				tuple_num++;	
			}
			while (tuple_num < Config.COUNT_TUPLES) {
				temp.append("0");
				tuple_num++;
			}
			writer.write(temp+"\n");
			String compressedTemp=compress(temp.toString());
			writerToCompressFile.write(compressedTemp+"\n");
			Config.COUNT_bitmap++;
		}		
		writer.close();
		writerToCompressFile.close();
	}

	private static String compress(String str) {
		int N=quantityOne(str);
		int i=0,j=0;
		int prevOneIndex=-1;
		StringBuffer compressedStr = new StringBuffer();
		while(N>0) {
			i=str.indexOf("1",prevOneIndex+1)-(prevOneIndex+1);			
			prevOneIndex=str.indexOf("1",str.indexOf("1",prevOneIndex+1));
			if(i==0||i==1)
				j=1;
			else
				j=sizeJ(i);
			for(int p=0;p<j-1;p++) {
				compressedStr.append("1");
			}
			compressedStr.append("0");
			compressedStr.append(Integer.toBinaryString(i));
			N--;
		}			
		return compressedStr.toString();
	}
	
	private static int sizeJ(int i) {
		return (int) Math.ceil(Math.log(i)/Math.log(2));
	}
	
	private static int quantityOne(String str) {
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='1')
				count++;
		}
		return count;
	}
	
	public static void findDuplicate(Map<String,ArrayList<Integer>> mapT1,String filePath,File inFile1) throws IOException{
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(filePath));
		for(Map.Entry<String, ArrayList<Integer>> map:mapT1.entrySet()) {
			
			if(map_EmpID.containsKey(map.getKey())) {
				duplicateEmpID.add(map.getKey());
			}			
		}
		BufferedReader readerT1=null;
		try{
			readerT1 = new BufferedReader(new InputStreamReader(new FileInputStream(inFile1), "UTF-8"));
			String tuple;
			String key="";
			while ((tuple = readerT1.readLine())!=null) {
				key=tuple.substring(0,8);
				if(duplicateEmpID.contains(key)) {
					writer.write(tuple+"\n");
				}		
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		} 
		catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		}
		writer.close();
	}
	public static void merge(Map<String,ArrayList<Integer>> mapT1,Map<String,ArrayList<Integer>> mapT2, String filePath,File inFile1,File inFile2) throws IOException{
		BufferedReader readerT1=null;
		BufferedReader readerT2=null;
		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
		try{
			readerT1 = new BufferedReader(new InputStreamReader(new FileInputStream(inFile1), "UTF-8"));
			readerT2 = new BufferedReader(new InputStreamReader(new FileInputStream(inFile2), "UTF-8"));
			String tuple;
			int index=0;
			String key="";
			while ((tuple = readerT1.readLine())!=null) {
				key=tuple.substring(0,8);
				boolean bool1=(index==mapT1.get(key).get(mapT1.get(key).size()-1));
				boolean bool2=!duplicateEmpID.contains(key);
				if(bool1&&bool2) {
					writer.write(tuple+"\n");
				}
				index++;				
			}
			//readerT1.close();
			index=0;
			while ((tuple = readerT2.readLine())!=null) {
				key=tuple.substring(0,8);
				if((index==mapT2.get(key).get(mapT2.get(key).size()-1))) {
					writer.write(tuple+"\n");
				}
				index++;				
			}
			//readerT2.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		} 
		catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		} 		
	}
}
