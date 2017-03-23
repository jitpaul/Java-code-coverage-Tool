package TestCompetition.JavaAgent;

//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
import java.io.*;

public class StatementCoverageData {
	//static final Map<String, Integer> coverageHashmap = new HashMap<String, Integer>();

	public static void MarkLineAsExecuted(int lineNumber, String className) {
		  String str = String.format("%s.%d", className, lineNumber);
	/*	try {
		  //File file = new File("cov.txt");
      
         // creates the file
          //file.createNewFile();
		  FileWriter writer = new FileWriter("stmt-cov.txt",true); 
      
         // Writes the content to the file
          writer.write(str);
          writer.write(System.getProperty("line.separator")); 	 		  
          writer.flush();
          writer.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}*/
		
	}
	
}
