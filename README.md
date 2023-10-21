I. Test Automation Framework Selenium Java with TestNG:

1.	Read Config from Properties file.
2.	Extent Report.
3.	Send Mail after the run test (Report information and HTML file attachment).
4.	Write Log to file.
5.	Record video and Screenshot test case.
6.	Read data test from Excel file (xlsx).
7.	Base function in the package: utils, helpers.
8.	Main Keyword: WebUI (call common function).
9.	Sample test all function in WebUI keyword.
10.	Retry Failed Test in TestNG with IRetryAnalyzer and IAnnotationTransformer.
----------------------

II. SYSTEM REQUIREMENTS:

1. Install Java JDK (recommend JDK >=11)& Maven.
2. Install Chrome Browser, Edge Browser, Firefox Browser.
3. Run well on the Windows platform.
Note: Use IntelliJ IDEA is the best choice (easy change the JDK version).
----------------------
III. HOW TO USE:

1. Run test case in suite XML (src\test\resources\TestSuites\SC)in IntelliJ IDEA.
	+ MyPrivacySC.xml
	+ MyAccountSC.xml
	+ RegisterProductSC.xml	
	+ AllTestSuites.xml	
2. Run test cases from Maven pom.xml file (mvn clean test) in IntelliJ IDEA.
3. Run test cases from cmd (Windows platform).
  	+ run-automation-MyAccount.bat
	+ run-automation-MyPrivacySC.bat
	+ run-automation-RegisterProductSC.bat	
	+ run-automation-suite-all.bat	  
Note: 
1. Replace the path of file "project folder" of each bat file before run auto script. (cd D:\lms-automation-test\)
	Script:
	@echo off
	cd D:\lms-automation-test\
	mvn clean test -P MyAccountSC

2. Run Headless mode only for chrome & local execution => set HEADLESS = true in [Config.properties] file (src\test\resources\config)


----------------------	


