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
import TestCompetition.JavaAgent.StatementCoverageData;

public class Listener extends RunListener
{
	static FileWriter writer;
	
	public void testRunStarted(Description description) throws java.lang.Exception 
	{
          try 
	  {
		 File file = new File("stmt-cov.txt");
		 if (file.exists())
                       file.delete();
                 else		   
		       file.createNewFile();
		 writer = new FileWriter("stmt-cov.txt",false);
	  }
	  catch (Exception ex) 
	  {
	          ex.printStackTrace();
	
	  }
        }	
	/**
	 *  Called when all tests have finished
	 * */
	public void testRunFinished(Result result) throws java.lang.Exception
	{
		writer.close();
	}
	
	public void testFinished(Description description) throws java.lang.Exception
	{
        StatementCoverageData.writeIntoFile(writer);
        }

	/**
	 *  Called when an atomic test is about to be started.
	 * */
	public void testStarted(Description description) throws java.lang.Exception
	{
		 writer.write("[TEST] "+description.getClassName()+":"+description.getMethodName() + System.lineSeparator());
	}
}
