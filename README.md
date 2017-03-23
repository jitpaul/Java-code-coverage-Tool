Java Code Coverage Tool
===========================

## Authors ##

* Jithin Paul (paul.jitin@gmail.com)
* Nandita Balasubramanian (nandita.sbalaji@gmail.com)

##### University of Texas at Dallas (UTD) #####
March 2017


An Automated coverage collection tool that can capture the statement coverage for the program under test.

The tool uses ASM byte-code manipulation framework to manipulate the bytecode. Bytecode manipulation is performed on the fly by a 
Java Agent whcih makes use of the Intrumentation API. A JUnit listener is used to to capture the start and end events for each JUnit
test method. The agent jar file and the JUnit listener class can be integrated with any maven project to perform code coverage.

When firing “mvn test”, tool will output a file named “stmt-cov.txt” under the project under test. This file will include
statement coverage information for each test method. Each line in the file represents a test method or a covered statement, while the test
method line will have the [TEST] prefix. Each test method will be followed by the set of statements covered by it.Each test method is 
represented by the full name of the test class +”:”+the test method name, while each statement is represented by the 
full name of the class +”:”+the line number.
