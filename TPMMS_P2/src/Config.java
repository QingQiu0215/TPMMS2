import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Config {
	
	public static final String TEMPPATH = "/TempFile/";

	public static final String FILE_T1 = "T1.txt";
	public static final String FILE_T2 = "T2.txt";
	public static final String SAMPLE = "sample.txt";
	public static final String SAMPLE1 = "sample1.txt";
	public static final String SAMPLE_LA = "LA1-DS1.txt";

	public static final String outputFileT1 = "sortedT1.txt";
	public static final String outputFileT2 = "sortedT2.txt";
	//main memory size 10mb
	//public static final int MAIN_MEMORY_SIZE = 10485760;
	public static final long AVAILABLE_MEMORY = Runtime.getRuntime().freeMemory();
	public static int COUNT_START_TUPLES=0;
	public static int COUNT_END_TUPLES=0;
	
	public static final double MEMORY_USAGE=0.2;
	public static final long TUPLE_SIZE = 100;
	public static final int TUPLES_IN_BLOCK = 40;
	public static final int BLOCK_SIZE = 4000;
	//manually set the number of tuples in each chunk
	public static final int TUPLES_IN_CHUNKS = 250*TUPLES_IN_BLOCK;
	public static final int EMPID_LEN = 8;
	public static final int LASTUPDATE_LEN = 10;
	// how many tuple can store in main memory
	public static final long MAX_TUPLE_NUMBER=(long)(AVAILABLE_MEMORY*MEMORY_USAGE ) / TUPLE_SIZE;
	
	//********************************************************************************************************************************************************
	//BitMap configuration:
	public static final String bitmap_EmpId_File1  = "bitmap_EmpId_File1.txt";
	public static final String bitmap_Dept_File1   = "bitmap_Dept_File1.txt";
	public static final String bitmap_Gender_File1 = "bitmap_Gender_File1.txt";
	
	public static final String compressed_bitmap_EmpId_File1  = "compressed_bitmap_EmpId_File1.txt";
	public static final String compressed_bitmap_Dept_File1   = "compressed_bitmap_Dept_File1.txt";
	public static final String compressed_bitmap_Gender_File1 = "compressed_bitmap_Gender_File1.txt";
	
	public static final String bitmap_EmpId_File2  = "bitmap_EmpId_File2.txt";
	public static final String bitmap_Dept_File2   = "bitmap_Dept_File2.txt";
	public static final String bitmap_Gender_File2 = "bitmap_Gender_File2.txt";
	
	public static final String compressed_bitmap_EmpId_File2  = "compressed_bitmap_EmpId_File2.txt";
	public static final String compressed_bitmap_Dept_File2   = "compressed_bitmap_Dept_File2.txt";
	public static final String compressed_bitmap_Gender_File2 = "compressed_bitmap_Gender_File2.txt";
	
	public static final String duplicatedFile = "duplicatedFile.txt";
	public static final String mergeFile = "mergeFile.txt";
	
	public static int COUNT_TUPLES=0;
	public static int COUNT_TUPLES_file1=0;
	public static int COUNT_TUPLES_file2=0;
	public static int COUNT_bitmap=0;
	
	public static Map<String,ArrayList<Integer>> buffer_map_EmpID=new HashMap<String,ArrayList<Integer>>();
}
