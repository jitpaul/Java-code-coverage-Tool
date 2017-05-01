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

package org.apache.commons.dbutils;
 
import java.io.*;
import junit.framework.*;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import TestCompetition.JavaAgent.StatementCoverageData;
import TestCompetition.JavaAgent.GenerateTestSuiteForJUnit4;

public class Listener extends RunListener
{
	
	//  Called when all tests have finished
	public void testRunFinished(Result result) throws java.lang.Exception
	{
		GenerateTestSuiteForJUnit4.generate("T_TestSuite", StatementCoverageData.totalPriorIntoFile());
		GenerateTestSuiteForJUnit4.generate("A_TestSuite", StatementCoverageData.additionalPriorIntoFile());
	}

	//  Called when an atomic test is about to be started.	 
	public void testStarted(Description description) throws java.lang.Exception
	{
		 StatementCoverageData.testExecuted(description.getClassName(), description.getMethodName()); 
	}
	
	public void testFinished(Description description) throws Exception 
	{
        //StatementCoverageData.writeIntoFile();
    }
	
	 public void testFailure(Failure failure) throws Exception 
	{
        System.exit(0);
    }
}