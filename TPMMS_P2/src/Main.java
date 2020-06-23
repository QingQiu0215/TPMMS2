import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Main {


	public static void main(String[] args) throws IOException {

		System.out.println("The Main Memory size is: "+Config.AVAILABLE_MEMORY+" B");
		System.out.println("Main Memory usage: "+Config.MEMORY_USAGE);

		File file_T1 = new File(Config.SAMPLE);
		File file_T2 = new File(Config.SAMPLE_LA);
		
//		long nano_startTime = System.nanoTime(); 
//		ArrayList<File> subFiles1 = TPMMSort.phaseOne(file_T1);
//		int COUNT_START_TUPLES_T1=Config.COUNT_START_TUPLES;
//
//		ArrayList<File> subFiles2 = TPMMSort.phaseOne(file_T2);
//		int COUNT_START_TUPLES_T2=Config.COUNT_START_TUPLES;
//		
//		long nano_endTimePhaseOne = System.nanoTime(); 
//		//ArrayList<File> subFiles2 = TPMMSort.phaseOne(file_T2);			
//		File filea = new File("file1_sorted");
//		File fileb = new File("file2_sorted");
//		long nano_startTimePhaseTwo = System.nanoTime();
//		//File filec = 
//		TPMMSort.phaseTwo(subFiles1,filea);
//		//File filed = 
//		TPMMSort.phaseTwo(subFiles2,fileb);
//		long nano_endTimePhaseTwo = System.nanoTime();
//		
//		ArrayList<File> merge_file = new ArrayList<File>();
//		merge_file.add(filea);
//		merge_file.add(fileb);
//		
//		File final_merge = new File("merged_text");
//		//File final_file = 
//		TPMMSort.phaseTwo(merge_file, final_merge);
//		long nano_endTimeSort = System.nanoTime(); 
//		File final_file = new File("final_file");
//		TPMMSort.mergeAndRemoveDuplicateID(final_merge,final_file);
//		long nano_endTime = System.nanoTime(); 
//		
//		/*File file = new File("merge.txt");
//		File file_test = new File("testresult.txt");
//		TPMMSort.mergeAndRemoveDuplicateID(file,file_test);	
//		
//		*/
//
//		//calculate the I/O of input in pass one
//		int sublist_num_T1=(int)Math.ceil(COUNT_START_TUPLES_T1/Config.MAX_TUPLE_NUMBER);
//		int sublist_num_T2=(int)Math.ceil(COUNT_START_TUPLES_T2/Config.MAX_TUPLE_NUMBER);
//		int IO_input_passOne=sublist_num_T1+sublist_num_T2;
//		
//		//calculate the I/O of output in pass one
//		int IO_output_passOne=IO_input_passOne;
//		
//		//calculate the I/O of input in pass two		
//		int temp=(int)Math.ceil(Config.MAX_TUPLE_NUMBER/Config.TUPLES_IN_BLOCK);
//		int remainingTupleQty=COUNT_START_TUPLES_T1%(int)Config.MAX_TUPLE_NUMBER;
//		int IO_T1_Input_PassTwo=(sublist_num_T1-1)*temp+(int)Math.ceil(remainingTupleQty/Config.TUPLES_IN_BLOCK);
//		
//		int temp2=(int)Math.ceil(Config.MAX_TUPLE_NUMBER/Config.TUPLES_IN_BLOCK);
//		int remainingTupleQty2=COUNT_START_TUPLES_T2%(int)Config.MAX_TUPLE_NUMBER;
//		int IO_T2_Input_PassTwo=(sublist_num_T2-1)*temp+(int)Math.ceil(remainingTupleQty2/Config.TUPLES_IN_BLOCK);
//		
//		int IO_input_passTwo=IO_T1_Input_PassTwo+IO_T2_Input_PassTwo;
//		
//		//calculate the I/O of output in pass two
//		int IO_output_passTwo=(int)Math.ceil((COUNT_START_TUPLES_T1+COUNT_START_TUPLES_T2)/Config.TUPLES_IN_BLOCK);
//		
//		//calculate the I/O of input in merging two files
//		int IO_iuput_mergeFiles=(int)Math.ceil(COUNT_START_TUPLES_T1/Config.TUPLES_IN_BLOCK)+(int)Math.ceil(COUNT_START_TUPLES_T2/Config.TUPLES_IN_BLOCK);
//		
//		//calculate the I/O of output in merging two files
//		int IO_output_mergeFiles=(int)Math.ceil(Config.COUNT_END_TUPLES/Config.TUPLES_IN_BLOCK);
//		
//		System.out.println("");
//		System.out.println("The number of input tuples(file1): "+COUNT_START_TUPLES_T1);
//		System.out.println("The number of input blocks(file1): "+(int)(Math.ceil(COUNT_START_TUPLES_T1/40)));
//		System.out.println("");
//		System.out.println("The number of input tuples(file2): "+COUNT_START_TUPLES_T2);
//		System.out.println("The number of input blocks(file2): "+(int)(Math.ceil(COUNT_START_TUPLES_T2/40)));
//		System.out.println("");
//		System.out.println("The number of input tuples(total): "+(COUNT_START_TUPLES_T1+COUNT_START_TUPLES_T2));
//		System.out.println("The number of input blocks(total): "+((int)(Math.ceil(COUNT_START_TUPLES_T1/40))+(int)(Math.ceil(COUNT_START_TUPLES_T2/40))));
//		System.out.println("");
//		
//		System.out.println("The number of output tuples(total): "+Config.COUNT_END_TUPLES);
//		System.out.println("The number of output blocks(total): "+(int)Math.ceil(Config.COUNT_END_TUPLES/40));
//		System.out.println("The number of duplicated tuples: "+(Config.COUNT_START_TUPLES-Config.COUNT_END_TUPLES));
//		System.out.println("");
//		System.out.println("The execution time (Phase one) is: "+(nano_endTimePhaseOne-nano_startTime)/(double)(1000000000)+" seconds.");
//		System.out.println("The execution time (Phase two) is: "+(nano_endTimePhaseTwo-nano_startTimePhaseTwo)/(double)(1000000000)+" seconds.");
//		
//		//System.out.println("The execution time (sort operation) is: "+(nano_endTimeSort-nano_startTime)/(1000000000)+" seconds.");
//		System.out.println("The execution time (total task) is: "+(nano_endTime-nano_startTime)/(double)(1000000000)+" seconds.");
//		System.out.println("");		
//		System.out.println("The number of I/O (sort operation): "+(2*IO_input_passOne+IO_input_passTwo+IO_output_passTwo));
//		System.out.println("The number of I/O (whole task): "+(2*IO_input_passOne+IO_input_passTwo+IO_output_passTwo+IO_iuput_mergeFiles+IO_output_mergeFiles));
		
		
		//********************************************************************************************************************************************************
		System.out.println("*******************************************************************************************************************");	
		System.out.println("Start creating bitmap indexes.");	
		//start time for creating bitmap
		long nano_startTime_bitmap = System.nanoTime(); 
		BitMap.createBitmap(file_T1,"EmpID");
		Config.COUNT_TUPLES_file1=Config.COUNT_TUPLES;
		BitMap.createBitmap(file_T1,"Dept");
		BitMap.createBitmap(file_T1,"Gender");
		//IO for creating bitmap - file1
		int IO_bitmapCreate_file1=3*Config.COUNT_TUPLES_file1/Config.TUPLES_IN_BLOCK;
		System.out.println("Bitmap has been create successfully");
		long nano_endTime_bitmap_creation = System.nanoTime(); 

		System.out.println("Elaspe time: " + (nano_endTime_bitmap_creation - nano_startTime_bitmap));
		
		BitMap.outputBitmapToFile(BitMap.map_EmpID,Config.bitmap_EmpId_File1);
		System.out.println("1");
		
		int IO_bitmapOutput_file1_EmpId=Config.COUNT_bitmap;
		BitMap.outputBitmapToFile(BitMap.map_Dept,Config.bitmap_Dept_File1);
		System.out.println("2");
		
		int IO_bitmapOutput_file1_Dept=Config.COUNT_bitmap;
		BitMap.outputBitmapToFile(BitMap.map_Gender,Config.bitmap_Gender_File1);
		System.out.println("3");
		
		int IO_bitmapOutput_file1_Gender=Config.COUNT_bitmap;
		//IO for output bitmap - file1
		int IO_bitmapOutput_file1=IO_bitmapOutput_file1_EmpId+IO_bitmapOutput_file1_Dept+IO_bitmapOutput_file1_Gender;
		
		long nano_endTime_bitmap_output = System.nanoTime();
		System.out.println("Elaspe time: " + (nano_endTime_bitmap_output - nano_endTime_bitmap_creation));
		
		
		Config.buffer_map_EmpID.putAll(BitMap.map_EmpID);
		BitMap.map_EmpID.clear();
		BitMap.map_Dept.clear();
		BitMap.map_Gender.clear();
		
		
		BitMap.createBitmap(file_T2,"EmpID");
		Config.COUNT_TUPLES_file2=Config.COUNT_TUPLES;
		BitMap.createBitmap(file_T2,"Dept");
		BitMap.createBitmap(file_T2,"Gender");
		//IO for creating bitmap - file2
		int IO_bitmapCreate_file2=3*Config.COUNT_TUPLES_file2/Config.TUPLES_IN_BLOCK;
		
		BitMap.outputBitmapToFile(BitMap.map_EmpID,Config.bitmap_EmpId_File2);
		int IO_bitmapOutput_file2_EmpId=Config.COUNT_bitmap;
		BitMap.outputBitmapToFile(BitMap.map_Dept,Config.bitmap_Dept_File2);
		int IO_bitmapOutput_file2_Dept=Config.COUNT_bitmap;
		BitMap.outputBitmapToFile(BitMap.map_Gender,Config.bitmap_Gender_File2);
		int IO_bitmapOutput_file2_Gender=Config.COUNT_bitmap;
		//IO for output bitmap - file2
		int IO_bitmapOutput_file2=IO_bitmapOutput_file2_EmpId+IO_bitmapOutput_file2_Dept+IO_bitmapOutput_file2_Gender;
		
		System.out.println("Finished creating bitmap indexes.");
		//end time for creating bitmap
		long nano_endTime_bitmap = System.nanoTime(); 
		
		
		//show the file size
		System.out.println();
		File file1=new File(Config.bitmap_EmpId_File1);
		if(!file1.exists()||!file1.isFile()) return;
		System.out.println("actual size (for EmpID_T1): " +file1.length()+" bytes");		
		File file2=new File(Config.bitmap_Dept_File1);
		if(!file2.exists()||!file2.isFile()) return;
		System.out.println("actual size (for Dept_T1): " +file2.length()+" bytes");	
		File file3=new File(Config.bitmap_Gender_File1);
		if(!file3.exists()||!file3.isFile()) return;
		System.out.println("actual size (for Gender_T1): " +file3.length()+" bytes");
		File file4=new File(Config.bitmap_EmpId_File2);
		if(!file4.exists()||!file4.isFile()) return;
		System.out.println("actual size (for EmpID_T2): " +file4.length()+" bytes");	
		File file5=new File(Config.bitmap_Dept_File2);
		if(!file5.exists()||!file5.isFile()) return;
		System.out.println("actual size (for Dept_T2): " +file5.length()+" bytes");
		File file6=new File(Config.bitmap_Gender_File2);
		if(!file6.exists()||!file6.isFile()) return;
		System.out.println("actual size (for Gender_T2): " +file6.length()+" bytes");
		
		File file7=new File(Config.compressed_bitmap_EmpId_File1);
		if(!file7.exists()||!file7.isFile()) return;
		System.out.println("compressed size (for compressed_EmpID_T1): " +file7.length()+" bytes");		
		File file8=new File(Config.compressed_bitmap_Dept_File1);
		if(!file8.exists()||!file8.isFile()) return;
		System.out.println("compressed size (for compressed_Dept_T1): " +file8.length()+" bytes");	
		File file9=new File(Config.compressed_bitmap_Gender_File1);
		if(!file9.exists()||!file9.isFile()) return;
		System.out.println("compressed size (for compressed_Gender_T1): " +file9.length()+" bytes");
		File file10=new File(Config.compressed_bitmap_EmpId_File2);
		if(!file10.exists()||!file10.isFile()) return;
		System.out.println("compressed size (for compressed_EmpID_T2): " +file10.length()+" bytes");	
		File file11=new File(Config.compressed_bitmap_Dept_File2);
		if(!file11.exists()||!file11.isFile()) return;
		System.out.println("compressed size (for compressed_Dept_T2): " +file11.length()+" bytes");
		File file12=new File(Config.compressed_bitmap_Gender_File2);
		if(!file12.exists()||!file12.isFile()) return;
		System.out.println("compressed size (for compressed_Gender_T2): " +file12.length()+" bytes");
		
		
		
		//find the duplicate tuples in T1 and T2
		long nano_startTime_findDup = System.nanoTime(); 
		BitMap.findDuplicate(Config.buffer_map_EmpID,Config.duplicatedFile,file_T1);
		System.out.println("Duplicated tuples are found and stored in "+Config.duplicatedFile);	
		long nano_endTime_findDup = System.nanoTime();
		//IO for finding duplicate 
		int IO_duplicate=Config.COUNT_TUPLES_file1/Config.TUPLES_IN_BLOCK;
		
		
		//merge T1 and T2	
		long nano_startTime_merge = System.nanoTime(); 
		BitMap.merge(Config.buffer_map_EmpID,BitMap.map_EmpID,Config.mergeFile,file_T1,file_T2);
		System.out.println("Merge file stored in "+Config.mergeFile);
		long nano_endTime_merge = System.nanoTime();
		
		//execution time
		System.out.println();
		System.out.println("The execution time (create bitmap for T1&T2) is: "+(nano_endTime_bitmap-nano_startTime_bitmap)/(double)(1000000000)+" seconds.");
		System.out.println("The execution time (find duplicated tuples of T1&T2) is: "+(nano_endTime_findDup-nano_startTime_findDup)/(double)(1000000000)+" seconds.");
		System.out.println("The execution time (merge T1&T2) is: "+(nano_endTime_merge-nano_startTime_merge)/(double)(1000000000)+" seconds.");
		
		//the number of I/O
		System.out.println();
		System.out.println("The IO (create bitmap for T1&T2) is: "+ (IO_bitmapCreate_file1+IO_bitmapCreate_file2));
		System.out.println("The IO (output bitmap for T1&T2) is: "+ (IO_bitmapOutput_file1+IO_bitmapOutput_file2));
		System.out.println("The IO (output duplicate for T1&T2) is: "+ (IO_duplicate));
		System.out.println("The IO (create merge for T1&T2) is: "+ (IO_bitmapCreate_file1+IO_bitmapCreate_file2));
		System.out.println("The IO (Total process) is: "+ (2*(IO_bitmapCreate_file1+IO_bitmapCreate_file2)+IO_bitmapOutput_file1+IO_bitmapOutput_file2+IO_duplicate));
		
		
		
		
		/***O***/
		ArrayList<File> subFiles1 = TPMMSort.phaseOne(file_T1);
		ArrayList<File> subFiles2 = TPMMSort.phaseOne(file_T2);

		
		File filea = new File("file1_sorted");
		File fileb = new File("file2_sorted");

		TPMMSort.phaseTwo(subFiles1,filea);
		TPMMSort.phaseTwo(subFiles2,fileb);

		
		ArrayList<File> merge_file = new ArrayList<File>();
		merge_file.add(filea);
		merge_file.add(fileb);
		
		File final_merge = new File("merged_text");
		//File final_file = 
		TPMMSort.phaseTwo(merge_file, final_merge);
		
		File final_file = new File("final_file");
		TPMMSort.mergeAndRemoveDuplicateID(final_merge,final_file);
		

		System.out.println("Finished");
    } 
}
