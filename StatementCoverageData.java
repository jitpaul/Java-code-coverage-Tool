package TestCompetition.JavaAgent;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.io.*;
import java.util.*;

public class StatementCoverageData {
	static String key;
	static final Set<String> records = new HashSet<String>();
	static final HashMap<String,Set<String>> h = new HashMap<>();
	public static void testExecuted(String className, String methodName) 
	{
		  key = "[TEST] "+className+":"+methodName;
		  h.put(key,new HashSet<>());;
	}
	
	public static void lineExecuted(int lineNumber, String className) 
	{
		  String str = className+":"+lineNumber;
		  str=str.replace('/', '.');
		  if(h.get(key)!=null)
		     h.get(key).add(str);
	}
	
	public static void writeIntoFile()
	{
		try 
		{
		  File file = new File("stmt-cov.txt");
		  if (file.exists())
               file.delete();
          else		   
		       file.createNewFile();
		  FileWriter writer = new FileWriter("stmt-cov.txt",true); 		
		  for(Map.Entry<String, Set<String>> e : h.entrySet())
		  {
				writer.write(e.getKey());
				writer.write(System.getProperty("line.separator"));
				for(String temp : e.getValue())
				{
					writer.write(temp);
					writer.write(System.getProperty("line.separator"));
				}
				    writer.write(System.getProperty("line.separator"));
		  }
       		  		  
		  writer.close();
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
	
		}
	}		
}
