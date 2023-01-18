import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
/*
 * File Utilities doe reading and writing
 * 
 * @ author Shyamak Pal
 * @ since August 25, 2022
 */

public class FileUtils
{
	/*
	 * Opens a file to read using Scanner class
	 * @param fileName    	name of the file to open
	 * @return 				the Scanner object to the file
	 */
	 public static java.util.Scanner openToRead(String fileName){
		 java.util.Scanner input = null;
		 try{
			 input = new java.util.Scanner(new java.io.File(fileName));
		 }
		 catch(java.io.FileNotFoundException e ){
			 System.err.println("ERROR: Cannot open "+fileName+" for reading.");
			 System.exit(-1);
		 }
		 return input;
	 }
	 /*
	  * Opens a file to write using the print writer class
	  * @param FileName 	name of the file to open
	  * @retuen 			the print writer object to the file
	  */
	  
	  public static PrintWriter openToWrite(String fileName)
	  {
		  PrintWriter output = null;
		  try{
			  output = new PrintWriter(new File(fileName));
		  }
		  catch(FileNotFoundException fred){
			  System.err.println("ERROR: Cannot open "+ fileName+" for writing");
			  System.exit(-1);
		  }
		  return output;
	  }
}
