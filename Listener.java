/*
 *  Copyright 2001-2011 Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.joda.time;
 
import java.io.*;
import junit.framework.*;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class Listener extends RunListener
{
	/**
	 * Called before any tests have been run.
	 * */

	public void testRunStarted(Description description)	throws java.lang.Exception
	{
		 File file = new File("stmt-cov.txt");
		 //StorageClass.storeResult.add("stmt-cov.txt");
      
         // creates the file
         file.createNewFile();
		 FileWriter writer = new FileWriter("stmt-cov.txt"); 
      
         // Writes the content to the file
          writer.write("Test Coverage Details");
          writer.append(System.getProperty("line.separator"));
          writer.append(System.getProperty("line.separator")); 	 		  
          writer.flush();
          writer.close();
	}

	/**
	 *  Called when all tests have finished
	 * */
	public void testRunFinished(Result result) throws java.lang.Exception
	{
		System.out.println("Number of testcases executed : " + result.getRunCount());
	}

	/**
	 *  Called when an atomic test is about to be started.
	 * */
	public void testStarted(Description description) throws java.lang.Exception
	{
		 String temp = "Starting execution of test case : " + description.getMethodName();
		 FileWriter writer = new FileWriter("stmt-cov.txt",true); 
      
         // Writes the content to the file
          writer.write(temp);
          writer.write(System.getProperty("line.separator")); 		  
          writer.flush();
          writer.close();
	}

	/**
	 *  Called when an atomic test has finished, whether the test succeeds or fails.
	 * */
	public void testFinished(Description description) throws java.lang.Exception
	{
		//System.out.println("Finished execution of test case : "+ description.getMethodName());
		String temp = "Finished execution of test case : "+ description.getMethodName();
		FileWriter writer = new FileWriter("stmt-cov.txt",true); 
      
         // Writes the content to the file
          writer.write(temp); 
		  writer.write(System.getProperty("line.separator")); 		  
		  writer.write(System.getProperty("line.separator")); 		  
          writer.flush();
          writer.close();
	}

	/**
	 *  Called when an atomic test fails.
	 * */
	public void testFailure(Failure failure) throws java.lang.Exception
	{
		System.out.println("Execution of test case failed : "+ failure.getMessage());
	}

	/**
	 *  Called when a test will not be run, generally because a test method is annotated with Ignore.
	 * */
	public void testIgnored(Description description) throws java.lang.Exception
	{
		System.out.println("Execution of test case ignored : "+ description.getMethodName());
	}
}