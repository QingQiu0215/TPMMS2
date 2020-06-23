import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class TPMMSort {
	/*
	 * This is phaseOne method to do the TPMM method phase one
	 * 
	 * */
	public static ArrayList<File> phaseOne(File inFile) {
		
		//ArrayList to store subfile
		ArrayList<File> files = new ArrayList<File>();
		
		//ArrayList to store tuples
		ArrayList<String> tuples = new ArrayList<String>();
		
		//Current file
		File current_file;
		
		//Check available memory
		
		//BufferedReader
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(inFile), "UTF-8"))){
			
			String tuple;
			long tuple_number = 0;
			//Read the entire file
			Config.COUNT_START_TUPLES=0;
			while ((tuple = reader.readLine())!=null) {
				
				//Check if main memory is full
				//If the main memory if full, write to subfile
				if (tuple_number >= Config.MAX_TUPLE_NUMBER) {
					//add the List to file
					current_file = writeListToSubFile(tuples);					
					files.add(current_file);
					//Reset counter
					tuple_number = 0;
					//Erase tuples
					tuples.clear();
				}
				//add current tuple to tuples ArrayList
				tuples.add(tuple);
				tuple_number++;
				Config.COUNT_START_TUPLES++;
			}		

			if (tuples.isEmpty() == false) {
				current_file = writeListToSubFile(tuples);
				files.add(current_file);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		} 
		finally {
			//left tuple file
			tuples.clear();
			//System.out.println("Exception");
		}
		System.gc();
		return files;
	}
	
	
	public static void phaseTwo(ArrayList<File> subfiles,File filename) throws FileNotFoundException,IOException {
			FileWriter writer = new FileWriter(filename);
		
		
			//ArrayList to include all subfiles' BufferedReader
			ArrayList<BufferedReader> readers = new ArrayList<BufferedReader>();
		
			for (File subfile : subfiles) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(subfile)));
					readers.add(reader);
			}
			
			int readers_number = readers.size();
			PriorityQueue<String> pq = new PriorityQueue<String>(readers_number, SortIdDate);
			Hashtable<String, BufferedReader> hash = new Hashtable<String, BufferedReader>(); 
				
			for (BufferedReader current_reader : readers) {
				String reader_string;
				reader_string = current_reader.readLine();
				
				if (reader_string != null) {
					hash.put(reader_string, current_reader);
					pq.add(reader_string);
				}
				
			}
			
			while(pq.size() > 0) {
				String current_string = pq.peek();
				BufferedReader current_reader = hash.get(current_string);
				writer.write(current_string + System.lineSeparator());
				pq.remove();
				hash.remove(current_string);

				//System.out.println(hash.size());
				try {
					if ((current_string = current_reader.readLine()) != null) {
						
						if (!hash.contains(current_string)) {

							hash.put(current_string,current_reader);
							pq.add(current_string);
						} 
						else {
							current_reader.readLine();
						}
						
					} else {
						current_reader.close();
					}
				} catch(NullPointerException e) {
					
				}
			}

		writer.close();
		
		//return filename;
	}
	
	
	
	public static void mergeAndRemoveDuplicateID(File inputFile,File outputFile) throws FileNotFoundException,IOException {
			FileWriter writer = new FileWriter(outputFile);
		
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
			String tuple1 = reader.readLine();
			String tuple2 = reader.readLine();
			String id1 = tuple1.subSequence(0, Config.EMPID_LEN).toString();
			String id2 = tuple2.subSequence(0, Config.EMPID_LEN).toString();
			if (id1 != id2) {
				writer.write(tuple1 + System.lineSeparator());
				//System.out.println(tuple1);
			}
			
			while(tuple2 != null) {
				id1 = tuple1.subSequence(0, Config.EMPID_LEN).toString();
				id2 = tuple2.subSequence(0, Config.EMPID_LEN).toString();					
				if (id1.equals(id2)) {
					tuple1 = tuple2;
					tuple2 = reader.readLine();
					//System.out.println("Same");

					continue;
				} else {
					Config.COUNT_END_TUPLES++;
					writer.write(tuple2 + System.lineSeparator());
					tuple1 = tuple2;
					tuple2 = reader.readLine();
					//System.out.println("Different");
				}
			}
			
			reader.close();
		    writer.close();
	}
	
	
	
	public static File writeListToSubFile(ArrayList<String> tuples) {
		sortList(tuples);
		//File 
		File myfile = null;
		try {
			myfile = File.createTempFile("temp", null);
			//System.out.println(myfile.getAbsolutePath());
			myfile.deleteOnExit();
			FileWriter writer = new FileWriter(myfile); 
			for(String str: tuples) {
			  writer.write(str + System.lineSeparator());
			}
			writer.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myfile;
	}
	
	
	
	
	/*
	 * This method sort the input tuple by EmployID and last update Date
	 * Sort by EmployID first, if the EmployID is same, then sort by last update date
	 * @param ArrayList<String> tuples, the ArrayList need to be sorted
	 */
	public static void sortList(ArrayList<String> tuples) {
		Collections.sort(tuples,SortIdDate);
	}
	
	

	private static Comparator<String> SortIdDate = new Comparator<String>() {
	    public int compare(String str1, String str2) {
	    	String substr1_empid = str1.substring(0,Config.EMPID_LEN);
	    	String substr2_empid = str2.substring(0,Config.EMPID_LEN);
	    	
	    	String substr1_date = str1.substring(Config.EMPID_LEN,Config.EMPID_LEN + Config.LASTUPDATE_LEN);
	    	String substr2_date = str2.substring(Config.EMPID_LEN,Config.EMPID_LEN + Config.LASTUPDATE_LEN);
    	
	        int empid_compare = substr1_empid.compareTo(substr2_empid);
	        int date_compare = substr2_date.compareTo(substr1_date);
	        if (empid_compare == 0) {
	        	return ((date_compare == 0) ? empid_compare : date_compare);
	        } else {
	        	return empid_compare;
	        }
	    }
	};
	
	
	
}

