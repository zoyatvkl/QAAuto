# QAAuto
QA Automation Codes

This code tests the login functionality of www.saucedemo.com/index.html. 

TestScenarios class contains all the test cases. 
The runner file is placed in src/test/java/Assignment/Lab/testNg.xml. It's a testNg xml file. 
The suite contains two tests to run the code on firefox and chrome browser. 

In order to run the code, user needs to enter the driver path of respective browser in driver path variable. 
Code Snippet
	<parameter name="DriverPath" value="chromeDriverPath"></parameter>
	<parameter name="DriverPath" value="firefoxDriverPath"></parameter>

The system requirement to run the test- 
1. Maven
2. Java
3. Gecko Driver
4. Chrome Driver
5. Chrome browser
6. Firefox browser
7. IDE
8. TestNg

Steps to run the test- 
1. Import the porject in IDE
2. Build the project
3. Go to testNg.xml file  placed in src/test/java/Assignment/Lab

This is the file you need to run inorder to run the tests.
