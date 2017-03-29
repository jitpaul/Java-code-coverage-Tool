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
test method. The agent jar file and the JUnit listener class can be integrated with any maven project to perform code coverage. This is done by updating the pom.xml file present in the maven project rool directory.

Following needs to be added to the pom.xml file.
1) Replace [path-to-your-agent.jar] with your java agent jar’s absolute path, and 
replace [YourListener] with your JUnit listener’s full name.
<pre>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-surefire-plugin</artifactId>
<configuration>
<argLine>-javaagent:[path-to-your-agent.jar]</argLine>
<properties>
<property>
<name>listener</name>
<value>[YourListener]</value>
</property>
</properties>
</configuration>
</plugin>
</pre>
2) Add the agent.jar file as a dependency as it is used by the 'Listener.java' file. 
(The following dependency was written for my 'JPAgent.jar' file which is attached 
in the repository for your reference)
<pre>
<dependency>
<artifactId>TestCompetition.JavaAgent</artifactId>
<groupId>JPAgent</groupId>
<version>1.0</version>
<scope>system</scope>
<systemPath>${basedir}/JPAgent.jar</systemPath>
</dependency>
</pre>
3) Add the asm package as a dependency if needed as it is used by multiple files.

<pre>
<dependency>
<groupId>org.ow2.asm</groupId>
<artifactId>asm</artifactId>
<version>5.0.3</version>
</dependency>
</pre>
4) Add the junit package as a dependency if needed.
<pre>
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>4.11</version>
<scope>test</scope>
</dependency>
</pre>

When firing “mvn test”, tool will output a file named “stmt-cov.txt” under the project under test. This file will include
statement coverage information for each test method. Each line in the file represents a test method or a covered statement, while the test
method line will have the [TEST] prefix. Each test method will be followed by the set of statements covered by it.Each test method is 
represented by the full name of the test class +”:”+the test method name, while each statement is represented by the 
full name of the class +”:”+the line number.



PS:- A 'JPAgent.jar' file has been attached for reference. This jar file includes MethodPrinter.class, ClassPrinter.class, MyClassFileTransformer.class, StatementCoverageData.class and Agent.class
